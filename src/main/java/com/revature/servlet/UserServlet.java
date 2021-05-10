package com.revature.servlet;



	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.revature.models.Account;
	import com.revature.models.User;
	import com.revature.service.AccountService;
	import com.revature.service.UserService;



	public class UserServlet extends HttpServlet{
		
	

			private UserService uService = new UserService();
			private ObjectMapper om = new ObjectMapper();

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//Gets all users from the database via UserServices
				PrintWriter out = resp.getWriter();
				HttpSession ses = req.getSession(false);
				if(ses != null) {
					String username = (String) ses.getAttribute("user_name");
					User loggedIn = uService.findByName(username);
					
					if(loggedIn.getRole() ==(1) || loggedIn.getRole() ==(2)) {
	
						List<User> list = uService.getAll(); 
						
						
						String json = om.writeValueAsString(list);
					
						out.print(json);
						resp.setStatus(200); 			
						resp.setContentType("application/json");
					}else {
						out.print("Access denied.");
						resp.setStatus(401);
					}			
				}else {
					resp.setStatus(401);
					out.print("Please log-in");
				}
			}
			
			@Override
			protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				PrintWriter out = resp.getWriter();
				
				HttpSession ses = req.getSession(false);
				if(ses != null) {
					String username = (String) ses.getAttribute("user_name");
					User loggedIn = uService.findByName(username);
					
					StringBuilder sb = new StringBuilder();
					
					BufferedReader reader = req.getReader();
					
					String line = reader.readLine();
					
					while(line != null) {
						sb.append(line);
						line = reader.readLine();
					}

					String body = new String(sb); 
					
					User u = om.readValue(body, User.class);
					
					if(loggedIn.getRole() == (1) || u.getUserId() == loggedIn.getUserId()) {	
						if(uService.findById(u.getUserId()) != null) {
						
							uService.updateUser(u, u.getUserId());
							out.print(u.getUsername() + "Updated");
							resp.setStatus(200);	
						}else {
							out.print("User number " + u.getUserId() + " No record found for this user");
							resp.setStatus(404);
						}
						
					}else {
						out.print("For Admin use only)");
						resp.setStatus(401);
					}
				}else {
					out.print("Please login");
					resp.setStatus(401);
				}
			}
	}	
		



