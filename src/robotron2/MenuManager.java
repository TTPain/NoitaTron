package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlColor;
import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlEnvironment;
import static com.osreboot.ridhvl2.HvlStatics.hvlFont;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.menu.HvlDefault;
import com.osreboot.ridhvl2.menu.HvlMenu;
import com.osreboot.ridhvl2.menu.component.HvlArranger;
import com.osreboot.ridhvl2.menu.component.HvlButtonLabeled;
import com.osreboot.ridhvl2.menu.component.HvlButton.HvlButtonState;

public class MenuManager {

	public static HvlArranger intro, main, game, pause, settings, credits, gameover;

	public static void initialize() {
		// Arranger(HorizontalArg, xAlign, yAlign)
		//DEFAULT CREATION
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
		defaultButton.align(0.33f, 0.2f);
		HvlDefault.put(defaultButton);

		//MAIN MENU
		main = new HvlArranger(false, 0f, 0f);
		main.add(HvlButtonLabeled.fromDefault().text("Play!").clicked((button) -> {
			HvlMenu.set(game);
			EnemySpawner.reset();
		}));
		main.add(HvlButtonLabeled.fromDefault().text("Quit :(").clicked((button) -> {
			Main.newest().setExiting();
		}));

		game = new HvlArranger(false, 1f, 1f);
		
		HvlMenu.set(main);
		
	}

	public static void update(float delta) {

		HvlMenu.operate(delta, hvlEnvironment(20, 240, 800, 400));

	}

}
