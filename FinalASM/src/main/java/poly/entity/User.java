package poly.entity;

import java.io.Serializable;
import javax.persistence.*;

import poly.constant.NamedStored;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="`user`")
@NamedQuery(name="User.findAll", query="SELECT o FROM User o")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = NamedStored.FIND_USER_LIKED_VIDEO_BY_HREF,
			procedureName = "sp_selectUserLikeVideoByVdHref",
			resultClasses = {User.class},
			parameters = @StoredProcedureParameter(name = "videoHref", type = String.class))
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "email")
	private String email;

	@Column(name = "isActive")
	private boolean isActive;

	@Column(name = "isAdmin")
	private boolean isAdmin;

	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", isActive=" + isActive + ", isAdmin=" + isAdmin + ", password="
				+ password + ", username=" + username + "]";
	}

}