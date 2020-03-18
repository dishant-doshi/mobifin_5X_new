package base;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestDataImport extends SetupInit {
	public static Object[][] readExcelFileTo2D(String filepath, String sheetname) {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(filepath));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetname);
		int lastRowNum = sheet.getRows();
		Object[][] object = new Object[lastRowNum - 1][1];
		for (int i = 1; i < lastRowNum; i++) {
			Map<Object, Object> map = new LinkedHashMap<Object, Object>();
			for (int j = 0; j < sheet.getColumns(); j++) {
				map.put(removeExtraSpaces(sheet.getCell(j, 0).getContents().toString().trim().replaceAll("  ", " ")),
						removeExtraSpaces(sheet.getCell(j, i).getContents().toString().trim().replaceAll("  ", " ")));
			}
			object[i - 1][0] = map;
		}
		return object;
	}

	/**
	 * @author dishant.doshi to remove extra spaces in string
	 * @param string
	 * @return string with one space
	 * @creation date 28/12/2018
	 */
	public static String removeExtraSpaces(String string) {
		return string.replaceAll("\\s+", " ");
	}

	public static int findRow(String fileName, String sheetName, String cellContent) {
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getRows();
		for (int i = 1; i < rows; i++) {
			Cell cell = sheet.getCell(0, i);
			if (cell.getContents().toString().equals(cellContent)) {
				return i;
			}
		}
		return 0;
	}

	public static Map<Object, Object> readExcelFileTo2D(String fileName, String sheetName, int rowNumber) {
		File inputWorkbook = new File(fileName);
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(inputWorkbook);
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		Map<Object, Object> map = new LinkedHashMap<Object, Object>();
		Sheet sheet = workbook.getSheet(sheetName);
		int columns = sheet.getColumns();
		for (int j = 0; j < columns; j++) {
			map.put(sheet.getCell(j, 0).getContents().toString().trim().replaceAll("  ", " "),
					sheet.getCell(j, rowNumber).getContents().toString().trim().replaceAll("  ", " "));
		}
		return map;
	}

	/**
	 * @author shivani.patel data provider for add parameter
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Parameter_Add")
	public static Object[][] Parameter_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Parameter_Add");
	}

	/**
	 * @author shivani.patel data provider for edit parameter
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "Parameter_Edit")
	public static Object[][] Parameter_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Parameter_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete parameter
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "Parameter_Delete")
	public static Object[][] Parameter_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Parameter_Delete");
	}

	/**
	 * @author shivani.patel data provider for add userCategory
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "UserCategory_Add")
	public static Object[][] UserCategory_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "UserCategory_Add");
	}

	/**
	 * @author shivani.patel data provider for edit userCategory
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "UserCategory_Edit")
	public static Object[][] UserCategory_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "UserCategory_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete userCategory
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "UserCategory_Delete")
	public static Object[][] UserCategory_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "UserCategory_Delete");
	}

	/**
	 * @author shivani.patel data provider for add wallet
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "Wallet_Add")
	public static Object[][] Wallet_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Wallet_Add");
	}

	/**
	 * @author shivani.patel data provider for edit wallet
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "Wallet_Edit")
	public static Object[][] Wallet_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Wallet_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete wallet
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "Wallet_Delete")
	public static Object[][] Wallet_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Wallet_Delete");
	}

	/**
	 * @author shivani.patel data provider for add unit
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "Unit_Add")
	public static Object[][] Unit_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Unit_Add");
	}

	/**
	 * @author shivani.patel data provider for edit unit
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "Unit_Edit")
	public static Object[][] Unit_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Unit_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete unit
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "Unit_Delete")
	public static Object[][] Unit_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Unit_Delete");
	}

	/**
	 * @author shivani.patel data provider for add pouch
	 * @return excel data
	 * @creation date 30/07/2019
	 */
	@DataProvider(name = "Pouch_Add")
	public static Object[][] Pouch_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Pouch_Add");
	}

	/**
	 * @author shivani.patel data provider for edit pouch
	 * @return excel data
	 * @creation date 30/07/2019
	 */
	@DataProvider(name = "Pouch_Edit")
	public static Object[][] Pouch_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Pouch_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete pouch
	 * @return excel data
	 * @creation date 30/07/2019
	 */
	@DataProvider(name = "Pouch_Delete")
	public static Object[][] Pouch_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Pouch_Delete");
	}

	/**
	 * @author shivani.patel data provider for add service
	 * @return excel data
	 * @creation date 31/07/2019
	 */
	@DataProvider(name = "Service_Add")
	public static Object[][] Service_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Service_Add");
	}

	/**
	 * @author shivani.patel data provider for edit service
	 * @return excel data
	 * @creation date 31/07/2019
	 */
	@DataProvider(name = "Service_Edit")
	public static Object[][] Service_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Service_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete service
	 * @return excel data
	 * @creation date 31/07/2019
	 */
	@DataProvider(name = "Service_Delete")
	public static Object[][] Service_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Service_Delete");
	}

	/**
	 * @author shivani.patel data provider for add accessChannel
	 * @return excel data
	 * @creation date 31/07/2019
	 */
	@DataProvider(name = "AccessChannel_Add")
	public static Object[][] AccessChannel_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "AccessChannel_Add");
	}

	/**
	 * @author shivani.patel data provider for edit accessChannel
	 * @return excel data
	 * @creation date 31/07/2019
	 */
	@DataProvider(name = "AccessChannel_Edit")
	public static Object[][] AccessChannel_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "AccessChannel_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete accessChannel
	 * @return excel data
	 * @creation date 31/07/2019
	 */
	@DataProvider(name = "AccessChannel_Delete")
	public static Object[][] AccessChannel_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "AccessChannel_Delete");
	}

	/**
	 * @author shivani.patel data provider for add ucp
	 * @return excel data
	 * @creation date 01/08/2019
	 */
	@DataProvider(name = "Ucp_Add")
	public static Object[][] Ucp_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Ucp_Add");
	}

	/**
	 * @author shivani.patel data provider for edit ucp
	 * @return excel data
	 * @creation date 01/08/2019
	 */
	@DataProvider(name = "Ucp_Edit")
	public static Object[][] Ucp_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Ucp_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete ucp
	 * @return excel data
	 * @creation date 01/08/2019
	 */
	@DataProvider(name = "Ucp_Delete")
	public static Object[][] Ucp_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Ucp_Delete");
	}

	/**
	 * @author shivani.patel data provider for add rule
	 * @return excel data
	 * @creation date 02/08/2019
	 */
	@DataProvider(name = "Rule_Add")
	public static Object[][] Rule_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Rule_Add");
	}

	/**
	 * @author shivani.patel data provider for edit rule
	 * @return excel data
	 * @creation date 02/08/2019
	 */
	@DataProvider(name = "Rule_Edit")
	public static Object[][] Rule_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Rule_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete rule
	 * @return excel data
	 * @creation date 02/08/2019
	 */
	@DataProvider(name = "Rule_Delete")
	public static Object[][] Rule_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Rule_Delete");
	}

	/**
	 * @author shivani.patel data provider for add notificationTemplate
	 * @return excel data
	 * @creation date 02/08/2019
	 */
	@DataProvider(name = "NotificationTemplate_Add")
	public static Object[][] NotificationTemplate_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "NotificationTemplate_Add");
	}

	/**
	 * @author shivani.patel data provider for edit notificationTemplate
	 * @return excel data
	 * @creation date 02/08/2019
	 */
	@DataProvider(name = "NotificationTemplate_Edit")
	public static Object[][] NotificationTemplate_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "NotificationTemplate_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete notificationTemplate
	 * @return excel data
	 * @creation date 02/08/2019
	 */
	@DataProvider(name = "NotificationTemplate_Delete")
	public static Object[][] NotificationTemplate_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "NotificationTemplate_Delete");
	}

	/**
	 * @author shivani.patel data provider for add exchangeRateManager
	 * @return excel data
	 * @creation date 02/08/2019
	 */
	@DataProvider(name = "ExchangeRateManager_Add")
	public static Object[][] ExchangeRateManager_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "ExchangeRateManager_Add");
	}

	/**
	 * @author shivani.patel data provider for edit exchangeRateManager
	 * @return excel data
	 * @creation date 02/08/2019
	 */
	@DataProvider(name = "ExchangeRateManager_Edit")
	public static Object[][] ExchangeRateManager_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "ExchangeRateManager_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete exchangeRateManager
	 * @return excel data
	 * @creation date 02/08/2019
	 */
	@DataProvider(name = "ExchangeRateManager_Delete")
	public static Object[][] ExchangeRateManager_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "ExchangeRateManager_Delete");
	}

	/**
	 * @author shivani.patel data provider for add product
	 * @return excel data
	 * @creation date 05/08/2019
	 */
	@DataProvider(name = "Product_Add")
	public static Object[][] Product_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Product_Add");
	}

	/**
	 * @author shivani.patel data provider for edit product
	 * @return excel data
	 * @creation date 05/08/2019
	 */
	@DataProvider(name = "Product_Edit")
	public static Object[][] Product_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Product_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete product
	 * @return excel data
	 * @creation date 05/08/2019
	 */
	@DataProvider(name = "Product_Delete")
	public static Object[][] Product_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Product_Delete");
	}

	/**
	 * @author shivani.patel data provider for add productGroup
	 * @return excel data
	 * @creation date 05/08/2019
	 */
	@DataProvider(name = "ProductGroup_Add")
	public static Object[][] ProductGroup_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "ProductGroup_Add");
	}

	/**
	 * @author shivani.patel data provider for edit productGroup
	 * @return excel data
	 * @creation date 05/08/2019
	 */
	@DataProvider(name = "ProductGroup_Edit")
	public static Object[][] ProductGroup_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "ProductGroup_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete productGroup
	 * @return excel data
	 * @creation date 05/08/2019
	 */
	@DataProvider(name = "ProductGroup_Delete")
	public static Object[][] ProductGroup_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "ProductGroup_Delete");
	}

	/**
	 * @author shivani.patel data provider for add counter
	 * @return excel data
	 * @creation date 06/08/2019
	 */
	@DataProvider(name = "Counter_Add")
	public static Object[][] Counter_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Counter_Add");
	}

	/**
	 * @author shivani.patel data provider for edit counter
	 * @return excel data
	 * @creation date 06/08/2019
	 */
	@DataProvider(name = "Counter_Edit")
	public static Object[][] Counter_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Counter_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete counter
	 * @return excel data
	 * @creation date 06/08/2019
	 */
	@DataProvider(name = "Counter_Delete")
	public static Object[][] Counter_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Counter_Delete");
	}

	/**
	 * @author shivani.patel data provider for add KYC
	 * @return excel data
	 * @creation date 06/08/2019
	 */
	@DataProvider(name = "KYC_Add")
	public static Object[][] KYC_Add() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "KYC_Add");
	}

	/**
	 * @author shivani.patel data provider for edit KYC
	 * @return excel data
	 * @creation date 06/08/2019
	 */
	@DataProvider(name = "KYC_Edit")
	public static Object[][] KYC_Edit() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "KYC_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete KYC
	 * @return excel data
	 * @creation date 06/08/2019
	 */
	@DataProvider(name = "KYC_Delete")
	public static Object[][] KYC_Delete() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "KYC_Delete");
	}

	/**
	 * @author shivani.patel data provider for delete wallet
	 * @return excel data
	 * @creation date 29/07/2019
	 */
	@DataProvider(name = "Usercategory_Sort")
	public static Object[][] Usercategory_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Usercategory_Sort");
	}

	/**
	 * @author shivani.patel data provider for add role
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Role_Add")
	public static Object[][] Role_Add() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "Role_Add");
	}

	/**
	 * @author shivani.patel data provider for edit role
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "Role_Edit")
	public static Object[][] Role_Edit() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "Role_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete role
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "Role_Delete")
	public static Object[][] Role_Delete() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "Role_Delete");
	}

	/**
	 * @author shivani.patel data provider for add SystemOperatorEntity
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "SystemOperatorEntity_Add")
	public static Object[][] SystemOperatorEntity_Add() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorEntity_Add");
	}

	/**
	 * @author shivani.patel data provider for edit SystemOperatorEntity
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "SystemOperatorEntity_Edit")
	public static Object[][] SystemOperatorEntity_Edit() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorEntity_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete SystemOperatorEntity
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "SystemOperatorEntity_Delete")
	public static Object[][] SystemOperatorEntity_Delete() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorEntity_Delete");
	}

	/**
	 * @author shivani.patel data provider for add SystemOperatorOnboarding
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "SystemOperatorOnboarding_Add")
	public static Object[][] SystemOperatorOnboarding_Add() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorOnboarding_Add");
	}

	/**
	 * @author shivani.patel data provider for edit SystemOperatorOnboarding
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "SystemOperatorOnboarding_Edit")
	public static Object[][] SystemOperatorOnboarding_Edit() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorOnboarding_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete SystemOperatorOnboarding
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "SystemOperatorOnboarding_Delete")
	public static Object[][] SystemOperatorOnboarding_Delete() {
		return readExcelFileTo2D(OPERATORCONFIG_FILE_PATH, "SystemOperatorOnboarding_Delete");
	}

	/**
	 * @author shivani.patel data provider for add serviceVendor
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "ServiceVendor_Add")
	public static Object[][] ServiceVendor_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "ServiceVendor_Add");
	}

	/**
	 * @author shivani.patel data provider for edit serviceVendor
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "ServiceVendor_Edit")
	public static Object[][] ServiceVendor_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "ServiceVendor_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete serviceVendor
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "ServiceVendor_Delete")
	public static Object[][] ServiceVendor_Delete() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "ServiceVendor_Delete");
	}

	/**
	 * @author shivani.patel data provider for add notification
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Notification_Add")
	public static Object[][] Notification_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "Notification_Add");
	}

	/**
	 * @author shivani.patel data provider for edit notification
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "Notification_Edit")
	public static Object[][] Notification_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "Notification_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete notification
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "Notification_Delete")
	public static Object[][] Notification_Delete() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "Notification_Delete");
	}

	/**
	 * @author shivani.patel data provider for add ServiceProfile
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "ServiceProfile_Add")
	public static Object[][] ServiceProfile_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "ServiceProfile_Add");
	}

	/**
	 * @author shivani.patel data provider for edit ServiceProfile
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "ServiceProfile_Edit")
	public static Object[][] ServiceProfile_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "ServiceProfile_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete ServiceProfile
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "ServiceProfile_Delete")
	public static Object[][] ServiceProfile_Delete() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "ServiceProfile_Delete");
	}

	/**
	 * @author shivani.patel data provider for edit productManagement
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "ProductManagement_Edit")
	public static Object[][] ProductManagement_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "ProductManagement_Edit");
	}

	/**
	 * @author shivani.patel data provider for add TechnicalVendor
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "TechnicalVendor_Add")
	public static Object[][] TechnicalVendor_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "TechnicalVendor_Add");
	}

	/**
	 * @author shivani.patel data provider for edit TechnicalVendor
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "TechnicalVendor_Edit")
	public static Object[][] TechnicalVendor_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "TechnicalVendor_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete TechnicalVendor
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "TechnicalVendor_Delete")
	public static Object[][] TechnicalVendor_Delete() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "TechnicalVendor_Delete");
	}

	/**
	 * @author shivani.patel data provider for add BusinessZone
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "BusinessZone_Add")
	public static Object[][] BusinessZone_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "BusinessZone_Add");
	}

	/**
	 * @author shivani.patel data provider for edit BusinessZone
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "BusinessZone_Edit")
	public static Object[][] BusinessZone_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "BusinessZone_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete BusinessZone
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "BusinessZone_Delete")
	public static Object[][] BusinessZone_Delete() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "BusinessZone_Delete");
	}

	/**
	 * @author shivani.patel data provider for add BusinessZone
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "RegionalEntity_Add")
	public static Object[][] RegionalEntity_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "RegionalEntity_Add");
	}

	/**
	 * @author shivani.patel data provider for edit BusinessZone
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "RegionalEntity_Edit")
	public static Object[][] RegionalEntity_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "RegionalEntity_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete BusinessZone
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "RegionalEntity_Delete")
	public static Object[][] RegionalEntity_Delete() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "RegionalEntity_Delete");
	}

	/**
	 * @author shivani.patel data provider for add BusinessZone
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "OperatingEntityTemplate_Add")
	public static Object[][] OperatingEntityTemplate_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "OperatingEntityTemplate_Add");
	}

	/**
	 * @author shivani.patel data provider for edit BusinessZone
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "OperatingEntityTemplate_Edit")
	public static Object[][] OperatingEntityTemplate_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "OperatingEntityTemplate_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete BusinessZone
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "OperatingEntityTemplate_Delete")
	public static Object[][] OperatingEntityTemplate_Delete() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "OperatingEntityTemplate_Delete");
	}

	/**
	 * @author shivani.patel data provider for add BusinessZone
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "WalletTemplate_Add")
	public static Object[][] WalletTemplate_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "WalletTemplate_Add");
	}

	/**
	 * @author shivani.patel data provider for edit BusinessZone
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "WalletTemplate_Edit")
	public static Object[][] WalletTemplate_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "WalletTemplate_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete BusinessZone
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "WalletTemplate_Delete")
	public static Object[][] WalletTemplate_Delete() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "WalletTemplate_Delete");
	}

	/**
	 * @author shivani.patel data provider for add OperatingEntity
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "OperatingEntity_Add")
	public static Object[][] OperatingEntity_Add() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "OperatingEntity_Add");
	}

	/**
	 * @author shivani.patel data provider for edit OperatingEntity
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "OperatingEntity_Edit")
	public static Object[][] OperatingEntity_Edit() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "OperatingEntity_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete OperatingEntity
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "OperatingEntity_Delete")
	public static Object[][] OperatingEntity_Delete() {
		return readExcelFileTo2D(BUSINESSCONFIG_FILE_PATH, "OperatingEntity_Delete");
	}

	/**
	 * @author shivani.patel data provider for add ReportTool
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "ReportTool_Add")
	public static Object[][] ReportTool_Add() {
		return readExcelFileTo2D(OPERATION_FILE_PATH, "ReportTool_Add");
	}

	/**
	 * @author shivani.patel data provider for edit ReportTool
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "ReportTool_Edit")
	public static Object[][] ReportTool_Edit() {
		return readExcelFileTo2D(OPERATION_FILE_PATH, "ReportTool_Edit");
	}

	/**
	 * @author shivani.patel data provider for delete ReportTool
	 * @return excel data
	 * @creation date 26/07/2019
	 */
	@DataProvider(name = "ReportTool_Delete")
	public static Object[][] ReportTool_Delete() {
		return readExcelFileTo2D(OPERATION_FILE_PATH, "ReportTool_Delete");
	}

	/**
	 * @author shivani.patel data provider for addMoney
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "AddMoney_Add")
	public static Object[][] AddMoney_Add() {
		return readExcelFileTo2D(OPERATION_FILE_PATH, "AddMoney_Add");
	}

	/**
	 * @author shivani.patel data provider for sort parameter
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Parameter_Sort")
	public static Object[][] Parameter_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Parameter_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort kyc
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "KYC_Sort")
	public static Object[][] KYC_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "KYC_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort wallet
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Wallet_Sort")
	public static Object[][] Wallet_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Wallet_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort wallet
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Unit_Sort")
	public static Object[][] Unit_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Unit_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort pouch
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Pouch_Sort")
	public static Object[][] Pouch_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Pouch_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort service
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Service_Sort")
	public static Object[][] Service_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Service_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort accessChannel
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "AccessChannel_Sort")
	public static Object[][] AccessChannel_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "AccessChannel_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort ucp
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Ucp_Sort")
	public static Object[][] Ucp_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Ucp_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort counter
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Counter_Sort")
	public static Object[][] Counter_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Counter_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort rule
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Rule_Sort")
	public static Object[][] Rule_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Rule_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort notificationTemplate
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "NotificationTemplate_Sort")
	public static Object[][] NotificationTemplate_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "NotificationTemplate_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort product
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Product_Sort")
	public static Object[][] Product_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Product_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort product
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "ProductGroup_Sort")
	public static Object[][] ProductGroup_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "ProductGroup_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort product
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "ServiceProfile_Sort")
	public static Object[][] ServiceProfile_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "ServiceProfile_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort service vendor
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "ServiceVendor_Sort")
	public static Object[][] ServiceVendor_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "ServiceVendor_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort technical vendor
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "TechnicalVendor_Sort")
	public static Object[][] TechnicalVendor_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "TechnicalVendor_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort technical vendor
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Notification_Sort")
	public static Object[][] Notification_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Notification_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort role
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "Role_Sort")
	public static Object[][] Role_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "Role_Sort");
	}

	/**
	 * @author shivani.patel data provider for sort systemOperatorEntity
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "SystemOperatorEntity_Sort")
	public static Object[][] SystemOperatorEntity_Sort() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "SystemOperatorEntity_Sort");
	}

	/**
	 * @author dharti.patel data provider for Add Scheduler
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "TechnicalConfig_AddScheduler")
	public static Object[][] TechnicalConfig_AddScheduler() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "TechnicalConfig_AddScheduler");
	}

	/**
	 * @author dharti.patel data provider for Edit Scheduler
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "TechnicalConfig_EditScheduler")
	public static Object[][] TechnicalConfig_EditScheduler() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "TechnicalConfig_EditScheduler");
	}

	/**
	 * @author dharti.patel data provider for Delete Scheduler
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "TechnicalConfig_DeleteScheduler")
	public static Object[][] TechnicalConfig_DeleteScheduler() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "TechnicalConfig_DeleteScheduler");
	}

	/**
	 * @author dharti.patel data provider for Add Process Scheduler
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "TechnicalConfig_AddProcessScheduler")
	public static Object[][] TechnicalConfig_AddProcessScheduler() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "TechnicalConfig_AddProcessSched");
	}

	/**
	 * @author dharti.patel data provider for Add Process Scheduler
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "TechnicalConfig_EditProcessScheduler")
	public static Object[][] TechnicalConfig_EditProcessScheduler() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "TechnicalConfig_EditProcessSche");
	}

	/**
	 * @author dharti.patel data provider for Add Process Scheduler
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "TechnicalConfig_DeleteProcessScheduler")
	public static Object[][] TechnicalConfig_DeleteProcessScheduler() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "TechnicalConfig_DeleteProcessS");
	}

	/**
	 * @author dharti.patel data provider for Add Process Scheduler
	 * @return excel data
	 * @creation date 17/07/2019
	 */
	@DataProvider(name = "TechnicalConfig_ProcessRunDetails")
	public static Object[][] TechnicalConfig_ProcessRunDetails() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "TechnicalConfig_ProcessRunDetai");
	}

	@DataProvider(name = "UserManagement_ResetPassword")
	public static Object[][] UserManagement_ResetPassword() {
		return readExcelFileTo2D(PLATEFORMCONFIGURATION_FILE_PATH, "UserMgt_ResetPassword");
	}
}
