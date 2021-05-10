package com.revature.servlet;


	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.revature.models.User;
	import com.revature.service.UserService;


	public class RegisterServlet extends HttpServlet{
		
		private UserService uService = new UserService();
		private ObjectMapper om = new ObjectMapper();
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession ses = req.getSession(false);
			if(ses != null) {
				User loggedIn = uService.findByName(ses.getAttribute("username").toString());
				
				PrintWriter out = resp.getWriter();
				
				if(loggedIn.getRole() ==(1)) {
					
					StringBuilder sb = new StringBuilder();
					
					BufferedReader reader = req.getReader();
					
					String line = reader.readLine();
					
					while(line != null) {
						sb.append(line);
						line = reader.readLine();
					}

					String body = new String(sb); 
					
					
					User u = om.readValue(body, User.class);
					
					if(uService.addUser(u)) {
						resp.setStatus(201); 
						out.print(u.getUsername() + " Created");
					}else {
						resp.setStatus(400); 
						out.print("Invalid input");
					}
				}else {
					out.print("Premission Denied");
					resp.setStatus(401);
					
				}
			}else {
				PrintWriter out = resp.getWriter();
				out.print("Please log in");
				resp.setStatus(400);
			}

		}
		
	}


