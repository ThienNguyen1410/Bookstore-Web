<%-- 
    Document   : home
    Created on : Sep 24, 2019, 11:57:44 AM
    Author     : user
--%>
<%@page import="dao.CartDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Book"%>
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
        <link rel="stylesheet" type="text/css" href="css\book_home.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    
       <link rel="stylesheet" type="text/css" href="css\preloadPage.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script type="text/javascript" src="js\preLoad.js"></script>
        
        <title>Home</title>
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
		             <li><a href="bestSeller_user.jsp">Best seller</a></li>
		             <li><a href="best2019_user.jsp">Best in 2019</a></li>
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
		           <li class="wishlist_link"><a href="wishlist_user.jsp"><b>Wishlist | </b></a></li>
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
		          <div class="inside"><a href="Study_user.jsp" style="padding-right: 8em">Study</a></div>
		          <div class="inside"><a href="Novels_user.jsp" style="padding-right: 8em">Novels</a></div>
             </div>
         
            <div class="block">
           		  <h3 style="text-align:center">Most Viewed Categories</h3>
		          <div class="inside"><a href="Life-style_Self-help_user.jsp" style="padding-right: 6em">Life-Style</a></div>
		          <div class="inside"><a href="Art_Photography_user.jsp" style="padding-right: 10em">Art</a></div>  
           </div>
           
         
            <div class="block">
            	<h3 style="text-align:center">Popular Authors</h3>
		        <div class="haflLeft">
			          <a href="author_user.jsp">J. K. Rowling</a>
			          <a href="author_user.jsp">Nora Roberts</a>
		        </div>
		        <div class="haftRight">
			          <a href="author_user.jsp">Elon Musk</a>
			          <a href="author_user.jsp">Conan Doyle</a>
		        </div>
          </div>
          
          <div class="block">
            	  <img src="https://i.pinimg.com/originals/dd/06/24/dd06241d218a3391016369260c36bece.jpg" style="height:270px;">
            </div>
            
            <div class="block" style="margin-top:130px;">
            	  <img src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cicero-book-quote-1531932791.jpg" style="height:270px;">
            </div>
            
            <div class="block" style="margin-top:130px;">
            	  <img src="https://media.bookbub.com/wp-content/uploads/2015/06/Cooley.jpg" style="height:270px;">
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
          <p style="margin-top: 20px; font-weight: 700;">Best selling</p>
             
          <div class="bestSelling">      
          
             <%CartDao cart = new CartDao(); 
               for (Book book : cart.showBooks_bestSeller()){
             %>
             <form action="${pageContext.request.contextPath}/BookPageUser" method="get">

              <div class ="itemInfo">
                <div class = "itemImg">
                    <input type ="hidden" name="itemID" value="<%=book.getBID()%>">
                    <input type ="hidden" name="imageHom" value="<%=book.getImage()%>">
                    <input type="image" name="imageHome" src="<%=book.getImage()%>">
                </div> 
                
                <div class="itemTitle">
                   <input type ="hidden" name="ItemTitle" value="<%=book.getBtitle()%>">
                   <p><%=book.getBtitle()%></p>
                </div>
                
                <div class="itemAuthor">
                   <input type ="hidden" name="ItemAuthor" value="<%=book.getBauthor()%>">
                   <p><span><b>Author:</b></span> <a id="author" href="author_user.jsp"><%=book.getBauthor()%></a></p>
                </div>
                
                <div class="itemPrice">
                  <span style="color: #00BFFF; font-size:17px;"><b><%= book.getBprice() %> VND</b></span>
                </div>
                
                <div class="buttonAdd">
                  <a href="${pageContext.request.contextPath}/Cart_servlet?BID=<%=book.getBID()%>&UID=<%=cus.getUID()%>"><input type="button" name="buttonAdd" value="Add to cart"></a>
                </div>
                
              </div>
            </form>
              <%}%>
              
              <form action="bestSeller_user.jsp">
              <div class ="itemInfo">
                <div class = "itemImg">
                    <input type="image" style="width:100%; height:200px;" name="imageHome" src="https://us.123rf.com/450wm/777nikolay777/777nikolay7771601/777nikolay777160100166/50996310-positive-symbol-zoom-in-plus-sign-icon-isolated-on-white-background.jpg?ver=6" >
                </div>
                
                <div class="itemTitle">
                   <a href="bestSeller_user.jsp" style="margin:auto; font-size: 40px; font-style: normal; text-align: center; text-decoration: none;">See More</a>
                </div>
              </div>
              </form>

          </div>
          
          <hr style=" border-top: dotted; margin-top: 50px;width:100%; margin-bottom: -30px">

          <%------------------------------------------------------------------------%>
          <%------------------------------------------------------------------------%>
          <div class="cointain">
          <p style="margin-top: 20px; font-weight: 700;">Best in 2019</p>
          <div class="best2019">
           <%for (Book book : cart.showBooks_best2019()){
             %>
             <form action="${pageContext.request.contextPath}/BookPageUser" method="get">

              <div class ="itemInfo">
                <div class = "itemImg">
                    <input type ="hidden" name="itemID" value="<%=book.getBID()%>">
                    <input type ="hidden" name="imageHom" value="<%=book.getImage()%>">
                    <input type="image" name="imageHome" src="<%=book.getImage()%>" >
                </div> 
                
                <div class="itemTitle">
                   <input type ="hidden" name="ItemTitle" value="<%=book.getBtitle()%>">
                   <p><%=book.getBtitle()%></p>
                </div>
                
                <div class="itemAuthor">
                   <input type ="hidden" name="ItemAuthor" value="<%=book.getBauthor()%>">
                   <p><span><b>Author:</b></span> <a id="author" href="author_user.jsp"><%=book.getBauthor()%></a></p>
                </div>
                
                <div class="itemPrice">
                  <span style="color: #00BFFF; font-size:17px;"><b><%= book.getBprice() %> VND</b></span>
                </div>
                
                <div class="buttonAdd">
                  <a href="${pageContext.request.contextPath}/Cart_servlet?BID=<%=book.getBID()%>"><input type="button" name="buttonAdd" value="Add to cart"></a>
                </div>
                
              </div>
            </form>
              <%}%>
              
              <form action="best2019_user.jsp">
              <div class ="itemInfo">
                <div class = "itemImg">
                    <input type="image" style="width:100%; height:200px;" name="imageHome" src="https://us.123rf.com/450wm/777nikolay777/777nikolay7771601/777nikolay777160100166/50996310-positive-symbol-zoom-in-plus-sign-icon-isolated-on-white-background.jpg?ver=6" >
                </div>
                
                <div class="itemTitle">
                   <a href="best2019_user.jsp" style="margin:auto; font-size: 40px; font-style: normal; text-align: center; text-decoration: none;">See More</a>
                </div>
              </div>
              </form>
          </div>
          
          </div>
          <hr style=" border-top: dotted; margin-top: 50px;width:100%; margin-bottom: -30px">
          <%------------------------------------------------------------------------%>
          <%------------------------------------------------------------------------%>
          <div class="cointain">
          <p style="margin-top: 20px; font-weight: 700;">New Release</p>
          <div class="newRelease">
             <%for (Book book : cart.showBooks_newRelease()){
             %>
             <form action="${pageContext.request.contextPath}/BookPageUser" method="get">

              <div class ="itemInfo">
                <div class = "itemImg">
                    <input type ="hidden" name="itemID" value="<%=book.getBID()%>">
                    <input type ="hidden" name="imageHom" value="<%=book.getImage()%>">
                    <input type="image" name="imageHome" src="<%=book.getImage()%>" >
                </div> 
                
                <div class="itemTitle">
                   <input type ="hidden" name="ItemTitle" value="<%=book.getBtitle()%>">
                   <p><%=book.getBtitle()%></p>
                </div>
                
                <div class="itemAuthor">
                   <input type ="hidden" name="ItemAuthor" value="<%=book.getBauthor()%>">
                   <p><span><b>Author:</b></span> <a id="author" href="author_user.jsp"><%=book.getBauthor()%></a></p>
                </div>
                
                <div class="itemPrice">
                  <span style="color: #00BFFF; font-size:17px;"><b><%= book.getBprice() %> VND</b></span>
                </div>
                
                <div class="buttonAdd">
                  <a href="${pageContext.request.contextPath}/Cart_servlet?BID=<%=book.getBID()%>"><input type="button" name="buttonAdd" value="Add to cart"></a>
                </div>
                
              </div>
            </form>
              <%}%>
              
              <form action="newRelease_user.jsp">
              <div class ="itemInfo">
                <div class = "itemImg">
                    <input type="image" style="width:100%; height:200px;" name="imageHome" src="https://us.123rf.com/450wm/777nikolay777/777nikolay7771601/777nikolay777160100166/50996310-positive-symbol-zoom-in-plus-sign-icon-isolated-on-white-background.jpg?ver=6" >
                </div>
                
                <div class="itemTitle">
                   <a href="newRelease_user.jsp" style="margin:auto; font-size: 40px; font-style: normal; text-align: center; text-decoration: none;">See More</a>
                </div>
              </div>
              </form>
          </div>      
          
          </div>
          <hr style=" border-top: dotted; margin-top: 50px;width:100%; margin-bottom: -30px">
          <%------------------------------------------------------------------------%>
          <%------------------------------------------------------------------------%>
          <div class="cointain">
          <p style="margin-top: 20px; font-weight: 700;">Children</p>
          <div class="forChildren">
           <%for (Book book : cart.showBooks_children()){
             %>
             <form action="${pageContext.request.contextPath}/BookPageUser" method="get">

              <div class ="itemInfo">
                <div class = "itemImg">
                    <input type ="hidden" name="itemID" value="<%=book.getBID()%>">
                    <input type ="hidden" name="imageHom" value="<%=book.getImage()%>">
                    <input type="image" name="imageHome" src="<%=book.getImage()%>" >
                </div> 
                
                <div class="itemTitle">
                   <input type ="hidden" name="ItemTitle" value="<%=book.getBtitle()%>">
                   <p><%=book.getBtitle()%></p>
                </div>
                
                <div class="itemAuthor">
                   <input type ="hidden" name="ItemAuthor" value="<%=book.getBauthor()%>">
                   <p><span><b>Author:</b></span> <a id="author" href="author_user.jsp"><%=book.getBauthor()%></a></p>
                </div>
                
                <div class="itemPrice">
                  <span style="color: #00BFFF; font-size:17px;"><b><%= book.getBprice() %> VND</b></span>
                </div>
                
                <div class="buttonAdd">
                  <a href="${pageContext.request.contextPath}/Cart_servlet?BID=<%=book.getBID()%>"><input type="button" name="buttonAdd" value="Add to cart"></a>
                </div>
                
              </div>
            </form>
              <%}%>
              
              <form action="forChildren_user.jsp">
              <div class ="itemInfo">
                <div class = "itemImg">
                    <input type="image" style="width:100%; height:200px;" name="imageHome" src="https://us.123rf.com/450wm/777nikolay777/777nikolay7771601/777nikolay777160100166/50996310-positive-symbol-zoom-in-plus-sign-icon-isolated-on-white-background.jpg?ver=6" >
                </div>
                
                <div class="itemTitle">
                   <a href="forChildren_user.jsp" style="margin:auto; font-size: 40px; font-style: normal; text-align: center; text-decoration: none;">See More</a>
                </div>
              </div>
              </form>
          
          </div>
        </div>
        </div>
        </div>
    </body>
</html>
