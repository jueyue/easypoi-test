/**
 * Copyright 2013-2015 JueYue (qrb.jueyue@gmail.com)
 *   
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.afterturn.easypoi.test.excel.read;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import cn.afterturn.easypoi.hanlder.ViliGroupOne;
import cn.afterturn.easypoi.test.entity.ExcelVerifyEntity;
import cn.afterturn.easypoi.test.entity.ExcelVerifyEntityOfMode;
import cn.afterturn.easypoi.test.excel.read.hanlder.ExcelVerifyHandlerImpl;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.util.PoiPublicUtil;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Excel 导入校验
 * @author JueYue
 *   2015年10月31日 下午10:34:35
 */
public class ExcelVerifyTest {
    
    private final static  Logger  LOGGER = LoggerFactory.getLogger(ExcelVerifyTest.class);

    @Test
    public void basetest() {
        try {
            ImportParams params = new ImportParams();
            params.setNeedVerfiy(true);
            params.setVerfiyGroup(new Class[]{ViliGroupOne.class});
            ExcelImportResult<ExcelVerifyEntity> result = ExcelImportUtil.importExcelMore(
                new File(PoiPublicUtil.getWebRootPath("import/verfiy.xlsx")),
                ExcelVerifyEntity.class, params);
            FileOutputStream fos = new FileOutputStream("D:/excel/ExcelVerifyTest.basetest.xlsx");
            result.getWorkbook().write(fos);
            fos.close();
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getList().get(i)));
            }
            Assert.assertTrue(result.getList().size() == 2);
            Assert.assertTrue(result.isVerfiyFail());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }
    }

    @Test
    public void basetestonlyFail() {
        try {
            ImportParams params = new ImportParams();
            params.setNeedVerfiy(true);
            params.setVerfiyGroup(new Class[]{ViliGroupOne.class});
            ExcelImportResult<ExcelVerifyEntity> result = ExcelImportUtil.importExcelMore(
                    new File(PoiPublicUtil.getWebRootPath("import/verfiy.xlsx")),
                    ExcelVerifyEntity.class, params);
            FileOutputStream fos = new FileOutputStream("D:/excel/ExcelVerifyTest.basetestonlyFail.xlsx");
            result.getWorkbook().write(fos);
            fos.close();
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getList().get(i)));
            }
            //失败的数据
            for (int i = 0; i < result.getFailList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getFailList().get(i)));
            }
            Assert.assertTrue(result.getList().size() == 2);
            Assert.assertTrue(result.isVerfiyFail());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }
    }
    
    @Test
    public void baseModetest() {
        try {
            ImportParams params = new ImportParams();
            params.setNeedVerfiy(true);
            ExcelImportResult<ExcelVerifyEntityOfMode> result = ExcelImportUtil.importExcelMore(
                    new FileInputStream(new File(PoiPublicUtil.getWebRootPath("import/verfiy.xlsx"))),
                ExcelVerifyEntityOfMode.class, params);
            FileOutputStream fos = new FileOutputStream("D:/excel/baseModetest.xlsx");
            result.getWorkbook().write(fos);
            fos.close();
            fos = new FileOutputStream("D:/excel/baseModetest_fail.xlsx");
            result.getFailWorkbook().write(fos);
            fos.close();
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getList().get(i)));
            }
            //失败的数据
            for (int i = 0; i < result.getFailList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getFailList().get(i)));
            }
            Assert.assertTrue(result.getList().size() == 2);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }
    }
    
    @Test
    public void baseHanldertest() {
        try {
            ImportParams params = new ImportParams();
            params.setVerifyHanlder(new ExcelVerifyHandlerImpl());
            ExcelImportResult<ExcelVerifyEntityOfMode> result = ExcelImportUtil.importExcelMore(
                new File(PoiPublicUtil.getWebRootPath("import/verfiy.xlsx")),
                ExcelVerifyEntityOfMode.class, params);
            FileOutputStream fos = new FileOutputStream("D:/excel/baseHanldertest.xlsx");
            result.getWorkbook().write(fos);
            fos.close();
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getList().get(i)));
            }
            Assert.assertTrue(result.getList().size() == 0);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }
    }
    
    @Test
    public void combinedVerificationTest() {
        try {
            ImportParams params = new ImportParams();
            params.setVerifyHanlder(new ExcelVerifyHandlerImpl());
            params.setNeedVerfiy(true);
            ExcelImportResult<ExcelVerifyEntityOfMode> result = ExcelImportUtil.importExcelMore(
                new File(PoiPublicUtil.getWebRootPath("import/verfiy.xlsx")),
                ExcelVerifyEntityOfMode.class, params);
            FileOutputStream fos = new FileOutputStream("D:/excel/combinedVerificationTest.xlsx");
            result.getWorkbook().write(fos);
            fos.close();
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getList().get(i)));
            }
            Assert.assertTrue(result.getList().size() == 0);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }
    }

}
