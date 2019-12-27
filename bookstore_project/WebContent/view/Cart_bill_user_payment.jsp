
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
        <script type="text/javascript" src="js\checkPaymentValid.js"></script>
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
          
          <div class="form" style="margin-top:-140px;">             
                  <div class="formHead">		                		                
		                <label>Please choose your payment option</label><br>
		                <hr style="border-color: gray;">
	                	<input type="radio" name="tab" value="Bank" onclick="show2();"> <label>Bank card</label><br>
	                	
						<div id="bank" class="hide">
						 <form action="${pageContext.request.contextPath}/Cart_payment" method="get" onsubmit="return validate();">
						        <label>Name on card:</label><br>
						        <input type="text" name="nameCard"  style="text-transform:uppercase" required><br>
						        <label>Initiated date:</label><br>
								<input type="number" placeholder="mm" name="monthCard" maxlength="2" onkeypress="return isNumberKey(event)" required>&nbsp;/
								<input type="number" placeholder="yy" name="yearCard" maxlength="2" onkeypress="return isNumberKey(event)" required><br>
								<label>Card number</label><br>
								<input type="text" name="numberCard" onkeypress="return isNumberKey(event)" required><br>
								
								<input type="hidden" name="Cid" value="<%=cus.getUserName()%>">
	                            <input type="hidden" name="Uid" value="<%=cus.getUID()%>">
			                    <input type="hidden" name="totalPrice" value="<%=totalPrice%>">
			                    <input type="hidden" name="uName" value="<%=session.getAttribute("usName")%>">
			                    <input type="hidden" name="form_address" value="<%=session.getAttribute("addr")%>">
			                    <input type="hidden" name="enter_email" value="<%=cus.getEmail()%>">
			                    <input type="hidden" name="totalItem" value="<%=totalItem%>">
			                    <input type="hidden" name="method" value="Bank">
			                    <input name="agree1" type="checkbox" style="width:15px; height:15px;" value="agree" id="agree1"> <span style="font-size: 15px; text-decoration: underline;">Agree that after your payment, you cannot cancel the Order.</span><br>
			                    <input name="agree2" type="checkbox" value="agree" id="agree2"> <span style="font-size: 15px; text-decoration: underline;">Agree with our <a href="term.jsp">Term</a> and <a href="policy.jsp">Private Policy</a></span><br>
				                <input name="payment" type="submit" value="Payment">
				           </form>
						</div>
						
						<input type="radio" name="tab" value="Visa" onclick="show3();"> <label>Visa&nbsp;&nbsp; <img id="visaLogo" style="width: 45px; height:30px;"src="https://upload.wikimedia.org/wikipedia/commons/1/16/Former_Visa_%28company%29_logo.svg"></label><br>
						
						<div id="visa" class="hide">
						  <form action="${pageContext.request.contextPath}/Cart_payment" method="get" onsubmit="return validate2();">
								<label>Name on card:</label><br>
						        <input type="text" name="nameCard"  style="text-transform:uppercase" required><br>
						        <label>Expired date:</label><br>
								<input type="number" placeholder="mm" name="monthCard" maxlength="2" onkeypress="return isNumberKey(event)" required>&nbsp;/
								<input type="number" placeholder="yy" name="yearCard" maxlength="2" onkeypress="return isNumberKey(event)" required><br>
								<label>Card number</label><br>
								<input type="text" name="numberCard" onkeypress="return isNumberKey(event)" required><br>
								
								<input type="hidden" name="Cid" value="<%=cus.getUserName()%>">
	                            <input type="hidden" name="Uid" value="<%=cus.getUID()%>">
			                    <input type="hidden" name="totalPrice" value="<%=totalPrice%>">
			                    <input type="hidden" name="uName" value="<%=session.getAttribute("usName")%>">
			                    <input type="hidden" name="form_address" value="<%=session.getAttribute("addr")%>">
			                    <input type="hidden" name="enter_email" value="<%=cus.getEmail()%>">
			                    <input type="hidden" name="totalItem" value="<%=totalItem%>">
			                    <input type="hidden" name="method" value="Visa">
				                <input name="agree1" type="checkbox" style="width:15px; height:15px;" value="agree" id="agree3"> <span style="font-size: 15px; text-decoration: underline;">Agree that after your payment, you cannot cancel the Order.</span><br>
			                    <input name="agree2" type="checkbox" value="agree" id="agree4"> <span style="font-size: 15px; text-decoration: underline;">Agree with our <a href="term.jsp">Term</a> and <a href="policy.jsp">Private Policy</a></span><br>
				                <input name="payment" type="submit" value="Payment">
							</form>
						</div>		            
                 </div>         
          </div>
            
        </div>  
        
    </body>
</html>
