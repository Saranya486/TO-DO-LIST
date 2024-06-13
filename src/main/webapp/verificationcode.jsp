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
     padding-top:200px;
     background: linear-gradient(to right, #27C48D 30%, #02325A 90%); 
   }
    form{
    height:200px;
    width:500px;
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

<form  action="verification" method="post">
  <h2>PLEASE VERIFY YOUR EMAIL ADDRESS</h1>
   CODE:<input type="text" name="code"> <br>
   
   <input type="submit">
  

</form>




</body>
</html>