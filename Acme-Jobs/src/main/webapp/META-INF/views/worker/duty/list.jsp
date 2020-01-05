<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="worker.duty.list.label.title" path="title" width="30%"/>
	<acme:list-column code="worker.duty.list.label.description"	path="description"	width="50%"/>
	<acme:list-column code="worker.duty.list.label.percentageOfTime" path="percentageOfTime" width="20%"/>
</acme:list>

<acme:form>
	<acme:form-return code="worker.duty.form.button.return"/>
</acme:form>