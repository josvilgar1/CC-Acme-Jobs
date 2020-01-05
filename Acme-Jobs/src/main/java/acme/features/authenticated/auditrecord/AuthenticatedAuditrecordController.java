
package acme.features.authenticated.auditrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.auditrecords.Auditrecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("authenticated/auditrecord")
public class AuthenticatedAuditrecordController extends AbstractController<Authenticated, Auditrecord> {

	@Autowired
	private AuthenticatedAuditrecordListByJobService	listByJobService;

	@Autowired
	private AuthenticatedAuditrecordShowService			showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listByJobService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
