package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.SceneObject;

import arcticpines.main.Variables;


public class FireMove extends Node{

	@Override
	public boolean activate() {
		SceneObject fire = SceneEntities.getNearest(Variables.fire_ID);
		if(fire != null){
			if(Players.getLocal().getLocation().equals(fire.getLocation()))
				return true;
		}
		return false;
	}

	@Override
	public void execute() {
		Variables.status = "Moving from fire";
		System.out.println("Fire - moving");
		int x = 0;
		
		SceneObject fire = SceneEntities.getNearest(Variables.fire_ID);
		
		if(!Players.getLocal().isMoving()){
			x = Random.nextInt(0, Variables.fireTiles.length-1);
			if(Variables.fireTiles[x].equals(fire.getLocation())){
				System.out.println("baddd");
			}
				Walking.walk(Variables.fireTiles[x]);
				sleep(2000,2200);
			
		}
			
		
		
	}

}
