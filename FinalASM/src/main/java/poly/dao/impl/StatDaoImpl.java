package poly.dao.impl;

import java.util.ArrayList;
import java.util.List;

import poly.dao.AbstractDao;
import poly.dao.StatDao;
import poly.dao.admin.VideoLiked;

public class StatDaoImpl extends AbstractDao<Object[]> implements StatDao {

	@Override
	public List<VideoLiked> findVideoLiked() {
		String sql = "select v.id, v.title, v.href, sum(cast(h.isLiked as int)) as totalLike"
				+ " FROM video v left join history h on v.id = h.videoId"
				+ " where v.isActive = 1"
				+ " group by v.id, v.title, v.href"
				+ " order by"
				+ " sum(cast(h.isLiked as int)) desc";
		
		//trả về object vì ko biết trả về gì
		List<Object[]> objects = super.findManyByNativeQuery(sql);
		List<VideoLiked> rs = new ArrayList<>();
		objects.forEach(object -> {
			VideoLiked videoliked = setDataVideoLiked(object);
			rs.add(videoliked); 
		}); 
		return rs;
	}
	
	private VideoLiked setDataVideoLiked (Object[] object) {
		VideoLiked videoliked = new VideoLiked();
		videoliked.setVideoId((Integer) object[0]);
		videoliked.setTitle((String) object[1]);
		videoliked.setHref((String) object[2]);
		videoliked.setTotalLike((Integer) object[3] == null ? 0 : (Integer) object[3]);
		return videoliked;
	}
	

}
