<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.commercial.form.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.commercial.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.commercial.form.label.url" path="url"/>
	<acme:form-textbox code="administrator.commercial.form.label.creditCardName" path="creditCardName"/>
	<acme:form-textbox code="administrator.commercial.form.label.creditCardNumber" path="creditCardNumber"/>
	<acme:form-integer code="administrator.commercial.form.label.creditCardMonth" path="creditCardMonth" placeholder="01"/>
	<acme:form-integer code="administrator.commercial.form.label.creditCardYear" path="creditCardYear" placeholder="2019"/>
	<acme:form-integer code="administrator.commercial.form.label.creditCardCVV" path="creditCardCVV" placeholder="000"/>
	<acme:form-textbox code="administrator.commercial.form.label.creditCardType" path="creditCardType" placeholder="VISA"/>
	

	
	<acme:form-submit test="${command == 'show'}"
		code="administrator.commercial.form.button.update"
		action="/administrator/commercial/update"/>
		
	<acme:form-submit test="${command == 'show'}"
		code="administrator.commercial.form.button.delete"
		action="/administrator/commercial/delete"/>
		
	<acme:form-submit test="${command == 'create'}"
		code="administrator.commercial.form.button.create"
		action="/administrator/commercial/create"/>
		
	<acme:form-submit test="${command == 'update'}"
		code="administrator.commercial.form.button.update"
		action="/administrator/commercial/update"/>
		
	<acme:form-submit test="${command == 'delete'}"
		code="administrator.commercial.form.button.delete"
		action="/administrator/commercial/delete"/>
		
	<acme:form-return code="administrator.commercial.form.button.return"/>
</acme:form>
