package items;

import java.util.List;

public class Item {
	protected String name; 
	protected String pickUp;
	protected String use;
	protected String interact;
	protected String attack;
	protected boolean pickUpable;
	
	private Item(String name, String pickUp, String use, String interact, String attack, boolean pickUpable) {
		this.name = name;
		this.pickUp = pickUp;
		this.use = use;
		this.interact = interact;
		this.attack = attack;
		this.pickUpable = pickUpable;
	}
	
	/**
	 * An Item that can be picked up
	 * @param name
	 * @param pickUp
	 * @param use
	 * @param interact
	 * @param attack
	 */
	public Item(String name, String pickUp, String use, String interact, String attack) {
		this(name, pickUp, use, interact, attack, true);
	}
	
	/**
	 * An Item that cannot be picked up
	 * @param name
	 * @param interact
	 * @param attack
	 */
	public Item(String name, String interact, String attack) {
		this(name, null, null, interact, attack, false);
	}

	public String getName() {
		return name;
	}
	
	public String getPickUp() {
		return pickUp;
	}

	public String getUse() {
		return use;
	}

	public String getInteract(List<Item> inventory) {
		return interact;
	}

	public String getAttack() {
		return attack;
	}
	
	public boolean getPickUpable() {
		return pickUpable;
	}
	
}
