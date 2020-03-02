package robotron2.enemy;

import static com.osreboot.ridhvl2.HvlStatics.hvlSound;

import java.util.ArrayList;

import robotron2.Bullet;
import robotron2.BulletFire;
import robotron2.EnemySpawner;
import robotron2.Game;
import robotron2.Player;
import robotron2.Score;
import robotron2.load.SoundLoader;

public class EnemyGrunt {

	public EnemyGrunt(float xPosArg, float yPosArg, boolean livingStateArg, float stutterArg, int shatterDirectionArg,
			int textureArg) {
		xPos = xPosArg;
		yPos = yPosArg;
		livingState = livingStateArg;
		gruntStutter = stutterArg;
		gruntTexture = textureArg;
		shatterDirection = shatterDirectionArg;
	}

	public static final float GRUNT_SIZE = 25;

	public float yPos = 0;
	public float xPos = 0;
	public boolean livingState = true;
	public float gruntStutter = 0;
	public int gruntTexture;
	public int shatterDirection;

	public int stutterSpeed = 1;
	private boolean firstStepX = false;
	private boolean firstStepY = false;

	private boolean movedThisFrame;

	public void update(float delta, Player player) {

		movedThisFrame = false;

		// GRUNT MOVEMENT AND SPRITE CHANGE
		if (livingState == true) {
			if (player.getxPos() > xPos && stutterSpeed != 3
					&& (gruntStutter <= 0 || ((gruntStutter <= 0.15) && !(firstStepX)))) {

				xPos = xPos + 12;

				firstStepX = true;
				hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
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
				hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
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
				hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
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
				hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
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
				hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
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
				hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
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
				hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
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
				hvlSound(SoundLoader.INDEX_GRUNTSTEP).playAsSoundEffect(0.15f, 0.05f, false);
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
			if (((bullet.getxPos() < xPos + 15) && (bullet.getxPos() > xPos - 15) && (bullet.getyPos() < yPos + 15)
					&& (bullet.getyPos() > yPos - 15))) {
				livingState = false;
				bullet.setFired(false);
				bullet.setBulletDrawn(false);
				shatterDirection = bullet.getDirectionFired();
				Score.addPoints(100);
			}
		}

		// PLAYER HITBOX
		if ((player.getxPos() - Player.PLAYER_WIDTH / 2 < xPos + 15)
				&& (player.getxPos() + Player.PLAYER_WIDTH / 2 > xPos - 15)
				&& (player.getyPos() - Player.PLAYER_HEIGHT / 2 < yPos + 15)
				&& player.getyPos() + Player.PLAYER_HEIGHT / 2 > yPos - 15) {
			player.setAlive(false);
		}
		// END GRUNT/PLAYER HITBOX

		// GRUNT STUTTER SPEED
		// Speeds up every 10 seconds.
		if ((EnemySpawner.levelTimer + 10 > Game.globalTimer)) {
			stutterSpeed = 1;
		} else if ((EnemySpawner.levelTimer + 10 <= Game.globalTimer)
				&& (EnemySpawner.levelTimer + 20 > Game.globalTimer)) {
			stutterSpeed = 2;
		} else if ((EnemySpawner.levelTimer + 20 <= Game.globalTimer)) {
			stutterSpeed = 3;
		}

		if (gruntStutter <= 0 && stutterSpeed == 1) {
			gruntStutter = 0.82f;
			firstStepX = false;
			firstStepY = false;
		} else if (gruntStutter <= 0 && stutterSpeed == 2) {
			gruntStutter = 0.36f;
			firstStepX = false;
			firstStepY = false;
		} else if (gruntStutter <= 0 && stutterSpeed == 3) {
			gruntStutter = 0.13f;
			firstStepX = false;
			firstStepY = false;
		}

		else {
			gruntStutter = gruntStutter - (delta * 1.2f);
		}

		System.out.println(gruntStutter);
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

	public float getGruntStutter() {
		return gruntStutter;
	}

	public void setGruntStutter(int gruntStutter) {
		this.gruntStutter = gruntStutter;
	}

}
