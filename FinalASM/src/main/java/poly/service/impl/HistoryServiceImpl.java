package poly.service.impl;

import java.sql.Timestamp;
import java.util.List;

import poly.dao.HistoryDao;
import poly.dao.impl.HistoryDaoImpl;
import poly.entity.History;
import poly.entity.User;
import poly.entity.Video;
import poly.service.HistoryService;
import poly.service.VideoService;

public class HistoryServiceImpl implements HistoryService {
	
	private HistoryDao dao;
	private VideoService videoService = new VideoServiceImpl();
	
	public HistoryServiceImpl() {
		dao = new HistoryDaoImpl();
	}
	@Override
	public List<History> findByUser(String username) {
		return dao.findByUser(username);
	}

	@Override
	public List<History> findByUserAndIsLiked(String username) {
		return dao.findByUserAndIsLiked(username);
	}

	@Override
	public History findByUserIdAndVideoId(int userId, int videoId) {
		return dao.findByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public History create(User user, Video video) {
		History existHis = findByUserIdAndVideoId(user.getId(), video.getId());
		if(existHis == null ) {
			existHis = new History();
			existHis.setUser(user);
			existHis.setVideo(video);
			existHis.setViewedDate(new Timestamp(System.currentTimeMillis())); //lấy ngày h hệ thống set vào
			existHis.setIsLiked(Boolean.FALSE);
			return dao.create(existHis);
		}
		return existHis;

	}

	@Override
	public boolean updateLikeOrUnlike(User user, String videoHref) {
		Video video = videoService.findByHref(videoHref);
		History exHistory = findByUserIdAndVideoId(user.getId(),video.getId());
		
		if (exHistory.getIsLiked() == Boolean.FALSE) {
			exHistory.setIsLiked(Boolean.TRUE);
			//khi set thằng is liked = 0 thành 1, nghĩa là like, thì phải set cả likedDate vào ngay lúc đó
			exHistory.setLikedDate(new Timestamp(System.currentTimeMillis())); //lấy ngày h hệ thống set vào
		} else {
			exHistory.setIsLiked(Boolean.FALSE);
			exHistory.setLikedDate(null);
		}
		History updatedHistory = dao.update(exHistory);
		return updatedHistory != null ? true : false; //toán tử 3 ngôi: nếu biến đó khác null thì trả về true, ko thì false
	}

}
