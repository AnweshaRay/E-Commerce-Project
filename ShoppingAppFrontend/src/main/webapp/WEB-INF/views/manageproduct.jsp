<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<div class="container">
	<div class="card">
		<div class="card-header bg-success text-center text-white">
			<h2 class="display-4">MANAGE PRODUCT</h2>
		</div>
		<div class="card-body">
		<sf:form action="" method="post" modelAttribute="product">
			<div class="form-group row">
				<label for="name" class="col-md-4 fs-3">Book Name : </label>
				<div class="col-md-8">
					<sf:input type="text" path="name" id="name" class="form-control"/>
				</div>
			</div>
			<div class="form-group row mt-1">
				<label for="author" class="col-md-4 fs-3">Author Name : </label>
				<div class="col-md-8">
					<sf:input type="text" path="author" id="author" class="form-control"/>
				</div>
			</div>
			<div class="form-group row mt-1">
				<label for="publisherName" class="col-md-4 fs-3">Publisher Name : </label>
				<div class="col-md-8">
					<sf:input type="text" path="publisherName" id="publisherName" class="form-control"/>
				</div>
			</div>
			<div class="form-group row mt-1">
				<label for="unitPrice" class="col-md-4 fs-3">Price : </label>
				<div class="col-md-3">
					<sf:input type="text" path="unitPrice" id="unitPrice" class="form-control"/>
				</div>
				<label for="quantity" class="col-md-2 fs-3">Quantity : </label>
				<div class="col-md-3">
					<sf:input type="text" path="quantity" id="quantity" class="form-control"/>
				</div>
			</div>
			<div class="form-group row mt-1">
				<label for="description" class="col-md-4 fs-3">Description : </label>
				<div class="col-md-8">
					<sf:textarea path="description" id="description" class="form-control" rows="5"/>
				</div>
			</div>
			<div class="form-group row mt-1">
				<label for="name" class="col-md-4 fs-3">Supplier ID : </label>
				<div class="col-md-2">
					<input type="text" name="name" id="name" class="form-control"/>
				</div>
				<label for="name" class="col-md-2 fs-3">Category ID : </label>
				<div class="col-md-2">
					<input type="text" name="name" id="name" class="form-control"/>
				</div>
				<a class="col-md-2 btn btn-info fw-bold">ADD CATEGORY</a>
			</div>
			<div class="mt-5 text-center">
				<input type="submit" class="col-md-2 btn btn-success btn-lg fw-bold" value="manage product"/>
			</div>
			</sf:form>
		</div>
	</div>
</div>