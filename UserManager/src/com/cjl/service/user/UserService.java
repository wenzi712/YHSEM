package com.cjl.service.user;

import java.util.Map;

import com.cjl.pojo.user.User;



public interface UserService {

	Map<String, Object> queryUserInfo(User user);

	void insertUserInfo(User user);

	User selectUserByID(User user);

	void updateUserInfo(User user);

	void deleteUser(User user);

	


}
