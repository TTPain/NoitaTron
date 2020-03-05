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

public class MenuManager {

	public static HvlArranger intro, main, game, pause, settings, credits, gameover;

	public static void initialize() {
		// Arranger(HorizontalArg, xAlign, yAlign)
		// DEFAULT CREATION
		HvlButtonLabeled defaultButton = new HvlButtonLabeled(hvlFont(0), "", Color.white, 0.2f,
				(delta, environment, button, state) -> {
					if (state == HvlButtonState.HOVER) {
						hvlDraw(hvlQuad(environment.getX(), environment.getY(), environment.getWidth(),
								environment.getHeight()), hvlColor(0.2f, 0.2f, 0.2f, 0.7f));
					} else {
						hvlDraw(hvlQuad(environment.getX(), environment.getY(), environment.getWidth(),
								environment.getHeight()), Color.gray);
					}
				});
		//TEXT ALIGNMENT
		defaultButton.align(0.5f, 0.5f);
		HvlDefault.put(defaultButton);

		// MAIN MENU
		main = new HvlArranger(false, 0.3f, 0.5f);
		main.add(HvlButtonLabeled.fromDefault().text("Play!").align(0.3f, 0.5f).clicked((button) -> {
			HvlMenu.set(game);
			EnemySpawner.reset();
		}));
		main.add(new HvlSpacer(1));
		main.add(HvlButtonLabeled.fromDefault().text("Quit :(").align(0.3f, 0.5f).clicked((button) -> {
			Main.newest().setExiting();
		}));

		// GAME SCREEN
		game = new HvlArranger(false, 0f, 0f);
		
		// PAUSE SCREEN
		pause = new HvlArranger(false, 0.5f, 0.5f);
		pause.add(HvlButtonLabeled.fromDefault().text("Resume").clicked((button) -> {
			HvlMenu.set(game);
		}));
		pause.add(new HvlSpacer(10));
		pause.add(HvlButtonLabeled.fromDefault().text("Quit").clicked((button) -> {
			Main.newest().setExiting();
		}));

		// Initialize game to chosen menu. Can change for debug purposes.
		HvlMenu.set(main);

	}

	public static void update(float delta) {
		
		PauseFunction.update(delta);

		if (HvlMenu.top() == main) {
			//xPos, yPos, xSize, ySize
			HvlMenu.operate(delta, hvlEnvironment(Display.getWidth() / 16f, Display.getHeight() / 4f, Display.getWidth() / 2f, Display.getHeight() / 2f));
		}
		if (HvlMenu.top() == pause) {
			HvlMenu.operate(delta, hvlEnvironment(Display.getWidth() / 3f, Display.getHeight() / 4f, Display.getWidth() / 3f, Display.getHeight() / 2f));
		}
		
		


	}

}
