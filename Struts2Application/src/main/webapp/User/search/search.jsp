<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
	<h1>Struts 2 Search Application</h1>

	<s:form action="resultAction">
		<table>
			<tr>
				<td><lebel> Enter the text to Search : </lebel></td>
				<td><s:textfield name="query"></s:textfield></td>
			</tr>
			<tr>
				<td><lebel> Select the Search Engine : </lebel></td>
				<td><s:select headerKey="-1"
						headerValue="Select Search Engines" list="searchEngines"
						name="yourSearchEngine" value="defaultSearchEngine"></s:select></td>
			</tr>

		</table>
			<s:submit />
	</s:form>

</body>
</html>