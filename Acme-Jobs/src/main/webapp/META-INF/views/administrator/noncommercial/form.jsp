<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.noncommercial.form.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.noncommercial.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.noncommercial.form.label.url" path="url"/>
	<acme:form-textbox code="administrator.noncommercial.form.label.jingle" path="jingle"/>
	
	<acme:form-submit test="${command == 'show'}"
		code="administrator.noncommercial.form.button.update"
		action="/administrator/noncommercial/update"/>
		
	<acme:form-submit test="${command == 'show'}"
		code="administrator.noncommercial.form.button.delete"
		action="/administrator/noncommercial/delete"/>
		
	<acme:form-submit test="${command == 'create'}"
		code="administrator.noncommercial.form.button.create"
		action="/administrator/noncommercial/create"/>
		
	<acme:form-submit test="${command == 'update'}"
		code="administrator.noncommercial.form.button.update"
		action="/administrator/noncommercial/update"/>
		
	<acme:form-submit test="${command == 'delete'}"
		code="administrator.noncommercial.form.button.delete"
		action="/administrator/noncommercial/delete"/>
		
	<acme:form-return code="administrator.noncommercial.form.button.return"/>
</acme:form>
