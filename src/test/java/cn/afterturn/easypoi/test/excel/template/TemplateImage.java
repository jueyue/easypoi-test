package cn.afterturn.easypoi.test.excel.template;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelStyleType;
import cn.afterturn.easypoi.test.entity.CourseEntity;

/**
 * 图片导出
 * Created by JueYue on 2017/9/15.
 */
public class TemplateImage {

    @Test
    public void img03() throws Exception {
        TemplateExportParams params = new TemplateExportParams(
                "doc/exportTemp_image.xls", true);
        Map<String, Object> map = new HashMap<String, Object>();
        // sheet 2
        map.put("month", 10);
        Map<String, Object> temp;
        for (int i = 1; i < 8; i++) {
            temp = new HashMap<String, Object>();
            temp.put("per", i * 10);
            temp.put("mon", i * 1000);
            temp.put("summon", i * 10000);
            ImageEntity image = new ImageEntity();
            image.setHeight(200);
            image.setWidth(500);
            image.setUrl("imgs/company/baidu.png");
            temp.put("image", image);
            map.put("i" + i, temp);
        }
        Workbook book = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("D:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/excel/exportTemp_image.xls");
        book.write(fos);
        fos.close();

    }

    @Test
    public void img07() throws Exception {
        TemplateExportParams params = new TemplateExportParams(
                "doc/exportTemp_image.xlsx", true);
        Map<String, Object> map = new HashMap<String, Object>();
        // sheet 2
        map.put("month", 10);
        Map<String, Object> temp;
        for (int i = 1; i < 8; i++) {
            temp = new HashMap<String, Object>();
            temp.put("per", i * 10);
            temp.put("mon", i * 1000);
            temp.put("summon", i * 10000);
            ImageEntity image = new ImageEntity();
            image.setHeight(200);
            image.setWidth(500);
            image.setUrl("imgs/company/baidu.png");
            temp.put("image", image);
            map.put("i" + i, temp);
        }
        Workbook book = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("D:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/excel/exportTemp_image.xlsx");
        book.write(fos);
        fos.close();

    }
}
