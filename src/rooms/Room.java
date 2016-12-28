package rooms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import items.Item;

public abstract class Room {
	protected String name;
	protected String flavor;
	
	private String[] looks;
	private int lookInd;
	
	protected boolean leaving;
	
	protected Map<String, Item> roomItems;
	
	protected static final String INVALID_ITEM = "That is not a valid item!";
	
	public Room(String name, String flavor, String[] looks, Item[] items) {
		this.name = name;
		this.flavor = flavor;
		this.looks = looks;
		lookInd = 0;
		leaving = false;
		roomItems = new HashMap<>();
		for(Item itm : items) {
			roomItems.put(itm.getName().toLowerCase(), itm);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	public String lookResponse() {
		if(lookInd >= looks.length) {
			lookInd = 0;
		}
		return looks[lookInd++];
	}
			
	public String pickUpResponse(Item itm, List<Item> inventory) {
		if(itm == null) {
			return INVALID_ITEM;
		} else if(inventory.contains(itm)) {
			return "You are already carrying " + itm.getName() + "!";
		} else {
			if(itm.getPickUpable()) {
				inventory.add(itm);
				return itm.getPickUp();
			} else {
				return "You cannot carry a " + itm.getName() + "!";
			}
		}
	}
	
	public String useResponse(Item itm, List<Item> inventory) {
		if(itm == null) {
			return INVALID_ITEM;
		} else if(inventory.contains(itm)) {
			return itm.getUse();
		} else {
			return "You are not carrying a " + itm.getName() + "!";
		}
	}
	
	public String interactResponse(Item itm, List<Item> inventory) {
		if(itm == null) {
			return INVALID_ITEM;
		} else {
			return itm.getInteract(inventory);
		}
	}
	
	public String attackResponse(Item itm) {
		if(itm == null) {
			return INVALID_ITEM;
		} else {
			return itm.getAttack();
		}
	}
	
	protected String canLeaveString() {
		return "You're ready to move on.";
	}
	
	protected String canNotLeaveString() {
		return "You feel like you're still forgetting something.";
	}
	
	public String leaveResponse() {
		if(complete()) {
			leaving = true;
			return canLeaveString();
		} else {
			return canNotLeaveString();
		}
	}
	
	public String processCommand(String cmd, List<Item> inventory) {
		leaving = false;
		if(cmd.equals("look")) {
			return lookResponse();
		} else if(cmd.startsWith("pick up")) {
			return pickUpResponse(roomItems.get(cmd.substring(8)), inventory);
		} else if(cmd.startsWith("use")) {
			return useResponse(roomItems.get(cmd.substring(4)), inventory);
		} else if(cmd.startsWith("interact")) {
			return interactResponse(roomItems.get(cmd.substring(9)), inventory);
		} else if(cmd.startsWith("attack")) {
			return attackResponse(roomItems.get(cmd.substring(7)));
		} else if(cmd.equals("leave")) {
			return leaveResponse();
		} else if(cmd.startsWith("help")) {
			return help();
		} else {
			return "You don't know how to " + cmd + "!";
		}
	}
	
	protected String help() {
		return "You can look, pick up [item], use [inventory item], interact [item], and attack [item]";
	}
	
	public boolean shouldLeave() {
		return complete() && leaving;
	}
	
	public abstract boolean complete();
}
