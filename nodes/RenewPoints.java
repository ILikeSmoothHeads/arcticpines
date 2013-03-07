package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Summoning;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import arcticpines.main.Variables;


public class RenewPoints extends Node{

	@Override
	public boolean activate() {
		if(Inventory.contains(Variables.summPots) || Variables.obelisk)
			return  Summoning.getTimeLeft() < 31 && Summoning.getPoints() < 4;
		return false;
	}

	@Override
	public void execute() {
		if(Inventory.contains(Variables.summPots)) {
			Variables.status = "Drinking potion";
			Inventory.getItem(Variables.summPots).getWidgetChild().interact("Drink");
			sleep(1000,1200);
			if(Inventory.contains(Variables.vial_ID))
				Inventory.getItem(Variables.vial_ID).getWidgetChild().interact("Drop");
		} else if(Variables.obelisk){
			Variables.status = "Walking to obelisk";
			SceneObject bridge = SceneEntities.getNearest(Variables.bridge_ID);
			SceneObject obelisk = SceneEntities.getNearest(Variables.obelisk_ID);
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
			}
			Variables.status = "Renewing points";
			if(obelisk.isOnScreen()){
				obelisk.interact("Renew-points");
				sleep(1000,1200);
			} else Camera.turnTo(obelisk);
			
		}
	}

}
