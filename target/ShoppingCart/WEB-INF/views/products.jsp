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
  


<form:form action="addProduct" modelAttribute="product" id="btn-add">
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
				
				
				
				
				 <td> <a href="adddeleteproduct/${obj.id}">Delete </a> /
				     <a href="addupdateproduct/${obj.id}">Edit</a> 
				 </td>
				 
				 
		      </tr>
	      </c:forEach>
          </table> 
 </form:form>


</body>
</html>
