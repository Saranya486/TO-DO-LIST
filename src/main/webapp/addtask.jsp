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
   }
   h1{
    text-align:center;
   
   }
</style>
</head>
<body>
<form action="addtask" method="post">
   <h1>ADD TASK</h1>
   TASKID:<br><input style="width:100%"  type="number"  name="taskid"><br><br>
   TASKTITLE:<br><input style="width:100%"  type="text" name="tasktitle"><br><br>
   TASKDESCRIPTION:<br><input style="width:100%"  type="text" name="taskdesc"><br><br>
   <label id="lab"for="taskprior">TASKPRIORITY:</label>
  <input type="radio" name="taskprior" value="low">Low
  
   <input type="radio" name="taskprior" value="high">High 
   <br><br>
   TASKDUEDATE:<br><input style="width:100%" type="date"name="taskdue"> <br><br>
   <input type="submit">
   
   
</form>

</body>
</html>

