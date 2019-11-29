<%-- 
    Document   : home
    Created on : Sep 24, 2019, 11:57:44 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-touchevents flexbox csscolumns csscolumns-width csscolumns-span csscolumns-fill csscolumns-gap csscolumns-rule csscolumns-rulecolor csscolumns-rulestyle csscolumns-rulewidth csscolumns-breakbefore csscolumns-breakafter csscolumns-breakinside smil">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Nhat Huy, Minh Phuc, Hoang Thien">
        <meta name="description" content="The website for rent cars">
        <link rel="stylesheet" type="text/css" href="bookbackground.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="./clock.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        <title>BestBook_home</title>
    <div class="head">
    <form name="head1">
        <table name="table1" width="97%">
            <tr>
                <td><h1>&nbsp&nbsp&nbsp<i class='fas fa-book-open' style="color: white; font-size: 40px;"><a name="title" href="bookstore_home_user.jsp" style="font-family: Impact; color: whitesmoke;text-decoration: none; "> BookForYou </a></i></h1></td>
                <td align="right">
                    <box><i name ="option" class='far fa-grin-squint'> <a name="option" href="profile_user.jsp"><%= session.getAttribute("username")%> |</a></i></box>&nbsp&nbsp&nbsp
                    <box><i name ="option" class='far fa-question-circle'><a name="option" href="helppage_user.jsp"> Help |</a></i></box>&nbsp&nbsp&nbsp
                    <box><i name ="option" class='fas fa-comment-alt'><a name="option" href="contact_user.jsp"> Contact us |</a></i></box>&nbsp&nbsp&nbsp
                    <box><a name="option" style="color:white;" href="logout_bookstore_servlet?logout=ok">Logout</a></box>
                    
                </td>
            </tr>   
        </table>
    </form>
    <div class="topnav">
      <box><a name="topicon" href="bookstore_home_user.jsp"><i class='fas fa-home' style="font-size: 25px; color: white"></i></a></box>
                  <a name="topicon" style="font-size: 20px; color: white">|</a>&nbsp
                  <a name="topicon" id="txt" style="font-size: 20px; color: white"></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <div class="search-container">
          <form action="">
              <input name="search" type="text" size="60" placeholder="Search your books here." name="search">
            <button name="submit" type="submit"><i class="fa fa-search"></i></button>
          </form>
        </div>
    </div>
    </div>
    
    <style>
    
    .sidebar {
		  height: 800px;
		  width: 250px;
		  position: fixed;
		  z-index: 1;
		  top: 150px;
		  left: 240px;
		  background: whitesmoke;
		  overflow-x: hidden;
		  padding: 8px 0;
		}
		
		.sidebar a {
		  padding: 6px 8px 6px 16px;
		  text-decoration: none;
		  font-size: 25px;
		  color: #2196F3;
		  display: block;
		  font-family: Arial;
		}
		
		.sidebar a:hover {
		  color: red;
		}
		
		
		
		
		
		@media screen and (max-height: 450px) {
		  .sidebar {padding-top: 15px;}
		  .sidebar a {font-size: 18px;}
		}
		.mainside {
		  background: whitesmoke;
		  margin-top: 150px;
		  margin-left: 500px;
		  margin-right: 400px;
		  font-size: 28px; 
		  padding: 0px 10px;
		  position: absolute;
		  width: 1000px;
		}
    </style>
    </head>
    <body onload="startTime()">
        
        <div class="mainside">
          <h1 >FAQ:</h1>
          <p>question 1</p>
          <p>answer 1 </p>
          
          <p>question 2</p>
          <p>answer 2 </p>
          
          <p>question 3</p>
          <p>answer 3 </p>
          
          <p>question 4</p>
          <p>answer 4 </p>
          
          <p>question 5</p>
          <p>answer 5 </p>
          
          <p>question 6</p>
          <p>answer 6 </p>
          
          <p>question 7</p>
          <p>answer 7 </p>
          
          <p>question 8</p>
          <p>answer 8 </p>
          
          <p>question 9</p>
          <p>answer 9 </p>
          
          <p>question 10</p>
          <p>answer 10 </p>
          <p></p>
          <hr style="background-color: black;">
        </div>  
    </body>
</html>