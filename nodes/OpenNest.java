package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;

import arcticpines.main.Variables;


public class OpenNest extends Node{

	@Override
	public boolean activate() {
		//return Inventory.contains(Variables.Nest_ID);
		return false;
		
	}

	@Override
	public void execute() {
		/**Variables.status = "Looting nest";
		if(Inventory.getItem(Variables.seedNest_ID) != null)
			Inventory.getItem(Variables.seedNest_ID).getWidgetChild().interact("Search");
		sleep(1000,1200);
		if(Inventory.contains(Variables.seed_IDs))
			System.out.println("yo");
		if(Inventory.contains(Variables.dropSeed_IDs))
			Inventory.getItem(Variables.dropSeed_IDs).getWidgetChild().interact("Drop");
		sleep(1000,1200);
		if(Inventory.getItem(Variables.nest_ID) != null)
			Inventory.getItem(Variables.nest_ID).getWidgetChild().interact("Drop");
		**/
	}

}
