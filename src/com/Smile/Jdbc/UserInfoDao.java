package com.Smile.Jdbc;

import com.Smile.Bean.UserInfo;

public interface UserInfoDao {
	/**
	 * ����û�
	 * @param userInfo
	 * @return
	 */
	public int AddUser(UserInfo userInfo);
	/**
	 * ��ѯ�û�
	 * @param userNum
	 * @return 
	 */
	public UserInfo QueryUser(String userNum);
}
