
<%@page import="dao.AdminDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Admin"%>
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
        <link rel="stylesheet" type="text/css" href="css\manageBook.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="js\clock.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        
        <title>Home</title>
    </head>
    
    
    <body onload="startTime()">
      
      
      <div class="head">
		    <div class="head1">
		      <div class="webName">
		           <i class='fas fa-book-open' style="color: white; font-size: 40px;"><a id="title" href="bookstore_home_admin.jsp" style="font-family: Impact; color: whitesmoke;text-decoration: none; "> BookForYou </a></i>
		      </div>
		      
		      <div class="services">
                    <i id ="option" class='far fa-grin-squint'> Hello, Admin <%String Aname= (String)session.getAttribute("Aname"); if(Aname != null){out.print(Aname);} else{response.sendRedirect("bookstore_home.jsp");} %>|  </i>
                    <a id="option" style="color:white;" href="${pageContext.request.contextPath}/logout_bookstore_servlet?logout=ok">Logout</a>
	           </div>
		    </div>
		    
		    <div class="head2">
			    <div class="topnav">
			        <div class="more_service">
			                  <a href="bookstore_home_admin.jsp"><i class='fas fa-home' style="font-size: 25px; color: white; margin-left:70px;"></i></a>
			                  <a style="font-size: 20px; color: white">|  </a>
			                  <a id="clock" style="font-size: 20px; color: white"></a>
			            </div>
			        <div class="search-container">
			          <form action="Search_admin.jsp">
			              <input name="search" type="text" size="60" placeholder="Search books.">
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
		        <li class="bestSellingblock"><a class="bestSelling_link" href="ManageBook.jsp"><b>Manage Book | </b></a></li>
		        <li class="newReleaseblock"><a class="newRelease_link" href="ManageOrder.jsp"><b>Manage Order | </b></a></li>
		      </ul>

		     </div>
		    </div>
		    </div>
       </div>
    

        
        <div class="mainside">  
          <div class="addToStorage">
          <h1><b>Add Book:</b></h1>
           <form name="addForm" id="addForm" action="${pageContext.request.contextPath}/AdminAddBook" method="get">
              <span>ID:</span><br><input type="text" name="addID" class="addID" id="addID" required><br>
              <span>Image(source):</span><br><input type="text" name="addImage" class="addImage" id="addImage"required><br>
              <span>Name:</span><br><input type="text" name="addName"  class="addName" id="addName"required><br>
              <span>Author:</span><br><input type="text" name="addAuthor" class="addAuthor" id="addAuthor"required><br>
              <span>Quantity:</span><br><input type="text" name="addQuantity" class="addQuantity" id="addQuantity"required><br>
              <span>Price:</span><br><input type="text" name="addPrice"  class="addPrice" id="addPrice"><br>
              
              <input type ="hidden" name="Adname" value="<%=session.getAttribute("Aname")%>">
              <input type ="hidden" name="ADD" value="ADD">
              
               <input type="text" style="background-color: white; border-width: 0;" value="" id="resultAdd" readonly><br>
              <input type="submit" value="Add" name="add" class="add" id="add">
            </form> 
            <script type="text/javascript" src="js/jq.js"></script>
			<script type="text/javascript">
				 
				var form = $('#addForm');
				form.submit(function () {
				 
				$.ajax({
				type: form.attr('method'),
				url: form.attr('action'),
				data: form.serialize(),
				success: function (data) {
				var result=data;
				$('#resultAdd').attr("value",result);
				 
				}
				});
				 
				return false;
				});
		  </script> 
          </div>
          <hr style="border-width: 5px; border-color: gray;">
          <hr style="border-width: 5px; border-color: gray;">
          <div class="deleteFromStorage">
          <h1><b>Delete Book:</b></h1>
           <form name="deleteForm" id="deleteForm" action="${pageContext.request.contextPath}/AdminDeleteBook" method="get">
              <span>ID:</span><br><input type="text" name="deleteID" class="deleteID" id="deleteID" required><br>
              <span>Name:</span><br><input type="text" name="deleteName"  class="deleteName" id="deleteName"required><br>
              <span>Author:</span><br><input type="text" name="deleteAuthor" class="deleteAuthor" id="deleteAuthor"required><br>
              <input type="text" style="background-color: white; border-width: 0;" value="" id="resultDelete" readonly><br>
              
              <input type ="hidden" name="Adname" value="<%=session.getAttribute("Aname")%>">
              <input type ="hidden" name="DELETE" value="DELETE">
              
              <input type="submit" value="Delete">
           </form> 
           
             <script type="text/javascript">
				 
				var form1 = $('#deleteForm');
				form1.submit(function () {
				 
				$.ajax({
				type: form1.attr('method'),
				url: form1.attr('action'),
				data: form1.serialize(),
				success: function (data) {
				var result1=data;
				$('#resultDelete').attr("value",result1);
				 
				}
				});
				 
				return false;
				});
		  </script> 
          </div>
          <hr style="border-width: 5px; border-color: gray;">
          <hr style="border-width: 5px; border-color: gray;">
          <div class="UpdateQuan">
             <h1><b>Update Quantity Book:</b></h1>
             <form name="updateForm" id="updateForm" action="${pageContext.request.contextPath}/AdminUpdateBook" method="get">
              <span>ID:</span><br><input type="text" name="updateID" class="updateID" id="updateID" required><br>
              <span>Quantity:</span><br><input type="text" name="updateQuantity" class="updateQuantity" id="updateQuantity"required><br>
              <input type="text" style="background-color: white; border-width: 0;" value="" id="resultUpdate" readonly><br>
              
              <input type ="hidden" name="Adname" value="<%=session.getAttribute("Aname")%>">
              <input type ="hidden" name="UPDATE_QUAN" value="UPDATE_QUAN">
              
              <input type="submit" value="Update">
            </form> 
            <script type="text/javascript">
				 
				var form2 = $('#updateForm');
				form2.submit(function () {
				 
				$.ajax({
				type: form2.attr('method'),
				url: form2.attr('action'),
				data: form2.serialize(),
				success: function (data) {
				var result2=data;
				$('#resultUpdate').attr("value",result2);
				 
				}
				});
				 
				return false;
				});
		  </script> 
             
          </div>   
        </div>

        
        
    </body>
</html>

