package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlSound;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.menu.HvlMenu;

import robotron2.enemy.hulk.EnemyHulk;
import robotron2.menu.MenuManager;
import robotron2.terrain.TerrainGeneration;
import robotron2.weapon.BulletLogic;

public class Game {

	public static Player player;
	public static float globalTimer = 0f;
	public static float gameplayTimer = 0f;
	public static int level = 1;
	public static boolean devMode;
    

	public static void initialize() {
		///////
		devMode = true;
		//////
		//hvlSound(1).playAsMusic(1f, 1f, true);
		player = new Player(Player.PLAYER_START_X, Player.PLAYER_START_Y, true);
		player.reset();
		MenuManager.initialize(player);
		BulletLogic.initialize();
		BulletLogic.reset(player);
		TerrainGeneration.loadBlocks();
		RoomGenerator.reset(player);
		
	}

	public static void update(float delta) {
		globalTimer += delta;
		if(HvlMenu.top() == MenuManager.game) {		
		gameplayTimer += delta;
		LevelManager.update(player, delta);
		Score.update(delta, player);
		TerrainGeneration.update();
		BulletLogic.update(delta, player);
		RoomGenerator.update(delta);
		player.update(delta);
	
		}
		
	}

	public static void reset(Player player) {
		RoomGenerator.reset(player);
		player.reset();
		Score.reset();
		
	}
	
}