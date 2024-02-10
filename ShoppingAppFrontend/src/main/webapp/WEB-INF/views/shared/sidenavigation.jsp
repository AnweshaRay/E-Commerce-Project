<!--All category-->
<div class="col-lg-3">
	<div class="home__categories">
    	<div class="home__categories__all">
        	<i class="fa fa-bars"></i>
            <span>All Categories</span>
        </div>
        <ul class="category-list">
			<c:forEach items="${categoryList}" var="category">
				<li><a href="${contextRoot}/product/show/all/active/category/${category.id}/products">${category.categoryName}</a></li>
			</c:forEach>	
		</ul>
	</div>
</div>
<!--All category-->