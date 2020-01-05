<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
 	<jstl:if test="${command == 'show-by-auditrecord'}">
 		<acme:form-textbox code="employer.auditor.form.label.userIdentity.fullName" path="identity.fullName"/>
 		<acme:form-textbox code="employer.auditor.form.label.userIdentity.email" path="identity.email"/>
 	</jstl:if>
	<acme:form-textbox code="employer.auditor.form.label.firm" path="firm"/>
	<acme:form-textbox code="employer.auditor.form.label.responsibility" path="responsibility"/>
	
	<acme:form-submit test="${command == 'create'}" code="employer.auditor.form.button.create" action="/employer/auditor/create"/>
	<acme:form-submit test="${command == 'update'}" code="employer.auditor.form.button.update" action="/employer/auditor/update"/>
	<acme:form-return code="employer.auditor.form.button.return"/>
</acme:form>
