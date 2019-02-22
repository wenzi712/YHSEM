package com.cjl.service.account;

import java.util.List;
import java.util.Map;

import com.cjl.pojo.account.Account;



public interface AccountService {

	Map<String, Object> queryUserInfo(Account account);

	void insertUserInfo(Account account);

	Account selectUserByID(Account account);

	void updateUserInfo(Account account);

	void deleteUser(Account account);

	Map<String, Object> queryDisabledlist(Account account);

	List<Account> queryAccountType();

	void updateEnabledInfoFlow(Account account);

	
	 



	


}
