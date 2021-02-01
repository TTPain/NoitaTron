package robotron2.enemy.grunt;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLine;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlSound;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import java.util.ArrayList;
import java.util.HashMap;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;






import robotron2.Door;
import robotron2.RoomGenerator;
import robotron2.Game;
import robotron2.Player;
import robotron2.Score;
import robotron2.load.SoundLoader;
import robotron2.terrain.Block;
import robotron2.terrain.TerrainGeneration;
import robotron2.util.Utility;
import robotron2.weapon.Bullet;
import robotron2.weapon.BulletLogic;

public class EnemyGrunt {

	public EnemyGrunt(float xPosArg, float yPosArg, boolean livingStateArg, float stutterArg, boolean canSeePlayerArg,
			int textureArg) {
		xPos = xPosArg;
		yPos = yPosArg;
		livingState = livingStateArg;
		gruntStutter = stutterArg;
		gruntTexture = textureArg;
		canSeePlayer = canSeePlayerArg;
	}



	public static int pathfindingCalls = 0;


	public static final float GRUNT_SIZE = 25;
	public static final int DETECTION_RANGE = 500; //Distance (in pixels) before an enemy in line of sight will begin tracking
	public static final int CHASE_TIMER = 20; //Currently unused; can used to enable a maximum non-LOS chase timer
	public static final int PATHFINDING_RANGE = 30; //Maximum allowed distance (in blocks) that pathfinding can calculate

	private ArrayList<HvlCoord> pathToPlayer = new ArrayList<HvlCoord>();

	private float yPos = 0;
	private float xPos = 0;
	private float yPosLastFrame = -Block.BLOCK_SIZE;
	private float xPosLastFrame = -Block.BLOCK_SIZE;
	private boolean movedBlocks = false;
	private float enemyChase = 0;
	private boolean livingState = true;
	private float gruntStutter = 0;
	private int gruntTexture;
	private boolean withinRange;
	private boolean canSeePlayer;
	private int stutterSpeed = 1;
	private boolean firstStepX = false;
	private boolean firstStepY = false;
	private boolean movedThisFrame = false;

	private boolean lineOfSightBrokenOnThisFrame = false;
	private boolean hasHadLineOfSightSinceLastBroken = false;

	private HvlCoord gruntPos = new HvlCoord(0, 0);

