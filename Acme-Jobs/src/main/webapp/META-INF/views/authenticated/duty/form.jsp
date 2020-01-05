<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.duty.form.label.job.reference"	path="job.reference"/>
	<acme:form-textbox code="authenticated.duty.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.duty.form.label.description" path="description"/>
	<acme:form-double code="authenticated.duty.form.label.percentageOfTime" path="percentageOfTime"/>
  	
  	<acme:form-submit 
		method="get" 
		code="authenticated.duty.form.button.job" 
		action="/authenticated/job/show?id=${job.id}"/>
  	<acme:form-return code="authenticated.duty.form.button.return"/>
</acme:form>
