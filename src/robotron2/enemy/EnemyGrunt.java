package robotron2.enemy;

import java.util.ArrayList;

import robotron2.Bullet;
import robotron2.BulletFire;
import robotron2.EnemySpawner;
import robotron2.Game;
import robotron2.Player;
import robotron2.Score;

public class EnemyGrunt {

	public EnemyGrunt(float xPosArg, float yPosArg, boolean livingStateArg, int stutterArg, int shatterDirectionArg, int textureArg) {
		xPos = xPosArg;
		yPos = yPosArg;
		livingState = livingStateArg;
		gruntStutter = stutterArg;
		gruntTexture = textureArg;
		shatterDirection  = shatterDirectionArg;
	}

	public static final float GRUNT_SIZE = 25;

	public float yPos = 0;
	public float xPos = 0;
	public boolean livingState = true;
	public int gruntStutter = 0;
	public int gruntTexture;
	public int shatterDirection;

	public int stutterSpeed = 1;
	private boolean movedThisFrame;

	public void update(float delta, Player player) {

		movedThisFrame = false;

		// GRUNT MOVEMENT AND SPRITE CHANGE
		if (livingState == true) {
			if (player.getxPos() > xPos && (gruntStutter == 0 || gruntStutter == 20)) {
				xPos = xPos + 12;
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			} else if (player.getxPos() < xPos && (gruntStutter == 0 || gruntStutter == 20)) {
				xPos = xPos - 12;
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			}
			if (player.getyPos() > yPos && (gruntStutter == 0 || gruntStutter == 20)) {
				yPos = yPos + 12;
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			} else if (player.getyPos() < yPos && (gruntStutter == 0 || gruntStutter == 20)) {
				yPos = yPos - 12;
				if (gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				} else if (gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			}
		}
		// END MOVEMENT AND SPRITE CHANGE

		// GRUNT HITBOX
		for (Bullet bullet : BulletFire.bullets) {
			if (((bullet.getxPos() < xPos + 15) && (bullet.getxPos() > xPos - 15) 
					&& (bullet.getyPos() < yPos + 15) && (bullet.getyPos() > yPos - 15))) {
				livingState = false;
				bullet.setFired(false);
				bullet.setBulletDrawn(false);
				shatterDirection = bullet.getDirectionFired();
				Score.addPoints(100);
			}
		}
		
		if((player.getxPos() < xPos + 15) && (player.getxPos() > xPos - 15) && (player.getyPos() < yPos + 15) && player.getyPos() > yPos - 15) {
			player.setAlive(false);
		}
		
		// END GRUNT HITBOX

		// GRUNT STUTTER SPEED
		if ((EnemySpawner.levelTimer + 10 > Game.globalTimer)) {
			stutterSpeed = 1;
		} else if ((EnemySpawner.levelTimer + 10 <= Game.globalTimer)
				&& (EnemySpawner.levelTimer + 20 > Game.globalTimer)) {
			stutterSpeed = 2;
		} else if ((EnemySpawner.levelTimer + 20 <= Game.globalTimer)) {
			stutterSpeed = 3;
		}

		if (gruntStutter == 0 && stutterSpeed == 1) {
			gruntStutter = 100;
		} else if (gruntStutter == 0 && stutterSpeed == 2) {
			gruntStutter = 60;
		} else if (gruntStutter == 0 && stutterSpeed == 3) {
			gruntStutter = 30;
		}

		else {
			gruntStutter = gruntStutter - 1;
		}
	}
	// END GRUNT STUTTER SPEED

	public float getyPos() {
		return yPos;
	}

	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public boolean getLivingState() {
		return livingState;
	}

	public void setLivingState(boolean livingState) {
		this.livingState = livingState;
	}

	public int getGruntStutter() {
		return gruntStutter;
	}

	public void setGruntStutter(int gruntStutter) {
		this.gruntStutter = gruntStutter;
	}

}
