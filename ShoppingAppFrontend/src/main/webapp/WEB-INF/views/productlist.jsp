<div class="row">
	<%@include file="./shared/sidenavigation.jsp" %>
    <div class="col-lg-9">
   	<%@include file="./shared/topnavigation.jsp" %>
       <div class="row">
			<c:if test="${userclickallproducts==true}" var="data">
				<ol class="breadcrumb col-md-12">
					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
    				<li class="breadcrumb-item active">Shop</li>
				</ol>
				<script>
    				window.categoryId= '';
    			</script>					
			</c:if>
			<c:if test="${userclickcategoryproducts==true}" var="data">
				<ol class="breadcrumb col-md-12">
					<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
    				<li class="breadcrumb-item"><a href="${contextRoot}/product/show/all/active/products">Shop</a></li>
    				<li class="breadcrumb-item active">${category.categoryName}</li>
				</ol>
				<script>
    				window.categoryId= '${category.id}';
    			</script>
			</c:if>
			<div class="col-sm-12">
				<table class="table" id="producttable">
					<thead>
						<tr>
							<th>Book Cover</th>
							<th>Book Name</th>
							<th>Author</th>
							<th>Availability</th>
							<th>Price</th>
							<th></th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>
