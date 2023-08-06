package poly.service.impl;

import javax.servlet.ServletContext;

import poly.entity.User;
import poly.service.EmailService;
import poly.util.SendEmailUtil;

public class EmailServiceImpl implements EmailService{

	private static final String EMAIL_WELCOME = "Chào mừng bạn đã đến với bình nguyên vô tận!";
	private static final String EMAIL_FORGOTPASSWORD = "KUN ENTERTAINMET - NEW PASSWORD";
	@Override
	public void email(ServletContext context, User recipient, String type) {
	        String host = context.getInitParameter("host");
	        String port = context.getInitParameter("port");
	        String user = context.getInitParameter("user");
	        String pass = context.getInitParameter("pass");
		
	        try {
	        		String cont = null;
	        		String sub = null;
	        		switch (type) {
					case "welcome": 
						sub = EMAIL_WELCOME;
						cont = "Dear" + recipient.getUsername() + ", hãy tận hưởng sự giải trí này";
						break;
					case"forgot":
						sub = EMAIL_FORGOTPASSWORD;
						cont = "Dear" + recipient.getUsername() + ", your new password: " + recipient.getPassword();
						break;
					default:
						sub = "KUN ENTERTAINMENT";
						cont = "I'm Just Keeding :3";
	        		}
	        		SendEmailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), sub, cont);
	        		
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}

}
