
package acme.features.worker.auditor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.roles.Auditor;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("worker/auditor")
public class WorkerAuditorController extends AbstractController<Worker, Auditor> {

	@Autowired
	private WorkerAuditorByAuditrecordShowService showByAuditrecordService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.SHOW_BY_AUDITRECORD, BasicCommand.SHOW, this.showByAuditrecordService);
	}

}
