package arcticpines.nodes;


import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.methods.tab.Inventory;

import arcticpines.main.Variables;



public class LootNests extends Node{

	@Override
	public boolean activate() {
		if(Inventory.getCount()<27){
				return GroundItems.getNearest(Variables.Nest_ID) != null;
		}
		return false;
		
		
	}

	@Override
	public void execute() {
		int n = Inventory.getCount(Variables.Nest_ID);
		System.out.println("Taking Nest");
		Variables.status = "Taking nest";
		GroundItems.getNearest(Variables.Nest_ID).interact("Take");
		sleep(2000,2200);
		if(Inventory.getCount(Variables.Nest_ID)>n)
			Variables.nestsLooted++;
		
	}

}
