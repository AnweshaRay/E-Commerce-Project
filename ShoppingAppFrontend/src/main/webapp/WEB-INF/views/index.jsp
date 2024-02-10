<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/rs/css"/>
    <spring:url var="js" value="/rs/js"/>
    <spring:url var="images" value="/rs/images"/>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zxx"> 

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${title}</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${css}/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${css}/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${css}/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${css}/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${css}/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${css}/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${css}/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${css}/style.css" type="text/css">
    <link rel="stylesheet" href="${css}/jquery.dataTables.css" type="text/css">
    
    <script>
    	window.contextRoot= '${contextRoot}';
    </script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
  	<%@include file="./shared/header.jsp" %>
    <!-- Header Section End -->

    <!-- Home Section Begin -->
    <section class="home">
        <div class="container">
        	<c:if test="${userclickhome==true}">
				<%@include file="productbanner.jsp" %>
			</c:if>
			<c:if test="${userclickallproducts==true || userclickcategoryproducts==true}">
				<%@include file="productlist.jsp" %>
			</c:if>
			<c:if test="${userclicksingleproduct==true}">
				<%@include file="singleproduct.jsp" %>
			</c:if>
			<c:if test="${userclickmanageproduct==true}">
				<%@include file="manageproduct.jsp" %>
			</c:if>
        </div>
    </section>
    <!-- home Section End -->

    <!-- Footer Section Begin -->
    <%@include file="./shared/footer.jsp" %>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="${js}/jquery-3.3.1.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/jquery.nice-select.min.js"></script>
    <script src="${js}/jquery-ui.min.js"></script>
    <script src="${js}/jquery.slicknav.js"></script>
    <script src="${js}/mixitup.min.js"></script>
    <script src="${js}/owl.carousel.min.js"></script>
    <script src="${js}/main.js"></script>
    <script src="${js}/dataTables.bootstrap.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
	<script src="${js}/customScript.js"></script>
</body>

</html>