<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="employer.auditrecord.form.label.auditor.identity.fullName" path="auditor.identity.fullName"/>
	<acme:form-textbox code="employer.auditrecord.form.label.job.reference"	path="job.reference"/>
	<acme:form-textbox code="employer.auditrecord.form.label.title" path="title"/>
	<acme:form-moment code="employer.auditrecord.form.label.creationMoment" path="creationMoment"/>
	<acme:form-textarea code="employer.auditrecord.form.label.body" path="body"/>
  	
  	<acme:form-submit 
		method="get" 
		code="employer.auditrecord.form.button.job" 
		action="/employer/job/show?id=${job.id}"/>
	<acme:form-submit 
		method="get" 
		code="employer.auditrecord.form.button.auditor" 
		action="/employer/auditor/show-by-auditrecord?id=${id}"/>
  	<acme:form-return code="employer.auditrecord.form.button.return"/>
</acme:form>
