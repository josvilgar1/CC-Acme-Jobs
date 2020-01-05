
package acme.features.anonymous.investorrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.investorrecords.Investorrecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/investorrecord/")
public class AnonymousInvestorRecordController extends AbstractController<Anonymous, Investorrecord> {

	//Internal State	----------------------------------------

	@Autowired
	private AnonymousInvestorRecordListService		listService;

	@Autowired
	private AnonymousInvestorRecordShowService		showService;

	@Autowired
	private AnonymousInvestorRecordListBestService	listBestService;


	//Constructors 	--------------------------------------------

	@PostConstruct
	private void initialise() {
		//BasicCommand
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		//CustomCommand
		super.addCustomCommand(CustomCommand.LIST_BEST, BasicCommand.LIST, this.listBestService);
	}
}
