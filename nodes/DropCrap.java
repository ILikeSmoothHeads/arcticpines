package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;

import arcticpines.main.Variables;

public class DropCrap extends Node{

	@Override
	public boolean activate() {
		
		return Inventory.getItem(Variables.randomCrap)!=null;
	}

	@Override
	public void execute() {
		Inventory.getItem(Variables.randomCrap).getWidgetChild().interact("Drop");
		sleep(500,600);
		
	}

}
