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
package org.jeecgframework.poi;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;

public class TestTest {
	
	public static void main(String[] args) {
	    ImportParams params = new ImportParams();
        long start = new Date().getTime();
        List<Map<String, Object>> list = ExcelImportUtil.importExcel(
            new File("C:/Users/Think/Desktop/卡号.xlsx"), Map.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        for (Map<String, Object> map : list) {
            if(map.get("card") != null){
                if(!new LuhnUtil(map.get("card").toString()).check()){
                    System.out.println(map.get("card"));
                }
            }
        }
	}

}
