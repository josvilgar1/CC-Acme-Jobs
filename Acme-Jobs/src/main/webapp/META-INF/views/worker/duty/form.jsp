<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="worker.duty.form.label.job.reference"	path="job.reference"/>
	<acme:form-textbox code="worker.duty.form.label.title" path="title"/>
	<acme:form-textarea code="worker.duty.form.label.description" path="description"/>
	<acme:form-double code="worker.duty.form.label.percentageOfTime" path="percentageOfTime"/>
  	
  	<acme:form-submit 
		method="get" 
		code="worker.duty.form.button.job" 
		action="/worker/job/show?id=${job.id}"/>
  	<acme:form-return code="worker.duty.form.button.return"/>
</acme:form>
