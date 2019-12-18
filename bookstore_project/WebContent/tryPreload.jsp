<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

        <script type="text/javascript">
		        $(window).load(function() {
		    		// Animate loader off screen
		    		$(".se-pre-con").fadeOut(3000);
		    	});
        </script>
        
        <style>
        .no-js #loader { display: none;  }
.js #loader { display: block; position: absolute; left: 100px; top: 0; }
.se-pre-con {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url(https://media.giphy.com/media/ZCMXZVHCbyOU0qEiqe/giphy.gif) center no-repeat #fff;
	background-color: #ff9393;
}
        </style>
</head>
<body>
 <div class="se-pre-con"></div>
</body>
</html>