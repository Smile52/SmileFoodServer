package com.Smile.Bean;
/**
 * 管理员实例
 * @author 九龙
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
