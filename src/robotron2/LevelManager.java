package robotron2;

import org.lwjgl.input.Keyboard;

import robotron2.enemy.grunt.EnemyGrunt;

public class LevelManager {

	public static int gruntDeathCount = 0;

	public static void update(Player player, float delta) {

		//Room Cleared Detection
		gruntDeathCount = 0;
		RoomGenerator.enemiesAlive = RoomGenerator.enemyGrunts.size();
		for (EnemyGrunt grunt : RoomGenerator.enemyGrunts) {
			if (grunt.livingState == false) {
				RoomGenerator.enemiesAlive--;
			}
		}

		//System.out.println(RoomGenerator.enemiesAlive);



		//Hard coded for level 1 only
		if(RoomGenerator.enemiesAlive == 0) {
			///////

			RoomClearAnimation.play(delta);
			for(Door door : RoomGenerator.doors) {
				door.setOpen(true);
				if(door.getOpen() && player.getxPos() - Player.PLAYER_WIDTH/2 < door.getxPos() + Door.DOOR_SIZE/2 && player.getxPos() + Player.PLAYER_WIDTH/2 > door.getxPos() - Door.DOOR_SIZE/2
						&& player.getyPos() - Player.PLAYER_HEIGHT/2 < door.getyPos() + Door.DOOR_SIZE/2 && player.getyPos() + Player.PLAYER_HEIGHT/2 > door.getyPos() - Door.DOOR_SIZE/2) {
					
					//SET NEXT LEVEL
					System.out.println("You beat the game!");
					Game.level++;
					RoomGenerator.reset(player);

				}

			}

		}
	}
}
