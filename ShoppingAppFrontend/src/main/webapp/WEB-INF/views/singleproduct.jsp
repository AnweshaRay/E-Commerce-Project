<nav class="header__menu bg-success">
        <ul>
        	<li><a href="${contextRoot}/home" class="ps-5">Home</a></li>
            <li><a href="${contextRoot}/product/show/all/active/products">Shop</a></li>
            <li><a href="${contextRoot}/manage/show">Manage Products</a></li>
        </ul>
        </nav>
   	<br>
    <div class="container">
    	<ol class="breadcrumb col-md-12">
			<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
    		<li class="breadcrumb-item"><a href="${contextRoot}/product/show/all/active/products">Shop</a></li>
    		<li class="breadcrumb-item active">${product.name}</li>
		</ol>
    </div>
    <div class="row">
    	<div class="col-xs-12 col-sm-3">
    		<div class="thumbnail">
    			<img src="${images}/${product.code}.jpg" class="img img-responsive"/>
    		</div>
    	</div>
    	<div class="col-xs-12 col-sm-9">
    		<h3>${product.name}</h3>
    		<hr/>
    		<h6><b>Author :</b> ${product.author}</h6>
    		<h6><b>Published By :</b> ${product.publisherName}</h6>
    		<hr/>
    		<h4>
    			Price : <strong>&#8377;${product.unitPrice}/-</strong>
    		</h4>
    		<c:choose>
    			<c:when test="${product.quantity<1}">
    				<h6 style="color:red">Out of Stock!</h6><br>
    			</c:when>
    			<c:otherwise>
    				<h6 style="color:green">Available</h6><br>
    			</c:otherwise>
    		</c:choose>
    		<c:choose>
    			<c:when test="${product.quantity<1}">
    				<a href="javascript:void(0)" class="btn btn-success btn-lg fw-bold disabled"><strike><span class="glyphicon glyphicon-shopping-cart">Add to Cart</span></strike></a>
    			</c:when>
    			<c:otherwise>
    				<a href="#" class="btn btn-success btn-lg fw-bold"><span class="glyphicon glyphicon-shopping-cart">Add to Cart</span></a>
    			</c:otherwise>
    		</c:choose>
    		
    		<a href="${contextRoot}/product/show/all/active/products" class="btn btn-danger btn-lg fw-bold ms-4">Back</a>
    		<hr>
    		<div class="container pt-2" style="background-color:#bfe297">
    		<h6><b>About the Book</b></h6>
    		<p class="text-dark fst-italic">${product.description}</p><hr>
    		</div>
    	</div>
    	
    </div>
