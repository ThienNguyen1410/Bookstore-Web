<%-- 
    Document   : forget_pass
    Created on : Oct 15, 2019, 12:03:21 PM
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
        <link rel="stylesheet" type="text/css" href="css\bookbackground.css">
        <link rel="stylesheet" type="text/css" href="css\log_sign_css.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script type="text/javascript" src="js\reg_check.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        <title>Recreate your password</title>
    
        <style>
        .mainsidelog{
            width: 560px;
            height: 170px;
            background: whitesmoke;
            margin:auto;
            margin-top: 120px;
          }
        .mainsidelog .log{
            position: relative;
        }
        .mainsidelog .log input[name = enter_email]{
            width: 500px; 
            padding: 12px 20px; 
            display: inline-block; 
            border: 1px solid #ccc; 
            border-radius: 4px; 
            box-sizing: border-box; 
            font-size: 15px; 
            margin-top:60px;
            margin-left: 130px;
        }
        .mainsidelog .log input[name = change_pass]{
            font-size: 20px;
            margin-top: 20px; 
            margin-left: 440px; 
            width: 200px; 
            background-color: lightcoral;
            border-width:0;
            border-radius:12px;
        }
        .mainsidelog .log input[name = change_pass]:hover{
            background-color: red;}
    </style> 
    
         
    <link rel="stylesheet" type="text/css" href="css\preloadPage.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script type="text/javascript" src="js\preLoad.js"></script>
    </head>
    
    <body onload="startTime()">
      <div class="se-pre-con"></div>
      
        <div class="head">
		    <div class="head1">
		        <div class="webName">
		               <i class='fas fa-book-open' style="color: white; font-size: 40px;"><a id="title" href="bookstore_home.jsp" style="font-family: Impact; color: whitesmoke;text-decoration: none;font-size: 40px; "> BookForYou </a></i>
		        </div>
		        <div class="services">
	                     <a id="option" href="login_signin.jsp"><i id ="option" class='far fa-grin-squint'> Log in/Join us | </i></a>
	                     <a id="option" href="helppage.jsp"><i id ="option" class='far fa-question-circle'> Help | </i></a>
	                     <a id="option" href="contact.jsp"><i id ="option" class='fas fa-comment-alt'> Contact us </i></a>
	            </div>
		    </div>
		    
		    <div class="head2">
			    <div class="topnav">
			       <div class="more_service">
			                  <a href="bookstore_home.jsp"><i class='fas fa-home' style="font-size: 25px; color: white; margin-left:70px;"></i></a>
			                  <a style="font-size: 20px; color: white">|  </a>
			                  <a id="clock" style="font-size: 20px; color: white"></a>
			        </div>
			        <div class="search-container">
			          <form action="Search.jsp">
			              <input name="search" type="text"  placeholder="Search your books here." name="search">
			              <button name="submit" type="submit"><i class="fa fa-search"></i></button>
			          </form>
			        </div>
			    </div>
		    </div>
        </div>
         
        <div class="mainsidelog">
              <table style="width:100%;">
                  <tr>
                      <td>
                          <div class="log">
                              <form  name="change_pass" action="${pageContext.request.contextPath}/Mail_receive" method="get">                                                              
                                  <input name="enter_email" type="email" placeholder="Your email" required><br>
                                  <input name="change_pass" type="submit" value="Continue">
                              </form>
                          </div>
                      </td>
                  </tr>    
              </table>  
        </div>  
    </body>
</html>
