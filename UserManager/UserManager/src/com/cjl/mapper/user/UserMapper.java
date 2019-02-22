package com.cjl.mapper.user;

import java.util.List;

import com.cjl.pojo.user.User;

public interface UserMapper {


	List<User> queryUserInfo(User user);

	void insertUserInfo(User user);

	List<User> selectUserByID(User user);

	void updateUserInfo(User user);

	void deleteUser(User user);

}
