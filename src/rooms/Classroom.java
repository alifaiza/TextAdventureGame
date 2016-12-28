package rooms;

import java.util.Random;

import items.Item;

public class Classroom extends Room {
	
	private static final String FLAVOR =
			"You race up the stairs, down the hall, and to the 207 classroom. You enter, only a few minutes late this "
			+ "time! As you walk in, you glance at Larry, who shakes his head disappointedly at you. ";
	private static final String FLAVOR_END1 =
			"PM thankfully ignores your late arrival, although you are sure he will point it out later. However, you "
			+ "are finally here, and that is what matters.";
	private static final String FLAVOR_END2 =
			"Suddenly, everyone starts booing you. Shocked, you look at PM, but to your dismay he is the one leading "
			+ "the crowd of boos. This is what you get for being late, you suppose.";
	private static final String[] LOOKS = {
			"You look around the classroom. Everyone looks dead, as usual. You notice Mattori being very attentive, "
			+ "as he is a great student. You also see the pile of Google swag, still lying on the table after the talk "
			+ "several weeks ago.",
			"You briefly wonder what the class's daily topic is, but decide it's less important than looking at your "
			+ "phone."
	};
	private static final Item[] ITEMS = {
			new Item("Mattori",
					"You message Mattori a random sticker. He sends one back. A very fulfilling interaction.",
					"You sneak over to Mattori and prepare to attack. However, you can't bring yourself to do it."),
			new Item("swag",
					"You take some swag from the pile. Yay, more random stuff you won't end up using!",
					"You play with a toy you got from the pile. Much better than your phone.",
					"You sift through the pile of swag. Mostly notepads and pens.",
					"You nudge the pile of swag. A couple students nearby briefly look at you before falling back "
					+ "asleep")
	};
	
	public Classroom() {
		super("207 Classroom", FLAVOR + (new Random().nextInt(10) == 0 ? FLAVOR_END2 : FLAVOR_END1), LOOKS, ITEMS);
	}
	
	@Override
	protected String canLeaveString() {
		return "Your journey is now complete.";
	}

	@Override
	public boolean complete() {
		return true;
	}
}
