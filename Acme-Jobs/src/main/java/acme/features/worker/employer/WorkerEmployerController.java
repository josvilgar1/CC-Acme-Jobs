
package acme.features.worker.employer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.roles.Employer;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("worker/employer")
public class WorkerEmployerController extends AbstractController<Worker, Employer> {

	@Autowired
	private WorkerEmployerShowByJobService showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.SHOW_BY_JOB, BasicCommand.SHOW, this.showService);
	}
}