	public void update(float delta, Player player) {

		if(enemyChase>0 && !canSeePlayer) {
			
		}

		//System.out.println(pathfindingCalls);

		//System.out.println("CURRENT TILE: "+Utility.getCurrentTile(xPos, yPos).toString());
		//System.out.println("PREVIOUS TILE: "+Utility.getCurrentTile(xPosLastFrame, yPosLastFrame).toString());
		//System.out.println(movedBlocks);

		if(Utility.getCurrentTile(xPos, yPos).equals(Utility.getCurrentTile(xPosLastFrame, yPosLastFrame))){
			movedBlocks = false;
		}else {
			movedBlocks = true;
		}

		gruntPos.x = xPos;
		gruntPos.y = yPos;

		if(withinRange) {
			if(canSeePlayer && (Block.hasLineOfSight(TerrainGeneration.blocks, player.getPlayerPos(), gruntPos))) {

				hasHadLineOfSightSinceLastBroken = true;

				if(Game.devMode) {
					hvlDraw(hvlLine(xPos, yPos, player.getxPos(), player.getyPos(), 2), Color.red);
				}

			}else{

				if(hasHadLineOfSightSinceLastBroken) {
					hasHadLineOfSightSinceLastBroken = false;
					lineOfSightBrokenOnThisFrame = true;
				}

				if(Game.devMode) {
					hvlDraw(hvlLine(xPos, yPos, player.getxPos(), player.getyPos(), 1), Color.white);
				}
			}
		}


		if(withinRange) {
			if(canSeePlayer) {
				hasHadLineOfSightSinceLastBroken = true;
			}else{
				if(hasHadLineOfSightSinceLastBroken) {
					hasHadLineOfSightSinceLastBroken = false;
					lineOfSightBrokenOnThisFrame = true;
				}

			}
		}




		xPosLastFrame = xPos;
		yPosLastFrame = yPos;


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
			
			//ALSO NEED TO CHECK IF A CHASE IS ACTIVE AND LINE OF SIGHT WAS BROKEN ON THIS FRAME
			if(player.getMovedBlocks() || movedBlocks || lineOfSightBrokenOnThisFrame) {		
				pathToPlayer = pathfind(Utility.getCurrentTile(xPos, yPos), Utility.getCurrentTile(player.getxPos(), player.getyPos()));
				
				pathfindingCalls++;
				//System.out.println("SIZE " + pathToPlayer.size());
				if(pathToPlayer.size() < 2) {
					enemyChase = 0;
				}
			}

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

		// GRUNT HITBOX
		for (Bullet b : BulletLogic.bulletTotal) {
			if (((b.getxPos() < xPos + 15) && (b.getxPos() > xPos - 15) && (b.getyPos() < yPos + 15)
					&& (b.getyPos() > yPos - 15))) {
				livingState = false;
				b.setFired(false);
				b.setBulletDrawn(false);
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
		if ((RoomGenerator.levelTimer + 10 > Game.gameplayTimer)) {
			stutterSpeed = 1;
		} else if ((RoomGenerator.levelTimer + 10 <= Game.gameplayTimer)
				&& (RoomGenerator.levelTimer + 20 > Game.gameplayTimer)) {
			stutterSpeed = 2;
		} else if ((RoomGenerator.levelTimer + 20 <= Game.gameplayTimer)) {
			stutterSpeed = 3;
		}

		if (gruntStutter <= 0 && stutterSpeed == 1) {
			gruntStutter = 0.85f;
			firstStepX = false;
			firstStepY = false;
		} else if (gruntStutter <= 0 && stutterSpeed == 2) {
			gruntStutter = 0.60f;
			firstStepX = false;
			firstStepY = false;
		} else if (gruntStutter <= 0 && stutterSpeed == 3) {
			gruntStutter = 0.25f;
			firstStepX = false;
			firstStepY = false;
		}

		else {
			gruntStutter = gruntStutter - (delta * 1.2f);
		}
		// END GRUNT STUTTER SPEED



		//PATHFINDING TO PLAYER;
		//If an enemy has *direct* line of sight to the player, it should ignore the pathfinding algorithm and
		//just rush the player.
		Utility.getCurrentTile(xPos, yPos);
		//If pathToPlayer is null, populate with pathfinding method
		//if(pathToPlayer.size() == 0) {



		//Pathfinding Representation
		if(Game.devMode && !canSeePlayer && enemyChase > 0 && enemyChase < CHASE_TIMER) {
			for(HvlCoord coord : pathToPlayer) {
				hvlDraw(hvlQuadc(coord.x, coord.y, 15, 15), Color.green);
			}
		}

		//}
		//Else follow the currently established path
		//GRUNT LINE OF SIGHT AND CHASE MECHANICS

		//withinRange = false;
		//canSeePlayer = true;
		//enemychase = 500;
		//Develop list of coordinates from the enemy to the player




		if(player.getxPos() >=  xPos - DETECTION_RANGE && player.getxPos() <=  xPos  + DETECTION_RANGE
				&& player.getyPos() >=  yPos - DETECTION_RANGE && player.getyPos() <=  yPos + DETECTION_RANGE) {
			withinRange = true;
		}else {
			if(enemyChase > 0) {
				withinRange = true;
			}else {
				withinRange = false;
			}
		}

		if(withinRange) {
			if(Block.hasLineOfSight(TerrainGeneration.blocks, player.getPlayerPos(), gruntPos)){	
				canSeePlayer = true;
				enemyChase = CHASE_TIMER;
			}else {
				canSeePlayer = false;
			}
			if (enemyChase < 0) {
				enemyChase = 0;
			}
		}

		lineOfSightBrokenOnThisFrame = false;	
		//END LINE OF SIGHT AND CHASE MECHANICS


	}

	public ArrayList<HvlCoord> pathfind(HvlCoord startPos, HvlCoord endPos){
		return GruntPathfinding.pathfind(startPos, endPos);	
	}


	public HvlCoord getGruntPos() {
		return gruntPos;
	}


	public void setGruntPos(HvlCoord gruntPos) {
		this.gruntPos = gruntPos;
	}


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

	public ArrayList<HvlCoord> getPathToPlayer() {
		return pathToPlayer;
	}

	public void setPathToPlayer(ArrayList<HvlCoord> pathToPlayer) {
		this.pathToPlayer = pathToPlayer;
	}

	public float getEnemyChase() {
		return enemyChase;
	}

	public void setEnemyChase(float enemyChase) {
		this.enemyChase = enemyChase;
	}

	public int getGruntTexture() {
		return gruntTexture;
	}

	public void setGruntTexture(int gruntTexture) {
		this.gruntTexture = gruntTexture;
	}

	public boolean isWithinRange() {
		return withinRange;
	}

	public void setWithinRange(boolean withinRange) {
		this.withinRange = withinRange;
	}

	public boolean isCanSeePlayer() {
		return canSeePlayer;
	}

	public void setCanSeePlayer(boolean canSeePlayer) {
		this.canSeePlayer = canSeePlayer;
	}

	public int getStutterSpeed() {
		return stutterSpeed;
	}

	public void setStutterSpeed(int stutterSpeed) {
		this.stutterSpeed = stutterSpeed;
	}

	public boolean isFirstStepX() {
		return firstStepX;
	}

	public void setFirstStepX(boolean firstStepX) {
		this.firstStepX = firstStepX;
	}

	public boolean isFirstStepY() {
		return firstStepY;
	}

	public void setFirstStepY(boolean firstStepY) {
		this.firstStepY = firstStepY;
	}

	public boolean isMovedThisFrame() {
		return movedThisFrame;
	}

	public void setMovedThisFrame(boolean movedThisFrame) {
		this.movedThisFrame = movedThisFrame;
	}

	public void setGruntStutter(float gruntStutter) {
		this.gruntStutter = gruntStutter;
	}


}