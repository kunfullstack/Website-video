package poly.service;

import java.util.List;

import poly.dao.admin.VideoLiked;

public interface StatService {

	List <VideoLiked> findVideoLiked();
}
