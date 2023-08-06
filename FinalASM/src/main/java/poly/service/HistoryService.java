package poly.service;

import java.util.List;

import poly.entity.History;
import poly.entity.User;
import poly.entity.Video;

public interface HistoryService {
	//hien thi video nguoi dung da xem bằng username
	List<History> findByUser(String username);
	
	//hien thi video nguoi dung đã THÍCH bằng username
	List<History> findByUserAndIsLiked(String username);
	History findByUserIdAndVideoId(int userId, int videoId);
	History create(User user, Video video);
	boolean updateLikeOrUnlike(User user,String videoHref);
	
	// ko cần delete, nếu dc thì thêm sau
}