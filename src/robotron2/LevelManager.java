package robotron2;

import org.lwjgl.input.Keyboard;

import robotron2.enemy.EnemyGrunt;

public class LevelManager {

	public static int gruntDeathCount = 0;

	public static void update(Player player, float delta) {

		//Room Cleared Detection
		gruntDeathCount = 0;
		for (EnemyGrunt grunt : RoomGenerator.enemyGrunts) {
			if (grunt.livingState == false) {
				gruntDeathCount = gruntDeathCount + 1;
			}
		}

		if (gruntDeathCount == RoomGenerator.enemyGrunts.size()) {
			LevelGenerator.currentRoom.setRoomCleared(true);
		}
		
		//Room Completion Detection	
		if(LevelGenerator.currentRoom.getRoomCleared() == true && LevelGenerator.currentRoom.getRoomCompleted() == false) {
			
			for(Door door : RoomGenerator.doors) {
				door.setOpen(true);
				
				if(door.getOpen() && player.getxPos() - Player.PLAYER_WIDTH/2 < door.getxPos() + Door.DOOR_SIZE/2 && player.getxPos() + Player.PLAYER_WIDTH/2 > door.getxPos() - Door.DOOR_SIZE/2
						&& player.getyPos() - Player.PLAYER_HEIGHT/2 < door.getyPos() + Door.DOOR_SIZE/2 && player.getyPos() + Player.PLAYER_HEIGHT/2 > door.getyPos() - Door.DOOR_SIZE/2) {
					LevelGenerator.currentRoom.setRoomCompleted(true);
				}
			}
				RoomClearAnimation.play(delta);
				System.out.println("Room cleared, but not yet completed.");	
		}
		
	if(LevelGenerator.currentRoom.getRoomCompleted() == true) {
			System.out.println("Room Completed!!");
			//Set next room.
			LevelGenerator.currentRoom.setRoomCleared(false);
			LevelGenerator.currentRoom.setRoomCompleted(false);
			RoomGenerator.reset(player);
		}
		
		
		

	}
}
