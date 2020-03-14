package robotron2.menu;

import org.lwjgl.input.Keyboard;

import com.osreboot.ridhvl2.menu.HvlMenu;

public class PauseFunction {
	
	public static boolean escapeHeld = false;
	
	public static void update(float delta) {
		if(!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			escapeHeld = false;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && !escapeHeld){
			escapeHeld = true;
			if(HvlMenu.top()==MenuManager.game) {
				HvlMenu.set(MenuManager.pause);
			} else if(HvlMenu.top()==MenuManager.pause) {
				HvlMenu.set(MenuManager.game);
			}	
		}
	}

}
