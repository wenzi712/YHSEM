package com.yh.mapper.account;

import java.util.List;
import java.util.Map;

import com.yh.pojo.account.Account;

public interface AccountMapper {


	List<Account> queryUserInfo(Account account);

	void insertUserInfo(Account account);

	List<Account> selectUserByID(Account account);

	void updateUserInfo(Account account);

	void deleteUser(Account account);

	List<Account> queryDisabledlist(Account account);

	void deleteUser1(Account account);

	List<Account> queryAccountType();

	void updateEnabledInfoFlow(Account account);

}
