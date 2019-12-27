<%@page import="dao.BookDao"%>
<%@page import="models.Book"%>

<%@page import="dao.CartDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-touchevents flexbox csscolumns csscolumns-width csscolumns-span csscolumns-fill csscolumns-gap csscolumns-rule csscolumns-rulecolor csscolumns-rulestyle csscolumns-rulewidth csscolumns-breakbefore csscolumns-breakafter csscolumns-breakinside smil">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Nhat Huy, Minh Phuc, Hoang Thien">        
        <link rel="stylesheet" type="text/css" href="css\bookbackground.css">
        <link rel="stylesheet" type="text/css" href="css\Search.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
        
        <link rel="stylesheet" type="text/css" href="css\preloadPage.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script type="text/javascript" src="js\preLoad.js"></script>
        
        <title>Beauty of life and yourself</title>
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
			              <input name="search" type="text"  placeholder="Search your books here.">
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
		             <li><a href="Art_Photography.jsp">Art, Photography</a></li>
		             <li><a href="forChildren.jsp">Children books</a></li>
		             <li><a href="Life-style_Self-help.jsp">Life-style/Self-help</a></li>
		             <li><a href="Novels.jsp">Novels</a></li>
		             <li><a href="Study.jsp">Study</a></li>
		           </ul>
		        </li>
		        <li class="bestSellingblock"><a class="bestSelling_link" href="bestSeller.jsp"><b>Bestsellers | </b></a></li>
		        <li class="newReleaseblock"><a class="newRelease_link" href="newRelease.jsp"><b>New Releases | </b></a></li>
		      </ul>
		      
		      <ul class="leftPart">
		           <li class="wishlist_link"><a href="login_signin.jsp"><b>Wishlist | </b></a></li>
		           <li class="cart_link"><a href="login_signin.jsp"><i class="fa fa-shopping-cart"></i><b>Cart |</b></a></li>
		       </ul>
		     </div>
		     
		    </div>
		    </div>
        </div>
        
        
          <div class="searchView">
         <p style="margin-top: 20px; font-weight: 700;">Lifestyle</p>
         <%BookDao cart = new BookDao(); 
               for (Book book : cart.showBooks_life()){
             %>
          <form action="${pageContext.request.contextPath}/BookPage" method="get">

              <div class ="itemInfo">
                <div class = "itemImg">
                    <input type ="hidden" name="itemID" value="<%=book.getBID()%>">
                    <input type="image" name="imageHome" src="<%=book.getImage()%>" >
                </div> 
                
                <div class="itemTitle">
                   <p><%=book.getBtitle()%></p>
                </div>
                
                <div class="itemAuthor">
                   <p><span><b>Author:</b></span> <a id="author" href="${pageContext.request.contextPath}/Author?Bauthor=<%=book.getBauthor()%>"><%=book.getBauthor()%></a></p>
                </div>
                
                <%if (book.getQuantity() > 0){ %>
	                <%if(book.getSaleOffPercent()>0){ %>
	                <div class="itemPrice">
	                  <p style="font-size:17px; ">Remain:<%=book.getQuantity() %></p><br>
	                  <p style="font-size:12px; color: purple;margin-top: -50px;">Sale <%=book.getSaleOffPercent() %>%</p><br>
	                  <p style="color: #00BFFF; font-size:17px;margin-top: -50px;"><b><%=book.getSaleOffPrice() %> VND</b></p><br>
	                  <p style="font-size:10px; text-decoration: line-through; margin-top: -50px; margin-bottom: -30px;"><%=book.getBprice() %> VND</p><br>
	                </div>
	                
	                <div class="buttonAdd">
	                  <a href="login_signin.jsp"><input type="button" name="buttonAdd" value="Add to cart"></a>
	                </div>
	                   <%}else{ %>
	                      <div class="itemPrice">
			                  <p style="font-size:17px;">Remain:<%=book.getQuantity() %></p><br>
			                  <p style="color: #00BFFF; font-size:17px; margin-top: -30px;margin-bottom: 30px "><b><%=book.getBprice() %> VND</b></p>
			                </div>
			                
			                <div class="buttonAdd">
			                  <a href="login_signin.jsp"><input type="button" name="buttonAdd" value="Add to cart"></a>
			                </div>
	                   <%} %>
                <%}else{ %>
                  <div class="itemPrice">
                  <span style="font-size:17px; margin-bottom: -20px; margin-top:20px;"><b>Out of stock</b></span><br>
                </div>
                <%} %>
                
              </div>
            </form>
          <%} %>
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
