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
	<acme:form-textbox code="administrator.investorrecord.form.label.name" path="name" />
	<acme:form-textbox code="administrator.investorrecord.form.label.sector" path="sector" />
	<acme:form-textbox code="administrator.investorrecord.form.label.statement" path="statement" />
	<acme:form-integer code="administrator.investorrecord.form.label.stars" path="stars" placeholder="[1-5]"/>

	<acme:form-submit test="${command == 'show'}" code="administrator.investorrecord.form.button.update"
		action="/administrator/investorrecord/update" />
	<acme:form-submit test="${command == 'show'}" code="administrator.investorrecord.form.button.delete"
		action="/administrator/investorrecord/delete" />
	<acme:form-submit test="${command == 'create'}" code="administrator.investorrecord.form.button.create"
		action="/administrator/investorrecord/create" />
	<acme:form-submit test="${command == 'update'}" code="administrator.investorrecord.form.button.update"
		action="/administrator/investorrecord/update" />
	<acme:form-submit test="${command == 'delete'}" code="administrator.investorrecord.form.button.delete"
		action="/administrator/investorrecord/delete" />


	<acme:form-return code="administrator.investorrecord.form.button.return" />
</acme:form>
