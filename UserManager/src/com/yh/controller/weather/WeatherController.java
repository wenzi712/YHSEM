package com.yh.controller.weather;

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
}
