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
        <link rel="stylesheet" type="text/css" href="contact_css.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
            <button type="submit"><i class="fa fa-search"></i></button>
          </form>
        </div>
    </div>
    </div>
    
    <style>
      
    </style>
    </head>
    <body onload="startTime()">
     
        <div class="sidebar_contact">
          <a href="#about">About</a>
          <a href="#services">Services</a>
          <a href="#clients">Clients</a>
          <a href="#contact">Contact</a>
        </div>
        
        <div class="mainsidecontact">
            <form name="contact" action="" method="">
                <div class="contact_form">
                <h1>Contact us</h1><br>
                <i style="font-size: 15px; color: grey; margin-left: 30px">In order to contact us. Please fill the form under.</i><br>
                <i style="font-size: 15px; color: grey; margin-left: 30px"><i style="color: red">*</i> means require to answer.</i><br><br>
                <label>Full name <i style="color: red">*</i></label><br>
                <input name="contact_form" type="text" required="need"><br>
                <label>Email <i style="color: red">*</i></label><br>
                <input name="contact_form" type="email" required="need"><br>
                <label>Postcode/zip </label><br>
                <input name="contact_form" type="text"><br>
                <label>Reason <i style="color: red">*</i></label><br>
                <select name="contact_form" required="">
                    <option value="chose">--Choose--</option>
                    <option value="My_order">My order</option>
                    <option value="My__pre_order">My pre-order</option>
                    <option value="cancel_order">Cancel my order</option>
                    <option value="damaged_item">Damaged items</option>
                    <option value="incorrect_item">Incorrect items</option>
                    <option value="account">My account</option>
                    <option value="website">Website issues</option>
                    <option value="other">Other</option>
                </select><br>
                <label>More information <i style="color: red">*</i></label><br>
                <textarea name="contactMessage" id="contactMessage" required="need" rows="15"></textarea><br>
                <input name="send_mess" type="submit" value="Send"><br>
                <hr class="style-one">
                <h4>-----Follow us-----</h4><br>
                <a name="icon_fb" href="https://www.facebook.com/"><i class='fab fa-facebook-f'></i></a>
                <a name="icon_ins" href="https://www.instagram.com/"><i class='fab fa-instagram'></i></a>
                <a name="icon_twi" href="https://twitter.com/"><i class='fab fa-twitter'></i></a><br><br>
                </div>
            </form>
            
        </div>
        
         
    </body>
</html>
