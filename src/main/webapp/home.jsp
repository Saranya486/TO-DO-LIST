<%@page import="projectdto.Taskdto"%>
<%@page import="java.util.List"%>
<%@page import="projectdao.Taskdao"%>
<%@page import="projectdao.Userdao"%>
<%@page import="projectdto.Userdto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background: linear-gradient(to right, #27C48D 30%, #02325A 90%);
}
table {
    width: 90%;
    border-collapse: collapse;
    font-size: 18px;
    text-align: left;
    background-color: #fff;
}
 th,td {
    padding: 12px 15px;
    border: 2px solid black;
   
}

tr:nth-of-type(even) {
  background-color:#DDFFB2;
}
tr:nth-of-type(odd) {
    background-color:lightgreen ;
}
#tablecon{
display:flex;
align-items: center;
margin-top:30px;
justify-content: center;

}
th{
text-align: center;
}
button{
 width:100px;
padding:8px;
margin-left:70px;
background-color:#02325A; 
}
a:link{
color:white;
text-decoration: none;
}
a:visited{
color:white;
text-decoration: none;

}
a:active{
color:white;
text-decoration: none;

}
#navcontent{

/* border: 1px solid black;; */
height: 45px;
background-color:rgb(50, 48, 48);
border-top-left-radius:6% ; 
    border-top-right-radius: 10px;
    border-top-left-radius: 10px;

}
.left_module{
    /* border: 1px solid black; */
    height: 35px;
    
  
}
#left_content{
    display: flex;
    gap:30px;
    align-content: center;
    
}
.left_module{
    font-size: 16px;
    width:100px;
    height: 45px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: aliceblue;
    transition: 0.2s;
}
.left_module:hover{
    background-color: gray;
    height:48px ;
}
</style>


</head>
<body>
<h1>HOME PAGE</h1>

<div id="navcontent">

   <div id="navigation_module">

    <section id="left_content">
       <a class="left_module" href="addtask.jsp">ADDTASK</a>
       <a class="left_module" href="profile.jsp">PROFILE</a>
    </section>
   </div>

    </div>

 <% Userdto u=(Userdto)request.getSession().getAttribute("user");%>
 <% int userid=u.getUserid(); %>
 <%Taskdao d=new Taskdao();
 List<Taskdto> tasks=d.findalltasks(userid);%>
 <div id="tablecon">
 <table border="3px">
 <tr>
  <th>ID</th>
  <th>TITLE</th>
   <th>DESCRIPTION</th>
    <th>PRIORITY</th>
     <th>DUEDATE</th>
     <th>DELETE</th>
     <th>UPDATE</th>
 </tr>
 <% for(Taskdto dt:tasks){%>
   <tr>
    <td><%=dt.getTaskid()%></td>
    <td><%=dt.getTasktitle()%></td>
    <td><%=dt.getTaskdescription()%></td>
    <td><%=dt.getTaskpriority()%></td>
    <td><%=dt.getTaskduedate()%></td>
    <td><button><a href="delete?id=<%=dt.getTaskid()%>">DELETE</a></button></td>
    <td><button><a href="edit?id=<%=dt.getTaskid()%>">UPDATE</a></button></td>
   </tr>
 <%} %>
 
 </table><br>
 </div>
 <br>
 <button ><a href="logout">LOGOUT</a></button><br><br>

</body>
</html>