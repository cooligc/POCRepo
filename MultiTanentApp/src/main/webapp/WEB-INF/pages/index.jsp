<%@page import="com.skc.domain.Employee"%>
<%@ page import="java.util.*,com.skc.*" %>
<%
	List<Employee> employees = (List<Employee>)request.getAttribute("data");
	for(Employee employee:employees){
		out.println(employee.getId()+"\t"+employee.getName());
	}
%>