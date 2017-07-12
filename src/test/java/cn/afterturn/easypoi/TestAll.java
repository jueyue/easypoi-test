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
package cn.afterturn.easypoi;

import cn.afterturn.easypoi.cache.manager.POICacheManagerTest;
import cn.afterturn.easypoi.html.ExcelXorHtmlUtilTest;
import cn.afterturn.easypoi.test.UtilTest;
import cn.afterturn.easypoi.test.excel.read.CustomerEntityTest;
import cn.afterturn.easypoi.test.excel.read.ExcelImportSameNameTest;
import cn.afterturn.easypoi.test.excel.read.ExcelImportUtilTest;
import cn.afterturn.easypoi.test.excel.read.ExcelMapImportTest;
import cn.afterturn.easypoi.test.excel.read.ExcelVerifyTest;
import cn.afterturn.easypoi.test.excel.read.check.ImportCheckTestOneLine;
import cn.afterturn.easypoi.test.excel.read.check.ImportCheckTestTwoLine;
import cn.afterturn.easypoi.test.excel.template.ExcelExportTemplateTest;
import cn.afterturn.easypoi.test.excel.template.TemplateExcelExportTest;
import cn.afterturn.easypoi.test.excel.template.TemplateExcelManySheet;
import cn.afterturn.easypoi.test.excel.template.TemplateExcelSheetTest;
import cn.afterturn.easypoi.test.excel.template.TemplateForEachTest;
import cn.afterturn.easypoi.test.excel.template.TemplateForEachTest2;
import cn.afterturn.easypoi.test.excel.test.ExcelExportForLink;
import cn.afterturn.easypoi.test.excel.test.ExcelExportForMap;
import cn.afterturn.easypoi.test.excel.test.ExcelExportMsgClient;
import cn.afterturn.easypoi.test.excel.test.ExcelExportStatisticTest;
import cn.afterturn.easypoi.test.excel.test.ExcelExportUtilDataHandlerTest;
import cn.afterturn.easypoi.test.excel.test.ExcelExportUtilIdTest;
import cn.afterturn.easypoi.test.excel.test.ExcelExportUtilTest;
import cn.afterturn.easypoi.test.pdf.MultiLineHeadersTest;
import cn.afterturn.easypoi.test.pdf.PdfExportUtilTest;
import cn.afterturn.easypoi.test.pdf.PdfImageTest;
import cn.afterturn.easypoi.test.word.ContractDemoTest;
import cn.afterturn.easypoi.test.word.TaxManagementTest;
import cn.afterturn.easypoi.test.word.WordExportUtilAnnExcelTest;
import cn.afterturn.easypoi.test.word.WordExportUtilBaseExcelTest;
import cn.afterturn.easypoi.test.word.WordExportUtilTest;
import cn.afterturn.easypoi.util.PoiElUtilTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PoiElUtilTest.class, WordExportUtilTest.class, UtilTest.class,
                WordExportUtilBaseExcelTest.class, WordExportUtilAnnExcelTest.class,
                ExcelExportForLink.class, ExcelExportUtilIdTest.class,
                ExcelExportUtilDataHandlerTest.class, ExcelExportStatisticTest.class,
                ExcelExportMsgClient.class, ExcelExportForMap.class, ExcelExportForLink.class,
                TemplateForEachTest2.class, TemplateForEachTest.class, TemplateExcelSheetTest.class,
                TemplateExcelManySheet.class, TemplateExcelExportTest.class,
                ExcelExportTemplateTest.class, ExcelXorHtmlUtilTest.class, ExcelVerifyTest.class,
                ExcelMapImportTest.class, ExcelImportUtilTest.class, ExcelImportSameNameTest.class,
                CustomerEntityTest.class, ImportCheckTestOneLine.class, TaxManagementTest.class,
                ContractDemoTest.class, MultiLineHeadersTest.class, PdfExportUtilTest.class,
                PdfImageTest.class, ExcelExportUtilTest.class, TaxManagementTest.class,
                POICacheManagerTest.class,ImportCheckTestTwoLine.class })
public class TestAll {

}
