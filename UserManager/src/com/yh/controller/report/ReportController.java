
package com.yh.controller.report;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.pojo.regionReportData.RegionReportBean;
import com.yh.service.report.ReportsService;

@Controller
@RequestMapping("report")
public class ReportController {
	
	@Autowired
	private ReportsService reportsService;

	

	
	@RequestMapping("queryReportInfo")  
	@ResponseBody
	public Map<String, Object> queryReportInfo(RegionReportBean regionReportBean) {
		
		Map<String, Object> map = reportsService.queryRegionReportDataBeanInfo(regionReportBean);
		return map;
	}
	

	@RequestMapping("insertRegionReportDataBeanInfo")
	@ResponseBody
	public String insertRegionReportDataBeanInfo(RegionReportBean regionReportBean) {
		reportsService.insertRegionReportDataBeanInfo(regionReportBean);
		return "{}";
	}
	

}
