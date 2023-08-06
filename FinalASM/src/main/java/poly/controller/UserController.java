package poly.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import poly.constant.SessionAtribute;
import poly.entity.User;
import poly.service.EmailService;
import poly.service.UserService;
import poly.service.impl.EmailServiceImpl;
import poly.service.impl.UserServiceImpl;



@WebServlet({"/login","/logout","/register","/forgotpass","/changepass"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
        super();
    }
    	private UserService userService = new UserServiceImpl();
    	private EmailService  emailService = new EmailServiceImpl(); 
		
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(); 
    	String path = request.getServletPath(); 
		   switch(path) {
			case "/login":
				doGetLogin(request, response);
				break;
			case "/register":
			doGetResgiter(request, response);
			break;
			case "/logout":
				doGetLogout(session,request, response);
			break;
			case"/forgotpass":
				doGetForgotPass(request, response);
		   }
    }
	
	protected void doGetLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
	}
	protected void doGetResgiter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
	}	
	protected void doGetLogout(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				session.removeAttribute(SessionAtribute.CURRENT_USER);
				response.sendRedirect("index");
	}
	protected void doGetForgotPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/forgotpass.jsp").forward(request, response);
	}
	
	
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	
	String path = request.getServletPath(); 
		   switch(path) {
			case "/login":
				doPostLogin(session,request, response);
				break;
			case"/register":
				doPostRegister(session, request, response);
			case"/forgotpass":
				doPostForgotPass(request, response);
				break;
			case"/changepass":
				doPostChangePass(session, request, response);
				break;
		}
	}
	protected void doPostLogin(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User user = userService.Login(username, password);
			
			if(user != null) {
				session.setAttribute(SessionAtribute.CURRENT_USER, user);
				response.sendRedirect("index");
			}	
			else {
				request.setAttribute("message", "Sai mật khẩu hoặc password!");
				response.sendRedirect("login");
			}

}
	
	protected void doPostRegister(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = userService.findByUserName(username);
		
		 user = userService.register(username, password, email);
		
		if(user != null) {
			emailService.email(getServletContext(), user, "welcome");
			session.setAttribute(SessionAtribute.CURRENT_USER, user);
			response.sendRedirect("index");
		}	
		else {
			response.sendRedirect("register");
		}		
}
	
	protected void doPostForgotPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		String email = request.getParameter("email");
		User userNewPass =  userService.ResetPassword(email);
		
		if(userNewPass != null) {
			emailService.email(getServletContext(), userNewPass, "forgot");
			response.setStatus(204);
		}else {
			response.setStatus(400);
		}
	}	
	
	protected void doPostChangePass(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		
		User currentUser = (User) session.getAttribute(SessionAtribute.CURRENT_USER);
		
		if(currentUser.getPassword().equals(oldpass)) {
				currentUser.setPassword(newpass);
				User updated = userService.update(currentUser);
				if(updated != null) {
					//khi đã đổi mật khẩu mới, thì lưu mới thằng user trong session 
					session.setAttribute(SessionAtribute.CURRENT_USER, updated);
					response.setStatus(204);
				}else {
					response.setStatus(400);
				}
		}else {
			response.setStatus(400);
		}
		
	}
}
	
