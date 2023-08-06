package poly.dao;

import java.util.List;

import poly.entity.Video;

public interface VideoDao {

	Video findById(int id);
	//href: đoạn mã lấy trên yt, để trong DB thì nó là 1 unit(đơn vị)
	Video findByHref(String href);
	List<Video> findAll();
	List<Video> findAll(int pageNumber, int pageSize);
	
	Video create(Video entity);
	Video update(Video entity);
	Video delete(Video entity);

}
