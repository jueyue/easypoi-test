package cn.afterturn.easypoi.test.word;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import cn.afterturn.easypoi.test.word.entity.Person;
import cn.afterturn.easypoi.word.WordExportUtil;
import cn.afterturn.easypoi.word.entity.WordImageEntity;

import org.junit.Test;

public class WordExportUtilBaseExcelTest {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd");

    /**
     * 简单导出包含图片
     */
    @Test
    public void imageWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("department", "Easypoi");
        map.put("time", format.format(new Date()));
        Person person = new Person();
        person.setName("JueYue");
        map.put("p", person);
        WordImageEntity image = new WordImageEntity();
        image.setHeight(200);
        image.setWidth(500);
        image.setUrl("cn/afterturn/easypoi/test/word/img/testCode.png");
        image.setType(WordImageEntity.URL);
        map.put("testCode", image);
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                "cn/afterturn/easypoi/test/word/doc/Image.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/excel/image.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 简单导出没有图片和Excel
     */
    @Test
    public void SimpleWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("department", "Easypoi");
        map.put("person", "JueYue");
        map.put("auditPerson", "JueYue");
        map.put("time", format.format(new Date()));
        map.put("date", new Date());
        List<Person> list = new ArrayList<Person>();
        Person p = new Person();
        p.setName("小明");
        p.setTel("18711111111");
        p.setEmail("18711111111@139.com");
        list.add(p);
        p = new Person();
        p.setName("小红");
        p.setTel("18711111112");
        p.setEmail("18711111112@139.com");
        list.add(p);
        map.put("pList", list);
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                "cn/afterturn/easypoi/test/word/doc/SimpleExcel.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/excel/basesimpleExcel.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void SimpleWordExportOnly() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("applyNo", "Easypoi");
        map.put("createTime", "JueYue");
        map.put("financePayTime", "JueYue");
        map.put("departmentNames", format.format(new Date()));
        map.put("userName", new Date());
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        Map<String,String> temp = new HashMap<String, String>();
        temp.put("a","下实打实");
        temp.put("b","下实ewq打实");
        temp.put("c","下实saddas打实");
        temp.put("d","下实打dsad实");
        temp.put("e","下实asdasd打实");
        list.add(temp);
        map.put("23123data", list);
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                "C:\\Users\\Think\\Documents\\Tencent Files\\909217383\\FileRecv\\reimb_template.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/excel/basesimpleExcel.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
