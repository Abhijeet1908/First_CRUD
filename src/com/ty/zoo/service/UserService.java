package com.ty.zoo.service;
import static com.ty.zoo.util.AppConstants.*;
import com.ty.zoo.dao.UserDao;
import com.ty.zoo.dto.User;

import com.ty.zoo.util.AES;

public class UserService {
	UserDao dao = new UserDao();
	public int saveUser(User user)
	{
		String encPassword = AES.encrypt(user.getPassword(),SECRET_KEY);
		user.setPassword(encPassword);
		return dao.saveUser(user);
		
	}
	public User getuserById(int id)
	{
		User user = dao.getuserById(id);
		String decPassword = AES.decrypt(user.getPassword(), SECRET_KEY);
		user.setPassword(decPassword);
		return user;
		
	}

}
