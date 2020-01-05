<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.noncommercial.list.label.picture" path="picture" width="60%"/>
	<acme:list-column code="administrator.noncommercial.list.label.url" path="url" width="40%"/>
</acme:list>

<acme:form>
		<acme:form-submit 
		code="administrator.noncommercial.list.button.create"
		action="/administrator/noncommercial/create"
		method="get"/>
</acme:form>