package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlFont;

import org.newdawn.slick.Color;

public class RoomClearAnimation {

	private static float animationCounter = 0f;
	private static float animationLength = 1.5f;
	private static float animationTimer;
	public static boolean stop = false;

	public static void play(float delta) {
		
		
		
		if (stop == false) {
			animationCounter += delta;
		}
		
				if (animationCounter < animationLength && stop == false) {

			hvlFont(0).draw("Room Cleared!", (1920 / 2) - 180, 100, Color.white, 0.3f);

		} else {
			animationCounter = 0;
			stop = true;
		}

	}

}