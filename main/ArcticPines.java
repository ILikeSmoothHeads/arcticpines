package arcticpines.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import org.powerbot.core.Bot;
import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.randoms.SpinTickets;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.core.script.methods.Game;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Environment;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.methods.widget.WidgetCache;
import org.powerbot.game.api.util.SkillData;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.client.Client;

import arcticpines.nodes.Banking;
import arcticpines.nodes.Beaver;
import arcticpines.nodes.Chop;
import arcticpines.nodes.Combat;
import arcticpines.nodes.DropCrap;
import arcticpines.nodes.DropFailSafe;
import arcticpines.nodes.FireCheck;
import arcticpines.nodes.FireMove;
import arcticpines.nodes.LightLogs;
import arcticpines.nodes.LootNests;
import arcticpines.nodes.ObeliskToArea;
import arcticpines.nodes.RenewPoints;
import arcticpines.nodes.SendUrns;
import arcticpines.nodes.WalkFromBank;
import arcticpines.nodes.WalkToArea;
import arcticpines.nodes.WalkToBank;


@Manifest (authors ={"ILikeSmoothHeads"},
name = "Smooths Arctic Pines",
description = "Chops and instantaneously drops Artic Pine Logs in Neitznot for amazing Woodcutting xp!",
version = 1.6,
topic = 923963)

public class ArcticPines extends ActiveScript implements PaintListener, MessageListener, MouseListener {

	private Tree jobContainer = null;
	
	
	
	
	private static class ClaimSpinTickets extends SpinTickets {
		@Override
		public void execute() {
			if (Bank.isOpen()) {
				if(Bank.close()) {
					sleep(1000);
				}
			} else if (((Settings.get(1448) & 0xFF00) >>> 8) < 10) {
				final Item item = Inventory.getItem(SpinTickets.ITEM_ID_SPIN_TICKET);
				if (item != null && item.getWidgetChild().interact("Claim spin")) {
					sleep(1000);
				}
			} else {
				super.execute();
			}
		}
	}
	
	private static final ClaimSpinTickets ticketRandom = new ClaimSpinTickets();
	
	
	public void onStart() {
		
		
		
		System.out.println("Welcome!");
		
		Gui g = new Gui();
		g.setVisible(true);
		g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		g.setTitle("Settings");
		
		Variables.status = "loading";
		Camera.setAngle(0);
		Camera.setPitch(100);
		
		
		if(Variables.actionBarButton.visible())
			Variables.actionBarButton.click(true);
		
		Variables.summPoints = Skills.getLevel(Skills.SUMMONING);
		Variables.startingLogs = Inventory.getCount(Variables.articLogs_ID);
		Variables.wcStartingXp = Skills.getExperience(Skills.WOODCUTTING);
		Variables.startTime = System.currentTimeMillis();
		Variables.startingUrns = Inventory.getCount(Variables.fullUrn_ID);
		
		getContainer().submit(new Task() {
			@Override
			public void execute() {
				sleep(5000);
				Environment.enableRandom(SpinTickets.class, false);
			}
		});
			
			
			
		
	}
	
	
	
	
	public void onStop() {
		
		stop();
		
	}
	
