package robotron2;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.loader.HvlLoader;
import com.osreboot.ridhvl2.loader.HvlLoaderTexture;

import robotron2.enemy.EnemyGrunt;
import robotron2.enemy.EnemyHulk;
import robotron2.util.Utility;

import java.util.ArrayList;

public class RoomGenerator {

	public static float levelTimer;
	public static ArrayList<Door> doors = new ArrayList<>();
	public static ArrayList<EnemyGrunt> enemyGrunts = new ArrayList<>();
	public static ArrayList<EnemyHulk> enemyHulks = new ArrayList<>();
	public static int enemiesAlive = 0;
	public static int rangen = 0;

	public static void reset(Player player) {
		levelTimer = Game.gameplayTimer;
		
		//PLAYER INITIAL X AND Y
		player.setxPos(1920/2);
		player.setyPos(1080/2);
		
		BulletLogic.reset(player);
		enemyGrunts.clear();
		enemyHulks.clear();
		doors.clear();
		RoomClearAnimation.stop = false;
		// Fill array with enemies, exact placement can be specified
		if ((Game.selected_level == 1)) {
			doors.add(new Door(1920-160, 1080/2, false));
			// xPos, yPos, livingState, StutterStart, ShatterDirection, Starter Texture
			enemyGrunts.add(new EnemyGrunt(300f, 100f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(500f, 500f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(700f, 700f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(600f, 200f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(400f, 200f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemiesAlive = enemyGrunts.size();
			//enemyHulks.add(new EnemyHulk(0, 0, 1));
			
		}
		else if ((Game.selected_level == 2)) {
			doors.add(new Door(1920-160, 1080/2, false));
			// xPos, yPos, livingState, StutterStart, ShatterDirection, Starter Texture
			enemyGrunts.add(new EnemyGrunt(300f, 100f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(500f, 500f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(700f, 700f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(600f, 200f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(400f, 200f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(450f, 200f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(440f, 200f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(430f, 200f, true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			enemyHulks.add(new EnemyHulk(0, 0, 1));
			enemiesAlive = enemyGrunts.size();
			
		}
		
		else {
			rangen = Utility.randomIntBetween(0, 12);
			
			doors.add(new Door(1920-160, 1080/2, false));
			// xPos, yPos, livingState, StutterStart, ShatterDirection, Starter Texture
			
			enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(0, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			
			enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(0, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			
			enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(0, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			
			enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(0, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			
			enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(0, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			
			enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(0, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			
			enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(0, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			
			enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(0, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			if (rangen > 4) {
				enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(1, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
				enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(1, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			}
			if (rangen > 6) {
				enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(1, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
				enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(1, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			}
			if (rangen > 9) {
				enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(1, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
				enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(1, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			}
			if (rangen > 10) {
				enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(1, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
				enemyGrunts.add(new EnemyGrunt(75*(Utility.randomIntBetween(3, 12)), 100*(Utility.randomIntBetween(1, 9)), true, Utility.randomFloatBetween(0, 1), 0, Utility.randomIntBetween(4, 5)));
			}
			enemyHulks.add(new EnemyHulk(0, 0, 1));
			enemiesAlive = enemyGrunts.size();
		}
	}

	public static void update(float delta) {
		// Each frame check if each enemy is alive, and if so, update and draw it.
		for(Door door : doors) {
			door.draw();
		}
		
		for (EnemyGrunt grunt : enemyGrunts) {
			if (grunt.getLivingState()) {
				hvlDraw(hvlQuadc(grunt.xPos, grunt.yPos, EnemyGrunt.GRUNT_SIZE, EnemyGrunt.GRUNT_SIZE),
						hvlTexture(grunt.gruntTexture));
				grunt.update(delta, Game.player);
			}
		}
		
		for (EnemyHulk hulk : enemyHulks) {
		
				hvlDraw(hvlQuadc(hulk.xPos, hulk.yPos, 50, 50),
						hvlTexture(3));
				hulk.update(delta, Game.player);

		}
		
	}
}
