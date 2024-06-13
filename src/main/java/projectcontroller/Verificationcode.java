package projectcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/verification")
public class Verificationcode extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int code=Integer.parseInt(req.getParameter("code"));
		Integer sessionCode = (Integer) req.getSession().getAttribute("verificationCode");

        if (sessionCode != null && code == sessionCode) {
            resp.sendRedirect("updatepassword.jsp");
        } 
		else {
			
			
			System.out.println("wrong pin");
		}
		
		
	}

}
