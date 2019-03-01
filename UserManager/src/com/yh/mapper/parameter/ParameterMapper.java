package com.yh.mapper.parameter;

import java.util.List;

import com.yh.pojo.account.Account;
import com.yh.pojo.parameter.Parameter;

public interface ParameterMapper {

	List<Account> queryParameterInfo(Parameter parameter);

	void insertParameterInfo(Parameter parameter);

	void updateParameterInfo(Parameter parameter);

	void deleteParameter(Parameter parameter);

	void updateEnabledInfoFlow(Parameter parameter);

<<<<<<< HEAD
	void insertParameterInfo2(Parameter parameter);
=======
>>>>>>> 884352bcad5fb878e9eff072faf42fbe611fcfc4


}
