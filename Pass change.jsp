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
        <link rel="stylesheet" type="text/css" href="bookbackground.css">
        <link rel="stylesheet" type="text/css" href="log_sign_css.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="./clock.js"></script>
        <script type="text/javascript" src="./pass_check.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        <title>Recreate your password</title>
    <div class="head">
    <form name="head1">
        <table name="table1" width="97%">
            <tr>
                <td><h1>&nbsp&nbsp&nbsp<i class='fas fa-book-open' style="color: white; font-size: 40px;"><a name="title" href="bookstore_home.jsp" style="font-family: Impact; color: whitesmoke;text-decoration: none; "> BookForYou </a></i></h1></td>
                <td align="right">
                    <box><i name ="option" class='far fa-grin-squint'> <a name="option" href="login_signin.jsp">Log in/Join us |</a></i></box>&nbsp&nbsp&nbsp
                    <box><i name ="option" class='far fa-question-circle'><a name="option" href="helppage.jsp"> Help |</a></i></box>&nbsp&nbsp&nbsp
                    <box><a name="option" href="contact.jsp"><i name ="option" class='fas fa-comment-alt'> Contact us</i></a></box>
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
            width: 700px;
            height: 500px;
            background: whitesmoke;
            margin-top: 150px;
            margin-left: 35%;
            margin-right: 35%;
            position: absolute;

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
            font-size: 30px; 
            margin-top:80px;
            margin-left: 100px;
        }
        
        .mainsidelog .log input[name = enter_new_pass], input[name = confirm_new_pass]{
            width: 500px; 
            padding: 12px 20px; 
            display: inline-block; 
            border: 1px solid #ccc; 
            border-radius: 4px; 
            box-sizing: border-box; 
            font-size: 30px; 
            margin-top:30px;
            margin-left: 100px;
        }
        .mainsidelog .log input[name = change_pass]{
            font-size: 20px;
            margin-top: 20px; 
            margin-left: 400px; 
            width: 200px; 
            background-color: lightcoral;
        }
        .mainsidelog .log input[name = change_pass]:hover{
            color: wheat;
            background-color: red;}
    </style>      
    </head>
    <body onload="startTime()">
        <div class="mainsidelog">
              <table name="mainside" width="100%">
                  <tr>
                      <td>
                          <div class="log">
                              <form  name="change_pass_2" action="Pass_change" method="post">
                                  <%
                                  String email = request.getParameter("mail_re");
                                  %>                                                              
                                  <input name="enter_email" type="email" value="<%out.print(email); %> " readonly><br>
                                  <input name="enter_new_pass" type="password" placeholder="Password"><br>
                                  <label style="color: red" id="pass_change"></label><br> 
                                  <input name="confirm_new_pass" type="password" placeholder="Confirm password"><br>
                                  <label style="color: red" id="pass_change_check"></label><br> 
                                  <input name="change_pass" type="submit" value="Change password">
                              </form>
                          </div>
                      </td>
                  </tr>    
              </table>  
        </div>  
    </body>
</html>
