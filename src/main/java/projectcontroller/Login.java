package projectcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectdao.Taskdao;
import projectdao.Userdao;
import projectdto.Userdto;
@WebServlet("/login")
public class Login extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String email=req.getParameter("useremail");
	 String password=req.getParameter("userpassword");
	 
	 Userdao d=new Userdao();
	 Taskdao taskdao=new Taskdao();
	    
	      try {
			Userdto u =d.findbyemail(email);
			if(u!=null) {
				if(u.getUserpassword().equals(password)) {
					HttpSession session=req.getSession();
					session.setAttribute("user", u);
					taskdao.updateTaskPriorities(u.getUserid());
				    resp.sendRedirect("home.jsp");
				    
				}
				else {
					
					req.setAttribute("errmsg","incorrect password");
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}
			else {
				req.setAttribute("errmsg","incorrect email");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
} 
}
