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

import robotron2.enemy.grunt.EnemyGrunt;
import robotron2.enemy.hulk.EnemyHulk;
import robotron2.pickups.Shmoney;
import robotron2.terrain.Block;
import robotron2.terrain.TerrainGeneration;
import robotron2.util.Utility;
import robotron2.weapon.BulletLogic;

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
		if ((Game.level == 0)) {
			//doors.add(new Door(1920-160, 1080/2, false));
			// xPos, yPos, livingState, StutterStart, Can see player, Starter Texture
			
			enemyGrunts.add(new EnemyGrunt(500f, 500f, true, Utility.randomFloatBetween(0, 1), false, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(700f, 700f, true, Utility.randomFloatBetween(0, 1), false, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(600f, 200f, true, Utility.randomFloatBetween(0, 1), false, Utility.randomIntBetween(4, 5)));
			enemyGrunts.add(new EnemyGrunt(400f, 200f, true, Utility.randomFloatBetween(0, 1), false, Utility.randomIntBetween(4, 5)));
			enemiesAlive = enemyGrunts.size();
			//enemyHulks.add(new EnemyHulk(0, 0, 1));

		}


		else {
			enemyGrunts.add(new EnemyGrunt(300f, 100f, true, Utility.randomFloatBetween(0, 1), false, Utility.randomIntBetween(4, 5)));
			// xPos, yPos, livingState, StutterStart, CAN SEE PLAYER, Starter Texture
			for(Block b : TerrainGeneration.blocks) {
				rangen = Utility.randomIntBetween(0, 50);
				if(b.getBlockType()== 0 && rangen == 1) {
					enemyGrunts.add(new EnemyGrunt((b.getxPos() -+ Utility.randomFloatBetween(0, (Block.BLOCK_SIZE)/2)), (b.getyPos() -+ Utility.randomFloatBetween(0, (Block.BLOCK_SIZE)/2)), true, Utility.randomFloatBetween(0, 1), false, Utility.randomIntBetween(4, 5)));
				}
			}
		}
		//enemyHulks.add(new EnemyHulk(0, 0, 1));
		enemiesAlive = enemyGrunts.size();
	}

	public static void update(float delta, Player player) {
		// Each frame check if each enemy is alive, and if so, update and draw it.
		for(Door door : doors) {
			door.draw();
		}

		for (EnemyGrunt grunt : enemyGrunts) {
			if (grunt.getLivingState()) {
				hvlDraw(hvlQuadc(grunt.getxPos(), grunt.getyPos(), EnemyGrunt.GRUNT_SIZE, EnemyGrunt.GRUNT_SIZE),
						hvlTexture(grunt.getGruntTexture()));
				grunt.update(delta, Game.player);
			}
		}

		for (EnemyHulk hulk : enemyHulks) {

			hvlDraw(hvlQuadc(hulk.xPos, hulk.yPos, 50, 50),
					hvlTexture(3));
			hulk.update(delta, Game.player);

		}
		
		for(Shmoney rubies : Shmoney.availableRubies) {
			if(rubies.isExists()) {
				rubies.update(delta, player);
			}
			if(rubies.getTimer() > 0) {
				rubies.setTimer(rubies.getTimer()-1);
				System.out.println(rubies.getTimer());
			}
			if(rubies.getTimer() < 0) {
				rubies.setExists(false);
			}
		}
	}
}
