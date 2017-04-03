package com.meng.service;

import java.util.List;

import com.meng.domain.User;

public interface UserService {
	
	/**
	 * 查询全部用户
	 * @return
	 */
	public List<User> getAllUser();
	
	/**
	 * 查询单一用户，通过ID
	 * @return
	 */
	public User getUserById(User user);
	
	/**
	 * 本次中我们只需要对用户身份做出判断然后给予url
     * @return 数据库查询到为1
     */
    User CheckUser(String username, String password);
    
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 更新用户，通过ID
	 * @param user
	 * @return
	 */
	public int updateUserById(User user);
	
	/**
	 * 删除用户，通过ID
	 * @param user
	 * @return
	 */
	public int delUserById(User user);
}
