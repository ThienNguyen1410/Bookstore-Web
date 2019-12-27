
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
        <link rel="stylesheet" type="text/css" href="css\wishlist_css.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
        
        <title>Wishlist</title>
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
         <h1 style="font-size: 30px;"><b>Your wish-list:</b></h1>
         <hr style="border-width: 5px; background: black;">
         
          <table id="wish" style="width:100%;">

          <%WishListDao wlist = new WishListDao();
           for (Book book : wlist.viewWishList(cus.getUserName())){
         %>
          <tbody>
          <tr >
            <td>
	            <form action="${pageContext.request.contextPath}/BookPageUser" method="get">
	                <input type="hidden" name="itemID" value="<%=book.getBID()%>">
	            	<input type="image" style="width: 220px;height: 280px;margin-bottom:20px; border-radius: 12px;"name="imageHome" src="<%=book.getImage()%>">
	            </form>
            </td>
            <td><p style=" font-family:serif; font-size: 35px; width:300px;"><%=book.getBtitle()%></p></td>
            <td ><p style="font-family:serif;">Sale <%=book.getSaleOffPercent()%>%</p></td>
            <td>
              <%if(book.getSaleOffPercent() >0){ %>
                 <p style="text-decoration: underline;"><%=book.getSaleOffPrice()%> VND</p>
                 <p style="text-decoration: line-through; font-size: 15px; margin-top: -20px;"><%=book.getBprice()%> VND</p>
              <%}else{%>
              	<p style="text-decoration: underline; font-family:serif;"><%=book.getBprice()%> VND</p>
              <%} %>
             </td>
            <td>
                 <form action="${pageContext.request.contextPath}/DeleteFromWishList" method="get">
                   <input type="hidden" name="itemID" value="<%=book.getBID()%>">
                   <input type="hidden" name="UserName" value="<%=cus.getUserName()%>">
                   <button style="border: none; background-color: whitesmoke; cursor:pointer; color: red;" type="submit" ><i class="fa fa-trash"></i></button>
                 </form>
            </td>
            <td>
            <%if (book.getQuantity() > 0){ %>
                <a href="${pageContext.request.contextPath}/Cart_servlet?BID=<%=book.getBID()%>&UserName=<%=cus.getUserName()%>&UID=<%=cus.getUID()%>"><i class="fa fa-shopping-cart" style="color:navy ;"></i></a>
                <%}%>
            </td>
          </tr>
          
          </tbody>
          <%} %>
          </table>
          
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
