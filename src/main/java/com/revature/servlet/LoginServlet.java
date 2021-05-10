package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.service.LoginService;
import com.revature.service.UserService;

public class LoginServlet extends HttpServlet{

	LoginService lService = new LoginService();
	UserService uService = new UserService();
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDTO u = new UserDTO();

		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);
		u = om.readValue(body, UserDTO.class);


		PrintWriter out = resp.getWriter();

		if(lService.login(u.username, u.password)) {

			HttpSession ses = req.getSession(); 
			ses.setAttribute("username", u.username); 
			User myUser = uService.findByUsername(u.username);
			ses.setAttribute("role", myUser.getRole());


			out.print("Welcome, " + myUser.getFirstName() + " " + myUser.getLastName() +"! You have successfully logged in.");
			resp.setStatus(200);
		}else {
			out.print("Login failed. Please try again!");
			resp.setStatus(400);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession(false);
		PrintWriter out = resp.getWriter();

		if (ses != null) {
			out.print(ses.getAttribute("username").toString() + " is currently logged in!");
		}else {
			out.print("Please login");
		}

	}


}