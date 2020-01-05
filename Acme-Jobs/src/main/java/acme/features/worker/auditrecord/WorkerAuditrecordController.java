
package acme.features.worker.auditrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.auditrecords.Auditrecord;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("worker/auditrecord")
public class WorkerAuditrecordController extends AbstractController<Worker, Auditrecord> {

	@Autowired
	private WorkerAuditrecordListByJobService	listByJobService;

	@Autowired
	private WorkerAuditrecordShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_BY_JOB, BasicCommand.LIST, this.listByJobService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
