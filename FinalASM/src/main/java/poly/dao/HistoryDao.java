package poly.dao;

import java.util.List;

import poly.entity.History;

public interface HistoryDao {
	
	//hien thi video nguoi dung da xem bằng username
	List<History> findByUser(String username);
	
	//hien thi video nguoi dung đã THÍCH bằng username
	List<History> findByUserAndIsLiked(String username);
	History findByUserIdAndVideoId(int userId, int videoId);
	History create(History entity);
	History update(History entity);
	// ko cần delete, nếu dc thì thêm sau
}

