
package acme.features.administrator.investorrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investorrecords.Investorrecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("administrator/investorrecord")
public class AdministratorInvestorrecordController extends AbstractController<Administrator, Investorrecord> {

	@Autowired
	private AdministratorInvestorrecordCreateService	createService;
	@Autowired
	private AdministratorInvestorrecordUpdateService	updateService;
	@Autowired
	private AdministratorInvestorrecordDeleteService	deleteService;
	@Autowired
	private AdministratorInvestorrecordListService		listService;
	@Autowired
	private AdministratorInvestorrecordShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
