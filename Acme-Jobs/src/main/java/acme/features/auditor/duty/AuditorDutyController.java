
package acme.features.auditor.duty;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.duties.Duty;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("auditor/duty")
public class AuditorDutyController extends AbstractController<Auditor, Duty> {

	@Autowired
	private AuditorDutyShowService		showService;

	@Autowired
	private AuditorDutyListByJobService	listByJobService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_JOB, BasicCommand.LIST, this.listByJobService);

	}
}
