package robotron2.enemy.grunt;

import robotron2.Player;
import robotron2.util.Utility;

public class GruntMovement {
	
	
/*
	public static void gruntMovementController(Player player, float delta, EnemyGrunt g) {
		

		g.setMovedThisFrame(false);

		// GRUNT MOVEMENT AND SPRITE CHANGE
		if (livingState == true && enemyChase > 0 && canSeePlayer) {
			enemyChase = enemyChase-(delta*5);


			if (player.getxPos() > xPos && stutterSpeed != 3
					&& (gruntStutter <= 0 || ((gruntStutter <= 0.15) && !(firstStepX)))) {

				xPos = xPos + 12;
				firstStepX = true;

				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}


			} else if (player.getxPos() < xPos && stutterSpeed != 3
					&& (gruntStutter <= 0 || ((gruntStutter <= 0.15) && !(firstStepX)))) {

				xPos = xPos - 12;
				firstStepX = true;

				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}

			}

			if (player.getxPos() > xPos && stutterSpeed == 3
					&& (gruntStutter <= 0 || ((gruntStutter <= 0.1) && !(firstStepX)))) {

				xPos = xPos + 13;

				firstStepX = true;
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}

			} else if (player.getxPos() < xPos && stutterSpeed == 3
					&& (gruntStutter <= 0 || ((gruntStutter <= 0.1) && !(firstStepX)))) {

				xPos = xPos - 13;
				firstStepX = true;
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}

			}

			if (player.getyPos() > yPos && stutterSpeed != 3
					&& (gruntStutter <= 0 || ((gruntStutter <= 0.15) && !(firstStepY)))) {

				yPos = yPos + 12;

				firstStepY = true;
				//hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			} else if (player.getyPos() < yPos && stutterSpeed != 3
					&& (gruntStutter <= 0 || ((gruntStutter <= 0.15) && !(firstStepY)))) {

				yPos = yPos - 12;

				firstStepY = true;
				//hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			}
			if (player.getyPos() > yPos && stutterSpeed == 3
					&& (gruntStutter <= 0 || ((gruntStutter <= 0.1) && !(firstStepY)))) {

				yPos = yPos + 13;

				firstStepY = true;
				//hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			} else if (player.getyPos() < yPos && stutterSpeed == 3
					&& (gruntStutter <= 0 || ((gruntStutter <= 0.1) && !(firstStepY)))) {

				yPos = yPos - 13;

				firstStepY = true;
				//hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			}
		}else if(!canSeePlayer && enemyChase > 0 && enemyChase < CHASE_TIMER) {
			pathToPlayer = pathfind(Utility.getCurrentTile(xPos, yPos), Utility.getCurrentTile(player.getxPos(), player.getyPos()));

			if(pathToPlayer.size() >=2) {

				if (pathToPlayer.get(1).x > xPos 
						&& (gruntStutter <= 0 || ((gruntStutter <= 0.15) && !(firstStepX)))) {
					xPos = xPos + 12;
					firstStepX = true;

					if (gruntTexture == 4 && movedThisFrame == false) {
						gruntTexture = 5;
						movedThisFrame = true;
					} else if (gruntTexture == 5 && movedThisFrame == false) {
						gruntTexture = 4;
						movedThisFrame = true;
					}
				}else if (pathToPlayer.get(1).x < xPos 
						&& (gruntStutter <= 0 || ((gruntStutter <= 0.15) && !(firstStepX)))) {

					xPos = xPos - 12;
					firstStepX = true;

					if (gruntTexture == 4 && movedThisFrame == false) {
						gruntTexture = 5;
						movedThisFrame = true;
					} else if (gruntTexture == 5 && movedThisFrame == false) {
						gruntTexture = 4;
						movedThisFrame = true;
					}

				}

				if (pathToPlayer.get(1).y > yPos
						&& (gruntStutter <= 0 || ((gruntStutter <= 0.15) && !(firstStepY)))) {

					yPos = yPos + 12;

					firstStepY = true;
					//hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
					if (gruntTexture == 4 && movedThisFrame == false) {
						gruntTexture = 5;
						movedThisFrame = true;
					} else if (gruntTexture == 5 && movedThisFrame == false) {
						gruntTexture = 4;
						movedThisFrame = true;
					}
				}else if (pathToPlayer.get(1).y < yPos 
						&& (gruntStutter <= 0 || ((gruntStutter <= 0.1) && !(firstStepY)))) {

					yPos = yPos - 13;

					firstStepY = true;
					//hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
					if (gruntTexture == 4 && movedThisFrame == false) {
						gruntTexture = 5;
						movedThisFrame = true;
					} else if (gruntTexture == 5 && movedThisFrame == false) {
						gruntTexture = 4;
						movedThisFrame = true;
					}
				}
			}

		}
		// END MOVEMENT AND SPRITE CHANGE
		
	}
	
	*/
	
}
