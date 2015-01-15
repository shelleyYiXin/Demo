package cn.com.service;
import java.util.List;

import cn.com.pojo.Contactinfo;
import cn.com.pojo.Users;


public interface UserService {
	public List getUserList();
	public Users getUsersByUseridAndPassword(Users paramUsers);
	public  Contactinfo getContactinfo(Users aUser);
	public boolean UpdateUser(Users mUser,String oldUserid);
	public boolean UpdateContactinfo(Contactinfo mContactinfo);
}