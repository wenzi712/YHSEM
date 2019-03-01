package com.yh.controller.parameter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yh.mapper.account.AccountMapper;
import com.yh.mapper.parameter.ParameterMapper;
import com.yh.pojo.account.Account;
import com.yh.pojo.parameter.Parameter;

@Component
@EnableScheduling
public class LedgerReload {
	

	@Autowired
	AccountMapper accountMapper; 
	@Autowired
	ParameterMapper parameterMapper;
	
	@Scheduled(cron="*/30 * * * * *")
	public void aaa(){
		Account account = new Account();
		List<Account> list=accountMapper.queryUserInfo(account);
			Parameter parameter = new Parameter();
				for (int i = 0; i < list.size(); i++) {
					Account account1 = list.get(i);
					parameter.setAccountName(account1.getAccountName());
					parameter.setAccountDate(new Date());
					parameter.setAccountType(account1.getAccountType());
					parameter.setAccountPwd(account1.getAccountPwd());
					parameter.setToken(account1.getToken());
					parameterMapper.insertParameterInfo(parameter);
					System.out.println(account1.getAccountName());
					
				}
		
	}

}
