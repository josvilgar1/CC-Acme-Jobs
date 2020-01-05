
package acme.features.administrator.noncommercial;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.banners.Noncommercial;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("administrator/noncommercial")
public class AdministratorNonCommercialController extends AbstractController<Administrator, Noncommercial> {

	@Autowired
	private AdministratorNonCommercialListService	listService;

	@Autowired
	private AdministratorNonCommercialShowService	showService;

	@Autowired
	private AdministratorNonCommercialUpdateService	updateService;

	@Autowired
	private AdministratorNonCommercialDeleteService	deleteService;

	@Autowired
	private AdministratorNonCommercialCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);

	}
}
