package poly.dao;

import java.util.List;

import poly.dao.admin.VideoLiked;
import poly.entity.User;

public interface StatDao {
	
	List <VideoLiked> findVideoLiked();

}
