package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.wrappers.node.SceneObject;

import arcticpines.main.Variables;

public class WalkToBank extends Node {

	@Override
	public boolean activate() {
		if(Variables.banking) {
			if(Variables.beaver && !Inventory.contains(Variables.beaver_ID) && !Variables.urns)
				return true;
			if(Variables.urns && !Inventory.contains(Variables.urnsFilled) && !Variables.beaver && !Inventory.contains(Variables.Urn_ID))
				return true;
			if(Variables.urns && Variables.beaver && !Inventory.contains(Variables.beaver_ID) && !Inventory.contains(Variables.urnsFilled) && !Inventory.contains(Variables.Urn_ID))
				return true;
		}	
		
		return true;
	}

	@Override
	public void execute() {
		Variables.status = "Walking to bank";
		SceneObject bridge = SceneEntities.getNearest(Variables.bridge_ID);
		SceneObject obelisk = SceneEntities.getNearest(Variables.obelisk_ID);
		SceneObject door = SceneEntities.getNearest(Variables.door_ID);
		if(!Variables.bridgeSide2.contains(Players.getLocal().getLocation())){
			Walking.walk(Variables.bridgeTile1);
			sleep(1000,1200);
		
			if(bridge != null){
				bridge.interact("Walk-across");
				sleep(10000,12000);
			}
		}
		if(Variables.bridgeSide2.contains(Players.getLocal().getLocation()) && !obelisk.isOnScreen()){
			Walking.walk(Variables.obeliskTile);
			sleep(1000,1200);
			Walking.walk(Variables.doorTile1);
			sleep(1000,1200);
			if(door.isOnScreen() && door.validate()){
				door.interact("Open");
				sleep(2000,2200);
			}
			if(!Bank.isOpen()){
				Bank.open();
				System.out.println("Bank");
				sleep(2000,2200);
			}
			
			
		}
		
	}

}
