package com.meng.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.meng.domain.User;
import com.meng.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class) // spring的单元测试
@ContextConfiguration({ "classpath:spring/spring-*.xml" }) // 上下文配置
public class UserDaoTest {

	@Autowired
	private UserServiceImpl userService;

	@Test
	public void getAllUserTest() {
		
		List<User> result = new ArrayList<>();
		try {
			result = userService.getAllUser();
			for(User user : result) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查找用户失败！");
		}
		if (result != null) {
			System.err.println("查找用户成功！");
		}
	}
	
	@Test
	public void getUserByIdTest() {
		
		User user = new User();
		user.setId(1);
		User result;
		result = userService.getUserById(user);
		if (result != null) {
			System.out.println("查找成功！");
			System.out.println(result);
		}
	}
	
	@Test
	public void addUserTest() {
		
		User user = new User();
		user.setUsername("xiaowang");
		user.setPassword("000000");
		int result;
		result = userService.addUser(user);
		if (result != 0) {
			System.out.println("添加成功！");
			System.out.println(result);
		}
	}
	
	@Test
	public void updateUserByIdTest() {
		
		User user = new User();
		user.setId(3);
		user.setUsername("alin");
		user.setPassword("666666");
		int result;
		result = userService.updateUserById(user);
		if (result != 0) {
			System.out.println("更新成功！");
			System.out.println(result);
		}
	}
	
	@Test
	public void delUserByIdTest() {
		
		User user = new User();
		user.setId(2);
		int result;
		result = userService.delUserById(user);
		if (result != 0) {
			System.out.println("删除成功！");
			System.out.println(result);
		}
	}
}
