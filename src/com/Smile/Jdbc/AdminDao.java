package com.Smile.Jdbc;

import com.Smile.Bean.Admin;

/**
 * 
 * @author ����
 *
 */
public interface AdminDao {
	/**
	 * ��ӹ���Ա
	 * @param adminBean
	 * @return
	 */
	public int addAdmin(Admin adminBean);
	/**
	 * ɾ������Ա
	 * @param adminBean
	 * @return
	 */
	public int deleteUser(Admin adminBean);
	/**
	 * ���ݹ���Ա���ֲ�ѯ����Ա
	 * @param AdminName
	 * @return
	 */
	public Admin queryAdmin(String AdminName);
	/**
	 * ���¹���Ա��Ϣ
	 * @param admin
	 * @param AdminName
	 * @return
	 */
	public int updateAdmin(Admin admin,String AdminName);
	
}
