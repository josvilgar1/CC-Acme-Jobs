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

	<acme:form-textbox code="consumer.offer.form.lable.title" path="title"/>
	<acme:form-textbox code="consumer.offer.form.lable.text" path="text"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="consumer.offer.form.lable.moment" path="moment" readonly="true"/>
	</jstl:if>
	<acme:form-moment code="consumer.offer.form.lable.deadline" path="deadline"/>
	<acme:form-money code="consumer.offer.form.lable.rangeMax" path="rangeMax"/>
	<acme:form-money code="consumer.offer.form.lable.rangeMin" path="rangeMin"/>
	<acme:form-textbox code="consumer.offer.form.lable.ticker" path="ticker" placeholder="OAAAA-00000"/>
	<jstl:if test="${command == 'create'}">
		<acme:form-checkbox code="consumer.offer.form.lable.check" path="check"/>
	</jstl:if>

	<acme:form-submit test="${command == 'create'}"
		code="consumer.offer.form.button.create" 
		action="/consumer/offer/create"/>	
  	<acme:form-return code="consumer.offer.form.button.return"/>
</acme:form>