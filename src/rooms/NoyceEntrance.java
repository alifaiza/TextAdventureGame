package rooms;

import java.util.List;

import items.InventoryReqItem;
import items.Item;

public class NoyceEntrance extends Room {
	
	private boolean fixedBike;
	
	private static final String FLAVOR =
			"You arrive outside of Noyce, face numb from the cold. You're almost there. You are not the only one here "
			+ "rushing to class; there is a stream of students coming from JRC, likely from breakfast, heading across "
			+ "the street into Noyce. Before dashing up the steps, you notice something familiar on the ground: your "
			+ "bike's basket.";
	private static final String[] LOOKS = {
			"If the loggia looked cold, then 8th Ave looks like the tundra. With no buildings to block the wind for the"
			+ " most part, you are constantly blasted with air. All the students' attire reflects that; everyone is "
			+ "trying their best to cover every inch of skin with something warm.",
			"You note the snow looks beautiful. Perhaps you could admire it better if you weren't still freezing to "
			+ "death.",
			"All the trees have long since lost their leaves and are now dead, just like you are on the inside."
	};
	private static final Item[] ITEMS = {
			new InventoryReqItem("bike",
					"Your bike looks so sad and empty without its basket.",
					"You kick your bike. It's already broken, so it doesn't really matter.",
					"basket",
					"There's a time and place for everything, but not now."),
			new Item("basket",
					"You pick up the basket. It's very cold to the touch.",
					"You reattach the basket to the bike. That's better!",
					"You look over the basket. Luckily, it didn't go very far. You consider taking it to be fixed so "
					+ "that it actually stays in place but decide it's too much work.",
					"You shake the basket. Nothing happens."),
			new Item("student",
					"You consider being friendly and saying good morning to someone, but quickly dismiss it. Maybe you "
					+ "really are getting sick.",
					"You attempt to throw a punch at someone, but miss and just look like you slipped.")
	};
	
	public NoyceEntrance() {
		super("Noyce entrance", FLAVOR, LOOKS, ITEMS);
		fixedBike = false;
	}
	
	@Override
	public String useResponse(Item itm, List<Item> inventory) {
		if(itm.getName().equals("basket")) {
			fixedBike = true;
		}
		return super.useResponse(itm, inventory);
	}
	
	@Override
	protected String canNotLeaveString() {
		return "You need to fix your bike before you can head upstairs.";
	}
	
	@Override
	protected String canLeaveString() {
		return "Satisfied, you dash inside.";
	}

	@Override
	public boolean complete() {
		return fixedBike;
	}
}
