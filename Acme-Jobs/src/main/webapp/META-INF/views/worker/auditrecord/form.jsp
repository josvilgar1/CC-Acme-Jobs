<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="worker.auditrecord.form.label.auditor.identity.fullName" path="auditor.identity.fullName"/>
	<acme:form-textbox code="worker.auditrecord.form.label.job.reference"	path="job.reference"/>
	<acme:form-textbox code="worker.auditrecord.form.label.title" path="title"/>
	<acme:form-moment code="worker.auditrecord.form.label.creationMoment" path="creationMoment"/>
	<acme:form-textarea code="worker.auditrecord.form.label.body" path="body"/>
  	
  	<acme:form-submit 
		method="get" 
		code="worker.auditrecord.form.button.job" 
		action="/worker/job/show?id=${job.id}"/>
	<acme:form-submit 
		method="get" 
		code="worker.auditrecord.form.button.auditor" 
		action="/worker/auditor/show-by-auditrecord?id=${id}"/>
  	<acme:form-return code="worker.auditrecord.form.button.return"/>
</acme:form>
