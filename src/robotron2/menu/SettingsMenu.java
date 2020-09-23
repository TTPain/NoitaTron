package robotron2.menu;

import static com.osreboot.ridhvl2.HvlStatics.hvlSound;

import com.osreboot.ridhvl2.menu.HvlMenu;
import com.osreboot.ridhvl2.menu.component.HvlArranger;
import com.osreboot.ridhvl2.menu.component.HvlButtonLabeled;
import com.osreboot.ridhvl2.menu.component.HvlLabel;
import com.osreboot.ridhvl2.menu.component.HvlSpacer;

import robotron2.RoomGenerator;

public class SettingsMenu {
	
	public static final int SPACER_SIZE = 40;
	public static boolean muted = true;

	public static void initialize() {
		MenuManager.settings = new HvlArranger(false, 0.5f, 0.5f);
		MenuManager.settings.add(HvlButtonLabeled.fromDefault().text("Mute").align(0.5f, 0.5f).offsetY(4).clicked((button) -> {
			if(muted == true) {
				muted = false;
			}else if(muted == false) {
				muted = true;
			}
			
		}).name("mute"));
		MenuManager.settings.add(new HvlSpacer(SPACER_SIZE));
		MenuManager.settings.add(HvlButtonLabeled.fromDefault().text("Back").align(0.5f, 0.5f).offsetY(4).clicked((button) -> {
			HvlMenu.set(MenuManager.main);
		}));
	}
	public static void update(float delta) {
		if(muted == false) {
		MenuManager.settings.<HvlButtonLabeled>find("mute").text("[ ] Mute");
		}else {
			MenuManager.settings.<HvlButtonLabeled>find("mute").text("[X] Mute");	
		}
		
		if(muted == false && !(hvlSound(1).isPlaying())) {
			hvlSound(1).playAsSoundEffect(1f, 1f, true);
		}else if (muted == true && hvlSound(1).isPlaying()){
			hvlSound(1).stop();
		}
		
		
		      
		
		
	}
}
	
