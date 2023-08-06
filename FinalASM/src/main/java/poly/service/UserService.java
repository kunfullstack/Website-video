package poly.service;

import java.util.List;

import poly.entity.User;

public interface UserService {
	User findById(int id);
	User findByEmail(String email);
	User findByUserName(String username);
	User Login(String username, String password);
	User ResetPassword(String email);
	
	List<User> findAll();
	List<User> findAll(int pageNumber, int pageSize);
	
	User register(String username, String password, String email);
	User update(User entity);
	User delete(String username);
	
	List<User> findUSerLikedVidByHref(String href);
}
