package poly.service.impl;

import java.util.List;

import poly.dao.StatDao;
import poly.dao.admin.VideoLiked;
import poly.dao.impl.StatDaoImpl;
import poly.service.StatService;

public class StatServiceImpl implements StatService {

	private StatDao statDao;
	
	public StatServiceImpl() {
		statDao = new StatDaoImpl();
	}
	
	@Override
	public List<VideoLiked> findVideoLiked() {
		return statDao.findVideoLiked();
	}

	
}
