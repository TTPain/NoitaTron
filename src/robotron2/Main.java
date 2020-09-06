package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlScale;
import static com.osreboot.ridhvl2.HvlStatics.hvlSound;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;
import static com.osreboot.ridhvl2.HvlStatics.hvlTranslate;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;

import com.osreboot.ridhvl2.loader.HvlLoaderSound;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.loader.HvlLoader;
import com.osreboot.ridhvl2.loader.HvlLoaderTexture;
import com.osreboot.ridhvl2.template.HvlDisplayWindowed;
import com.osreboot.ridhvl2.template.HvlTemplateI;

import robotron2.load.SoundLoader;
import robotron2.load.TextureLoader;
import robotron2.menu.MenuManager;
import robotron2.util.Utility;

public class Main extends HvlTemplateI {

	/*
	 * TODO
	 * Render Class
	 * Current room is set to 0 as soon as game starts
	 * Update to new room when level is completed
	 * Fix 'E' bullets so they despawn
	 * Enemy Death Particles
	 * Hulks, other enemies
	 * People/Money
	 * Upgrades
	 * Pause Menu
	 * Splashes
	 * Actual Textures
	 * Sound
	 * Rewrite score/lives so that it is a component of Player
	 * *****Player Hitbox/Death*****
	 * Game over says score and "Game Over"
	 * Rework Player Lives after adding a second player
	 */
	

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		super(new HvlDisplayWindowed(144, 1280, 720, "Robotron 2", true));
	}

	@Override
	public void initialize() {
		TextureLoader.loadTextures();
		SoundLoader.loadSounds();
		Game.initialize();
	}

	@Override
	public void update(float delta) {
		System.out.println("Current Level: " + Game.selected_level);
		hvlTranslate(-(Game.player.getxPos() - Display.getWidth()/2), -(Game.player.getyPos() - Display.getHeight()/2), () ->{
	//	Utility.scale(Display.getWidth() / 1280f, Display.getHeight() / 720f, () -> {
			if(Display.getWidth() > 1280) {
				hvlScale(Game.player.getxPos(), Game.player.getyPos(), 1.2f, () -> {
					Game.update(delta);
				});
			}else {
			hvlScale(Game.player.getxPos(), Game.player.getyPos(), 1f, () -> {
				Game.update(delta);
			
			});
			}
			//Draw HUD Elements outside of Translate call
		    
		//});
		});
		MenuManager.update(delta);
	}

}