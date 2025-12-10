package vn.iotstar.dao;

import vn.iotstar.entity.User_23110172;

public interface UserDAO_23110172 {
	public User_23110172 get(String username);
	
	void insert(User_23110172 user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	User_23110172 findByEmail(String email);
	
	void updatePassword(int id, String newpass);
	
	void update(User_23110172 user);
}
