package com.yh.service.report.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yh.mapper.report.ReportMapper;
import com.yh.pojo.account.Account;
import com.yh.pojo.regionReportData.RegionReportBean;
import com.yh.service.report.ReportsService;


@Service
public class ReportsServiceImpl implements ReportsService{
	
	@Autowired
	private ReportMapper reportMapper;

	@Override
	public Map<String, Object> queryRegionReportDataBeanInfo(RegionReportBean regionReportBean) {
		// TODO Auto-generated method stub
				Map<String, Object> map = new HashMap<>();
				//设置分页
				PageHelper.startPage(regionReportBean.getPage(), regionReportBean.getRows());
				List<Account> list = reportMapper.queryRegionReportDataBeanInfo(regionReportBean);
				Page p = (Page) list;
				long total = p.getTotal();
				map.put("rows", list);
				map.put("total", total);
				return map;
	}

	@Override
	public  void insertRegionReportDataBeanInfo(RegionReportBean regionReportBean) {
		// TODO Auto-generated method stub
		reportMapper.insertRegionReportDataBeanInfo(regionReportBean);
	
	}

}
