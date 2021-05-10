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
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.models.RequestToWithdraw;
import com.revature.service.AccountService;
import com.revature.service.UserService;


public class WithdrawServlet extends HttpServlet{
	
	private UserService uService = new UserService();
	private AccountService aService = new AccountService();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession(false);
		if (ses != null) {
			User loggedIn = uService.findByName(ses.getAttribute("username").toString());

			PrintWriter out = resp.getWriter();

			StringBuilder sb = new StringBuilder();			
			BufferedReader reader = req.getReader();

			String line = reader.readLine();

			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}

			String body = new String(sb);


			RequestToWithdraw withdra = om.readValue(body, RequestToWithdraw.class);

			Account sourceAccount = aService.findById(withdra.getAccountId());
			if(loggedIn.getRole() == (1) || loggedIn.getUserId() == sourceAccount.getUser()) {
				try {
					if(aService.withdraw(sourceAccount, withdra.getAmount())) {
						sourceAccount = aService.findById(withdra.getAccountId());
						out.print(" You have sucessfully withdrawn  $"+ withdra.getAmount() + " from account number(" + withdra.getAccountId() + ")"+ "\n Your new balance: $" + sourceAccount.getBalance());
						resp.setStatus(200);
					}else {
						throw new Exception();
					}
				}catch(Exception e) {
					sourceAccount = aService.findById(withdra.getAccountId());
					e.printStackTrace();
					resp.setStatus(451);
					out.print(withdra.getAccountId() + " No sufficient funds for this transation"); 
				}
			}else {
				resp.setStatus(401);
				out.print("Unauthrozied user");
			}
		}else {
			PrintWriter out = resp.getWriter();
			resp.setStatus(401);
			out.print("Please log-in to use this service");
		}
	}

}
