package com.Smile.Jdbc;

import com.Smile.Bean.UserInfo;

public interface UserInfoDao {
	/**
	 * 添加用户
	 * @param userInfo
	 * @return
	 */
	public int AddUser(UserInfo userInfo);
	/**
	 * 查询用户
	 * @param userNum
	 * @return 
	 */
	public UserInfo QueryUser(String userNum);
}
