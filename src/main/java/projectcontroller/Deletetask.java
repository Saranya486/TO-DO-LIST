package projectcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdao.Taskdao;

@WebServlet("/delete")
public class Deletetask extends HttpServlet {
	
	
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int taskid=Integer.parseInt(req.getParameter("id"));
		Taskdao d=new Taskdao();
		  try {
			d.deletetaskbyid(taskid);
			resp.sendRedirect("home.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

}
