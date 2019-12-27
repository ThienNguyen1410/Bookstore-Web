<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.CartDao"%>
<%@page import="dao.AuthorDao"%>
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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Nhat Huy, Minh Phuc, Hoang Thien">
        <meta name="description" content="The website for rent cars">
        
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css\book_home.css">
        <link rel="stylesheet" type="text/css" href="css\bookbackground.css">
        
        <script type="text/javascript" src="js\clock.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
        
        <link rel="stylesheet" type="text/css" href="css\preloadPage.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script type="text/javascript" src="js\preLoad.js"></script>
        
        <title>Author</title>
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
    
       <div class="body_home">
        <div class="sidebar">
            <div class="block">
            	  <img src="http://www.milwaukeeafwa.org/_/rsrc/1570026699823/book-sale/Book%20Sale%20Image.jpg" >
            </div>
              
            <div class="block">
                  <h3 style="text-align:center">Best Sell Book Categories</h3>
		          <div class="inside"><a href="Study.jsp" style="padding-right: 8em">Study</a></div>
		          <div class="inside"><a href="Novels.jsp" style="padding-right: 8em">Novels</a></div>
             </div>
         
            <div class="block">
           		  <h3 style="text-align:center">Most Viewed Categories</h3>
		          <div class="inside"><a href="Life-style_Self-help.jsp" style="padding-right: 6em">Life-Style</a></div>
		          <div class="inside"><a href="Art_Photography.jsp" style="padding-right: 10em">Art</a></div>  
           </div>
           
         
            <div class="block">
            	<h3 style="text-align:center">Popular Authors</h3>
		        <div class="haflLeft">
			          <a href="author.jsp">J. K. Rowling</a>
			          <a href="author.jsp">Nora Roberts</a>
		        </div>
		        <div class="haftRight">
			          <a href="author.jsp">Elon Musk</a>
			          <a href="author.jsp">Conan Doyle</a>
		        </div>
          </div>
          
          <div class="block">
            	  <a href="login_signin.jsp"><img src=" https://previews.123rf.com/images/rajanig/rajanig1608/rajanig160800056/64304484-join-us-button-isolated.jpg" style="height:270px;" ></a>
            </div>
            
            <div class="block" style="margin-top:130px;">
            	  <img src="https://www.quotemaster.org/images/f3/f3345ccf1b67380ea06558bb28419758.jpg" style="height:270px;">
            </div>
            
            <div class="block" style="margin-top:130px;">
            	  <img src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/albert-einstein-book-quote-1531932852.jpg" style="height:270px;">
            </div>
        </div>
        
        
        
        <div class="autoslide">
			  <div class="slider1"></div>
			  <div class="slider2"></div>
			  <div class="slider3"></div>
        </div>
        
        <div class="quote">
             <img src="https://i.pinimg.com/originals/f9/fa/bc/f9fabc05e95a594bf270328c18394846.png">
        </div>
        
        <div class="mainside">
          <p style="margin-top: 20px; font-weight: 700;"><%=session.getAttribute("Bauthort")%></p>
             
          <div class="bestSelling">      
          
            <%String auth  = (String) session.getAttribute("Bauthort");%>
         
           <%AuthorDao author = new AuthorDao();
               for (Book book : author.showBooks_author(auth)){
             %>
             

              <div class ="itemInfo">
                <div class = "itemImg">
                <form action="${pageContext.request.contextPath}/BookPageUser" method="get">
                    <input type ="hidden" name="itemID" value="<%=book.getBID()%>">
                    <input type="image" name="imageHome" src="<%=book.getImage()%>" >
                   </form>
                </div> 
                
                <div class="itemTitle">
                   <p><%=book.getBtitle()%></p>
                </div>
                
                <div class="itemAuthor">
                   <p><span><b>Author:</b></span> <a id="author" href="${pageContext.request.contextPath}/AuthorUser?Bauthor=<%=book.getBauthor()%>"><%=book.getBauthor()%></a></p>
                </div>
                
                <%if (book.getQuantity() > 0){ %>
                <div class="itemPrice">
                  <span style="font-size:17px;">Remain:<%=book.getQuantity() %></span><br>
                  <span style="color: #00BFFF; font-size:17px;"><b><%=book.getBprice() %> VND</b></span>
                </div>
                
                <div class="buttonAdd">
                <form action="${pageContext.request.contextPath}/Cart_servlet" method ="get">
                  <input type ="hidden" name="BID" value="<%=book.getBID()%>"> 
                  <input type ="hidden" name="UserName" value="<%=cus.getUserName()%>">
                  <input type ="hidden" name="UID" value="<%=cus.getUID()%>"> 
                  <input type="submit" name="buttonAdd" value="Add to cart">
                </form>
                </div>
                <%}else{ %>
                  <div class="itemPrice">
                  <span style="font-size:17px; margin-bottom: -20px; margin-top:20px;"><b>Out of stock</b></span><br>
                </div>
                <%} %>
                
              </div>
           
              <%}%>
              
             
     
         
        </div>
       </div>
              </div>
       
    </body>
</html>

