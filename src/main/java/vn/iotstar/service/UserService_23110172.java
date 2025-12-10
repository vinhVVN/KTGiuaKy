package vn.iotstar.service;

import vn.iotstar.entity.User_23110172;

public interface UserService_23110172 {
	User_23110172 login(String username, String password);
	User_23110172 get(String username);
	
	
	void insert(User_23110172 user);
	boolean register(String email, String password, String username, String fullname,
			String phone);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	
	User_23110172 findByEmail(String email);
	
	void updatePassword(int id, String newpass);
	
	void update(User_23110172 user);
}
