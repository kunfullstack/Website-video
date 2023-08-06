package poly.dao.impl;

import java.util.List;
import java.util.Map;

import poly.constant.NamedStored;
import poly.dao.AbstractDao;
import poly.dao.UserDao;
import poly.entity.User;

/* class này sẽ extend(ke thua va mo rong) tu` class abstract,
sau do implement(trienkhai) thằng interface trong userDao,
=> hiện thực hóa các hàm trong userDao
--> cấu trúc quen thuộc trên springbooth 	
*/
public class UserDaoImpl extends AbstractDao<User> implements UserDao{
	
	// class này dc sử dụng các hàm của cha(abstractDao)
	@Override
	public User findById(int id) {
			return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		//su dung thằng findOne: viết câu lệnh ra cho email 
		String sql ="SELECT o FROM User o WHERE o.email =  ?0";
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User findByUsername(String username) {
		String sql ="SELECT o FROM User o WHERE o.username =  ?0";
		return super.findOne(User.class, sql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String sql ="SELECT o FROM User o WHERE o.username =  ?0 AND o.password =?1";
		return super.findOne(User.class, sql, username, password);
		// bắt buộc phải điền đúng thứ tự của tham số (param)
	}

	@Override 
	public List<User> findAll() {
		return	super.findAll(User.class, true);
	}
	

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return super.findAll(User.class, true, pageNumber, pageSize);
	}


	@Override
	public List<User> findUserLikedVidByHref(Map<String, Object> params) {
		return super.callStored(NamedStored.FIND_USER_LIKED_VIDEO_BY_HREF, params);
	}
	
	//del,create, update: khi đã truyền thằng abstract vào thì tự động đổi T sang User
	// ==> ko cần override giống trên
}
