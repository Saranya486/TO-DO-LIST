
package projectcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import projectdao.Userdao;
import projectdto.Userdto;
@WebServlet("/signup")
@MultipartConfig(maxFileSize=5*1024*1024)
public class Signup extends  HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("userid"));
		 String name=req.getParameter("username");
		 String email=req.getParameter("useremail");
		 long contact=Long.parseLong(req.getParameter("usercontact"));
		 String password=req.getParameter("userpassword");
		 Part  image=req.getPart("userimage");
		 byte [] imagebytes=image.getInputStream().readAllBytes();
		 Userdto u=new Userdto();
		 u.setUserid(id);
		 u.setUsername(name);
		 u.setUseremail(email);
		 u.setUsercontact(contact);
		 u.setUserpassword(password);
		 u.setUserimage(imagebytes);
		 
		 Userdao d=new Userdao();
		 try {
			d.saveuser(u);
			
			resp.sendRedirect("login.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		 
	}
}