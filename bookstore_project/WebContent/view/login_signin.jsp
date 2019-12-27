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
        <link rel="stylesheet" type="text/css" href="css\log_sign_css.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script type="text/javascript" src="js\checkbox_cheked.js"></script>
        <script type="text/javascript" src="js\showPass.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
        
        <link rel="stylesheet" type="text/css" href="css\preloadPage.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script type="text/javascript" src="js\reg_check_JQuery.js"></script>
        <script type="text/javascript" src="js\preLoad.js"></script>
        
        <title>Join us</title>
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
           
       <%
		     Cookie[] listCookie = request.getCookies();
		     String email_log = "";
		     String pass_log = "";
		     String user_reg = "";
		     String email_reg ="";
		     int co = 0;
		     if(listCookie != null){
		        while(co < listCookie.length){
		          if(listCookie[co].getName().equals("email_log")){
		            email_log = listCookie[co].getValue();
		           }
		          if(listCookie[co].getName().equals("pass_log")){
		            pass_log = listCookie[co].getValue();
		           }
		          if(listCookie[co].getName().equals("user_reg")){
		        	  user_reg = listCookie[co].getValue();
			           }
		          if(listCookie[co].getName().equals("email_reg")){
		        	  email_reg = listCookie[co].getValue();
			           }
		          co++;
		        }
		  
		      }
		 %>

		 
        <div class="mainsidelog">
              <table style="width:100%;">
                  <tr>
                      <td>
                          <h1 style="font-size: 30px; margin-top: -90px; margin-left: 40px;">Log in</h1><br>
                          <div class="log">
                          <a href="forget_pass.jsp" style="font-size: 15px; margin-left: 390px;">Forget password?</a><br>
                              <form  name="log" action="${pageContext.request.contextPath}/Login_bookstore_servlet" method="post">                              
                                  <input style="margin-top: 10px;" name="log_form_user" type="text" placeholder="Email" id="log_form_user" value="<%out.print(email_log);%>" required>                                 
                                  <input name="log_form_pass" type="password" placeholder="Password" id="log_form_pass" value="<%out.print(pass_log);%>" required><br>
                                  <input name="show_pass"  type="checkbox" onclick="myFunctionShow()"> Show password.<br>
                                  <input name="remem_pass" type="checkbox"> Remember my password.<br>
                                  <input name="login" type="submit" value="Log in">
                              </form>
                          </div>
                      </td>
                      
                      <td align="center">
                          <h2 style="font-size: 30px; margin-top: 20px; margin-left:-300px;">Register</h2>
                           <div class="reg" >    
                                <form onsubmit="return checkForm(this)"  name="reg" action="${pageContext.request.contextPath}/Register_bookstore_servlet" method="post">  
                                    <input name="reg_form_usern" type="text" placeholder="Username" value="<%out.print(user_reg);%>" id="reg_form_usern"><br>
                                    <label class="error" style="color: red; font-size: 10px;" id="reg_form_usern_check">Invalid User name!</label><br> 
                                    
                                    <input name="reg_form_mail" type="email" placeholder="Email" value="<%out.print(email_reg);%>" id="reg_form_mail"><br>
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
                      </td>
                  </tr>    
              </table>        

            <br><br><hr class="style-one">
             <h4>-----Or-----</h4><br>
             <div style="margin:auto; width:100%; padding-left: 38%;">   
                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8081/bookstore_project/login-google&response_type=code&client_id=518030905519-j9vpcfh3f0g41c7va5157grpkpdnmemt.apps.googleusercontent.com&approval_prompt=force">
                <img style="margin-top:-5px; width:300px; height:100px;" src="https://res.cloudinary.com/practicaldev/image/fetch/s--YVSXRIP0--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_880/https://thepracticaldev.s3.amazonaws.com/i/c74ljgt1t4o1ko28ycm8.png"></a>  
             </div>
        </div>
        
        <div class="footer">
        <div class="center">
          <h2>----------Follow us----------</h2><br>
                <a id="icon_fb" href="https://www.facebook.com/" ><i class='fab fa-facebook-f fa-2x'></i></a>
                <a id="icon_ins" href="https://www.instagram.com/"><i class='fab fa-instagram fa-2x'></i></a>
                <a id="icon_twi" href="https://twitter.com/"><i class='fab fa-twitter fa-2x'></i></a>
                <a id="icon_yt" href="https://youtube.com/"><i class='fab fa-youtube fa-2x'></i></a>
         </div>
         
         <div class="bottom">
	        <div class="Explore">
	          <h1>Explore</h1>
	          <a href="bookstore_home.jsp">About Us</a>
	          <a href="login_signin.jsp">Sign Up-Log In</a>
	        </div>
	        
	         <div class="Support">
	          <h1>Support</h1>
	          	 <a href="term.jsp">Our Policy and Term</a>
	             <a href="contact.jsp">Contact</a>
	        </div>
        
	       <div class="Contact" style="">
	          <h1>Contact</h1>
	          <p>Phone Number:809532840</p>
	          <p>Email:HTP_CORP@gmail.com</p>
	          <p>Address:...................</p>      
	        </div>
      </div>
      
      <div class="end"><p>Copyright 2019-2019 HTP-CORP - All Rights Reserved. </p></div>
    </div>  
    </body>
</html>
