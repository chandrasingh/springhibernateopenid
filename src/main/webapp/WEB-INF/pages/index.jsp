<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page isELIgnored="false"%>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
$(function() {
    $( "#from" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 1,
      onClose: function( selectedDate ) {
        $( "#to" ).datepicker( "option", "minDate", selectedDate );
      }
    });
    $( "#to" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 1,
      onClose: function( selectedDate ) {
        $( "#from" ).datepicker( "option", "maxDate", selectedDate );
      }
    });
  });
</script>
</head>
<body>
	<H2>Welcome ${name}</H2>
	<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>

	<h3>Apply Leaves</h3>
	<form method="POST" action="/springsecurity/apply.html">
		<table>
			<tr>
				<th>from</th>
				<th>To</th>
				<th>&nbsp;</th>
			</tr>
			<tr>
				<td><input type="text" name="from" id="from" /></td>
				<td><input type="text" name="to" id="to" /></td>
				<td><input type="submit" value="Apply" /></td>
			</tr>
		</table>
	</form>
</body>
</html>