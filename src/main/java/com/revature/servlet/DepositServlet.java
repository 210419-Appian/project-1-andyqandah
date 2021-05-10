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
import com.revature.models.RequestToDeposit;
import com.revature.models.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;

public class DepositServlet extends HttpServlet{
	
	private UserService uService = new UserService();
	private AccountService accService = new AccountService();
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

			RequestToDeposit deposit = om.readValue(body, RequestToDeposit.class); 

			Account sourceAccount = accService.findById(deposit.getAccountId());
			if (loggedIn.getRole()==(1) ||  loggedIn.getUserId() == sourceAccount.getUser()){

				if (accService.deposit(sourceAccount, deposit.getAmount())) {
					sourceAccount = accService.findById(deposit.getAccountId());
					out.print(deposit.getAmount() + "You have deposited $" +sourceAccount.getBalance() +" into account number(" + deposit.getAccountId() +")");
					resp.setStatus(200);
				} else {
					resp.setStatus(400);
					out.print("Error. Try Again Please!");
				}

			} else {
				resp.setStatus(401);
				out.print("Permission denied!");
			}
			
		} else {
			PrintWriter out = resp.getWriter();
			resp.setStatus(401);
			out.print("Log in please!");
		}
	}

}

