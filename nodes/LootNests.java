package arcticpines.nodes;


import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.node.GroundItems;

import arcticpines.main.Variables;



public class LootNests extends Node{

	@Override
	public boolean activate() {
		return GroundItems.getNearest(Variables.Nest_ID) != null;
		
		
	}

	@Override
	public void execute() {
		Variables.status = "Taking nest";
		GroundItems.getNearest(Variables.Nest_ID).interact("Take");
		sleep(1000,1200);
		Variables.nestsLooted++;
		
	}

}
