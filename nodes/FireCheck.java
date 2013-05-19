package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import arcticpines.main.Variables;


public class FireCheck extends Node{

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
		SceneObject fire = SceneEntities.getNearest(Variables.fire_ID);
		if(!Players.getLocal().isMoving()){
			if(Players.getLocal().getLocation().equals(Variables.choppingTiles[0]) || Players.getLocal().getLocation().equals(Variables.choppingTiles[1]) || Players.getLocal().getLocation().equals(Variables.choppingTiles[2])){
				Walking.walk(Variables.fireTiles[0]);
				sleep(2000,2200);
			} else if(Players.getLocal().getLocation().equals(Variables.choppingTiles[3]) || Players.getLocal().getLocation().equals(Variables.choppingTiles[4]) || 
					Players.getLocal().getLocation().equals(Variables.choppingTiles[5]) || Players.getLocal().getLocation().equals(Variables.choppingTiles[6])){
				Walking.walk(Variables.fireTiles[1]);
				sleep(2000,2200);
			} else if(Players.getLocal().getLocation().equals(Variables.choppingTiles[7]) || Players.getLocal().getLocation().equals(Variables.choppingTiles[8]) || 
					Players.getLocal().getLocation().equals(Variables.choppingTiles[9]) || Players.getLocal().getLocation().equals(Variables.choppingTiles[10])){
				Walking.walk(Variables.fireTiles[2]);
				sleep(2000,2200);
			}else if(Players.getLocal().getLocation().equals(Variables.choppingTiles[11])){
					Walking.walk(Variables.fireTiles[4]);
					sleep(2000,2200);
			} else {
				Walking.walk(Variables.fireTiles[3]); 
				sleep(2000,2200);
			}
		}
			
		
		
	}

}
