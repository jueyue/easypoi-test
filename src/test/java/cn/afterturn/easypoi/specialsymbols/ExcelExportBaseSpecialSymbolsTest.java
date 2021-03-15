package cn.afterturn.easypoi.specialsymbols;

import cn.afterturn.easypoi.entity.SpecialSymbolsEnum;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.test.en.EnumDataEntity;
import cn.afterturn.easypoi.test.en.Sex;
import cn.afterturn.easypoi.test.en.StatusEnum;
import cn.afterturn.easypoi.test.entity.specialsymbols.BaseSpecialSymbolsEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 基础特殊符号类型导出
 * @author by jueyue on 18-4-2.
 */
public class ExcelExportBaseSpecialSymbolsTest {

    @Test
    public void test() throws Exception {

        List<BaseSpecialSymbolsEntity> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            BaseSpecialSymbolsEntity symbolsEntity = new BaseSpecialSymbolsEntity();
            symbolsEntity.setSmallBox(SpecialSymbolsEnum.SMALL_BOX);
            symbolsEntity.setBigBox(SpecialSymbolsEnum.BIG_BOX);
            list.add(symbolsEntity);
        }
        Date start = new Date();
        ExportParams params = new ExportParams("特殊符号测试", "测试", ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(params, BaseSpecialSymbolsEntity.class, list);
        System.out.println(new Date().getTime() - start.getTime());
        FileOutputStream fos = new FileOutputStream("D:/home/excel/ExcelExportBaseSpecialSymbolsTest.test.xlsx");
        workbook.write(fos);
        fos.close();
    }
}
