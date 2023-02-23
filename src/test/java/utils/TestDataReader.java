package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader {
    private static HashMap<String, HashMap<String, String>> data;
    private static XSSFWorkbook workbook = null;

    public TestDataReader() {
    }

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        if (workbook == null) {
            FileInputStream fileInputStream = null;

            try {
                fileInputStream = new FileInputStream("src/test/resources/Group7_SearchBar.xlsx");
            } catch (FileNotFoundException var9) {
                throw new RuntimeException(var9);
            }

            try {
                workbook = new XSSFWorkbook(fileInputStream);
            } catch (IOException var8) {
                throw new RuntimeException(var8);
            }

            XSSFSheet sheet = workbook.getSheet("Sheet1");
            data = new HashMap();

            for(int i = 1; i <= sheet.getLastRowNum(); ++i) {
                Row row = sheet.getRow(i);
                System.out.println(i);
                String key = row.getCell(0).getStringCellValue();
                HashMap<String, String> rowData = new HashMap();

                for(int j = 1; j < row.getLastCellNum(); ++j) {
                    String columnName = sheet.getRow(0).getCell(j).getStringCellValue();
                    System.out.println(j);
                    if (row.getCell(j) != null) {
                        rowData.put(columnName, row.getCell(j).getStringCellValue());
                    }
                }

                data.put(key, rowData);
            }
        }

    }

    public static HashMap<String, String> getData(String key) {
        init();
        return (HashMap)data.get(key);
    }
}

