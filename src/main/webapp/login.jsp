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
     padding-top: 200px;
    background: linear-gradient(to right, #27C48D 30%, #02325A 90%);
   }
    form{
   
    height:360px;
    width:420px;
    display:flex;
    flex-direction:column;
    border:1px solid black;
    padding:20px;
    background-color: white;
   
    
   }
   input{
    padding:7px;
   
   }
   h1{
    text-align:center;
   
   }
   #but{
   margin-top:20px;
   background-color: #25BE88;
   color: white;
   padding:15px;
   font-size: 16px;
   font-weight: bold;
   }
   #img1{
   
   position:relative;
    top:43px;
    left:390px;
   }
   #img2{
   
    position:relative;
    top:46px;
    left:390px;
   }
    
   
   

</style>

<body>

<form action="login" method="post">
<h1>USER LOGIN</h1>
<img id="img1"src="person.png" height="20px" width="20px">
EMAIL<input type="text" name="useremail"><br>
<img id="img2"src="lock.png" height="20px" width="20px">
PASSWORD<input type="text" name="userpassword"><br>
<a href="mailapp">FORGET PASSWORD</a>
<input id="but" type="submit">

<%String error=(String)request.getAttribute("errmsg") ;%>
<%if(error!=null){%>
  <p><%=error %> 
  <%} %>
   

</form>
</body>
</html>