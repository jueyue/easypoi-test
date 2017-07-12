package cn.afterturn.easypoi.html;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import cn.afterturn.easypoi.excel.ExcelXorHtmlUtil;
import cn.afterturn.easypoi.excel.entity.ExcelToHtmlParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;

public class ExcelXorHtmlUtilTest {

    @Test
    public void testToTableHtmlWorkbook() {
        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File(PoiPublicUtil
                .getWebRootPath("cn/afterturn/easypoi/test/excel/doc/专项支出用款申请书.xls"))));
            String html = ExcelXorHtmlUtil.toTableHtml(wb);
            FileWriter fw = new FileWriter("D:/excel/专项支出用款申请书_table.html");
            fw.write(html);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToTableHtmlWorkbookInt() {
        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File(PoiPublicUtil
                .getWebRootPath("cn/afterturn/easypoi/test/excel/doc/exportTemp.xls"))));
            String html = ExcelXorHtmlUtil.excelToHtml(new ExcelToHtmlParams(wb, 1));
            FileWriter fw = new FileWriter("D:/excel/exportTemp_table.html");
            fw.write(html);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToAllHtmlWorkbookAndImage() {

        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File("D:/excel/tt.xls")));
            //            Workbook wb = new HSSFWorkbook(new FileInputStream(
            //                new File(
            //                    PoiPublicUtil
            //                    .getWebRootPath("cn/afterturn/easypoi/test/excel/doc/专项支出用款申请书.xls"))));
            long d = System.nanoTime();
            String html = ExcelXorHtmlUtil.excelToHtml(new ExcelToHtmlParams(wb,true,"D:/excel/"));
            FileWriter fw = new FileWriter("D:/excel/专项支出用款申请书_all.html");
            fw.write(html);
            fw.close();

            System.err.println(System.nanoTime() - d);
            d = System.nanoTime();
            html = ExcelXorHtmlUtil.excelToHtml(new ExcelToHtmlParams(wb,true,"D:/excel/"));
            fw = new FileWriter("D:/excel/专项支出用款申请书_all_cache.html");
            fw.write(html);
            fw.close();
            System.err.println(System.nanoTime() - d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToAllHtmlWorkbook() {

        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File("D:/excel/tt.xls")));
            //            Workbook wb = new HSSFWorkbook(new FileInputStream(
            //                new File(
            //                    PoiPublicUtil
            //                    .getWebRootPath("cn/afterturn/easypoi/test/excel/doc/专项支出用款申请书.xls"))));
            String html = ExcelXorHtmlUtil.toAllHtml(wb);
            FileWriter fw = new FileWriter("D:/excel/专项支出用款申请书_all.html");
            fw.write(html);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToAllHtmlWorkbookInt() {
        try {
            Workbook wb = new HSSFWorkbook(new FileInputStream(new File(PoiPublicUtil
                .getWebRootPath("cn/afterturn/easypoi/test/excel/doc/exportTemp.xls"))));
            String html = ExcelXorHtmlUtil.excelToHtml(new ExcelToHtmlParams(wb,true,1,null));
            FileWriter fw = new FileWriter("D:/excel/exportTemp_all.html");
            fw.write(html);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
