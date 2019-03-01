package com.yh.mapper.account;

import java.util.List;
<<<<<<< HEAD

import org.springframework.stereotype.Component;

import com.yh.pojo.account.Account;

@Component
=======
import java.util.Map;

import com.yh.pojo.account.Account;

>>>>>>> 884352bcad5fb878e9eff072faf42fbe611fcfc4
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
