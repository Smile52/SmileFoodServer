package com.Smile.Bean;
/**
 * ����Աʵ��
 * @author ����
 *
 */
public class Admin {
	private String AdminName;
	private String AdminPwd;
	public Admin(){
		
	};
	public String getAdminUserName() {
		return AdminName;
	}
	public void setAdminUserName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminUserPwd() {
		return AdminPwd;
	}
	public void setAdminUserPwd(String adminPwd) {
		AdminPwd = adminPwd;
	}
	@Override
	public String toString() {
		return "AdminUserBean [AdminUserName=" + AdminName
				+ ", AdminUserPwd=" + AdminPwd + "]";
	}
	
	
}
