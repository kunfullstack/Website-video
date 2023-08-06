package poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import poly.constant.SessionAtribute;
import poly.entity.History;
import poly.entity.User;
import poly.entity.Video;
import poly.service.HistoryService;
import poly.service.VideoService;
import poly.service.impl.HistoryServiceImpl;
import poly.service.impl.VideoServiceImpl;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/index","/favorites","/history"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }
    private VideoService videoService = new VideoServiceImpl();
    private HistoryService historyService = new HistoryServiceImpl();
    private static final int VIDEO_MAX_SIZE = 2;
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	HttpSession session = request.getSession();
    	String path = request.getServletPath(); 
		   switch(path) {
			case "/index":
				doGetHome(request, response);
				break;
			case "/favorites":
				doGetFavorite(session,request, response);
			break;
			case "/history":
				doGetHistory(session,request, response);
			break;
		   }
    	}
    
	private void doGetHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Video> countvid = videoService.findAll();
		
		int maxPage = (int) Math.ceil(countvid.size() /(double) VIDEO_MAX_SIZE);  //tổng video / video trong 1 trang : ceil(làm tròn lên)
		request.setAttribute("maxPage", maxPage);

		String pageNum = request.getParameter("page");
		List<Video> videos;
		
		if (pageNum == null || Integer.valueOf(pageNum) > maxPage) {
			videos = videoService.findAll(1, VIDEO_MAX_SIZE);
			request.setAttribute("currentPage", 1);
		} else {
			videos = videoService.findAll(Integer.valueOf(pageNum), VIDEO_MAX_SIZE);
			request.setAttribute("currentPage",Integer.valueOf(pageNum));
		}
		
		
    	System.out.println("Video: " +videos.toString());
    	request.setAttribute("videos", videos);
    	request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);
	}
	
	private void doGetFavorite(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAtribute.CURRENT_USER);
		
		// gọi phương thức tìm kiếm trên đối tượng  htrService để tìm kiếm dựa tên user trạng thái liked
		List<History> history = historyService.findByUserAndIsLiked(user.getUsername()); 
		List<Video> videos = new ArrayList<>(); // tạo 1 list video rỗng để truyền video đã thích của người dùng vào
		
		for(int i = 0; i < history.size(); i++) {
			videos.add(history.get(i).getVideo());
		}
		
		request.setAttribute("videos", videos);
		
    	request.getRequestDispatcher("/views/user/favorites.jsp").forward(request, response);
	}
	
	private void doGetHistory(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAtribute.CURRENT_USER);
		
		List<History> history = historyService.findByUser(user.getUsername());
		List<Video> videos = new ArrayList<>(); 
		
		for(int i = 0; i < history.size(); i++) {
			videos.add(history.get(i).getVideo());
		}
		
		request.setAttribute("videos", videos);
		
    	request.getRequestDispatcher("/views/user/history.jsp").forward(request, response);

	}
}
