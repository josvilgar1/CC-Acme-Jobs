<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.auditrecord.form.label.auditor.identity.fullName" path="auditor.identity.fullName"/>
	<acme:form-textbox code="authenticated.auditrecord.form.label.job.reference"	path="job.reference"/>
	<acme:form-textbox code="authenticated.auditrecord.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.auditrecord.form.label.creationMoment" path="creationMoment"/>
	<acme:form-textarea code="authenticated.auditrecord.form.label.body" path="body"/>
  	
  	<acme:form-submit 
		method="get" 
		code="authenticated.auditrecord.form.button.job" 
		action="/authenticated/job/show?id=${job.id}"/>
	<acme:form-submit 
		method="get" 
		code="authenticated.auditrecord.form.button.auditor" 
		action="/authenticated/auditor/show-by-auditrecord?id=${id}"/>
  	<acme:form-return code="authenticated.auditrecord.form.button.return"/>
</acme:form>
