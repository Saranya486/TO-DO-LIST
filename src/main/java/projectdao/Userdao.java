package projectdao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import projectdto.Userdto;

public class Userdao {

	 public Connection getConnection() throws ClassNotFoundException, SQLException {
		   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/office?user=root&password=root");
		    return c;
	   }
	 public int saveuser(Userdto u) throws ClassNotFoundException, SQLException {
		 Connection co=getConnection();
		 PreparedStatement pst=co.prepareStatement("insert into userdto values(?,?,?,?,?,?)");
		 pst.setInt(1,u.getUserid());
		 pst.setString(2,u.getUsername());
		 pst.setString(3, u.getUseremail());
		 pst.setLong(4, u.getUsercontact());
		 pst.setString(5,u.getUserpassword());
	     Blob image = new SerialBlob(u.getUserimage());
		 pst.setBlob(6, image);
		return  pst.executeUpdate();
		 
	 }
	 public Userdto findbyemail(String email) throws ClassNotFoundException, SQLException  {
		 
		 Connection co=getConnection();
		 PreparedStatement pst=co.prepareStatement("select * from userdto where useremail=?");
		 pst.setString(1, email);
		  ResultSet rs=pst.executeQuery();
		  Userdto u=new Userdto();
		  
		  if(rs.next()) {
			  u.setUserid(rs.getInt(1));
			  u.setUsername(rs.getString(2));
			  u.setUseremail(rs.getString(3));
			  u.setUsercontact(rs.getLong(4));
			  u.setUserpassword(rs.getString(5));
			  Blob b=rs.getBlob(6);
			  byte[] image=b.getBytes(1,(int) b.length());
			  u.setUserimage(image);
			  return u;
		  }
		  return null;
		 
		 
	 }
	 public int updatepassword(String pass,String email) throws ClassNotFoundException, SQLException {
		 Connection co=getConnection();
		 PreparedStatement pst=co.prepareStatement("update userdto set userpass=? where useremail=?");
		 
		 pst.setString(1,pass );
		 pst.setString(2, email);
		 return  pst.executeUpdate();
		
		 
		 
	 }
	 

}

