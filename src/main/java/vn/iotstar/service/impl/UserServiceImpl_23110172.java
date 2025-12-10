package vn.iotstar.service.impl;

import vn.iotstar.dao.UserDAO_23110172;
import vn.iotstar.dao.impl.UserDAOImpl_23110172;
import vn.iotstar.entity.User;
import vn.iotstar.service.UserService_23110172;

public class UserServiceImpl_23110172 implements UserService_23110172 {
	UserDAO_23110172 userDAO = new UserDAOImpl_23110172();
	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public User get(String username) {
		return userDAO.get(username);
	}

	@Override
	public void insert(User user) {
		userDAO.insert(user);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password); 
        user.setEmail(email);
        user.setFullname(fullname);
        user.setPhone(phone);
        user.setAdmin(false); 
        user.setActive(true);
        user.setImages(null);
        
        userDAO.insert(user);
        return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		
		return userDAO.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDAO.checkExistUsername(username);
	}


	@Override
	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	@Override
	public void updatePassword(int id, String newpass) {
		userDAO.updatePassword(id, newpass);
		
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
		
	}

}
