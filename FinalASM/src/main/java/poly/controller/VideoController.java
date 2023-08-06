package poly.controller;

import java.io.IOException;
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
 * Servlet implementation class VideoController
 */
@WebServlet("/video")
public class VideoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public VideoController() {
        super();
    }
    
    private VideoService videoService = new VideoServiceImpl();
    private HistoryService historyService = new HistoryServiceImpl();
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String actionParam = request.getParameter("action");
			String href = request.getParameter("id");
			HttpSession session = request.getSession();
		switch(actionParam) {
			case "watch":
				doGetWatch(session, href, request, response);
				break;
			case "like":
				doGetLike(session, href, request, response);
				break;
		}
	}
	//localhost:asm.../video?action=watch&id={href}
	protected void doGetWatch(HttpSession session, String href,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Video video = videoService.findByHref(href);
			request.setAttribute("video", video);
			User currentUser = (User) session.getAttribute(SessionAtribute.CURRENT_USER);
			
			if(currentUser != null) {
				History hs = historyService.create(currentUser, video);
				request.setAttribute("flagLikedBtn", hs.getIsLiked());
			}
			
			request.getRequestDispatcher("/views/user/video-detail.jsp").forward(request, response);
	}
	
	//localhost:asm.../video?action=like&id={href}
	
	protected void doGetLike(HttpSession session, String href,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ajax nhận và trả data dạng json
		response.setContentType("application/json");
		//lây trong session cái id user
		User currentUser = (User) session.getAttribute(SessionAtribute.CURRENT_USER); 
		Boolean rs = historyService.updateLikeOrUnlike(currentUser, href);
		if (rs == true) {
			response.setStatus(204); // thành công (success) nhưng ko trả về data (no respone data)
		}else {
			response.setStatus(400);
		}
}

}
