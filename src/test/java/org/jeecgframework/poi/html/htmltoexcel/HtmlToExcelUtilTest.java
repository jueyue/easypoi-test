package org.jeecgframework.poi.html.htmltoexcel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.HtmlToExcelUtil;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecgframework.poi.excel.html.HtmlToExcelServer;
import org.jeecgframework.poi.test.entity.CourseEntity;
import org.junit.Test;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 
 * @author JueYue
 * 2017年4月16日
 */
public class HtmlToExcelUtilTest {

    @Test
    public void htmlToExcelByStr() throws Exception {
        StringBuilder html = new StringBuilder();
        Scanner s = new Scanner(getClass().getResourceAsStream("/html/sample.html"), "utf-8");
        while (s.hasNext()) {
            html.append(s.nextLine());
        }
        s.close();
        Workbook workbook = HtmlToExcelUtil.htmlToExcel(html.toString(), ExcelType.XSSF);
        File savefile = new File("D:\\home\\lemur");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:\\home\\lemur\\htmlToExcelByStr.xlsx");
        workbook.write(fos);
        fos.close();
        workbook = HtmlToExcelUtil.htmlToExcel(html.toString(), ExcelType.HSSF);
        fos = new FileOutputStream("D:\\home\\lemur\\htmlToExcelByStr.xls");
        workbook.write(fos);
        fos.close();
    }

    @Test
    public void htmlToExcelByIs() throws Exception {
        Workbook workbook = HtmlToExcelUtil.htmlToExcel(getClass().getResourceAsStream("/html/sample.html"), ExcelType.XSSF);
        File savefile = new File("D:\\home\\lemur");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:\\home\\lemur\\htmlToExcelByIs.xlsx");
        workbook.write(fos);
        fos.close();
        workbook = HtmlToExcelUtil.htmlToExcel(getClass().getResourceAsStream("/html/sample.html"), ExcelType.HSSF);
        fos = new FileOutputStream("D:\\home\\lemur\\htmlToExcelByIs.xls");
        workbook.write(fos);
        fos.close();
    }

}
