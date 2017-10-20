package cn.afterturn.easypoi.test.excel.read.groupname;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.test.entity.groupname.GroupNameEntity;
import cn.afterturn.easypoi.test.entity.samename.ClassName;
import cn.afterturn.easypoi.util.PoiPublicUtil;

/**
 * @Auther JueYue on 2017/10/20.
 */
public class ExcelGroupNameImport {


    @Test
    public void groupNameTest() {
        ImportParams params = new ImportParams();
        params.setHeadRows(2);
        long start = new Date().getTime();
        List<GroupNameEntity> list = ExcelImportUtil.importExcel(
                new File(PoiPublicUtil.getWebRootPath("import/groupName.xlsx")), GroupNameEntity.class, params);
        System.out.println(new Date().getTime() - start);
        Assert.assertEquals(10,list.size());
        Assert.assertEquals("187970",list.get(0).getClientPhone());
        Assert.assertEquals("小明0",list.get(0).getClientName());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));

    }
}
