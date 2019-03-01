package com.yh.service.patameter;

import java.util.Map;

import com.yh.pojo.parameter.Parameter;

public interface ParameterService {

	Map<String, Object> queryParameterInfo(Parameter parameter);

	void insertParameterInfo(Parameter parameter);

	void updateParameterInfo(Parameter parameter);

	void deleteParameter(Parameter parameter);

	void updateEnabledInfoFlow(Parameter parameter);

	void insertParameterInfo2(Parameter parameter);


	
	 



	


}
