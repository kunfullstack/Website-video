package poly.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the video database table.
 * 
 */
@Entity
@Table(name="video")
@NamedQuery(name="Video.findAll", query="SELECT o FROM Video o")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "description")
	private String description;

	@Column(name = "href")
	private String href;

	@Column(name = "isActive")
	private boolean isActive;

	@Column(name = "poster")
	private String poster;

	@Column(name = "shares")
	private int shares;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "views")
	private int views;
	
	public Video() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getShare() {
		return this.shares;
	}

	public void setShare(int share) {
		this.shares = share;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getView() {
		return this.views;
	}

	public void setView(int view) {
		this.views = view;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", description=" + description + ", href=" + href + ", isActive=" + isActive
				+ ", poster=" + poster + ", shares=" + shares + ", title=" + title + ", views=" + views + "]";
	}

}