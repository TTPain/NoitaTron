package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlFont;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.menu.HvlMenu;

import robotron2.menu.MenuManager;
import robotron2.terrain.Block;

public class HUD {
	public static int fpsTimer=20;
	private static int fps;

	public static void draw(float delta) {
		if(HvlMenu.top() == MenuManager.game) {
			hvlFont(0).draw("Lives: "+ Score.lives, Display.getWidth()-Block.BLOCK_SIZE*3, 10, Color.white, 0.2f);
			hvlFont(0).draw("Score: ", 12, 10, Color.white, 0.2f);
			hvlFont(0).draw(""+ Score.score, 40, 45, Color.white, 0.17f);
			
			if(Game.devMode == true) {
				HUD.fpsTimer --;
				hvlFont(0).draw("FPS:"+ fps, Display.getWidth()/2, 10, Color.white, 0.17f);
				if(fpsTimer == 0) {
					fps = (int) (Math.pow(delta, -1));
					fpsTimer = 20;
				}
			}
		}
	}
}
