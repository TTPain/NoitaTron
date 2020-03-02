package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import robotron2.enemy.EnemyHulk;

public class Game {

	public static Player player;
	//public static EnemyHulk Hulk;
	public static float globalTimer = 0f;
	public static int selected_level = 1;
    

	public static void initialize() {
		player = new Player(Player.PLAYER_START_X, Player.PLAYER_START_Y, true);
		//Hulk = new EnemyHulk(300,400,0);
		BulletFire.initialize();
		EnemySpawner.reset();
	}

	public static void update(float delta) {
		globalTimer += delta;

		player.update(delta);
		if(player.isAlive()==true) {
			player.draw(delta);
		}
		EnemySpawner.update(delta);
		BulletFire.update(delta, player);
		LevelManager.update();
		Border.update(delta);
		Score.update(delta);
		//Hulk.update(delta, player);
	}

}