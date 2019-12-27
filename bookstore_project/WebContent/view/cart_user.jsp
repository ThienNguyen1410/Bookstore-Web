
<%@page import="dao.CartDao"%>
<%@page import="models.Book"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" type="text/css" href="css\Cart.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        
        <title>Cart</title>
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
        <div class="main">
        <h1>-----<b> <%= cus.getUserName()%> Cart:</b></h1>
        <hr style="border-width: 5px; border-color: #c0c0c0;">
        <table id="cart" style="width:100%;">
           <thead>
            <tr>
              <th>Image</th>
              <th>Title</th>
              <th>Quantity</th>
              <th>Price</th>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
           </thead>
          <%CartDao cart = new CartDao();
           int totalPrice = 0;
           for (Book book : cart.cartShow(cus.getUserName())){
         %>
          <tbody>
          <tr >
            <td align="center">
	            <form action="${pageContext.request.contextPath}/BookPageUser" method="get">
	                <input type="hidden" name="itemID" value="<%=book.getBID()%>">
	            	<input type="image" style="width: 220px;height: 280px;margin-bottom:20px; border-radius: 12px;"name="imageHome" src="<%=book.getImage()%>">
	            </form>
            </td>
            
            <td align="center"><p style=" font-family:serif; font-size: 35px; width:300px;"><%=book.getBtitle()%></p></td>
            
            <td align="center">
               <form action="${pageContext.request.contextPath}/UpdateQuanCart" method="get">
                 <input type="hidden" name="itemID" value="<%=book.getBID()%>">
                 <input type="hidden" name="Cid" value="<%=cus.getUserName()%>">
                 <input type="text" name="Quan" style="width:70px;border-radius: 8px;" value="<%=book.getQuantity()%>">
                 <input type="submit" name="Update" style="font-size: 20px; cursor:pointer;" value="Update">
               </form>
            </td>
            
            <td align="center">
                <p style=" font-family:serif;"><%=book.getBprice()%> VND<br>(Sale <%=book.getSaleOffPercent()%>%)</p>              
            </td>
            <%totalPrice+=book.getBprice(); %>
            <td align="center">
                 <form action="${pageContext.request.contextPath}/Delete_from_cart" method="get">
                   <input type="hidden" name="itemID" value="<%=book.getBID()%>">
                   <input type="hidden" name="Cid" value="<%=cus.getUserName()%>">
                   <button style="border: none; background-color: whitesmoke; cursor:pointer; color: red;" type="submit" ><i class="fa fa-trash"></i></button>
                 </form>
            </td>
            
          </tr>
          
          </tbody>
          <%} %>
          </table>
          
          </div>
          
          <div class="cartButton">
          <p>--Total price: <%=totalPrice %> VND</p>
          <hr style="border-width: 5px; border-color: #c0c0c0;">
            <div class="Delete">
	          <form action="${pageContext.request.contextPath}/Delete_all_cart" method="get">
	                   <input type="hidden" name="Cid" value="<%=cus.getUserName()%>">
	                   <input type="submit" name="Update" style=" cursor:pointer;" value="Delete All">
	           </form>
	        </div>
	        <div class="Payment">   
	          <form action="Cart_bill_user.jsp">
	                   <input type="submit" name="Checkout" style=" cursor:pointer;" value="Checkout">
	           </form>
	         </div>  
           </div> 
          
           
        </div> 

    </body>
</html>
