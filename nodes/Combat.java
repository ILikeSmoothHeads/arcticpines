package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.wrappers.node.SceneObject;

import arcticpines.main.Variables;

public class Combat extends Node{

	@Override
	public boolean activate() {
		return Players.getLocal().isInCombat();
		
	}

	@Override
	public void execute() {
		System.out.println("Running from combat");
		Variables.status = "Avoiding combat";
		SceneObject bridge = SceneEntities.getNearest(Variables.bridge_ID);
		Walking.walk(Variables.runAwayTile);
		sleep(15000,17000);
	
		
		
	}

}
