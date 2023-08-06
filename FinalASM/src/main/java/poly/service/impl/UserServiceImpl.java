package poly.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import poly.dao.UserDao;
import poly.dao.impl.UserDaoImpl;
import poly.entity.User;
import poly.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao dao;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}
	
	@Override
	public User findById(int id) {
		return dao.findById(id);
	}


	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}
	
	@Override
	public User findByUserName(String username) {
		return dao.findByUsername(username);
	}
	@Override
	public User Login(String username, String password) {
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public User ResetPassword(String email) {
		User existUser = findByEmail(email);
		if(existUser != null) {
			// random 1000-999, (random * (MAX - MIN) +1) + MIN 
			String newPass = String.valueOf((int) (Math.random() * ((9999 - 1000) + 1)) + 1000);
			existUser.setPassword(newPass);
			return dao.update(existUser);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public User register(String username, String password, String email) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setIsAdmin(Boolean.FALSE);
		user.setIsActive(true);
		return dao.create(user);
	}

	@Override
	public User update(User entity) {
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		//ko xóa thằng user ra khỏi sql, mà set cái active(hoạt dộng) về 0
		User user = dao.findByUsername(username);
		user.setIsActive(Boolean.FALSE); 
		return dao.update(user);
		// sử dụng update vì nếu delete thì nó sẽ bay ra khỏi csdl
	}

	@Override
	public List<User> findUSerLikedVidByHref(String href) {
		Map<String, Object> params = new HashMap<>();
		params.put("videoHref", href);
		return dao.findUserLikedVidByHref(params);
	}



}
