package rooms;

import java.util.List;

import items.DestructableItem;
import items.Item;

public class EastCampus extends Room {
	
	private boolean hasWalked;
	
	private boolean isLying;
	
	private static final String FLAVOR =
			"As you step outside, you are met by an immense gust of arctic Iowa air, almost knocking you on your back. "
			+ "The sky is a dark gray and the ground is a mix of white snow and brown mud where people have been "
			+ "walking. Glacing at your phone, you realize you're going to be a bit late already!";
	private static final String[] LOOKS = {
			"You peek around the corner, trying your best to shield yourself from the wintry gusts. You spot the bike "
			+ "racks, still filled with bikes. Across, the loggia glass seems fogged, and any posters have since blown "
			+ "away. Before you lies icy, muddy snow. You think it's probably best to be careful.",
			"There appears to be an inch or so of snow on the ground. Unfortunately, since people have been walking on "
			+ "the grass shortcut the snow has been trampled and melted into a gross mush."
	};
	private static final Item[] ITEMS = {
			new Item("bike",
					"You admire the handiwork of the bikes. You wish your bike wasn't broken so you could get to class "
					+ "on time.",
					"You attempt to steal a bike to no avail. The owner smartly used a bike lock."),
			new Item("snow",
					"You stuff some snow in your pockets.",
					"The snow has melted, leaving your hands wet. You're not sure what you expected to happen.",
					"You poke some snow. It's cold.",
					"You give the snow a solid kick. You feel like a child."),
			new DestructableItem("poster",
					"You put the 2017 Class Ambassadors poster in your pocket, where no one can see it.",
					"You look at the 2017 Class Ambassadors poster. You remember the upcoming Winter Cafe study break "
					+ "on December 9 at 7PM in JRC 101. What a great event that everyone definitely should go to.",
					"You see a 2017 Class Ambassadors poster. Featured are you and Victor. You wish they didn't have to"
					+ " take a picture.",
					"You rip up the poster. The pieces quickly fly away in the wind.",
					"There are no traces that you are a 2017 Class Ambassador, unless you look at the number of other "
					+ "posters scattered throughout campus")
	};

	public EastCampus() {
		super("East Campus loggia", FLAVOR, LOOKS, ITEMS);
		hasWalked = false;
		isLying = false;
	}
	
	private String walkResponse() {
		if(hasWalked) {
			return "You have already made it through the loggia.";
		} else {
			hasWalked = true;
			return "You successfully maneuver across the icy ground.";
		}
	}
	
	private String runResponse() {
		if(hasWalked) {
			return "You have already made it through the loggia.";
		} else {
			isLying = true;
			return "You begin to run in an effort to make it to class on time for once. Unfortunately, you are not able"
					+ " to find good footing and trip, falling directly on your face in the snow. You lie there for a "
					+ "moment, contemplating life and wondering what you did to deserve this.";
		}
	}
	
	private String lieResponse() {
		return "You continue lying there, slowly freezing over. You are concerned someone might see you, but that "
				+ "is overridden by sleepiness.";
	}
	
	private String getUpResponse() {
		isLying = false;
		return "You finally muster up the energy to stand back up. You brush the snow off your jacket, thankful that "
				+ "you did not land in any mud.";
	}
	
	@Override
	public String processCommand(String cmd, List<Item> inventory) {
		if(isLying) {
			if(cmd.equals("get up")) {
				return getUpResponse();
			} else if(cmd.equals("lie") || cmd.equals("wait")) {
				return lieResponse();
			} else {
				return "You are currently lying on the ground and cannot do anything. You might want to get up first.";
			}
		} else {
			if(cmd.equals("walk")) {
				return walkResponse();
			} else if(cmd.equals("run")) {
				return runResponse();
			} else {
				return super.processCommand(cmd, inventory);
			}
		}
	}
	
	@Override
	protected String canNotLeaveString() {
		return "You first need to walk or run to the end of the loggia.";
	}

	@Override
	public boolean complete() {
		return hasWalked;
	}

}
