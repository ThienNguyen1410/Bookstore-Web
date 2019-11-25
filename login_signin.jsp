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
        <link rel="stylesheet" type="text/css" href="log_sign_css.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="./clock.js"></script>
        <script type="text/javascript" src="./reg_check.js"></script>
        <script type="text/javascript" src="./showPass.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        <title>BestBook_home</title>
    <div class="head">
    <form name="head1">
        <table name="table1" width="97%">
            <tr>
                <td><h1>&nbsp&nbsp&nbsp<i class='fas fa-book-open' style="color: white; font-size: 40px;"><a name="title" href="bookstore_home.jsp" style="font-family: Impact; color: whitesmoke;text-decoration: none; "> BookForYou </a></i></h1></td>
                <td align="right">
                    <box><i name ="option" class='far fa-grin-squint'> <a name="option" href="login_signin.jsp">Log in/Join us |</a></i></box>&nbsp&nbsp&nbsp
                    <box><i name ="option" class='far fa-question-circle'><a name="option" href="helppage.jsp"> Help |</a></i></box>&nbsp&nbsp&nbsp
                    <box><i name ="option" class='fas fa-comment-alt'><a name="option" href="contact.jsp"> Contact us</a></i></box>
                </td>
            </tr>   
        </table>
    </form>
    <div class="topnav">
      <box><a name="topicon" href="bookstore_home.jsp"><i class='fas fa-home' style="font-size: 25px; color: white"></i></a></box>
                  <a name="topicon" style="font-size: 20px; color: white">|</a>&nbsp
                  <a name="topicon" id="txt" style="font-size: 20px; color: white"></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <div class="search-container">
          <form action="">
              <input name="search" type="text" size="60" placeholder="Search your books here." name="search">
            <button type="submit"><i class="fa fa-search"></i></button>
          </form>
        </div>
    </div>
    </div>
    <style>
    
        .mainsidelog{
            width: 1500px;
            height: 800px;
            background: whitesmoke;
            margin-top: 150px;
            margin-left: 350px;
            margin-right: 350px;
            position: absolute;

          }
        .mainsidelog .log{
            position: relative;
             margin-left: -10px;
        }
        .mainsidelog .log input[name = log_form_user], input[name = log_form_pass]{
            width: 500px; 
            padding: 12px 20px; 
            display: inline-block; 
            border: 1px solid #ccc; 
            border-radius: 4px; 
            box-sizing: border-box; 
            font-size: 20px; 
            margin-left: 150px;
        }
        .mainsidelog .log input[name = remem_pass]{
            margin-top: 15px; 
            margin-left: 150px;
        }
        .mainsidelog .log input[name = show_pass]{
            margin-top: 15px; 
            margin-left: 150px;
        }
        .mainsidelog .log input[name = login]{
            font-size: 30px;
            margin-top: 20px; 
            margin-left: 150px; 
            width: 500px; 
            background-color: lightcoral;
        }
        .mainsidelog .log input[name = login]:hover{
            color: wheat;
            background-color: red;
        }
        .mainsidelog .reg{
            position: relative;
            margin-left: 200px;

        }
        .mainsidelog .reg input[name = reg_form_usern], .mainsidelog .reg input[name = reg_form_mail], .mainsidelog .reg input[name = reg_form_pass], .mainsidelog .reg input[name = reg_form_ret_pass]{
            width: 500px; 
            padding: 12px 20px; 
            display: inline-block; 
            border: 1px solid #ccc; 
            border-radius: 4px; 
            box-sizing: border-box; 
            font-size: 20px; 
            margin-right: 150px;
        }
        .mainsidelog .reg input[name = keep_sign]{
            margin-top: 15px; 
            margin-left:-400px;
        }
        .mainsidelog .reg input[name = agree], input[name = show_pass_reg]{
            margin-top: 15px; 
            margin-left:-300px;
        }
        .mainsidelog .reg input[name = show_pass_reg]{
            margin-top: 5px; 
            margin-left:-470px;
        }
        .mainsidelog .reg input[name = register]{
            font-size: 30px;
            margin-top: 20px; 
            margin-left:-150px; 
            width: 500px; 
            background-color: lightcoral;
        }
        .mainsidelog .reg input[name = register]:hover{
            color: wheat;
            background-color: red;
        }
    </style>
    </head>
    <body onload="startTime()">
       <%
		     Cookie[] listCookie = request.getCookies();
		     String email_log = "";
		     String pass_log = "";
		     int co = 0;
		     if(listCookie != null){
		        while(co < listCookie.length){
		          if(listCookie[co].getName().equals("email_log")){
		            email_log = listCookie[co].getValue();
		           }
		          if(listCookie[co].getName().equals("pass_log")){
		            pass_log = listCookie[co].getValue();
		           }
		          co++;
		        }
		  
		      }
		 %>
        <div class="mainsidelog">
              <table name="mainside" width="100%">
                  <tr>
                      <td>
                          <h1 style="font-size: 40px; margin-top: 100px; margin-left: 150px;">Log in</h1><br>
                          <div class="log">
                          <a href="forget_pass.jsp" style="font-size: 20px; margin-left: 450px;">Forget password?</a><br>
                              <form  name="log" action="Login_bookstore_servlet" method="post">                              
                                  <input style="margin-top: 10px;" name="log_form_user" type="email" placeholder="Email" id="log_form_user" value="<%out.print(email_log);%>" required>                                 
                                  <input name="log_form_pass" type="password" placeholder="Password" id="log_form_pass" value="<%out.print(pass_log);%>" required><br>
                                  <input name="show_pass"  type="checkbox" onclick="myFunctionShow()"> Show password.<br>
                                  <input name="remem_pass" type="checkbox"> Remember my password.<br>
                                  <input name="login" type="submit" value="Log in">
                              </form>
                          </div>
                      </td>
                      
                      <td align="center">
                          <h2 style="font-size: 40px; margin-top: 110px; margin-left:-300px;">Register</h2>
                           <div class="reg" >    
                                <form onSubmit="return checkForm(this)" name="reg" action="Register_bookstore_servlet" method="post">  
                                    <input name="reg_form_usern" type="text" placeholder="Username" id="reg_form_usern"><br>
                                    <label style="color: red" id="reg_form_usern_check"></label><br> 
                                    <input name="reg_form_mail" type="email" placeholder="Email" id="reg_form_mail"><br>
                                    <label style="color: red" id="reg_form_mail_check"></label><br> 
                                    <input name="reg_form_pass" type="password" placeholder="Password" id="reg_form_pass"><br>
                                    <label style="color: red" id="reg_form_pass_check"></label><br> 
                                    <input style="margin-bottom: 10px;" name="reg_form_ret_pass" type="password" placeholder="Confirm password" id="reg_form_ret_pass"><br>
                                    <label style="color: red" id="reg_form_ret_pass_check"></label><br>
                                    <input name="show_pass_reg"  type="checkbox" onclick="myFunctionShowReg()"> Show password.<br>
                                    <input name="agree" type="checkbox" value="agree" id="agree"> Agree with our <a href="term.jsp">Term</a> and <a href="policy.jsp">Private Policy</a><br>
                                    <input name="register" type="submit" value="Register">   
                                </form>
                          </div>
                      </td>
                  </tr>    
              </table>        

            <br><br><hr class="style-one">
                <h4>-----Follow us-----</h4><br>
                <a name="icon_fb" href="https://www.facebook.com/"><i class='fab fa-facebook-f'></i></a>
                <a name="icon_ins" href="https://www.instagram.com/"><i class='fab fa-instagram'></i></a>
                <a name="icon_twi" href="https://twitter.com/"><i class='fab fa-twitter'></i></a><br><br> 
        </div>  
    </body>
</html>
