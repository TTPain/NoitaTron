package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlFont;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.menu.HvlMenu;

import robotron2.menu.MenuManager;

public class HUD {

	public static void draw(float delta) {
		if(HvlMenu.top() == MenuManager.game) {
			hvlFont(0).draw("Lives: "+ Score.lives, 1280-160, 10, Color.white, 0.2f);
			hvlFont(0).draw("Score: ", 12, 10, Color.white, 0.2f);
			hvlFont(0).draw(""+ Score.score, 40, 45, Color.white, 0.17f);
		}
	}
}
