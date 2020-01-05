<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.investorrecord.show.label.name" path="name" />
	<acme:form-textarea code="anonymous.investorrecord.show.label.sector" path="sector" />
	<acme:form-textarea code="anonymous.investorrecord.show.label.statement" path="statement" />
	<acme:form-integer code="anonymous.investorrecord.show.label.stars" path="stars" />
	
  	<acme:form-return code="anonymous.investorrecord.show.button.return"/>
</acme:form>
