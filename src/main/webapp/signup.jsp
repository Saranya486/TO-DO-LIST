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
     padding-top:30px;
     background: linear-gradient(to right, #27C48D 30%, #02325A 90%); 
   }
    form{
    display:flex;
    flex-direction:column;
    height:550px;
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
    margin-left: 30px;
   
   }
   input{
    padding:7px;
   
   }
   

</style>
<body> 
  <form action="signup" method="post" enctype="multipart/form-data">
  <h1>Sign up</h1>
  ID:<input type="number" name="userid"> <br>
  NAME:<input type="text" name="username"><br>
  EMAIL:<input type="text" name="useremail"><br>
  CONTACT:<input type="text" name="usercontact"><br>
  PASSWORD:<input type="text"name="userpassword"><br>
  IMAGE:<input type="file" name="userimage"><br>
  <input type="submit">
</form>
</body>
</html>
