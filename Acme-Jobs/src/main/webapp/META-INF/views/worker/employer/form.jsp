<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
 	<jstl:if test="${command == 'show-by-job'}">
 		<acme:form-textbox code="worker.employer.employer.form.label.userIdentity.fullName" path="identity.fullName"/>
 		<acme:form-textbox code="worker.employer.employer.form.label.userIdentity.email" path="identity.email"/>
 	</jstl:if>
	<acme:form-textbox code="worker.employer.employer.form.label.company" path="company"/>
	<acme:form-textbox code="worker.employer.employer.form.label.sector" path="sector"/>
	
	<acme:form-return code="worker.employer.employer.form.button.return"/>
</acme:form>
