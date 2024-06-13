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
import projectdto.Userdto;
@WebServlet("/update")
public class Updatetask extends HttpServlet{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("taskid"));
		 String tasktitle=req.getParameter("tasktitle");
		 String taskdesc=req.getParameter("taskdesc");
		 String priority=req.getParameter("taskprior");
		 String date=req.getParameter("taskdue");
		 
		 
		 
		 Userdto u= (Userdto)req.getSession().getAttribute("user");
		 Taskdto t=new Taskdto();
		 t.setTaskid(id);
		 t.setTasktitle(tasktitle);
		 t.setTaskdescription(taskdesc);
		 t.setTaskpriority(priority);
		 t.setTaskduedate(date);
		 t.setUserid(u.getUserid());
		 
		 Taskdao d=new Taskdao();
		   try {
			d.updatetask(t);
			resp.sendRedirect("home.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("hiiii");
			e.printStackTrace();
		}
	}
	

}
