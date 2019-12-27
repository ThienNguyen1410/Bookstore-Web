
<%@page import="dao.WishListDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.CartDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Book"%>
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
        <link rel="stylesheet" type="text/css" href="css\cart_bill.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script type="text/javascript" src="js\show_hide_option_pay.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
        
        <title>Payment info</title>
    </head>
    <body onload="startTime()">
      
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
     
        <div class="mainside">
          <div class="title"><h1>Payment detail</h1></div>
          
          <div class = "summary">
            <div class="headd">
              <h1><b>Order Summary</b></h1>
            </div>
            
            <div class = "bodyy">
              <%CartDao cart = new CartDao();
		           int totalPrice = 0; int totalItem = 0;
		           for (Book book : cart.cartShow(cus.getUserName())){
		      %>    
		            <p style=" font-family:serif; font-size: 15px; width:400px; padding-left: 10px;">+ <%=book.getBtitle()%>----x<%=book.getQuantity()%><br><%=book.getBprice()%> VND(Sale <%=book.getSaleOffPercent() %>%)</p>	            
		            <%totalPrice+=book.getBprice(); totalItem+=book.getQuantity();%>
	          <%} %>
             <hr style="border-width: 5px; border-color: #c0c0c0;">
             <i class="fa fa-shopping-cart" style="color:red;padding-bottom: 20px;">  x<%=totalItem%> items</i>
             <span style=" font-family:serif; font-size: 20px; width:400px; padding-left: 60px;padding-bottom: 20px;">Total Price: <%=totalPrice%>.VND</span>
            </div> 
          </div>
          
          <div class="form" >
             
                  <div class="formHead">
		                <h1>Please fill in your detail for the order</h1>
		                <hr style="border-color: gray;">
	              </div>
	              
	              <div class="formBody">
	                <form action="${pageContext.request.contextPath}/Cart_payment_2" method="get">
		                <label>Full name <i style="color: red">*</i></label><br>
		                <input name="form_fullname" type="text" value="<%cus.getFullName();%>" required><br>
		                
		                <label>Email </label><br>
		                <input name="form_email" type="email" value="<%=cus.getEmail()%>" readonly><br>
		                
		                <label>Delivery Address <i style="color: red">*</i></label><br>
		                <input name="form_addresss" type="text" value="<%cus.getAddress(); %>" required><br> 
     		                   
		                <label>More information</label><br>
		                <textarea name="More_info" ></textarea><br>
		                <input type="submit" name="payment" value="Continue to payment">
		             </form>   		            
                 </div>         
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
