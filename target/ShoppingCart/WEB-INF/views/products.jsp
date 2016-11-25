<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head><title>Product</title>
<style>
 body {
      font: 400 15px Lato, sans-serif;
      line-height: 1.8;
      color: #818181;
  }
  h2 {
      font-size: 24px;
      text-transform: uppercase;
      color: #303030;
      font-weight: 600;
      margin-bottom: 30px;
  }
  h4 {
      font-size: 19px;
      line-height: 1.375em;
      color: #303030;
      font-weight: 400;
      margin-bottom: 30px;
  }
</style>
</head>
<body>
  
<h3>New Product Details</h3>

	<div class="text-center myForm">
		<c:url var="action" value="updateproduct"></c:url>
		<form:form action="${action}" modelAttribute="product"
			enctype="multipart/form-data" method="post">
			<div align="center">
			<table>
				<c:choose>
					<c:when test="${product.id gt 0}">
						<tr>
							<td>ID:</td>
							<td><form:input class="input1" path="id" readonly="true" /></td>
						</tr>
					</c:when>
				</c:choose>
				
				<tr>
					<td>Name:</td>
					<td><form:input class="input1" path="name" /></td>
				</tr>
				
				<tr>
					<td>Description:</td>
					<td><form:input class="input1" path="description" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input class="input1" path="price" /></td>
				</tr>
				<tr>
				<td>Category:</td>
				<td><form:select path="categoryid" required="true">
				<c:forEach items="${categoryList}" var="category">
								<form:option class="input1" value="${category.id}">${category.name}</form:option>
							</c:forEach>
								</form:select></td></tr>
						<tr>
								<td>Supplier:</td>
				<td><form:select path="supplierid" required="true">
				<c:forEach items="${supplierList}" var="supplier">
								<form:option class="input1"  value="${supplier.id}">${supplier.name}</form:option>
							</c:forEach>
								</form:select></td></tr>
				<tr>
					<td>Image:</td>
					<td><form:input type="file"
							class=" btn btn-default btn-block form-control" path="image"
							required="true" /></td>
				</tr> 
				<tr>
					<td></td>
					<td><input type="submit" class="btn btn-primary" value="Save" /></td>
				</tr>
			</table></div>
		</form:form>
	</div>
	<div align="center">
		<table class="table1 table-bordered" style="width: 100%">
			
			<thead>
			
				 <tr id="tr1">
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Category</th>
					<th>Supplier</th>
					<th>Image</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr id="tr1">
						<td id="td1"><c:out value="${product.id}" />
						<td id="td1"><c:out value="${product.name}" />
						<td id="td1"><c:out value="${product.description}" />
						<td id="td1"><c:out value="${product.price}" />
						<td id="td1"><c:out value="${product.categoryid}" />
						<td id="td1"><c:out value="${product.supplierid}" />
						<td><div class="thumbnail">
								<img height="100px" width="100px" alt="${product.id }"
									src="<c:url value="/images/${product.id }.jpg"></c:url>">
							</div>
						<td id="td1"><a href="addupdateproduct/${product.id }"class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-edit"></span> Edit
								</a>
						<td id="td1"><a href="adddeleteproduct/${product.id }"class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-trash"></span> Delete
        </a>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>





<%-- <form:form action="addProduct" modelAttribute="product" id="btn-add">
       <h3>
                    <c:if test="${product.id==0}">
		       Add New Item
	            </c:if>
	            <br>
	            <c:if test="${!empty product.id}">
		      Update Item for Id: <c:out value="${product.id}"/>
		     
	            </c:if>
       </h3>  
 
 
 
 
 
 <table>
	  
	  <tr>  <c:if test="${product.id!=0}">
	  <td> Id:</td> <td><form:input  path="id"/></td> 
	   </c:if>
	    <tr> <td> Name:</td> <td><form:input  path="name"/></td> 
	    <tr> <td>Description:</td> <td><form:input path="description"/> </td> 
	    <tr> <td>Price: </td> <td><form:input path="price"/></td> 
		
  
	    <tr> <td colspan="2">
    	        <c:if test="${product.id==0}">
			      <input type="submit" value="Add" id="btn-add"> 
	         </c:if>
	         <c:if test="${product.id!=0}">
			      <input type="submit" value="Update" id="btn-update"> 
	         </c:if>
		</td> 
		<tr> <td colspan="2" class="success-msg">
		   <c:out value="${msg}"/>
		</td> 
	  </table>
	  
	  
	  
	  <table>   
		 <tr>	 <td> ID </td>
		        	 <td> Name </td>
				 <td> Description</td>
				 <td> Price </td>
	
	      	</tr>
    	      <c:forEach var="obj" items="${productList}">
		      <tr>
		                 <td> <c:out value="${obj.id}"/> </td>
		                 <td> <c:out value="${obj.name}"/> </td>
				 <td> <c:out value="${obj.description}"/> </td>
				 <td> <c:out value="${obj.price}"/> </td>
				
				
				
				
				 <td> <a href="deleteById/${obj.id}">Delete </a> /
				     <a href="editById/${obj.id}">Edit</a> 
				 </td>
				 
				 
		      </tr>
	      </c:forEach>
          </table> 
 </form:form>
 --%>

</body>
</html>
