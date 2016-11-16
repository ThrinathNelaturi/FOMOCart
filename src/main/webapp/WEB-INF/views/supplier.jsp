<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="addSupplier" modelAttribute="supplier" id="btn-add">
     
       <h3>
                    <c:if test="${supplier.sid==0}">
		       Add New supplier
	            </c:if>
	            <br>
	            <c:if test="${!empty supplier.sid}">
		      Update supplier with SId: <c:out value="${supplier.sid}"/>
		     
	            </c:if>
       </h3>
       
       
       
  <table>
	  
	  <tr>  <c:if test="${supplier.sid!=0}">
	  <td> SId:</td> <td><form:input  path="sid"/></td> 
	   </c:if>
	    <tr> <td> SName:</td> <td><form:input  path="sname"/></td> 
	    <tr> <td>SDescription:</td> <td><form:input path="sdescription"/> </td> 
	    
		
  
	    <tr> <td colspan="2">
    	        <c:if test="${supplier.sid==0}">
			      <input type="submit" value="Add" id="btn-add"> 
	         </c:if>
	         
	         <c:if test="${supplier.sid!=0}">
			      <input type="submit" value="Update" id="btn-update"> 
	         </c:if>
	         
		</td> 
		<tr> <td colspan="2" class="success-msg">
		   <c:out value="${msg}"/>
		</td> 
		
	  </table>
	  
	  
	  
	    <table>   
		 <tr>	 <td> SId </td>
		        	 <td> SName </td>
				 <td> SDescription</td>
				
	
	      	</tr>
    	      <c:forEach var="obj" items="${SupplierList}">
		      <tr>
		                 <td> <c:out value="${obj.sid}"/> </td>
		                 <td> <c:out value="${obj.sname}"/> </td>
				 <td> <c:out value="${obj.sdescription}"/> </td>
				 
				
				
				
				
				 <td> <a href="deleteBySId/${obj.sid}">Delete </a> /
				     <a href="editBySId/${obj.sid}">Edit</a> 
				 </td>
				 
				 
		      </tr>
	      </c:forEach>
          </table> 
</form:form>
</body>
</html>