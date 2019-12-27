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
        <link rel="stylesheet" type="text/css" href="css\bookbackground.css">
        <link rel="stylesheet" type="text/css" href="css\newGoogleUser.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script type="text/javascript" src="js\checkbox_cheked.js"></script>
        <script type="text/javascript" src="js\showPass.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script type="text/javascript" src="js\reg_check_JQuery.js"></script>
        
        <title>Join us</title>
    </head>
    <body onload="startTime()">
    
    
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
              
          <h2>New User</h2>
           <div class="reg" >    
                <form onsubmit="return checkForm(this)"  name="reg" action="${pageContext.request.contextPath}/Register_bookstore_servlet" method="post">  
                    <input name="reg_form_usern" type="text" placeholder="Username" value="" id="reg_form_usern"><br>
                    <label class="error" style="color: red; font-size: 10px;" id="reg_form_usern_check">Invalid User name!</label><br> 
                    
                    <%String Uemail =(String) session.getAttribute("Uemail");%>
                    <input name="reg_form_mail" type="email" placeholder="Email" value="<%out.print(Uemail);%>" id="reg_form_mail"><br>
                    <label class="error" style="color: red; font-size: 10px;" id="reg_form_mail_check">Invalid Email!</label><br> 
                    
                    <input name="reg_form_pass" type="password" placeholder="Password" id="reg_form_pass"><br>
                    <label class="error" style="color: red; font-size: 10px;" id="reg_form_pass_check">Password must be at least 8 characters.</label><br> 
                    
                    <input style="margin-bottom: 10px;" name="reg_form_ret_pass" type="password" placeholder="Confirm password" id="reg_form_ret_pass"><br>
                    <label class="error" style="color: red; font-size: 10px;" id="reg_form_ret_pass_check">Password does not match.</label><br>
                    
                    <input name="show_pass_reg"  type="checkbox" onclick="myFunctionShowReg()"> Show password.<br>
                    <input name="agree" class="agree" type="checkbox" value="agree" id="agree"> Agree with our <a href="term.jsp">Term</a> and <a href="policy.jsp">Private Policy</a><br>
                    <input name="register" class="Register" type="submit" value="Register">   
                </form>
          </div>     

        </div>
        
        
    </body>
</html>
