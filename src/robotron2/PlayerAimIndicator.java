package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlRotate;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;


import robotron2.util.Utility;

public class PlayerAimIndicator {

	final static int INDICATOR_WIDTH = 3;
	final static int INDICATOR_HEIGHT = 14;
	final static int DISTANCE_FROM_PLAYER = 28;
	
	public static void draw(Player player) {
		float degRot = Utility.fullRadians(Display.getWidth()/2f, Display.getHeight()/2f, Utility.getCursorX(), Utility.getCursorY());
		hvlRotate(player.getxPos(), player.getyPos(), degRot * (180f /(float)Math.PI) + 90, () -> {
			hvlDraw(hvlQuadc(player.getxPos(), player.getyPos()+DISTANCE_FROM_PLAYER, INDICATOR_WIDTH, INDICATOR_HEIGHT), Color.white);
			//System.out.println("AIM"+player.getyPos()+DISTANCE_FROM_PLAYER);
		});
	}
	
}
