
package com.yh.controller.parameter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.controller.account.AccountController;
import com.yh.pojo.account.Account;
import com.yh.pojo.parameter.Parameter;
import com.yh.service.patameter.ParameterService;

@Controller
@RequestMapping("parameter")
public class ParameterController {
	
	@Autowired
	private ParameterService parameterService;

	

	
	@RequestMapping("queryParameterInfo")  
	@ResponseBody
	public Map<String, Object> queryParameterInfo(Parameter parameter, HttpSession session) {
		
		Map<String, Object> map = parameterService.queryParameterInfo(parameter);
		return map;
	}
	

	@RequestMapping("insertParameterInfo")
	@ResponseBody
	public String insertParameterInfo(Parameter parameter) {
		parameterService.insertParameterInfo(parameter);
		return "{}";
	}
	
	
	@RequestMapping("insertParameterInfo2")
	@ResponseBody
	public String insertParameterInfo2(Parameter parameter) {
		parameterService.insertParameterInfo2(parameter);
		return "{}";
	}
	


	@RequestMapping("updateParameterInfo")
	@ResponseBody
	String updateParameterInfo(Parameter parameter) {
		parameterService.updateParameterInfo(parameter);
		return "{}";
	}
	
	@RequestMapping("deleteParameter")
	@ResponseBody
	String deleteParameter(Parameter parameter) {
		parameterService.deleteParameter(parameter);
		return "{}";
	}
	
	@RequestMapping("updateEnabledInfoFlow")
	@ResponseBody
	String updateEnabledInfoFlow(Parameter parameter) {
		parameterService.updateEnabledInfoFlow(parameter);
		return "{}";
	}
	
}
