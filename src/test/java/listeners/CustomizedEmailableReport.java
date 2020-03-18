package listeners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.log4testng.Logger;
import org.testng.xml.XmlSuite;

import utils.ReadProperty;
import utils.Utility;

public class CustomizedEmailableReport implements IReporter {
	private static final Logger L = Logger.getLogger(CustomizedEmailableReport.class);
	private PrintWriter out;
	private Integer testIndex;
	private int methodIndex;
	private int suiteCount;
	private Scanner scanner;
	int passRecords = 0;
	int failRecords = 0;
	int skipRecords = 0;
	int passCaseCount = 0;
	int failCaseCount = 0;
	int skipCaseCount = 0;
	Map<String, Integer> passedData;
	Map<String, Integer> failedData;
	Map<String, Integer> skippedData;

	/** Creates summary of the run */
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outdir) {
		try {
			out = createWriter(outdir);
		} catch (IOException e) {
			L.error("output file", e);
			return;
		}
		List<ISuite> temp = new ArrayList<ISuite>();
		Map<Date, ISuite> map = new LinkedHashMap<Date, ISuite>();
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> tests = suite.getResults();
			for (ISuiteResult r : tests.values()) {
				ITestContext overview = r.getTestContext();
				map.put(overview.getStartDate(), suite);
			}
		}
		Set<Date> keySet = map.keySet();
		List<Date> keys = new ArrayList<Date>(keySet);
		Collections.sort(keys);
		for (int i = 0; i < keys.size(); i++) {
			temp.add(map.get(keys.get(i)));
		}
		LinkedHashSet<ISuite> hashSet = new LinkedHashSet<ISuite>(temp);
		ArrayList<ISuite> listWithoutDuplicates = new ArrayList<ISuite>(hashSet);
		suites = listWithoutDuplicates;
		startHtml(out);
		out.print("<h2><center>" + ReadProperty.getPropertyValue("PROJECT_NAME") + "</center></h2>");
		generateSuiteSummaryReport(suites);
		generateMethodSummaryReport(suites);
		generateMethodDetailReport(suites);
		endHtml(out);
		out.flush();
		out.close();
	}

	protected PrintWriter createWriter(String outdir) throws IOException {
		return new PrintWriter(
				new BufferedWriter(new FileWriter(new File(outdir, ReadProperty.getPropertyValue("PROJECT_NAME") + "_"
						+ Utility.getCurrentDateTime().replaceAll(":", ".") + "_Summary_Report.html"))));
	}

	/**
	 * Creates a table showing the highlights of each test method with links to the
	 * method details
	 */
	protected void generateMethodSummaryReport(List<ISuite> suites) {
		startResultSummaryTable("methodOverview");
		int testIndex = 1;
		for (ISuite suite : suites) {
			methodIndex = 0;
			suiteCount = suiteCount + 1;
			if (suites.size() >= 1)
				titleRow(suite.getName(), 5);
			Map<String, ISuiteResult> r = suite.getResults();
			for (ISuiteResult r2 : r.values()) {
				ITestContext testContext = r2.getTestContext();
				String testName = testContext.getName();
				this.testIndex = testIndex;
				resultSummary(suite, testContext.getFailedConfigurations(), testName, "Fail",
						" (configuration methods)");
				resultSummary(suite, testContext.getFailedTests(), testName, "Fail", "");
				resultSummary(suite, testContext.getSkippedConfigurations(), testName, "Skip",
						" (configuration methods)");
				resultSummary(suite, testContext.getSkippedTests(), testName, "Skip", "");
				resultSummary(suite, testContext.getPassedTests(), testName, "Pass", "");
				testIndex++;
			}
		}
		out.println("</Table>");
	}

	/** Creates a section showing known results for each method */
	protected void generateMethodDetailReport(List<ISuite> suites) {
		methodIndex = 0;
		suiteCount = 0;
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> r = suite.getResults();
			methodIndex = 0;
			suiteCount += 1;
			for (ISuiteResult r2 : r.values()) {
				ITestContext testContext = r2.getTestContext();
				if (r.values().size() > 0)
					out.println("<h2>" + testContext.getName() + "</h2>");
				resultDetail(testContext.getFailedTests());
				resultDetail(testContext.getSkippedTests());
				resultDetail(testContext.getPassedTests());
			}
		}
	}

	/**
	 * @param tests
	 */
	private void resultSummary(ISuite suite, IResultMap tests, String testname, String style, String details) {
		if (tests.getAllResults().size() > 0) {
			StringBuffer buff = new StringBuffer();
			String lastClassName = "";
			int mq = 0;
			for (ITestNGMethod method : getMethodSet(tests, suite)) {
				methodIndex += 1;
				ITestClass testClass = method.getTestClass();
				String className = testClass.getName();
				if (mq == 0) {
					String id = (testIndex == null ? null : "t" + Integer.toString(testIndex));
					titleRow(testname + " &#8212; " + style + details, 5, id);
					testIndex = null;
				}
				if (!className.equalsIgnoreCase(lastClassName)) {
					if (mq > 0) {
						out.print("<tr class=\"numi_" + style + "\">" + "<td class=\"numi_Left\"");
						if (mq > 1)
							out.print(" rowspan=\"" + mq + "\"");
						out.println(">" + lastClassName + "</td>" + buff);
					}
					mq = 0;
					buff.setLength(0);
					lastClassName = className;
				}
				Set<ITestResult> resultSet = tests.getResults(method);
				long end = Long.MIN_VALUE;
				long start = Long.MAX_VALUE;
				long startMS = 0;
				String firstLine = "";
				String screenshotLnk = "";
				// Collections.sort(list, new TestResultsSorter());
				for (ITestResult testResult : tests.getResults(method)) {
					if (testResult.getEndMillis() > end)
						end = testResult.getEndMillis() / 1000;
					if (testResult.getStartMillis() < start) {
						startMS = testResult.getStartMillis();
						start = startMS / 1000;
					}
					Throwable exception = testResult.getThrowable();
					boolean hasThrowable = exception != null;
					if (hasThrowable) {
						String str = Utils.stackTrace(exception, true)[0];
						scanner = new Scanner(str);
						firstLine = scanner.nextLine();
					}
				}
				DateFormat formatter = new SimpleDateFormat("kk:mm:ss");
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(startMS);
				mq += 1;
				if (mq > 1)
					buff.append("<tr class=\"numi_" + style + "\">");
				String description = method.getDescription();
				String testInstanceName = resultSet.toArray(new ITestResult[] {})[0].getTestName();
				buff.append("<td class=\"numi_Left\"><a href=\"#m" + methodIndex + "_" + suiteCount + "\">"
						+ qualifiedName(method) + " "
						+ (description != null && description.length() > 0 ? "(\"" + description + "\")" : "") + "</a>"
						+ (null == testInstanceName ? "" : "<br>(" + testInstanceName + ")") + "</td>"
						+ "<td class=\"numi\" style=\"text-align:left;padding-right:2em\">" + firstLine + "<br/>"
						+ screenshotLnk + "</td>" + "<td style=\"text-align:right\">"
						+ formatter.format(calendar.getTime()) + "</td>" + "<td class=\"numi\">"
						+ millisToTimeConversion(end - start) + "</td>" + "</tr>");
			}
			if (mq > 0) {
				out.print("<tr class=\"numi_" + style + "\">" + "<td class=\"numi_Left\"");
				if (mq > 1)
					out.print(" rowspan=\"" + mq + "\"");
				out.println(">" + lastClassName + "</td>" + buff);
			}
		}
	}

	private String millisToTimeConversion(long seconds) {
		final int MINUTES_IN_AN_HOUR = 60;
		final int SECONDS_IN_A_MINUTE = 60;
		int minutes = (int) (seconds / SECONDS_IN_A_MINUTE);
		seconds -= minutes * SECONDS_IN_A_MINUTE;
		int hours = minutes / MINUTES_IN_AN_HOUR;
		minutes -= hours * MINUTES_IN_AN_HOUR;
		return prefixZeroToDigit(hours) + ":" + prefixZeroToDigit(minutes) + ":" + prefixZeroToDigit((int) seconds);
	}

	private String prefixZeroToDigit(int num) {
		int number = num;
		if (number <= 9) {
			String sNumber = "0" + number;
			return sNumber;
		} else
			return "" + number;
	}

	/** Starts and defines columns result summary table */
	private void startResultSummaryTable(String style) {
		tableStart(style, "summary");
		out.println("<tr>");
		tableColumnStart("Class");
		tableColumnStart("Test Scenario");
		tableColumnStart("Exception");
		tableColumnStart("Start Time");
		tableColumnStart("Execution Time<br/>(hh:mm:ss)");
		out.println("</tr>");
	}

	private String qualifiedName(ITestNGMethod method) {
		StringBuilder addon = new StringBuilder();
		String[] groups = method.getGroups();
		int length = groups.length;
		if (length > 0 && !"basic".equalsIgnoreCase(groups[0])) {
			addon.append("(");
			for (int i = 0; i < length; i++) {
				if (i > 0)
					addon.append(", ");
				addon.append(groups[i]);
			}
			addon.append(")");
		}
		return "<b>" + method.getMethodName() + "</b> " + addon;
	}

	private void resultDetail(IResultMap tests) {
		Set<ITestResult> testResults = tests.getAllResults();
		List<ITestResult> list = new ArrayList<ITestResult>(testResults);
		// Collections.sort(list, new TestResultsSorter());
		ArrayList<String> classNames = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			ITestNGMethod method = list.get(i).getMethod();
			methodIndex++;
			String cname = method.getTestClass().getName();
			if (!classNames.contains(cname) || !classNames.contains(method.getMethodName())) {
				classNames.add(cname);
				classNames.add(method.getMethodName());
				out.println("<h3 id=\"m" + methodIndex + "_" + suiteCount + "\">" + cname + ":" + method.getMethodName()
						+ "</h3>");
			} else {
				out.println("<h3>" + cname + ":" + method.getMethodName() + "</h3>");
				methodIndex--;
			}
			Set<ITestResult> resultSet = tests.getResults(method);
			generateForResult(list.get(i), method, resultSet.size());
			out.println("<p class=\"totop\"><a href=\"#summary\">back to summary</a></p>");
		}
	}

	private void generateForResult(ITestResult ans, ITestNGMethod method, int resultSetSize) {
		List<String> headers;
		List<String> values = null;
		Object[] parameters = ans.getParameters();
		boolean hasParameters = parameters != null && parameters.length > 0;
		if (hasParameters) {
			headers = new ArrayList<String>();
			values = new ArrayList<String>();
			String[] valueSet = Utils.escapeHtml(Utils.toString(parameters)).toString().split(",");
			for (int i = 0; i < valueSet.length; i++) {
				if (valueSet[i].contains("=")) {
					String[] valuesArray = valueSet[i].split("=");
					headers.add(valuesArray[0].replace("[{", ""));
					try {
						values.add(valuesArray[1].replace("}]", ""));
					} catch (ArrayIndexOutOfBoundsException e) {
						values.add("");
					}
				} else {
					String appendValue = values.get(values.size() - 1).concat(", ").concat(valueSet[i]);
					values.set(values.size() - 1, appendValue);
				}
			}
			tableStart("result", null);
			out.print("<tr class=\"param\">");
			for (int x = 0; x < headers.size(); x++) {
				out.print("<th><b>" + headers.get(x) + "</b></th>");
			}
			out.println("</tr>");
			out.print("<tr class=\"param stripe\">");
			for (int x = 0; x < values.size(); x++) {
				out.println("<td>" + values.get(x) + "</td>");
			}
			out.println("</tr>");
		}
		List<String> msgs = Reporter.getOutput(ans);
		boolean hasReporterOutput = msgs.size() > 0;
		Throwable exception = ans.getThrowable();
		boolean hasThrowable = exception != null;
		if (hasReporterOutput || hasThrowable) {
			if (hasParameters) {
				out.print("<tr><td");
				if (values.size() > 1)
					out.print(" colspan=\"" + values.size() + "\"");
				out.println(">");
			} else {
				out.println("<div>");
			}
			if (hasReporterOutput) {
				if (hasThrowable)
					out.println("<h3>Test Steps</h3>");
				for (String line : msgs) {
					out.println(line + "<br/>");
				}
			}
			if (hasThrowable) {
				boolean wantsMinimalOutput = ans.getStatus() == ITestResult.SUCCESS;
				if (hasReporterOutput) {
					out.println("<b><h2 style='color:red'>" + (wantsMinimalOutput ? "Expected Exception" : "Failure")
							+ "</h2></b>");
				}
				generateExceptionReport(exception, method);
			}
			if (hasParameters)
				out.println("</td></tr>");
			else
				out.println("</div>");
		}
		if (hasParameters)
			out.println("</Table>");
	}

	protected void generateExceptionReport(Throwable exception, ITestNGMethod method) {
		out.print("<div class=\"stacktrace\">");
		out.print(Utils.stackTrace(exception, true)[0]);
		out.println("</div>");
	}

	/**
	 * Since the methods will be sorted chronologically, we want to return the
	 * ITestNGMethod from the invoked methods.
	 */
	private Collection<ITestNGMethod> getMethodSet(IResultMap tests, ISuite suite) {
		List<IInvokedMethod> r = Lists.newArrayList();
		List<IInvokedMethod> invokedMethods = suite.getAllInvokedMethods();
		Collection<ITestNGMethod> allInvokedTestMethods = tests.getAllMethods();
		for (IInvokedMethod im : invokedMethods) {
			if (allInvokedTestMethods.contains(im.getTestMethod()))
				r.add(im);
		}
		List<ITestNGMethod> result = Lists.newArrayList();
		for (IInvokedMethod m : r) {
			for (ITestNGMethod temp : result) {
				if (!temp.equals(m.getTestMethod()))
					result.add(m.getTestMethod());
			}
		}
		List<ITestNGMethod> allMethods = new ArrayList<ITestNGMethod>(allInvokedTestMethods);
		for (ITestNGMethod m : allMethods) {
			if (!result.contains(m))
				result.add(m);
		}
		return result;
	}

	public void generateSuiteSummaryReport(List<ISuite> suites) {
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			out.print("IP address not available");
		}
		tableStart("executorDetail", null);
		out.print("<tr>");
		tableColumnStart("<b> Execution Date </b>");
		tableColumnStart("<b> IP </b>");
		tableColumnStart("<b> Host Name </b>");
		tableColumnStart("<b> Executor Name </b>");
		out.print("</tr>");
		out.print("<tr>");
		summaryCell(getCurrentDateTime(), "Pass");
		summaryCell(inetAddress.getHostAddress(), "Pass");
		try {
			summaryCell(InetAddress.getLocalHost().getHostName(), "Pass");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		summaryCell(System.getProperty("user.name"), "Pass");
		out.println("</tr>");
		out.println("</Table>");
		tableStart("percentageDetails", null);
		out.print("<tr>");
		tableColumnStart("<b> Record Wise Ratio </b>");
		tableColumnStart("<b> Testcase Wise  Ratio </b>");
		out.print("</tr>");
		out.print("<tr>");
		out.println("<td align=\"center\"><div id=\"recordWisePieChart\"></div></td>");
		out.println("<td align=\"center\"><div id=\"testCaseWisePieChart\"></div></td>");
		out.println("</tr>");
		out.println("</Table>");
		tableStart("testOverview", null);
		out.print("<tr>");
		tableColumnStart("Test");
		tableColumnStart("# Passed");
		tableColumnStart("# Failed");
		tableColumnStart("# Skipped");
		tableColumnStart("# Record Count (Passed)");
		tableColumnStart("# Record Count (Failed)");
		tableColumnStart("# Record Count (Skipped)");
		tableColumnStart("Start<br/>Time");
		tableColumnStart("End<br/>Time");
		tableColumnStart("Total<br/>Time(hh:mm:ss)");
		tableColumnStart("Included<br/>Groups");
		tableColumnStart("Excluded<br/>Groups");
		out.println("</tr>");
		new DecimalFormat("#,##0.0");
		int qty_tests = 0;
		passCaseCount = 0;
		skipCaseCount = 0;
		failCaseCount = 0;
		long time_start = Long.MAX_VALUE;
		long time_end = Long.MIN_VALUE;
		testIndex = 1;
		passedData = getPassedData(suites);
		failedData = getFailedData(suites);
		skippedData = getSkipedData(suites);
		for (ISuite suite : suites) {
			if (suites.size() >= 1)
				titleRow(suite.getName(), 12);
			Map<String, ISuiteResult> tests = suite.getResults();
			Set<String> keySet = tests.keySet();
			List<String> keys = new ArrayList<String>(keySet);
			List<Date> list = new ArrayList<Date>();
			int count = 0;
			for (ISuiteResult r : tests.values()) {
				qty_tests += 1;

				ITestContext overview = r.getTestContext();
				IResultMap skippedMethods = overview.getSkippedTests();
				IResultMap passedMethods = overview.getPassedTests();
				IResultMap failedMethods = overview.getFailedTests();
				for (ITestNGMethod a : passedMethods.getAllMethods()) {
					if (failedMethods.toString().contains(a.toString()))
						passedMethods.removeResult(a);
				}

				list.add(overview.getStartDate());
				out.print("<tr><td style=\"text-align:left;padding-right:2em\"><a href=\"#t" + testIndex + "\"><b>"
						+ overview.getName() + "</b></a>" + "</td>");
				int q = 0;
				q = getMethodSet(passedMethods, suite).size();
				passCaseCount += q;
				summaryCell(q, "Pass");
				q = getMethodSet(failedMethods, suite).size();
				failCaseCount += q;
				if (q > 0)
					summaryCell(q, "Fail");
				else
					summaryCell(q, "Pass");
				q = getMethodSet(skippedMethods, suite).size();
				skipCaseCount += q;
				if (q > 0)
					summaryCell(q, "Skip");
				else
					summaryCell(q, "Pass");
				summaryCell(passedData.get(keys.get(count)), "Pass");
				passRecords = passRecords + passedData.get(keys.get(count));
				if (failedData.get(keys.get(count)) == 0)
					summaryCell(failedData.get(keys.get(count)), "Pass");
				else
					summaryCell(failedData.get(keys.get(count)), "Fail");
				failRecords = failRecords + failedData.get(keys.get(count));
				if (skippedData.get(keys.get(count)) == 0)
					summaryCell(skippedData.get(keys.get(count)), "Pass");
				else
					summaryCell(skippedData.get(keys.get(count)), "Skip");
				skipRecords = skipRecords + skippedData.get(keys.get(count));
				SimpleDateFormat summaryFormat = new SimpleDateFormat("kk:mm:ss");
				summaryCell(summaryFormat.format(overview.getStartDate()), true);
				summaryCell(summaryFormat.format(overview.getEndDate()), true);
				time_start = Math.min(overview.getStartDate().getTime(), time_start);
				time_end = Math.max(overview.getEndDate().getTime(), time_end);
				summaryCell(millisToTimeConversion(
						(overview.getEndDate().getTime() - overview.getStartDate().getTime()) / 1000), true);
				summaryCell(overview.getIncludedGroups());
				summaryCell(overview.getExcludedGroups());
				out.println("</tr>");
				testIndex++;
				count++;
			}
		}
		if (qty_tests >= 1) {
			out.println("<tr class=\"total\"><td>Total</td>");
			summaryCell(passCaseCount, "Plain");
			summaryCell(failCaseCount, "Fail");
			summaryCell(skipCaseCount, "Skip");
			summaryCell(passRecords, "Plain");
			summaryCell(failRecords, "Fail");
			summaryCell(skipRecords, "Skip");
			summaryCell(" ", true);
			summaryCell(" ", true);
			summaryCell(millisToTimeConversion(((time_end - time_start) / 1000)), "Plain");
			out.println("<td colspan=\"3\">&nbsp;</td></tr>");
		}
		out.println("</Table>");
		// DecimalFormat decimalFormate = new DecimalFormat("#.##");
		// totalRecordWise = passRecords + failRecords + skipRecords;
		// passPerRecordWise = (passRecords * 100) / totalRecordWise;
		// skipPerRecordWise = (skipRecords * 100) / totalRecordWise;
		// failPerRecordWise = (failRecords * 100) / totalRecordWise;
		// tableStart("executionSummary", null);
		// out.print("<tr>");
		// if (passPerRecordWise != 0.00)
		// tableColumnStart("Pass Percentage");
		// if (skipPerRecordWise != 0.00)
		// tableColumnStart("Skip Percentage");
		// if (failPerRecordWise != 0.00)
		// tableColumnStart("Fail Percentage");
		// out.print("</tr>");
		// out.print("<tr>");
		// if (passPerRecordWise != 0.00)
		// out.print("<th width=\"" + decimalFormate.format((passPerRecordWise))
		// + "\" class=\"numi_Plain\"><b>"
		// + decimalFormate.format((passPerRecordWise)) + "</b></th>");
		// if (skipPerRecordWise != 0.00)
		// out.print("<th width=\"" + decimalFormate.format((skipPerRecordWise))
		// + "\" class=\"numi_Skip\"><b>"
		// + decimalFormate.format((skipPerRecordWise)) + "</b></th>");
		// if (failPerRecordWise != 0.00)
		// out.print("<th width=\"" + decimalFormate.format((failPerRecordWise))
		// + "\" class=\"numi_Fail\"><b>"
		// + decimalFormate.format((failPerRecordWise)) + "</b></th>");
		// out.print("</tr>");
		// out.println("</Table>");
	}

	private Map<String, Integer> getPassedData(List<ISuite> suites) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (ISuite suite : suites) {
			int count = 0;
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			Set<String> keySet = suiteResults.keySet();
			List<String> keys = new ArrayList<String>(keySet);
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				map.put(keys.get(count), tc.getPassedTests().getAllResults().size());
				count++;
			}
		}
		return map;
	}

	private Map<String, Integer> getFailedData(List<ISuite> suites) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (ISuite suite : suites) {
			int count = 0;
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			Set<String> keySet = suiteResults.keySet();
			List<String> keys = new ArrayList<String>(keySet);
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				map.put(keys.get(count), tc.getFailedTests().getAllResults().size());
				count++;
			}
		}
		return map;
	}

	private Map<String, Integer> getSkipedData(List<ISuite> suites) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (ISuite suite : suites) {
			int count = 0;
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			Set<String> keySet = suiteResults.keySet();
			List<String> keys = new ArrayList<String>(keySet);
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				map.put(keys.get(count), tc.getSkippedTests().getAllResults().size());
				count++;
			}
		}
		return map;
	}

	private void summaryCell(String[] val) {
		StringBuffer b = new StringBuffer();
		for (String v : val)
			b.append(v + " ");
		summaryCell(b.toString(), true);
	}

	private void summaryCell(String v, boolean isgood) {
		out.print("<td class=\"numi" + (isgood ? "" : "_attn") + "\">" + v + "</td>");
	}

	private void summaryCell(String v, String status) {
		out.print("<td class=\"numi_" + status + "\">" + v + "</td>");
	}

	private void summaryCell(int v, String status) {
		summaryCell(String.valueOf(v), status);
	}

	private void tableStart(String cssclass, String id) {
		out.println("<Table cellspacing=\"0\" border=\"1\"cellpadding=\"0\""
				+ (cssclass != null ? " class=\"" + cssclass + "\"" : " style=\"padding-bottom:2eml\"")
				+ (id != null ? " id=\"" + id + "\"" : "") + ">");
	}

	private void tableColumnStart(String label) {
		out.print("<th class=\"numi_Header\">" + label + "</th>");
	}

	private void titleRow(String label, int cq) {
		titleRow(label, cq, null);
	}

	private void titleRow(String label, int cq, String id) {
		out.print("<tr ");
		if (id != null) {
			out.print(" id=\"" + id + "\"");
		}
		out.println("><th colspan=\"" + cq + "\">" + label + "</th></tr>");
	}

	/** Starts HTML stream */
	protected void startHtml(PrintWriter out) {
		out.println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>TestNG Report</title>");
		out.println("<style type=\"text/css\">");
		out.println("Table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
		out.println("td,th {border:1px solid #009;padding:.25em .5em}");
		out.println(".result th {vertical-align:bottom}");
		out.println(".param th {padding-left:1em;padding-right:1em}");
		out.println(".param td {padding-left:.5em;padding-right:2em}");
		out.println(".stripeeven td,.stripeodd td,.stripeeven th, .stripeodd th {background-color: #E6EBF9}");
		out.println(".numi, .numi_Pass, .numi_Fail, .numi_Skip, .numi_Plain{text-align:center}");
		out.println(".numi_Left{text-align:left}");
		out.println(".total td {font-weight:bold}");
		out.println(".numi_Pass {background-color: #ffffff}");
		out.println(".numi_Header {background-color: #6dc6f2}");
		out.println(".numi_Plain {background-color: #00802b}");
		out.println(".numi_Fail {background-color: #e63900}");
		out.println(".numi_Skip {background-color: #e6e600}");
		out.println(".passedodd td {background-color: #0A8}");
		out.println(".passedeven td {background-color: #8F9}");
		out.println(".skippedodd td,.numi_attn {background-color: #CCC}");
		out.println(".skippedodd td,.numi_attn {background-color: #DDD}");
		out.println(".failedodd td,.numi_attn {background-color: #f47373}");
		out.println(".failedeven td,.stripe .numi_attn {background-color: #f47373}");
		out.println(".stacktrace {white-space:pre;font-family:monospace}");
		out.println(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
		out.println(
				"#myBtn {display: none;position: fixed;bottom: 20px;right: 30px; z-index: 99;font-size: 25px;font-weight: bold;border: none;outline: none;background-color: #6dc6f2;color: black;cursor: pointer;padding: 15px;border-radius: 4px;}");
		out.println("#myBtn:hover {background-color: #555;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\">^</button>");
	}

	/** Finishes HTML stream */
	protected void endHtml(PrintWriter out) {
		out.println("<center> Report Customized </center>");
		out.println("</body></html>");
		out.println(
				"<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script><script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Status', 'Percentage'],['Pass Records',"
						+ passRecords + "],['Fail Records', " + failRecords + "],['Skip Records', " + skipRecords
						+ "]]);var options = {'width':700, 'height':400, colors: ['#00802b', '#e62e00', '#e6e600'],'is3D': true,legend: 'bottom'};var chart = new google.visualization.PieChart(document.getElementById('recordWisePieChart'));chart.draw(data, options);}</script>");
		out.println(
				"<script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart']});google.charts.setOnLoadCallback(drawChart);function drawChart() {var data = google.visualization.arrayToDataTable([['Status', 'Percentage'],['Pass Test Cases',"
						+ passCaseCount + "],['Fail Test Cases', " + failCaseCount + "],['Skip Test Cases', "
						+ skipCaseCount
						+ "]]);var options = {'width':700, 'height':400, colors: ['#00802b', '#e62e00', '#e6e600'],is3D: true,legend: 'bottom'};var chart = new google.visualization.PieChart(document.getElementById('testCaseWisePieChart'));chart.draw(data, options);}</script>");
		out.println(
				"<script> var mybutton = document.getElementById(\"myBtn\");window.onscroll = function() {scrollFunction()};function scrollFunction() {if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {mybutton.style.display = \"block\";} else {mybutton.style.display = \"none\";}}function topFunction() {document.body.scrollTop = 0;document.documentElement.scrollTop = 0;}</script>");
	}

	// private class TestSorter implements Comparator<IInvokedMethod> {
	// @Override
	// public int compare(IInvokedMethod o1, IInvokedMethod o2) {
	// int r =
	// o1.getTestMethod().getTestClass().getName().compareTo(o2.getTestMethod().getTestClass().getName());
	// if (r == 0)
	// r = o1.getTestMethod().compareTo(o2.getTestMethod());
	// return r;
	// }
	// }
	//
	// private class TestMethodSorter implements Comparator<ITestNGMethod> {
	// public int compare(ITestNGMethod o1, ITestNGMethod o2) {
	// int r =
	// o1.getTestClass().getName().compareTo(o2.getTestClass().getName());
	// if (r == 0)
	// r = o1.getMethodName().compareTo(o2.getMethodName());
	// return r;
	// }
	// }
	//
	// private class TestResultsSorter implements Comparator<ITestResult> {
	// public int compare(ITestResult o1, ITestResult o2) {
	// int result =
	// o1.getTestClass().getName().compareTo(o2.getTestClass().getName());
	// if (result == 0)
	// result =
	// o1.getMethod().getMethodName().compareTo(o2.getMethod().getMethodName());
	// return result;
	// }
	// }
	public String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		String dateTime = dateFormat.format(currentDate);
		return dateTime;
	}

}