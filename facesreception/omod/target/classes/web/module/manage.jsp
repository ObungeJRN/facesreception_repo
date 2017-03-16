<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<%@ include file="template/localHeader.jsp"%>

<p>Hello ${user.systemId}!</p>

<p>Hello ${user.username}!</p>
<form method="post" action="manage.form" >

     <fieldset>
           <table style="padding:20px">
           <legend>
           Search Concept By Name:
           </legend>
           <tr>
           <td><label for="searchString">Enter the concept Name:</label></td>
           <td><input type="text" id="searchstr" name="searchstr"></td>
           <td colspan="2" style="padding-left:50px;">
           <input type="submit" value="Search" name="submit" id="submit">
           </td>
           </tr>
           </table>
     </fieldset>
<table class="box">
      <c:forEach var="concept" items="${conceptList}">
      <tr class="evenRow">
      <td>${concept.id}</td>
      <td>${concept.name}</td>
      </tr>
      </c:forEach>
</table>
</form>



<%@ include file="/WEB-INF/template/footer.jsp"%>