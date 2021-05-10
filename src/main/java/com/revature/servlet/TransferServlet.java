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
	import com.revature.models.RequestToTransfer;
	import com.revature.models.User;
	import com.revature.service.UserService;
	import com.revature.service.AccountService;




	public class TransferServlet extends HttpServlet {

		private UserService usService = new UserService();
		private AccountService accService = new AccountService();
		private ObjectMapper om = new ObjectMapper();


		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession ses = req.getSession(false);
			if (ses != null) {
				User loggedIn = usService.findByName(ses.getAttribute("username").toString());

				PrintWriter out = resp.getWriter();

				StringBuilder sb = new StringBuilder();
				BufferedReader reader = req.getReader();

				String line = reader.readLine();

				while (line != null) {
					sb.append(line);
					line = reader.readLine();
				}

				String body = new String(sb);

				RequestToTransfer trans = om.readValue(body, RequestToTransfer.class);

				Account sourceAccount = accService.findById(trans.getSourceAccountId());
				Account targetAccount = accService.findById(trans.getTargetAccountId());

				if (loggedIn.getRole() == (1)|| loggedIn.getUserId() == sourceAccount.getUser()) {

					if (accService.transfer(sourceAccount, targetAccount, trans.getAmount())) {
						sourceAccount = accService.findById(trans.getSourceAccountId());
						targetAccount = accService.findById(trans.getTargetAccountId());
						out.print(" the toal of $" + trans.getAmount() + " has been sucssfully transferd from account(" + trans.getSourceAccountId() + " to account number" + trans.getTargetAccountId()
						+ "\nYour Balance of Account number" + trans.getSourceAccountId() +": $" + sourceAccount.getBalance()
						+ "\nYour Balance of Account number" + trans.getTargetAccountId() +": $" + targetAccount.getBalance());
						resp.setStatus(200);
					} else {
						resp.setStatus(400);
						out.print("Account number " + trans.getSourceAccountId() + " does not have enough funds for this transaction. \nCurrent Balance: $" + sourceAccount.getBalance());
					}

				} else {
					resp.setStatus(401);
					out.print(" Permission denied!");
				}
			} else {
				PrintWriter out = resp.getWriter();
				resp.setStatus(401);
				out.print("Please log in first to use this service");
			}
		}

	}


