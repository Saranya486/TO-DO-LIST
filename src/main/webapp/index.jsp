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
        background-image: url("LIST.jpeg");
        background-repeat: no-repeat;
        background-color: #27C48D;
        
   
   }

div{
display:flex;
flex-direction:column;
  border:1px solid black;
  height:200px;
  width:300px;
  align-items: center;
  justify-content: center;
   border-radius:5px;
   margin-left: 1080px;
   margin-top: 200px;
   background-color:#FDAC40 ;
 
}
button{
 width:100px;
padding:8px;
margin-left:25px;
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
h1{
margin-left: 1050px;

}
button{
 margin-top: 20px;
 
}
</style>
<body>

<h1>TO-DO-LIST PROJECT</h1>

  <div>
  
 <button>
  <a href="login.jsp">Login</a></button>
    <button><a href="signup.jsp">Signup</a></button>
  </div>
</body>
</html>