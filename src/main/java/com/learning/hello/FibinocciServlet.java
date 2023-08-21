package com.learning.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Servlet implementation class FibinocciServlet
 */
public class FibinocciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	private static int fibonacci(int n) {
	    if (n == 0) {
	      return 1;
	    } else if (n == 1) {
	      return 1;
	    } else {
	      return fibonacci(n-1) + fibonacci(n-2);
	    }
	  }

	  private static List<Integer> fibonaccis(int n) {
	    return IntStream.range(0, n + 1).mapToObj(x -> fibonacci(x)).collect(Collectors.toList());
	  }
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		if(req.getParameter("n") == null) {
			out.println("Give a correct value");
			return;
		}
		else {
			int limit = Integer.valueOf(req.getParameter("n"));
			out.println(String.format("<p> %s </p>", fibonaccis(limit)));
		}
		
		
		
//		try {
////		      Map<String, String[]> parameterMap = req.getParameterMap();
////		      parameterMap.entrySet().stream().forEach(entry -> {
////		        System.out.print("key: " + entry.getKey());
////		        System.out.print(" values: " + Arrays.toString(entry.getValue()) + "\n");
////		      });
//		      PrintWriter out = resp.getWriter();
//		      String val = req.getParameter("n");
//		      int value=Integer.parseInt(val);
//		      int a=0,b=1,res = 0,count=value;
//		      out.println(" "+ a);
//		      out.println(" "+ b);
//		      for(int i=2;i<count;i++) {
//		    	  
//		    	  res = a+b;
//		    	  out.println(" "+ res);
//		    	  a = b;
//		    	  b = res;
//		      }
//		      
//		    } catch (IOException e) {
//		      // TODO Auto-generated catch block
//		      e.printStackTrace();
//		    }
	}
	
	@Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    PrintWriter out = response.getWriter();
	    if (request.getParameter("formLimit") == null) {
	      out.println("This is not the way to access this resource. Please give a value for the parameter 'n' in your query ");
	      return;
	    } else {
	      int limit = Integer.valueOf(request.getParameter("formLimit"));
	      out.println(String.format("<p>%s</p>", fibonaccis(limit)));
	    }
	  }


}
