package items;

import java.util.List;

public class InventoryReqItem extends Item {
	
	private String reqName;
	private String interactAlt;

	public InventoryReqItem(String name, String interact, String attack, String reqName, String interactAlt) {
		super(name, interact, attack);
		this.reqName = reqName;
		this.interactAlt = interactAlt;
	}
	
	@Override
	public String getInteract(List<Item> inventory) {
		if(inInventory(inventory, reqName)) {
			return interactAlt;
		} else {
			return super.getInteract(inventory);
		}
	}
	
	private static boolean inInventory(List<Item> inventory, String reqName) {
		for(Item itm : inventory) {
			if(itm.getName().equals(reqName)) {
				return true;
			}
		}
		return false;
	}

}
