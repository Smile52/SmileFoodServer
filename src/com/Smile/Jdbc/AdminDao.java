package com.Smile.Jdbc;

import com.Smile.Bean.Admin;

/**
 * 
 * @author 九龙
 *
 */
public interface AdminDao {
	/**
	 * 添加管理员
	 * @param adminBean
	 * @return
	 */
	public int addAdmin(Admin adminBean);
	/**
	 * 删除管理员
	 * @param adminBean
	 * @return
	 */
	public int deleteUser(Admin adminBean);
	/**
	 * 根据管理员名字查询管理员
	 * @param AdminName
	 * @return
	 */
	public Admin queryAdmin(String AdminName);
	/**
	 * 更新管理员信息
	 * @param admin
	 * @param AdminName
	 * @return
	 */
	public int updateAdmin(Admin admin,String AdminName);
	
}
