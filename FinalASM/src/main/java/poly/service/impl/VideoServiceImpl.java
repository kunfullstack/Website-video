package poly.service.impl;

import java.util.List;

import poly.dao.VideoDao;
import poly.dao.impl.VideoDaoImpl;
import poly.entity.Video;
import poly.service.VideoService;

public class VideoServiceImpl implements VideoService {

	private VideoDao dao;
	
	public VideoServiceImpl() {
		dao = new VideoDaoImpl();

	//NGUYÊN TẮC: INTERFACE THÌ KO NEW DC OBJECT
	//Lớp dao,controller ko xử lí Logic, mà là lớp service
	}
	
	@Override
	public Video findById(int id) {
		return dao.findById(id);
	}

	@Override
	public Video findByHref(String href) {
		return dao.findByHref(href);
	}

	@Override
	public List<Video> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public Video create(Video entity) {
		entity.setIsActive(true);
		entity.setView(0);
		entity.setShare(0);
// LOGIC: video mới tạo thì để true(hoat động), tạo ra thì cho view và share video đó bằng 0(vì mới t
		return dao.create(entity);
	}

	@Override
	public Video update(Video entity) {
		return dao.update(entity);
	}

	@Override
	public Video delete(String href) {
		//1.chỉ cần del cái href, del cả entity thì ko hợp lí => giảm sự phức tạp cho controller và người dùng
		Video entity = findByHref(href);
		//2. mục đích xóa href: là chỉ chuyển isActive = 0 (ko hoat động) chứ ko xóa khỏi DB
		entity.setIsActive(false);
		//3. ko xóa ra DB -> update lại là dc 
		return dao.update(entity);
	}
		
}
