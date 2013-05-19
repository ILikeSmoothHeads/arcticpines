package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Summoning;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import arcticpines.main.Variables;

public class WalkToBank extends Node {

	@Override
	public boolean activate() {
		if(Variables.banking && !Bank.isOpen()) {
			if(Variables.beaver && !Inventory.contains(Variables.beaver_ID) && !Variables.urns){
				return true;
			}
			if(Variables.beaver && Inventory.contains(Variables.beaver_ID) && !Inventory.contains(Variables.summPots) && !Variables.urns){
				return true;
			}
			if(Variables.urns && !Inventory.contains(Variables.urnsFilled) && !Variables.beaver && !Inventory.contains(Variables.Urn_ID)){
				return true;
			}
			if(Variables.urns && Variables.beaver && !Inventory.contains(Variables.beaver_ID) && !Inventory.contains(Variables.urnsFilled) && !Inventory.contains(Variables.Urn_ID)){			
				return true;
			}
			if(Variables.urns && Variables.beaver && Inventory.contains(Variables.beaver_ID) && !Inventory.contains(Variables.summPots) && Summoning.getPoints()==0 && !Inventory.contains(Variables.urnsFilled) && !Inventory.contains(Variables.Urn_ID)){			
				return true;
			}
		}	
			
		return false;
	}

	@Override
	public void execute() {
		System.out.println("Walking to the bank");
		Variables.status = "Walking to bank";
		SceneObject bridge = SceneEntities.getNearest(Variables.bridge_ID);
		SceneObject door = SceneEntities.getNearest(Variables.door_ID);
		
		
		if(Variables.villageArea.contains(Players.getLocal().getLocation())){
			if(!Bank.isOpen() && !Variables.doorArea.contains(Players.getLocal().getLocation())){
				System.out.println("Bank");
				Bank.open();
				sleep(2000,2200);
			}
		}
		
		if(!Variables.bridgeSide2.contains(Players.getLocal().getLocation()) && !Variables.villageArea.contains(Players.getLocal().getLocation())){
			Walking.walk(Variables.bridgeTile1);
			sleep(2500,2700);
			System.out.println("Bridge");
		
			if(bridge != null && !Players.getLocal().isMoving()){
				Camera.setPitch(100);
				System.out.println("Bridge");
				bridge.interact("Walk-across");
				sleep(10000,12000);
				
			}
		}
		
		
		if(Variables.bridgeSide2.contains(Players.getLocal().getLocation())){
			if(!Variables.doorArea.contains(Players.getLocal().getLocation()) && !Variables.villageArea.contains(Players.getLocal().getLocation())){
				System.out.println("bankpath");
				Walking.newTilePath(Variables.bank_path).traverse();
				sleep(2000,2200);
			}
			if(door != null && door.isOnScreen()){
				System.out.println("door");
				door.interact("Open");
				sleep(3000,3200);
			}
			if(Variables.doorArea.contains(Players.getLocal().getLocation())){
				System.out.println("inside door");
				Walking.walk(Variables.insideDoor);
				sleep(2500, 3000);
			}
		}
		
			
			
		
		
	}

}
