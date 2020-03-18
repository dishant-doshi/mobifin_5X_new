package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.CommonConstants;
import base.SetupInit;
import utils.Utility;

public class CommonPage extends SetupInit {

	By btnAdd = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_ADD", CommonConstants.ELEMENT_FILE));
	By btnClear = By.id("clearbutton");
	By btnSave = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_SAVE", CommonConstants.ELEMENT_FILE));
	By btnCancel = By.xpath("(//*[normalize-space(text())='Cancel'])[last()]");
	By btnFilter = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_SERVERSEARCH", CommonConstants.ELEMENT_FILE));
	By btnFilterSearch = By.id("searchbutton");
	By stripText = By.xpath("(//*[@class='ant-notification-notice-message'])[last()]");
	String info = "//td[normalize-space(text())='%s']//preceding-sibling::td[@class='center-align']//i";
	By btnSubmit = By.xpath("//span[normalize-space(text())='Submit']//parent::button");
	By btnNext = By.xpath("//span[normalize-space(text())='Next']//parent::button");
	By btnDeleteConfirm = By.xpath("(//*[@class='ant-btn ant-btn-primary'])[last()]");
	By btnClose = By.xpath("//button[@aria-label='Close']");
	By btnEdit = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_EDIT", CommonConstants.ELEMENT_FILE));
	By btnDelete = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_DELETE", CommonConstants.ELEMENT_FILE));
	By btnGridAdd = By.id("operationbarbuttongridsetting");
	By gridValues = By.xpath(
			"//*[contains(@class,'ant-select-dropdown ant-select-dropdown--multiple')]//li[@aria-selected='false']");
	By gridSetting = By.xpath("//*[contains(@class,'ant-select-search__field__wrap')]");
	By gridLabelValues = By.xpath("//*[contains(@role,'listbox')]//li");
	By gridHeaders = By.xpath("//thead//th//span//span");
	String sorting = "//thead//*[normalize-space(text())='%s']";
	String sortingOrder = "//thead//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'sorter')]//i[contains(@class,'up off')]";
	By rows = By.xpath("//tbody//tr");
	String tableColumn = "//tbody//tr[%s]//td[contains(@class,'sorters')]";
	String uniqueColumn = "//tbody//tr[%s]//td[3]";
	By columnList = By.xpath("//tbody//td[3]");
	By btnBack = By.id(Utility.readJSFile("OPERATIONBAR_BUTTON_BACK", CommonConstants.ELEMENT_FILE));

	Comparator<Entry<String, Integer>> descComparator = new Comparator<Entry<String, Integer>>() {
		@Override
		public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {
			int compareWordCount = a.getValue().compareTo(b.getValue());
			if (compareWordCount == 0)
				return b.getKey().compareToIgnoreCase(a.getKey());
			return compareWordCount;
		}
	};

	Comparator<Entry<String, Integer>> ascComparator = new Comparator<Entry<String, Integer>>() {
		@Override
		public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {
			int compareWordCount = a.getValue().compareTo(b.getValue());
			if (compareWordCount == 0)
				return a.getKey().compareToIgnoreCase(b.getKey());
			return compareWordCount;
		}
	};

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAddButton() {
		clickOnElement(btnAdd, 0);
	}

	public void clickOnFilterBtn() {
		clickOnElement(btnFilter);
	}

	public void clickOnClearBtn() {
		clickOnElement(btnClear);
	}

	public void clickOnFilterSearchBtn() {
		clickOnElement(btnFilterSearch, 0);
	}

	public void commonFilterSearch() {
		clickOnFilterBtn();
		clickOnClearBtn();
	}

	public void clickOnSaveBtn() {
		clickOnElement(btnSave, 0);
	}

	public boolean isStriptTextDisplayed(int... time) {
		if (verifyVisible(stripText, time)) {
			String text;
			try {
				text = "Strip Confirmation Message : " + getElementText(stripText);
			} catch (Exception e) {
				log("</br><b style='color:#02563d'> Strip Message Not Generated.</b></br>");
				return false;
			}
			log("</br><b style='color:#02563d'>" + text + "</b></br>");
			return true;
		} else {
			log("</br><b style='color:#02563d'> Strip Message Not Generated.</b></br>");
			return false;
		}
	}

	public void clickOnInfoBtn(String string) {
		clickOnElement(By.xpath(String.format(info, string)));
		waitForLoader();
	}

	public void clickOnNextBtn() {
		clickOnElement(btnNext);
	}

	public void clickOnSubmitBtn() {
		clickOnElement(btnSubmit);
	}

