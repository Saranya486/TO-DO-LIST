<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<style>
body{
     display:flex;
     align-items: center;
     justify-content: center;
     background-size: cover;
     padding-top:200px;
     background: linear-gradient(to right, #27C48D 30%, #02325A 90%); 
   }
    form{
    height:200px;
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
<body>



<form  action="updatepass" method="post">
  <h1>NEW PASSWORD UPDATE</h1>
   EMAIL:<input type="text" name="mail"> <br>
   NEW PASSWORD:<input type="text" name="updatedpass"> <br>
   
   <input type="submit">
  

</form>
</body>
</html>