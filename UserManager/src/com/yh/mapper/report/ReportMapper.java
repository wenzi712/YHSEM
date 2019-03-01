package com.yh.mapper.report;

import java.util.List;
import java.util.Map;

import com.yh.pojo.account.Account;
import com.yh.pojo.regionReportData.RegionReportBean;

public interface ReportMapper {

	List<Account> queryRegionReportDataBeanInfo(RegionReportBean regionReportBean);

	 void insertRegionReportDataBeanInfo(RegionReportBean regionReportBean);

}
