<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US">
<head><title>Category</title>
</head>
<body>
  

<form:form action="addCategory" modelAttribute="category" id="btn-add">
       <h3>
                    <c:if test="${category.cid==0}">
		       Add New Item
	            </c:if>
	            <br>
	            <c:if test="${!empty category.cid}">
		      Update Item for CId: <c:out value="${category.cid}"/>
		     
	            </c:if>
       </h3>  
 
 
 
 
 
 <table>
	  
	  <tr>  <c:if test="${category.cid!=0}">
	  <td> CId:</td> <td><form:input  path="cid"/></td> 
	   </c:if>
	    <tr> <td> CName:</td> <td><form:input  path="cname"/></td> 
	    <tr> <td>CDescription:</td> <td><form:input path="cdescription"/> </td> 
	
  
	    <tr> <td colspan="2">
    	        <c:if test="${category.cid==0}">
			      <input type="submit" value="Add" id="btn-add"> 
	         </c:if>
	         <c:if test="${category.cid!=0}">
			      <input type="submit" value="Update" id="btn-update"> 
	         </c:if>
		</td> 
		<tr> <td colspan="2" class="success-msg">
		   <c:out value="${msg}"/>
		</td> 
	  </table>
	  
	  
	  
	  <table>   
		 <tr>	 <td> CID </td>
		        	 <td> CName </td>
				 <td> CDescription</td>
				 
	
	      	</tr>
    	      <c:forEach var="obj" items="${categoryList}">
		      <tr>
		                 <td> <c:out value="${obj.cid}"/> </td>
		                 <td> <c:out value="${obj.cname}"/> </td>
				 <td> <c:out value="${obj.cdescription}"/> </td>
				 
				
				
				
				
				 <td> <a href="deleteByCId/${obj.cid}">Delete </a> /
				     <a href="editByCId/${obj.cid}">Edit</a> 
				 </td>
				 
				 
		      </tr>
	      </c:forEach>
          </table> 
 </form:form>


</body>
</html>