	public void clickOnDeleteConfirm() {
		clickOnElement(btnDeleteConfirm);
	}

	public void clickOnCloseBtn() {
		clickOnElement(btnClose);
	}

	public void clickOnEditBtn() {
		clickOnElement(btnEdit);
	}

	public void clickOnDeleteBtn() {
		clickOnElement(btnDelete);
	}

	public void delete() {
		clickOnDeleteBtn();
		clickOnDeleteConfirm();
	}

	public void clickOnGridAddBtn() {
		clickOnElement(btnGridAdd);
	}

	public List<String> addColumnInGrid() {
		String value = null;
		clickOnGridAddBtn();
		clickOnElement(gridSetting);
		List<WebElement> list = getElementList(gridValues);
		List<String> gridValues = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).click();
			value = list.get(i).getAttribute("value");
			value = "<b><span style='color:#3f0713'>" + value + "</span></b>";
			log("Clicked on " + value);
		}
		List<WebElement> labelText = getElementList(gridLabelValues);
		for (int i = 0; i < labelText.size(); i++)
			gridValues.add(getElementText(labelText.get(i), 3).trim());
		clickOnGridAddBtn();
		return gridValues;
	}

	public boolean verifyColumnInGrid(List<String> list) {
		List<WebElement> listHeaders = getElementList(gridHeaders);
		List<String> gridHeaderValues = new ArrayList<String>();
		for (int i = 0; i < listHeaders.size(); i++) {
			gridHeaderValues.add(getElementText(listHeaders.get(i), 3));
		}
		gridHeaderValues.remove(0);
		gridHeaderValues.remove(0);
		for (int i = 0; i < list.size(); i++) {
			if (!gridHeaderValues.contains(list.get(i)))
				return false;
		}
		return true;
	}

	public void clickOnSortBtn(String columnName, String order) {
		clickOnElement(By.xpath(String.format(sorting, columnName)), 0);
		if (order.equalsIgnoreCase("ASC")) {
			if (verifyVisible(By.xpath(String.format(sortingOrder, columnName)), 5))
				clickOnElement(By.xpath(String.format(sorting, columnName)), 0);
		} else {
			if (verifyVisible(By.xpath(String.format(sortingOrder, columnName)), 5))
				clickOnElement(By.xpath(String.format(sorting, columnName)), 0);
		}
	}

	public Map<String, List<String>> getTableData(String uniqueColumnName) {
		List<WebElement> tableRows = getElementList(rows);
		List<String> list;
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		for (int i = 1; i <= tableRows.size(); i++) {
			list = new ArrayList<String>();
			List<WebElement> tableCols = getElementList(By.xpath(String.format(tableColumn, i)), 0);
			for (int j = 0; j < tableCols.size(); j++)
				list.add(tableCols.get(j).getText());
			map.put(getElementText(By.xpath(String.format(uniqueColumn, i)), 3), list);
		}
		return map;
	}

	public void sortColumn(List<String> list, String order) {
		if (order.equalsIgnoreCase("Desc")) {
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				String word = list.get(i);
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}
			}
			List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
			Collections.sort(entries, descComparator);
		} else {
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				String word = list.get(i);
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word, 1);
				}
			}
			List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
			Collections.sort(entries, ascComparator);
		}
	}

	public List<String> getColumnData(String string) {
		List<String> columnData = new ArrayList<String>();
		List<WebElement> columns = getElementList(columnList);
		for (int i = 0; i < columns.size(); i++)
			columnData.add(columns.get(i).getText().toString());
		return columnData;
	}

	public boolean sorting(Map<Object, Object> map, List<Object> mapKeys) {
		Map<String, List<String>> getBeforeSortTableData = getTableData(map.get(mapKeys.get(2)).toString());
		clickOnSortBtn(map.get(mapKeys.get(0)).toString(), map.get(mapKeys.get(1)).toString());
		List<String> sortedUIColumnData = getColumnData(map.get(mapKeys.get(0)).toString());
		List<String> sortedUIColumnDataCopy = new ArrayList<>(sortedUIColumnData);
		sortColumn(sortedUIColumnData, map.get(mapKeys.get(1)).toString());
		if (!Utility.compareTwoLists(sortedUIColumnData, sortedUIColumnDataCopy))
			return false;
		Map<String, List<String>> getAfterSortTableData = getTableData(map.get(mapKeys.get(2)).toString());
		if (!getBeforeSortTableData.equals(getAfterSortTableData))
			return false;
		return true;
	}
	public void clickOnBackBtn() {
		clickOnElement(btnBack);
	}
	
	public String getUIText(By element) {
		return findPresentElement(element).getText().trim();
	}
}
