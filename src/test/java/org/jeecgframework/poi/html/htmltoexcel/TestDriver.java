package org.jeecgframework.poi.html.htmltoexcel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.html.HtmlToExcelServer;
import org.jeecgframework.poi.test.entity.CourseEntity;
import org.junit.Test;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @version 0.0.1
 * @since 0.0.1
 * @author Shaun Chyxion <br>
 * chyxion@163.com <br>
 * Oct 24, 2014 2:07:51 PM
 */
public class TestDriver {

    @Test
    public void run() throws Exception {
        StringBuilder html = new StringBuilder();
        Scanner s = new Scanner(getClass().getResourceAsStream("/html/sample.html"), "utf-8");
        while (s.hasNext()) {
            html.append(s.nextLine());
        }
        s.close();
       // Workbook workbook = new HSSFWorkbook();
        Workbook workbook = new XSSFWorkbook();
        new HtmlToExcelServer().createSheet(html.toString(), workbook);
        File savefile = new File("D:\\home\\lemur");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:\\home\\lemur\\data.xlsx");
        workbook.write(fos);
        fos.close();
    }
}
