package cn.afterturn.easypoi.test.excel.test.groupname;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.test.entity.MsgClient;
import cn.afterturn.easypoi.test.entity.MsgClientGroup;
import cn.afterturn.easypoi.test.entity.groupname.GroupNameEntity;

/**
 * Created by JueYue on 2017/10/2.
 */
public class ExcelExportGroupNameTest {

    @Test
    public void success() throws Exception {

        List<GroupNameEntity> list = new ArrayList<GroupNameEntity>();
        for (int i = 0; i < 10; i++) {
            GroupNameEntity client = new GroupNameEntity();
            client.setBirthday(new Date());
            client.setCreateBy("2017-10-01");
            client.setClientName("小明" + i);
            client.setClientPhone("18797" + i);
            client.setCreateBy("JueYue");
            client.setId("1" + i);
            client.setRemark("测试" + i);
            list.add(client);
        }
        Date start = new Date();
        ExportParams params = new ExportParams("GroupName测试", "测试", ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params, GroupNameEntity.class, list);
        File savefile = new File("D:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/excel/groupName.xlsx");
        workbook.write(fos);
        fos.close();
    }
}
