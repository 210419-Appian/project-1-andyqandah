package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	
	@Override
	
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession ses = req.getSession(false);
			
			PrintWriter out = resp.getWriter();
			
			if(ses != null) {
				out.print(ses.getAttribute("username") + " is currently logged out");
				resp.setStatus(200);
				ses.invalidate();
			}else {
				out.print("Not logged in");
				resp.setStatus(400);
			}
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
		
	}