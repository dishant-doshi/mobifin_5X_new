package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultData {
	protected static final String TESTDATA_FOLDER = ReadProperty.getPropertyValue("TESTDATA_FOLDER");
	public static final String FILE_NAME = TESTDATA_FOLDER + File.separator + "Default.xls";

	public static void main(String[] args) {
		Map<String, Map<String, List<String>>> map = getData();
		Map<String, List<String>> parameterMap = map.get("Parameter");
		for (Map.Entry<String, List<String>> m : parameterMap.entrySet()) {
			System.out.println(m.getValue().get(0));
		}
	}

	public static Map<String, Map<String, List<String>>> getData() {
		Map<String, Map<String, List<String>>> dataMap = new HashMap<String, Map<String, List<String>>>();
		Map<String, List<String>> map;
		List<String> list;
		List<String> sheets = ExcelUtility.getSheets(FILE_NAME);
		for (int i = 0; i < sheets.size(); i++) {
			map = new HashMap<String, List<String>>();
			int rows = ExcelUtility.getRowCount(FILE_NAME, sheets.get(i)) + 1;
			int cols = ExcelUtility.getColCount(FILE_NAME, sheets.get(i));
			for (int k = 0; k < cols; k++) {
				list = new ArrayList<String>();
				String headerName = ExcelUtility.getCellData(FILE_NAME, sheets.get(i), 0, k);
				for (int j = 1; j < rows; j++) {
					list.add(ExcelUtility.getCellData(FILE_NAME, sheets.get(i), j, k));
				}
				map.put(headerName, list);
			}
			dataMap.put(sheets.get(i), map);
		}
		return dataMap;
	}
}
