package com.yh.service.report;

import java.util.Map;

import com.yh.pojo.regionReportData.RegionReportBean;

public interface ReportsService {

	Map<String, Object> queryRegionReportDataBeanInfo(RegionReportBean regionReportBean);

	void insertRegionReportDataBeanInfo(RegionReportBean regionReportBean);

}
