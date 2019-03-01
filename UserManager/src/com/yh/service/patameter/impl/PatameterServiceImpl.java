package com.yh.service.patameter.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yh.mapper.parameter.ParameterMapper;
import com.yh.pojo.account.Account;
import com.yh.pojo.parameter.Parameter;
import com.yh.service.patameter.ParameterService;


@Service
public class PatameterServiceImpl implements ParameterService {
	
	@Autowired 
	private ParameterMapper parameterMapper;

	@Override
	public Map<String, Object> queryParameterInfo(Parameter parameter) {
		// TODO Auto-generated method stub
				Map<String, Object> map = new HashMap<>();
				//设置分页
				PageHelper.startPage(parameter.getPage(), parameter.getRows());
				List<Account> list = parameterMapper.queryParameterInfo(parameter);
				Page p = (Page) list;
				long total = p.getTotal();
				map.put("rows", list);
				map.put("total", total);
				return map;
	}

	@Override
	public void insertParameterInfo(Parameter parameter) {
		// TODO Auto-generated method stub
		parameterMapper.insertParameterInfo(parameter);
	}
	
	@Override
	public void insertParameterInfo2(Parameter parameter) {
		// TODO Auto-generated method stub
		parameterMapper.insertParameterInfo2(parameter);
	}


	@Override
	public void updateParameterInfo(Parameter parameter) {
		// TODO Auto-generated method stub
		parameterMapper.updateParameterInfo(parameter);
	}

	@Override
	public void deleteParameter(Parameter parameter) {
		// TODO Auto-generated method stub
		parameterMapper.deleteParameter(parameter);
	}

	@Override
	public void updateEnabledInfoFlow(Parameter parameter) {
		// TODO Auto-generated method stub
		parameterMapper.updateEnabledInfoFlow(parameter);
	}


}


