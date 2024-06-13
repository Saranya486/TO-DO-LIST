<%@page import="projectdto.Taskdto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 body{
     display:flex;
     align-items: center;
     justify-content: center;
     background-size: cover;
     padding-top:100px;
     background: linear-gradient(to right, #27C48D 30%, #02325A 90%); 
   }
    form{
    height:500px;
    width:420px;
    padding:40px;
    border:1px solid black;
    background-color: white;
   }
   input{
    padding:7px;
    margin-bottom: 10px;
   }
   h1{
    text-align:center;
   
   }
  </style> 
</head>
<body>

<%Taskdto task=(Taskdto)request.getAttribute("task"); %>

<form  action="update" method="post">
   <h1>UPDATE TASK</h1>

   TASKID:<input style="width:100%"  type="number"  name="taskid" value=<%=task.getTaskid() %> >
   TASKTITLE:<input style="width:100%" type="text" name="tasktitle" value=<%=task.getTasktitle() %> >
   TASKDESCRIPTION:<input style="width:100%"  type="text" name="taskdesc"  value=<%=task.getTaskdescription() %>>
   CURRENT TASKPRIORITY:<input  style="width:100%" type="text"  value=<%=task.getTaskpriority() %>>
   TASKPRIORITY:
   <input type="radio" name="taskprior" value="low">Low
   <input type="radio" name="taskprior" value="high">High <br><br>
   TASKDUEDATE:<input style="width:100%" type="date"name="taskdue" value=<%=task.getTaskduedate() %>><br><br>
   <input type="submit">


</form>

</body>
</html>