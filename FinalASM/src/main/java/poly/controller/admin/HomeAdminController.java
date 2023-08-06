package poly.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import poly.constant.SessionAtribute;
import poly.dao.admin.VideoLiked;
import poly.entity.User;
import poly.entity.Video;
import poly.service.StatService;
import poly.service.UserService;
import poly.service.VideoService;
import poly.service.impl.StatServiceImpl;
import poly.service.impl.UserServiceImpl;
import poly.service.impl.VideoServiceImpl;

/**
 * Servlet implementation class HomeAdminController
 */
@WebServlet(urlPatterns = { "/admin", "/Video", "/Video/edit", "/Video/create",
		"/Video/like" }, name = "HomeControllerAdmin")
public class HomeAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeAdminController() {
		super();
	}

	private Video v = new Video();
	private StatService statService = new StatServiceImpl();
	private VideoService videoService = new VideoServiceImpl();
	private UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute(SessionAtribute.CURRENT_USER);

		if (currentUser != null && currentUser.getIsAdmin() == Boolean.TRUE) {
			String path = request.getServletPath();
			System.out.println("Show Patt: " + path);
			switch (path) {
			case "/admin":
				System.out.println("Đã check admin");
				doGetHome(request, response);
				break;
			case "/Video":
				System.out.println("đã Check video");
				List<Video> videoall = videoService.findAll();
				request.setAttribute("videoAll", videoall);
				request.getRequestDispatcher("/views/admin/editVideo.jsp").forward(request, response);
				break;

			case "/Video/create": {
				doGetFavorite(request, response);
			}
			case "/Video/like": {
				System.out.println("Like");
				doGetLike(request, response);
			}
			}
		} else {
			response.sendRedirect("index");
		}

	}

	protected void doGetHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> videoall = videoService.findAll();
		request.setAttribute("videoAll", videoall);

		List<VideoLiked> videos = statService.findVideoLiked();
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/views/admin/admin.jsp").forward(request, response);
	}

	// localhost:.../favorites?href={video.href}
	protected void doGetFavorite(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		}
//		String uri = request.getRequestURI();

		try {
			BeanUtils.populate(v, request.getParameterMap());
			videoService.create(v);
			request.setAttribute("message", "đăng kí thành công");
		} catch (Exception e) {
			request.setAttribute("message", "đăng kí thất bại");
		}

		List<Video> videoall = videoService.findAll();
		request.setAttribute("videoAll", videoall);
		request.getRequestDispatcher("/views/admin/editVideo.jsp").forward(request, response);
	}

	protected void doGetLike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println("LIke");
		String videoHref = request.getParameter("href");
		List<User> user = userService.findUSerLikedVidByHref(videoHref);
		if (user.isEmpty()) {
			request.setAttribute("videos", "null");
		}
		
		List<Video> videoall = videoService.findAll();
		request.setAttribute("videoAll", videoall);
		request.setAttribute("videos", user);
		request.getRequestDispatcher("/views/admin/editVideo.jsp").forward(request, response);

	}

}
