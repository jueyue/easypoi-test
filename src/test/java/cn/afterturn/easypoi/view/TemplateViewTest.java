package cn.afterturn.easypoi.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.afterturn.easypoi.test.entity.CourseEntity;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.entity.vo.TemplateExcelConstants;
import cn.afterturn.easypoi.view.PoiBaseView;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 仅仅作为示例,无法执行
 * @author JueYue
 * 2017年3月19日
 */
public class TemplateViewTest {

    @RequestMapping(params = "exportXls")
    public void exportXlsrender(CourseEntity course, HttpServletRequest request,
                                HttpServletResponse response, ModelMap map) {
        List<CourseEntity> courses = null;//获取自己的数据列表;
        map.put(TemplateExcelConstants.FILE_NAME, "用户信息");
        map.put(TemplateExcelConstants.PARAMS, new TemplateExportParams());
        map.put(TemplateExcelConstants.MAP_DATA, courses);
        PoiBaseView.render(map, request, response,
            TemplateExcelConstants.EASYPOI_TEMPLATE_EXCEL_VIEW);
    }

    //推荐这种,无法执行用上面那个
    @RequestMapping(params = "exportXls")
    public String exportXls(CourseEntity course, HttpServletRequest request,
                            HttpServletResponse response, ModelMap map) {
        List<CourseEntity> courses = null;//获取自己的数据列表;
        map.put(TemplateExcelConstants.FILE_NAME, "用户信息");
        map.put(TemplateExcelConstants.PARAMS, new TemplateExportParams());
        map.put(TemplateExcelConstants.MAP_DATA, courses);
        return TemplateExcelConstants.EASYPOI_TEMPLATE_EXCEL_VIEW;
    }

}