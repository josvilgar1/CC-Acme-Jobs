
package acme.features.auditor.job;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("auditor/job")
public class AuditorJobController extends AbstractController<Auditor, Job> {

	@Autowired
	private AuditorJobShowService			showService;

	@Autowired
	private AuditorJobListHasAuditrecord	listHasAuditrecord;

	@Autowired
	private AuditorJobListNotHasAuditrecord	listNotHasAuditrecord;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		//CustomCommand
		super.addCustomCommand(CustomCommand.LIST_HAS_AUDITRECORD, BasicCommand.LIST, this.listHasAuditrecord);
		super.addCustomCommand(CustomCommand.LIST_NOT_HAS_AUDITRECORD, BasicCommand.LIST, this.listNotHasAuditrecord);
	}
}
