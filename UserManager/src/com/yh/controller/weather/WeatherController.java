package com.yh.controller.weather;

<<<<<<< HEAD
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



public   class WeatherController implements Job{
	
	/*
	 * 这个里边的方法  都不行。。。
	 * 方法2. 取消ParameterUtils的本身和参数的注解，用new初始化。用这个方法解决
	 * 看懂了吗
	 * 
	 * 
	 * 
	 * 
	@Autowired
	private AccountService accountService = springContextUtil.getBean(AccountService.class);
	*/
	/*	private static WeatherController weatherController;
		
		@PostConstruct
		public void init(){
			weatherController = this;
			weatherController.accountService = this.accountService;
		}
		*/
		public void execute (JobExecutionContext arg0) throws JobExecutionException {
			
			/*Account account = new Account();
			Map<String ,Object>map =accountService.queryUserInfo(account);
			for (Map.Entry<String, Object> entry : map.entrySet()) {
	            System.out.println("key= " + entry.getKey() + " and value= "
	                     + entry.getValue());
	        }
	
			System.out.println("123");*/
	}
		
	/*	@SuppressWarnings("unused")
		public static void main(String[] args) {
			Account account =	 new Account();
			ApplicationContext appCtx = springContextUtil.getApplicationContext();
			
			AccountService accountService = appCtx.getBean(AccountService.class);
			
			 AccountMapper accountMapper = (AccountMapper) appCtx.getBean("AccountMapper");
			 List<Account> list = accountMapper.queryUserInfo(account);
			 System.out.println(list.get(1).getAccountName());
			
		}
		*/
=======
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yh.controller.account.AccountController;
import com.yh.pojo.account.Account;
import com.yh.service.account.AccountService;

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
		
		
>>>>>>> 884352bcad5fb878e9eff072faf42fbe611fcfc4
}
