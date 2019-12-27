<%-- 
    Document   : home
    Created on : Sep 24, 2019, 11:57:44 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Customer"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en" class="no-touchevents flexbox csscolumns csscolumns-width csscolumns-span csscolumns-fill csscolumns-gap csscolumns-rule csscolumns-rulecolor csscolumns-rulestyle csscolumns-rulewidth csscolumns-breakbefore csscolumns-breakafter csscolumns-breakinside smil">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Nhat Huy, Minh Phuc, Hoang Thien">
        <meta name="description" content="The website for rent cars">
        <link rel="stylesheet" type="text/css" href="css\bookbackground.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" type="text/css" href="css\profile_css.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
        <link rel="stylesheet" type="text/css" href="css\preloadPage.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script type="text/javascript" src="js\preLoad.js"></script>
        
        <title>Profile</title>

    </head>
    
    
    <body onload="startTime()">
    <div class="se-pre-con"></div>
     <div class="head">
		    <div class="head1">
		      <div class="webName">
		           <i class='fas fa-book-open' style="color: white; font-size: 40px;"><a id="title" href="bookstore_home_user.jsp" style="font-family: Impact; color: whitesmoke;text-decoration: none; "> BookForYou </a></i>
		      </div>
		      
		      <div class="services">
                    <a id="option" href="profile_user.jsp"><i id ="option" class='far fa-grin-squint'> <% Customer cus = (Customer) session.getAttribute("user"); if(cus != null) { out.print(cus.getUserName());} else{response.sendRedirect("bookstore_home.jsp");}%> |  </i></a>
                    <a id="option" href="helppage_user.jsp"><i id ="option" class='far fa-question-circle'> Help |  </i></a>
                    <a id="option" href="contact_user.jsp"><i id ="option" class='fas fa-comment-alt'> Contact us |  </i></a>
                    <a id="option" style="color:white;" href="${pageContext.request.contextPath}/logout_bookstore_servlet?logout=ok">Logout</a>
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
			          <form action="Search_user.jsp">
			              <input name="search" type="text" size="60" placeholder="Search your books here.">
			            <button name="submit" type="submit"><i class="fa fa-search"></i></button>
			          </form>
			        </div>
			    </div>
		    </div>
		    
		    <div class="downnav_width">
		    <div class="downnav">
		      <div class="rightPart_downNav">
		      <ul class="rightPart">
		        <li class="categoryDropdown">
		           <a class="categoryName" href="#"><b>Category | </b></a>
		           <ul>
		             <li><a href="Art_Photography_user.jsp">Art, Photography</a></li>
		             <li><a href="forChildren_user.jsp">Children books</a></li>
		             <li><a href="Life-style_Self-help_user.jsp">Life-style/Self-help</a></li>
		             <li><a href="Novels_user.jsp">Novels</a></li>
		             <li><a href="Study_user.jsp">Study</a></li>
		           </ul>
		        </li>
		        <li class="bestSellingblock"><a class="bestSelling_link" href="bestSeller_user.jsp"><b>Bestsellers | </b></a></li>
		        <li class="newReleaseblock"><a class="newRelease_link" href="newRelease_user.jsp"><b>New Releases | </b></a></li>
		      </ul>
		      
		      <ul class="leftPart">
		           <li class="wishlist_link"><a href="wishlist_user.jsp" style="margin-top:-5px;"><b><span style="font-size: 20px;">&#9825;</span> Wishlist | </b></a></li>
		           <li class="cart_link"><a href="cart_user.jsp"><i class="fa fa-shopping-cart"></i><b>Cart |</b></a></li>
		       </ul>
		     </div>
		    </div>
		    </div>
    </div>
    
     <div class="profileBody">
        <div class="sidebar">
          <div class="part"><a href="bookstore_home_user.jsp">Home</a></div>
          <div class="part"><a href="wishlist_user.jsp">Wishlist</a></div>
          <div class="part"><a href="cart_user.jsp">Order status</a></div>
          <div class="part"><a href="History_user.jsp">Order history</a></div>
        </div>
        
        
        <div class="mainside">
        <form action="profile_user_edit.jsp">
          <h1><b>Information</b></h1>
          <hr style="background-color: black;">
          <h2>1.Full Name</h2>
          <p><input type="text" name="profile_full_name" value ="<% if(cus != null) { out.print(cus.getFullName());} else{out.print("");}%>" readonly></p>
          <h2>2.Address (Optional)</h2>
          <p><input type="text" name="profile_address" value ="<% if(cus != null) { out.print(cus.getAddress());} else{out.print("");}%>" readonly></p>
          <h2>3.User name</h2>
          <p><input type="text" name="profile_user_name" value ="<% if(cus != null) { out.print(cus.getUserName());} else{out.print("");}%>" readonly></p>
          <h2>4.Email</h2>
          <p><input type="text" name="profile_email" value ="<% if(cus != null) { out.print(cus.getEmail());} else{out.print("");}%>" readonly></p>
          <h2>5.Password</h2>
          <p><input type="password" name="profile_pass" value ="<% if(cus != null) { out.print(cus.getPass());} else{out.print("");}%>" readonly></p>
          <p><input type="submit" name="edit_profile" value="EDIT"></p>
        </form>
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
	          <a href="#">About Us</a>
	          <a href="profile_user.jsp">Your profile</a>
	        </div>
	        
	         <div class="Support">
	          <h1>Support</h1>
	          	 <a href="term.jsp">Our Policy and Term</a>
	             <a href="contact_user.jsp">Contact</a>
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
