package projectdao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.mysql.cj.jdbc.Blob;

import projectdto.Taskdto;

public class Taskdao {
	

	 public Connection getConnection() throws ClassNotFoundException, SQLException {
		   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/office?user=root&password=root");
		    return c;
	   }
	 public int savetask(Taskdto td) throws ClassNotFoundException, SQLException {
		 td.calculateAndSetPriority();
		 Connection co=getConnection();
		 PreparedStatement  pst=co.prepareStatement("insert into taskdto values(?,?,?,?,?,?)");
		 pst.setInt(1,td.getTaskid() );
		 pst.setString(2,td.getTasktitle());
		 pst.setString(3,td.getTaskdescription());
		 pst.setString(4, td.getTaskpriority());
		 Date taskdate=Date.valueOf(td.getTaskduedate());
		 pst.setDate(5,taskdate );
		 pst.setInt(6, td.getUserid());
		 return pst.executeUpdate();	
	 }
	 public int deletetask(int taskid) throws ClassNotFoundException, SQLException {
		 
		 Connection co=getConnection();
		 PreparedStatement  pst=co.prepareStatement("delete from taskdto where taskid=?");
		 pst.setInt(1,taskid);
		 return pst.executeUpdate();
	 }
	 public List<Taskdto> findalltasks(int userid) throws ClassNotFoundException, SQLException{
		 Connection co=getConnection();
		 PreparedStatement  pst=co.prepareStatement("select * from taskdto where userid=?");
		 pst.setInt(1, userid);
         ResultSet rs=pst.executeQuery();
         List<Taskdto> tasks=new ArrayList<Taskdto>();
         while(rs.next()) {
        	 Taskdto t=new Taskdto();
        	 t.setTaskid(rs.getInt(1));
        	 t.setTasktitle(rs.getString(2));
        	 t.setTaskdescription(rs.getString(3));
        	 t.setTaskpriority(rs.getString(4));
        	 t.setTaskduedate(rs.getString(5));
        	 t.setUserid(rs.getInt(6));
        	 tasks.add(t);
         }
         return tasks;
	 }
	 public int updatetask(Taskdto td) throws ClassNotFoundException, SQLException {
		 
		 Connection co=getConnection();
		 PreparedStatement pst=co.prepareStatement("update taskdto set tasktitle=?,taskdesc=?,taskprior=?,taskdue=?,userid=? where taskid=?");
		 
		 pst.setString(1,td.getTasktitle());
		 pst.setString(2,td.getTaskdescription());
		 pst.setString(3, td.getTaskpriority());
		 Date taskdate=Date.valueOf(td.getTaskduedate());
		 pst.setDate(4,taskdate );
		 pst.setInt(5, td.getUserid());
		 pst.setInt(6,td.getTaskid() );
		 return pst.executeUpdate();
	 }
	 
	 public int deletetaskbyid(int id) throws ClassNotFoundException, SQLException {
		 
		 Connection co=getConnection();
		 PreparedStatement  pst=co.prepareStatement("delete from taskdto where taskid=?");
		 pst.setInt(1, id);
		 return pst.executeUpdate();
		 
	 }
	 public Taskdto findbytaskid(int id) throws ClassNotFoundException, SQLException {
		
		 Connection co=getConnection();
		 PreparedStatement pst=co.prepareStatement("select * from taskdto where taskid=?");
		 pst.setInt(1, id);
		 ResultSet rs=pst.executeQuery();
		 Taskdto d=new Taskdto();
		 while(rs.next()) {
			 d.setTaskid(rs.getInt(1));
			 d.setTasktitle(rs.getString(2));
			 d.setTaskdescription(rs.getString(3));
			 d.setTaskpriority(rs.getString(4));
			 d.setTaskduedate(rs.getString(5));
			 d.setUserid(rs.getInt(6));
		 }
		
		return d;
	}
	 public void updateTaskPriorities(int userid) throws ClassNotFoundException, SQLException {
	        Connection co = getConnection();
	        PreparedStatement pst = co.prepareStatement("select * from taskdto where userid=?");
	        pst.setInt(1, userid);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            int taskId = rs.getInt(1);
	            String taskTitle = rs.getString(2);
	            String taskDesc = rs.getString(3);
	            String taskPriority = rs.getString(4);
	            Date taskDueDate = rs.getDate(5);
	            int userId = rs.getInt(6);

	            LocalDate dueDate = taskDueDate.toLocalDate();
	            LocalDate currentDate = LocalDate.now();
	            long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(currentDate, dueDate);

	            String newPriority = (daysBetween <= 3) ? "high" : "low";

	            if (!newPriority.equals(taskPriority)) {
	                PreparedStatement updatePst = co.prepareStatement("update taskdto set taskprior=? where taskid=?");
	                updatePst.setString(1, newPriority);
	                updatePst.setInt(2, taskId);
	                updatePst.executeUpdate();
	            }
	        }
	        co.close();
	    }

}
