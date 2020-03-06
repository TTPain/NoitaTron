package robotron2.menu;

import com.osreboot.ridhvl2.menu.HvlMenu;
import com.osreboot.ridhvl2.menu.component.HvlArranger;
import com.osreboot.ridhvl2.menu.component.HvlButtonLabeled;
import com.osreboot.ridhvl2.menu.component.HvlSpacer;

import robotron2.Main;

public class PauseMenu {
	
	public static void initialize() {
		MenuManager.pause = new HvlArranger(false, 0.5f, 0.5f);
		MenuManager.pause.add(HvlButtonLabeled.fromDefault().text("Resume").clicked((button) -> {
			HvlMenu.set(MenuManager.game);
		}));
		MenuManager.pause.add(new HvlSpacer(10));
		MenuManager.pause.add(HvlButtonLabeled.fromDefault().text("Quit").clicked((button) -> {
			Main.newest().setExiting();
		}));
	}

}
