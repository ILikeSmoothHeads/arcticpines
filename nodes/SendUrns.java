package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;

import arcticpines.main.Variables;


public class SendUrns extends Node {

	@Override
	public boolean activate() {
		if(Inventory.contains(Variables.fullUrn_ID))
			return true;
		return false;
	}

	@Override
	public void execute() {
		System.out.println("Sending Urns");
		Variables.status = "Sending Urn";
		if(!Variables.teleButton.visible()){
			Inventory.getItem(Variables.fullUrn_ID).getWidgetChild().interact("Teleport urn");
			sleep(800,900);
			
		}
		if(Variables.teleButton.visible()){
			Variables.teleButton.click(true);
			sleep(1000,1200);
		}
		
		
	}

}
