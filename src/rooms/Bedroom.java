package rooms;

import java.util.List;

import items.Item;
import items.DestructableItem;

public class Bedroom extends Room {

	private boolean hasPcard;
	private boolean isDressed;
	
	private static final String FLAVOR =
			"Your unfortunately mathematics-themed dream is interrupted by the piercing sound of your phone alarm. You "
			+ "fumble around, trying to remember where you put it, so that you can put an end to the racket. You cough,"
			+ " still sick and exhausted as usual, and prepare for the day.";
	private static final String[] LOOKS = {
			"You glance around the room, rubbing the sleep from your eyes. Across your bed is your desk, cluttered with"
			+ " assorted cooking and homework supplies along with everything else you dumped out of your bag. Atop your"
			+ " dresser lies a few more cups and random belongings.",
			"You remember planning to clean the room last night. You resolve to clean it this weekend, inadvertantly "
			+ "putting it off by yet another week.",
			"Seeing such a cozy little room fills you with determination."
	};
	private static final Item[] ITEMS = {
			new Item("PCard",
					"You stuff your PCard into your pocket",
					"You try to swipe your PCard on thin air, but it does nothing!",
					"You always hated your PCard picture...",
					"You punch the PCard. It does not care."),
			new Item("clothes",
					"You hastily change into your clothes for the day",
					"You note your outfit is all black, as usual.",
					"You pat your clothes. You remember you need to do laundry.",
					"You punch your clothes. That felt good!"),
			new DestructableItem("math homework",
					"You look at your abstract algebra homework and question why you chose to major in math",
					"You rip up the paper and immediately regret your decision.",
					"You poke the remains of the homework."),
			new Item("desk",
					"There are a number of papers and writing utensils all over the desk. You spot your barely "
					+ "completed math homework and PCard among the mess.",
					"You give the desk a shove. It does not seem to have moved an inch."),
			new Item("dresser",
					"You take a brief look through the dresser. You cannot find a single non-dark item.",
					"You give the dresser a nudge. All the items on top of it jiggle slightly.")
	};
	
	public Bedroom() {
		super("Bedroom", FLAVOR, LOOKS, ITEMS);
		hasPcard = false;
		isDressed = false;
	}
	
	@Override
	public String pickUpResponse(Item itm, List<Item> inventory) {
		if(itm == null) {
			return INVALID_ITEM;
		} else if(itm.getName().equals("PCard")) {
			hasPcard = true;
		} else if(itm.getName().equals("clothes")) {
			isDressed = true;
		}
		
		return super.pickUpResponse(itm, inventory);
	}

	@Override
	public boolean complete() {
		return hasPcard && isDressed;
	}

}
