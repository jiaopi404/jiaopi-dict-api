package org.jiaopi.entity;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class ExcelUtil {

    /**
     * 读取 excel 文件，返回 workbook 对象
     * @param filePath xlsx 文件路径
     * @return Workbook
     */
    public Workbook getExcelByFilePath (String filePath) {
        Workbook workbook = null;
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("file is not exist, file path: " + filePath);
        } else {
            String fileType = filePath.substring(filePath.lastIndexOf(".")); // 获取后缀名
            try {
                InputStream is = new FileInputStream(filePath);
                if (".xls".equals(fileType)) { // 如果 xls 格式
                    workbook = new HSSFWorkbook(is);
                } else if (".xlsx".equals(fileType)) { // 如果 xlsx 格式
                    workbook = new XSSFWorkbook(is);
                } else {
                    System.out.println("格式不正确");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }

    /**
     * 读取 excel 文件，通过 IO 读取，返回 workbook 对象; TODO 待补充
     * @param inputStream InputStream
     * @param excelName Excel 文件名字
     * @return Workbook
     */
    public Workbook getExcelByIO (InputStream inputStream, String excelName) {
        Workbook wb = null;
        return wb;
    }

    public List<String[]> analyzeExcel (Workbook wb) {
        Sheet sheet = wb.getSheetAt(0); // 读取 sheet (start from 0)
        int rowNum = sheet.getLastRowNum(); // 读取行数，从 0 计数
        List<String[]> result = new LinkedList<>();
        for (int i = 0; i <= rowNum; i++) {
            Row row = sheet.getRow(i); // 获取当前行
            int colNum = row.getLastCellNum(); // 获取当前行列数
            String[] cellContent = new String[colNum];
            for (int j = 0; j < colNum; j++) {
                Cell cell = row.getCell(j); // 获取单元格
                if (cell == null) {
//                    System.out.println(i + "行， " + j + "列为 null");
                    cellContent[j] = ""; // 空行给 ""
                } else {
                    cellContent[j] = cell.toString();
                }
            }
            result.add(cellContent);
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelUtil excelUtil = new ExcelUtil();
        Workbook wb = excelUtil.getExcelByFilePath("/Users/jiaopi404/Desktop/github_demos/jiaopi-dict-api/src/main/java/org/jiaopi/entity/testFiles/导入校内基本支出预算模板.xlsx");
        List<String[]> result = excelUtil.analyzeExcel(wb);
        for (int i = 0; i < result.size(); i++) {
            String[] row = result.get(i);
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
        System.out.println(result);
    }
}
