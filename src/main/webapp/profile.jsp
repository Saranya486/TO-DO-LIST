<%@page import="projectdto.Userdto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

body{

background: linear-gradient(to right, aliceblue 30%, #02325A 90%); 

}


  div{
    display:flex;
    width:400px;
    height:500px;
    flex-direction:column;
    margin-left: 650px;
    margin-top: 100px;

   
   
  }
  img{
   margin-left: 20px;
   

  }
 
</style>
</head>
<body>

<div>  
<% Userdto u=(Userdto)request.getSession().getAttribute("user");%>
 <%
        String base64Image = u.getUserImageBase64();
        if (base64Image != null) {
    %>
        <img src="data:image/jpeg;base64,<%= base64Image %>" height="200px" width="200px" alt="User Image"/>
    <%
        } else {
    %>
        <img src="default-image.jpg" alt="Default User Image"/>
    <%
        }
    %>
 <h3>Name:<%=u.getUsername() %></h2><br>
 <h3>EMAIL:<%=u.getUseremail() %> </h2><br>
 <h3>Password:<%=u.getUserpassword() %></h2><br>
 <h3>Contact:<%=u.getUsercontact() %></h2><br>
 

</div>
</body>
</html>