<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="employer.auditrecord.list.label.title" path="title" width="30%"/>
	<acme:list-column code="employer.auditrecord.list.label.creationMoment"	path="creationMoment"	width="20%"/>
	<acme:list-column code="employer.auditrecord.list.label.auditor.identity.fullName"	path="auditor.identity.fullName"	width="30%"/>
	<acme:list-column code="employer.auditrecord.list.label.job.reference"	path="job.reference"	width="20%"/>
</acme:list>

<acme:form>
	<acme:form-return code="employer.auditrecord.form.button.return"/>
</acme:form>