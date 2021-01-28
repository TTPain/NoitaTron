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
import com.osreboot.ridhvl2.template.HvlTimer;

import robotron2.enemy.grunt.EnemyGrunt;
import robotron2.load.SoundLoader;
import robotron2.load.TextureLoader;
import robotron2.menu.MenuManager;
import robotron2.terrain.LevelLoader;
import robotron2.util.Utility;

public class Main extends HvlTemplateI {

	/*
	 * TODO
	 * Reset player and enemy positions on death
	 * Fix issues with bullets (random trajectory bug, randomly stops firing bug)
	 * Enemies must follow pathfinding path
	 * Pathfinding does not occur if enemies have direct LOS
	 * Rewrite score/lives so that it is a component of Player
	 * Optimization
	 
	 * THINGS TO ADD:
	 * Support for different block types

	 * LOW PRIORITY
	 * Proper Game Over screen
	 * Proper death animation
	 * New enemies 
	 * Upgrades
	 * Money system?
	 * Particles
	 * Actual Textures
	 * Sound
	 * Better menus
	 * Credits menu
	 * Special Levels can change orientation to enhance gameplay and variety
	 */


	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		super(new HvlDisplayWindowed(144, 1280, 720, "Robotron 2", true));
	}

	@Override
	public void initialize() {
		getTimer().setMaxDelta(20);
		TextureLoader.loadTextures();
		SoundLoader.loadSounds();
		Game.initialize();
		LevelLoader.load();
	}

	@Override
	public void update(float delta) {
		//System.out.println("Current Level: " + Game.selected_level);
		//System.out.println(RoomGenerator.enemyGrunts.size());		
		hvlTranslate(-(Game.player.getxPos() - Display.getWidth()/2), -(Game.player.getyPos() - Display.getHeight()/2), () ->{

			if(Display.getWidth() > 1280) {
				hvlScale(Game.player.getxPos(), Game.player.getyPos(), 1f, () -> {
					Game.update(delta);
				});
			}else {
				hvlScale(Game.player.getxPos(), Game.player.getyPos(), 1f, () -> {
					Game.update(delta);

				});
			}		
		});
		//Draw HUD/Menu Elements outside of Translate call
		HUD.draw(delta);
		MenuManager.update(delta);
	}

}