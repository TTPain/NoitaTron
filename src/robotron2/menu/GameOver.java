package robotron2.menu;

import com.osreboot.ridhvl2.menu.HvlMenu;
import com.osreboot.ridhvl2.menu.component.HvlArranger;
import com.osreboot.ridhvl2.menu.component.HvlButtonLabeled;
import com.osreboot.ridhvl2.menu.component.HvlSpacer;

import robotron2.Game;
import robotron2.Main;
import robotron2.Player;

public class GameOver {
	public static void initialize(Player player) {
		MenuManager.gameover = new HvlArranger(false, 0.5f, 0.5f);
		MenuManager.gameover.add(HvlButtonLabeled.fromDefault().text("Retry").clicked((button) -> {
			HvlMenu.set(MenuManager.game);
		}));
		MenuManager.gameover.add(new HvlSpacer(10));
		MenuManager.gameover.add(HvlButtonLabeled.fromDefault().text("Main Menu").clicked((button) -> {
			HvlMenu.set(MenuManager.main);
			Game.reset(player);
		}));
		MenuManager.gameover.add(new HvlSpacer(10));
		MenuManager.gameover.add(HvlButtonLabeled.fromDefault().text("Quit").clicked((button) -> {
			Main.newest().setExiting();
		}));
		
	}
}
