<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Control + Double space  -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix ="form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> Mini-Project</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
     <div class="container">
      <h2 class="pb-3 pt-3">Report Application</h2>  
      <form:form action="search" modelAttribute="search" method="POST">
         <table>
           <tr>
            <td>Plan Name:</td>
            <td>
               <form:select path="plan">
                  <form:option value="">-Select-</form:option>
                  <form:options items="${names}"></form:options>
              </form:select>          
            </td>
            <td>Plan Status:</td>
            <td>
               <form:select path="status">
                  <form:option value="">-Select-</form:option>
                  <form:options items="${statuses}"></form:options>
              </form:select>          
            </td>
            <td>Gender:</td>
            <td>
               <form:select path="gender">
                  <form:option value="">-Select-</form:option>
                  <form:option value="M">Male</form:option>
                  <form:option value="F">Fe-male</form:option>
              </form:select>          
            </td>
            </tr>
           
            <tr>
            <td>Start Date:</td>
            <td>
               <form:input type="date" path="start_date" class="datepicker" date-date-format="yyyy-mm-dd"/>     
            </td>
           </tr>  
           <tr>
            <td>End Date:</td>      
            <td>
               <form:input type ="date" path="end_date" class="datepicker" date-date-format="yyyy-mm-dd"/>     
            </td>
             <td>
              <input type="submit" value="Search" class= "btn btn-danger">
             </td>
           </tr>                
         </table> 
         <a href = "/" class="btn btn-dark">Reset</a>
      </form:form>
      
      <hr/>
           <table class="table table-striped table-hover">
           <thead>
              <tr>
                 <th>Id</th>
                 <th>Holder</th>
                 <th>Gender</th>
                 <th>Plan</th>
                 <th>Status</th>
                 <th>Start Date</th>
                 <th>End Date</th>
              </tr>   
            </thead>
            <tbody>
               <c:forEach items ="${lists}" var="list" varStatus="index">
                <tr>
                 <td>${index.count}</td>
                 <td>${list.name}</td>
                 <td>${list.gender}</td>
                 <td>${list.plan}</td>
                 <td>${list.status}</td>
                 <td>${list.start_date}</td>
                 <td>${list.end_date}</td>
                </tr>   
               </c:forEach>
               <tr>
               <c:if test="${empty lists}">
               <td colspan ="7" style="text-align:center">No Record Found!!</td>
               </c:if>
               </tr>
            </tbody> 
                     
           </table>
      <hr/>
      
      Export: <a href="excel">Excel</a> <a href="pdf">PDF</a>    
     </div>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>