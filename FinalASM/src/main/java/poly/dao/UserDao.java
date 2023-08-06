package poly.dao;

import java.util.List;
import java.util.Map;

import poly.entity.User;

public interface UserDao {

	User	findById(int id);
	User 	findByEmail(String email);
	User	findByUsername(String username);
	User	findByUsernameAndPassword(String username, String password);
	List<User> findAll();
	List<User> findAll(int pageNumber, int pageSize);
	User create(User entity);
	User update(User entity);
	User delete(User entity);
	List<User> findUserLikedVidByHref(Map<String, Object> params); 
	
}
