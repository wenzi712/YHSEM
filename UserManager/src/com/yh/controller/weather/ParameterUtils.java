/*package com.yh.controller.weather;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.yh.pojo.account.Account;
import com.yh.service.account.AccountService;

public class ParameterUtils implements Job{
	
	private AccountService accountService;
	public ParameterUtils(AccountService accountService){
		 
		this.accountService = accountService;
	}
	 public ParameterUtils() {

	}
	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

		List<Account>list=accountService.queryAccountType();
		
		System.out.println("aabbccdd"+list.size());
		//那应该就是注入的问题 
		//传值的问题，就是List<Account>list=accountService.queryAccountType();  返回的值的问题，
	}
}
*/