	@Override
	public int loop() {
		
		
		 
		if (Game.getClientState() != Game.INDEX_MAP_LOADED) {
			return 1000;
		}
		if (client != Bot.client()) {
			WidgetCache.purge();
			Bot.context().getEventManager().addListener(this);
			client = Bot.client();
		}

		
		if (ticketRandom.activate()) {
			ticketRandom.execute();
			return 100;
		}
		if(!Variables.guiOpen){
			
			
		
			if (jobContainer != null) {
	            final Node job = jobContainer.state();
	
	            if (job != null) {
	                jobContainer.set(job);
	                getContainer().submit(job);
	                job.join();
	            }
			}else {
				
				Variables.jobs.add(new Combat());
				Variables.jobs.add(new DropFailSafe());
				Variables.jobs.add(new DropCrap());
				Variables.jobs.add(new FireMove());
				//Variables.jobs.add(new FireCheck());
				if(Variables.urns)
	            	Variables.jobs.add(new SendUrns());
				Variables.jobs.add(new LightLogs());
				if(Variables.banking){
					Variables.jobs.add(new WalkToBank());
					Variables.jobs.add(new Banking());
				}
				Variables.jobs.add(new WalkFromBank());
				
				 if(Variables.beaver){
		            	Variables.jobs.add(new Beaver());
		            	Variables.jobs.add(new RenewPoints());
		            	Variables.jobs.add(new ObeliskToArea());
		            }
				 if(Variables.nests)
		            	Variables.jobs.add(new LootNests());
		            	
				
	            Variables.jobs.add(new Chop());
	            Variables.jobs.add(new WalkToArea());
	            
	            
	            	
	            
	           
	            	

	            
	
	            jobContainer = new Tree(
	                    Variables.jobs.toArray(new Node[Variables.jobs
	                            .size()]));
	        }
		}
		
	    
	    
		return 50;
	}

	
	public void onRepaint(Graphics g) {
	
	    Variables.currentTime = System.currentTimeMillis() - Variables.startTime;
	    
	    Variables.wcGainedXp = Skills.getExperience(Skills.WOODCUTTING) - Variables.wcStartingXp;
	    Variables.xpHour = (int) (Variables.wcGainedXp * 3600000D / Variables.currentTime);
	    Variables.logsHour = (int) (Variables.logsChopped * 3600000D / Variables.currentTime);
	    
	    if(Variables.showPaint){
	    	g.drawImage(Variables.proggyImg, 0, 358, null);
	    
	    	if(!Variables.guiOpen){
			    g.setFont(Variables.font1);
			    g.setColor(Color.BLACK);
			    g.drawString("" + format(Variables.currentTime), 140, 411);
			    g.drawString("" + Variables.logsChopped + "  (" + Variables.logsHour + "/hour)", 173, 445);
			    g.drawString("" + Variables.wcGainedXp + "  (" + Variables.xpHour + "/hour)", 150, 480);
			    g.drawString("" + Variables.urnsFilled, 395, 445);
			    g.drawString("" + Variables.nestsLooted, 405, 411);
			    //g.drawString("" + Variables.profit+ "gp", 165, 519);
			    g.drawString("" + Variables.status, 80, 514);
		    }
	    	//g.drawRect(491, 391, 20, 20);
	    }
	    if(!Variables.showPaint)
	    	g.drawImage(Variables.xImg, 0, 358, null);
	    
	    g.drawImage(Variables.mouseImg, Mouse.getX()-26, Mouse.getY()-1, null);
	    
	}
	
	public String format(final long ms) {
        int seconds = (int) ms / 1000;
        int minutes = seconds / 60;
        seconds -= minutes * 60;
        int hours = minutes / 60;
        minutes -= hours * 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
	


	@Override
	public void messageReceived(MessageEvent message) {
		if(message.getMessage().contains("get some arctic pine"))
			Variables.logsChopped++;
		if(message.getMessage().contains("activate the rune"))
			Variables.urnsFilled++;
		
	}
	
	public void dropLogs(){
		for(int i = 0; i< Inventory.getCount(Variables.articLogs_ID); i++){
			Keyboard.sendKey('1');
		}
	}
	public Rectangle toggle() {
		Rectangle r = new Rectangle(491, 391, 20, 20);
		
		return r;
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		Rectangle r = new Rectangle(465, 390, 50, 20);
		Rectangle m = new Rectangle(Mouse.getX(), Mouse.getY(), 2, 2);
		if(r.contains(arg0.getPoint())){
			if(Variables.showPaint){
				Variables.showPaint = false;
			}else if (!Variables.showPaint)
				Variables.showPaint = true;
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}