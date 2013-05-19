package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

import arcticpines.main.Variables;

public class WalkFromBank extends Node{

	@Override
	public boolean activate() {
		if(Variables.villageArea.contains(Players.getLocal().getLocation())){
			if(Variables.banking){
				return true;
			}
		}
		if(Variables.doorArea.contains(Players.getLocal().getLocation()) || Variables.bridgeSide2.contains(Players.getLocal().getLocation())){
			return true;
		}
		return false;
	}

	@Override
	public void execute() {
		System.out.println("Walk from bank");
		Variables.status = "Walking to area";
		SceneObject bridge = SceneEntities.getNearest(Variables.bridge_ID);
		SceneObject door = SceneEntities.getNearest(Variables.door_ID);
		if(Variables.villageArea.contains(Players.getLocal().getLocation())){
			if(Variables.banking){
				if(Variables.beaver){
					if(Inventory.getCount(Variables.beaver_ID)>1){
						Walking.walk(Variables.insideDoor);
						sleep(1000, 1200);
					}
				}else if(Variables.urns){
					if(Inventory.getCount(Variables.Urn_ID)>1){
						Walking.walk(Variables.insideDoor);
						sleep(1000, 1200);
					}
					
				}
			}
		}
		
		if(door != null){
			System.out.println("door");
			door.interact("Open");
			sleep(2000,2200);
		}
		
		if(Variables.bridgeSide2.contains(Players.getLocal().getLocation()) || Variables.doorArea.contains(Players.getLocal().getLocation()) || Variables.villageArea.contains(Players.getLocal().getLocation())){
				System.out.println("bankpath");
				Walking.newTilePath(Variables.backBank_path).traverse();
				sleep(4000,4500);
			
		}
		
		if(bridge != null && bridge.isOnScreen()){
			System.out.println("Bridge");
			bridge.interact("Walk-across");
			sleep(8000,9000);
			
		}
		
		
	}

}
