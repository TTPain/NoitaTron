package robotron2.menu;

import static com.osreboot.ridhvl2.HvlStatics.hvlColor;
import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlEnvironment;
import static com.osreboot.ridhvl2.HvlStatics.hvlFont;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.menu.HvlDefault;
import com.osreboot.ridhvl2.menu.HvlMenu;
import com.osreboot.ridhvl2.menu.component.HvlArranger;
import com.osreboot.ridhvl2.menu.component.HvlButtonLabeled;
import com.osreboot.ridhvl2.menu.component.HvlSpacer;
import com.osreboot.ridhvl2.menu.component.HvlButton.HvlButtonState;

import robotron2.EnemySpawner;
import robotron2.Main;
import robotron2.Player;

public class MenuManager {

	public static HvlArranger intro, main, game, pause, settings, credits, gameover;

	public static void initialize(Player player) {
		// Default Creation MUST go before menu initialization.
		HvlButtonLabeled defaultButton = new HvlButtonLabeled(hvlFont(0), "", Color.white, 0.2f,
				(delta, environment, button, state) -> {
					if (state == HvlButtonState.HOVER) {
						hvlDraw(hvlQuad(environment.getX(), environment.getY(), environment.getWidth(),
								environment.getHeight()), Color.darkGray);
					} else {
						hvlDraw(hvlQuad(environment.getX(), environment.getY(), environment.getWidth(),
								environment.getHeight()), Color.gray);
					}
				});
		//Text Alignment
		defaultButton.align(0.5f, 0.5f);
		HvlDefault.put(defaultButton);

		// Menu Initialization
		MainMenu.initialize();
		game = new HvlArranger(false, 0f, 0f);
		PauseMenu.initialize(player);
		SettingsMenu.initialize();
		
		// Initialize game to chosen menu. Can change for debug purposes.
		HvlMenu.set(main);

	}

	public static void update(float delta) {
		
		PauseFunction.update(delta);
		SettingsMenu.update(delta);

		if (HvlMenu.top() == main) {
			HvlMenu.operate(delta, hvlEnvironment(Display.getWidth() / 20f, Display.getHeight() / 8f, Display.getWidth() / 4f, Display.getHeight() / 1.55f));
		}
		else if (HvlMenu.top() == pause) {
			HvlMenu.operate(delta, hvlEnvironment(Display.getWidth() / 3f, Display.getHeight() / 4f, Display.getWidth() / 3f, Display.getHeight() / 2f));
		}
		else if (HvlMenu.top() == settings) {
			HvlMenu.operate(delta, hvlEnvironment(Display.getWidth() / 20f, Display.getHeight() / 8f, Display.getWidth() / 4f, Display.getHeight() / 4f));
		}

		
		


	}

}
