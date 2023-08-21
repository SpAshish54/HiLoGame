package com.learning.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		String Path = "/home/ashish/eclipse-workspace/learning-web/src/main/java/com/learning/hello/Bannedpasswords.txt.txt";
		BufferedReader br = new BufferedReader(new FileReader(Path));
		
		String line;
		boolean change = false;
		out.println("<html> <body>");
		while ((line = br.readLine())!= null) {
			if(line.equals(password)) {
				change = true;
			}
		}
		if(change == false) {
			out.println("Entered password is correct");
		}
		else {
			out.println("Re-enter the password, the password which you entered is blocked");
		}
		out.println("</body> </html>");
	}

}
