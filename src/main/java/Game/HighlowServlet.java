package Game;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import controller.HiLoController;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hilo")

public class HighlowServlet extends HttpServlet{
	
	private int points;
	private int number;
	private SampleHiloServlet hl;
	
	@Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    hl = new SampleHiloServlet();
	    hl.reset();
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    hl.setGuess(Integer.parseInt(req.getParameter("guess")));
	    var out = resp.getWriter();
	    if (hl.judge() == 0)
	        hl.reset();
	    out.println(hl.feedback());
	}
	
}
