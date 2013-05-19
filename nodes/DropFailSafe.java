package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;

import arcticpines.main.Variables;

public class DropFailSafe extends Node{

	@Override
	public boolean activate() {
		
		return Inventory.getCount(Variables.articLogs_ID)>1;
	}

	@Override
	public void execute() {
		while(Inventory.getCount(Variables.articLogs_ID)>1){
			Inventory.getItem(Variables.articLogs_ID).getWidgetChild().interact("Drop");
			sleep(500,600);
		}
		
	}

}
