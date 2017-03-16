<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="template/localHeader.jsp"%>
<openmrs:htmlInclude file="/scripts/calendar/calendar.js"/>

<p>Hello ${user.systemId}!</p>




<form method="post" action="patientlist.form" >

     <fieldset>
           <table style="padding:20px">
           <legend>
           Person Details:
           </legend>
           <tr>
           <td><label for="searchString">Start Date:</label></td>
           <td><input type="text" id="startdate" name="startdate" onClick="showCalendar(this)"></td>
           <td><label for="searchString">End Date:</label></td>
           <td><input type="text" id="enddate" name="enddate" onClick="showCalendar(this)"></td>
           <td colspan="2" style="padding-left:50px;">
           <input type="submit" value="Search" name="submit" id="submit">
           </td>
           </tr>
           </table>
     </fieldset>
<table class="box">
      <c:forEach var="personsdetails" items="${persondetails}">
      <tr class="evenRow">
      <td>${personsdetails.id}</td>
      <td>${personsdetails.name}</td>
      <td>${personsdetails.DOB}</td>
      <td>${personsdetails.gender}</td>

      </tr>
      </c:forEach>
</table>
</form>



<%@ include file="/WEB-INF/template/footer.jsp"%>