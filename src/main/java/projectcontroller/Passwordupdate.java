package projectcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdao.Userdao;
import projectdto.Userdto;
@WebServlet("/updatepass")
public class Passwordupdate extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Userdto v=(Userdto)req.getSession().getAttribute("user");
		String mail=req.getParameter("mail");
		String newpass=req.getParameter("updatedpass");
		if(newpass!=null) {
			
			Userdao u=new Userdao();
			try {
				u.updatepassword(newpass,mail);
				resp.sendRedirect("login.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
