package poly.service;

import javax.servlet.ServletContext;

import poly.entity.User;

public interface EmailService {
		void email(ServletContext context, User recipient, String type);
}
