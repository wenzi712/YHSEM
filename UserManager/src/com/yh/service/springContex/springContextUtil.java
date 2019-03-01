package com.yh.service.springContex;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class springContextUtil implements ApplicationContextAware,DisposableBean{

	
	
	private static ApplicationContext applicationContext;
	  private static Logger logger = LoggerFactory
	            .getLogger(springContextUtil.class);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {

		springContextUtil.applicationContext = applicationContext;
	    }
	 
	    
	    //取得存储在静态变量中的ApplicationContext.
	    public static ApplicationContext getApplicationContext() {
	        checkApplicationContext();
	        return applicationContext;
	    }
	     
	    //从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	    @SuppressWarnings("unchecked")
	    public static <T> T getBean(String name) {
	        checkApplicationContext();
	        return (T) applicationContext.getBean(name);
	    }
	 
	     
	    //从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	    //如果有多个Bean符合Class, 取出第一个.
	    @SuppressWarnings("unchecked")
	    public static <T> T getBean(Class<T> clazz) {
	        checkApplicationContext();
	        @SuppressWarnings("rawtypes")
	                Map beanMaps = applicationContext.getBeansOfType(clazz);
	        if (beanMaps!=null && !beanMaps.isEmpty()) {
	            return (T) beanMaps.values().iterator().next();
	        } else{
	            return null;
	        }
	    }
	 
	    private static void checkApplicationContext() {
	    	
	        if (applicationContext == null) {
	            throw new IllegalStateException("applicationContext未注入,请在applicationContext.xml中定义springContextUtil");
	        }
	    }

	    
	    public static void clearHolder() {
	        if (logger.isDebugEnabled()) {
	            logger.debug("清除SpringContextHolder中的ApplicationContext:"
	                    + applicationContext);
	        }
	        applicationContext = null;
	    }

		@Override
		public void destroy() throws Exception {
			// TODO Auto-generated method stub
			springContextUtil.clearHolder();
			
		}
	 
}
				

