package cn.afterturn.easypoi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.handler.inter.IReadHandler;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Map;

/**
 * 专治疑难杂症
 *
 * @author by jueyue on 19-10-16.
 */
public class TTTest {

    private static final String DESKTOP = "C:\\Users\\jueyue\\Desktop\\";

    @Test
    public void img03() throws Exception {
        try {
            ImportParams params = new ImportParams();
            params.setTitleRows(1);
            long start = new Date().getTime();
            ExcelImportUtil.importExcelBySax(
                    new FileInputStream(
                            new File(DESKTOP + "后移.xlsx")),
                    Map.class, params, new IReadHandler<Map>() {
                        @Override
                        public void handler(Map o) {
                            System.out.println(o);
                        }

                        @Override
                        public void doAfterAll() {
                            System.out.println("全部执行完毕了--------------------------------");
                        }
                    });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
