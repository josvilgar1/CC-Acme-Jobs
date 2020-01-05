<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.commercial.list.label.picture" path="picture" width="40%"/>
	<acme:list-column code="administrator.commercial.list.label.slogan" path="url" width="20%"/>
	<acme:list-column code="administrator.commercial.list.label.url" path="url" width="40%"/>
</acme:list>

<acme:form>

		<acme:form-submit 
			code="administrator.commercial.list.button.create"
			action="/administrator/commercial/create"
			method = "get"
		/>
		
		<acme:form-return code="administrator.commercial.list.button.return"/>
</acme:form>