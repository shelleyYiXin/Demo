package cn.com.service;
import java.util.List;

import cn.com.pojo.Users;


public interface UserService {
	public List getUserList();
	public Users getUsersByUseridAndPassword(Users paramUsers);
}
