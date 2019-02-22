package com.cjl.service.user.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjl.mapper.user.UserMapper;
import com.cjl.pojo.user.User;
import com.cjl.service.user.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserMapper userMapper;

	@Override
	public Map<String, Object> queryUserInfo(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		//设置分页
		PageHelper.startPage(user.getPage(), user.getRows());
		List<User> list = userMapper.queryUserInfo(user);
		Page p = (Page) list;
		long total = p.getTotal();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	@Override
	public void insertUserInfo(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUserInfo(user);
	}

	@Override
	public User selectUserByID(User user) {
		// TODO Auto-generated method stub
		List<User> list = userMapper.selectUserByID(user);
		User u = null;
		if (null != list && 1 == list.size()) {
			u = list.get(0);
		}
		return u;
	}

	@Override
	public void updateUserInfo(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUserInfo(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
		String userIds = user.getUserIds();
		if (null != userIds && !"".equals(userIds)) {
			String[] split = userIds.split(",");
			List<String> asList = Arrays.asList(split);
			user.setUserIdsList(asList);
			
			userMapper.deleteUser(user);
			
		  }
		
			
		}
 }



