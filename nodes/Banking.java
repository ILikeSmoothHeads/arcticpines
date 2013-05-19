package arcticpines.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import arcticpines.main.Variables;

public class Banking extends Node{
	
	private int beavers;
	private int pots;
	private int urns;
	private int beaversW;
	private int potsW;
	private int urnsW;

	@Override
	public boolean activate() {
		return Variables.banking && Bank.isOpen() && Variables.villageArea.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		Variables.status = "Banking";
		System.out.println("Banking");
		if(Inventory.getItem(Variables.Nest_ID)!=null){
			for(int i=0; i< Variables.Nest_ID.length; i++){
				if(Inventory.getItem(Variables.Nest_ID[i])!=null){
					Bank.deposit(Variables.Nest_ID[i], Inventory.getCount(Variables.Nest_ID[i]));
					sleep(500,550);
				}
			}
			
		}
		pots = Inventory.getCount(Variables.summPots);
		urns = Inventory.getCount(Variables.Urn_ID);
		beavers = Inventory.getCount(Variables.beaver_ID);
		
		if(Variables.beaver&&Variables.urns){
			beaversW = 5 - beavers;
				potsW = 1 - pots;
			if(Inventory.getItem(Variables.hatchets)!=null){
				urnsW = 21 - urns;
			}else urnsW = 22 - urns;
		}
		if(Variables.beaver&&!Variables.urns){
			if(Inventory.getItem(Variables.hatchets)!=null){
				beaversW = 23 - beavers;
			}else beaversW = 24 - beavers;
			potsW = 3 - pots;
			urnsW = 0;
		}
		if(!Variables.beaver&&Variables.urns){
			beaversW = 0;
			potsW = 0;
			if(Inventory.getItem(Variables.hatchets)!=null){
				urnsW = 26 - urns;
			}else urnsW = 27 - Inventory.getCount();
			
		}
		
		System.out.println("Beavers: " + beaversW);
		System.out.println("Pots: " + potsW);
		System.out.println("Urns: " + urnsW);
		if(Variables.beaver){
			if(Bank.getItem(Variables.beaver_ID)!=null){
				Bank.withdraw(Variables.beaver_ID, beaversW);
				sleep(1000,1200);
			}
			if(Bank.getItem(Variables.summPots)!=null){
				for( int i=0; Inventory.getCount(Variables.summPots) < potsW; i++){
					if(Bank.getItem(Variables.summPots[i])!=null){
						if(Inventory.getCount(Variables.summPots)!=potsW){
							Bank.withdraw(Variables.summPots[i], potsW);
							sleep(1000,1200);
						}
					}
				}
			}
			if(Inventory.getCount(Variables.EmptySummPots)>0){
				if(Bank.getItem(Variables.summPots)!=null){
					for( int i=0; Inventory.getCount(Variables.summPots) < 2; i++){
						if(Bank.getItem(Variables.summPots[i])!=null){
							if(Inventory.getCount(Variables.summPots)!=2){
								Bank.withdraw(Variables.summPots[i], 1);
								sleep(1000,1200);
							}
						}
					}
				}
			}
		}
		if(Variables.urns){
			if(Bank.getItem(Variables.Urn_ID)!=null){
				for( int i=0; Inventory.getCount(Variables.Urn_ID) < urnsW+1-Inventory.getCount(Variables.summPots); i++){
					if(Bank.getItem(Variables.Urn_ID[i])!=null){
						if(Inventory.getCount(Variables.Urn_ID)!=urnsW+1-Inventory.getCount(Variables.summPots)){
							Bank.withdraw(Variables.Urn_ID[i], urnsW+1-Inventory.getCount(Variables.summPots));
							sleep(1000,1200);
						}
					}
				}
			}
		}
			
		if(Inventory.isFull()){
			if(Variables.urns){
				if(Inventory.getItem(20316)!=null)
					Bank.deposit(20316, 1);
				if(Inventory.getItem(20310)!=null)
					Bank.deposit(20310, 1);
			}else if(Variables.beaver){
				if(Inventory.getItem(Variables.beaver_ID)!=null)
					Bank.deposit(Variables.beaver_ID, 1);
			}
		}
		
		Bank.close();
		beaversW = 0;
		potsW = 0;
		urnsW = 0;
	}
	
	

}
