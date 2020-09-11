package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.menu.HvlMenu;

import robotron2.menu.MenuManager;

public class Border {

	//Needs to be addressed to compliment new moving camera

	public static void draw(float delta) {
		if(HvlMenu.top()==MenuManager.game) {
			hvlDraw(hvlQuad(0, 0, 160, 1080), Color.gray);
			hvlDraw(hvlQuad(1760, 0, 160, 1080), Color.gray);
			hvlDraw(hvlQuad(0, -160, 1920, 160), Color.gray);
			hvlDraw(hvlQuad(0, 1080, 1920, 160), Color.gray);
		}
	}

}
