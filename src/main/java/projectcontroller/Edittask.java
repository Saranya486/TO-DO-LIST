package projectcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectdao.Taskdao;
import projectdto.Taskdto;

@WebServlet("/edit")
public class Edittask extends HttpServlet {
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int taskid=Integer.parseInt(req.getParameter("id"));
		Taskdao d=new Taskdao();
		try {
			Taskdto task=d.findbytaskid(taskid);
			req.setAttribute("task",task);
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   

}
}
