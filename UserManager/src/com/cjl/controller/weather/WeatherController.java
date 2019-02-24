package com.cjl.controller.weather;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cjl.controller.account.AccountController;
import com.cjl.pojo.account.Account;
import com.cjl.service.account.AccountService;

@Controller
public   class WeatherController implements Job{
		@Autowired
		private AccountService accountService;	
		private static WeatherController weatherController;
		
		@PostConstruct
		public void init(){
			weatherController= this;
			weatherController.accountService = this.accountService;
			
			
		}
		
		public   void execute (JobExecutionContext arg0) throws JobExecutionException {
			Account account = new Account();
			Map<String, Object> map = accountService.queryUserInfo(account);
				@SuppressWarnings("unchecked")
				List<Account> list = (List<Account>) map.get("rows");
				//TODO:返回的list结果集为空   获取不到map的值...
				System.out.println("xixi"+list.get(1).getAccountName());
	}
		
		
		
		
		
		/* AccountController as = new AccountController();*/
		/*public static ParameterController pc = new ParameterController();*/
		
		
}
