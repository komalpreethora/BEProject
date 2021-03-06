package com.beproject.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beproject.usermanagement.models.*;
import com.beproject.usermanagement.repository.*;

@Service
public class UserMgmtService 
{
	@Autowired
	UserRepository userRepo;
	
	public User getUserbyEmail(String email)
	{
		try {
			User u = userRepo.findByemail(email);
			System.out.println("in get one user by email service");
			return u;
		} catch (Exception e) {
			return null;
		}
	}
	
	public User getUserbyUsername(String uname)
	{
		try {
			User u = userRepo.findByusername(uname);
			System.out.println("in get one user by username service");
			return u;
		} catch (Exception e) {
			return null;
		}
	}
	public User getUserbyId(long id)
	{
		try {
			User u = userRepo.findOne(id);
			System.out.println("in get one db user by id service");
			return u;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean createUser(User u)
	{
		System.out.println("in create user service");
		try {
			userRepo.save(u);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean updateUserdetails(User u,long id)
	{
		System.out.println("in put user db service");
		if(u.getUserid() == id)
		{
		User registeruser=userRepo.findOne(id);
		if(registeruser == null)
			return false;
		userRepo.save(u);
		return true;
		}
		return false;		
	}
	
	public boolean validateuserid(long userid)
	{
		if(userRepo.findOne(userid) != null)
			return true;
		return false;
	}
	
	public List<User> searchuser(String str)
	{
		return userRepo.search(str);
	}
}
