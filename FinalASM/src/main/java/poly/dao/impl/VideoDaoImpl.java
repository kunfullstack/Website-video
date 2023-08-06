package poly.dao.impl;

import java.util.List;

import poly.dao.AbstractDao;
import poly.dao.VideoDao;
import poly.entity.Video;

public class VideoDaoImpl extends AbstractDao<Video> implements VideoDao{
	@Override
	public Video findById(int id) {
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		String sql = "SELECT o FROM Video o WHERE o.href = ?0";
		return super.findOne(Video.class, sql, href);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return super.findAll(Video.class, false, pageNumber, pageSize);
	}
}
