package com.meng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.meng.domain.User;

public interface UserDao {
	/**
	 * 查询全部用户
	 * @return
	 */
	List<User> getAllUser();
	
	/**
	 * 查询单一用户，通过ID
	 * @return
	 */
	User getUserById(User user);
	
	/**如果查询到该用户就会返回1
     * @param username,password
     * @return数据库被修改的行数
     */
	User getUserByName(@Param("username") String username, @Param("password") String password);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 更新用户，通过ID
	 * @param user
	 * @return
	 */
	int updateUserById(User user);
	
	/**
	 * 删除用户，通过ID
	 * @param user
	 * @return
	 */
	int delUserById(User user);
	
}
