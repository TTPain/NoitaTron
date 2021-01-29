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

	public static final float GRUNT_SIZE = 25;
	public static final int LINE_OF_SIGHT = 500;
	public static final int PATHFINDING_RANGE = 30;
	public static final int CHASE_TIMER = 20;

	private ArrayList<HvlCoord> pathToPlayer = new ArrayList<HvlCoord>();

	public float yPos = 0;
	public float xPos = 0;
	public float enemyChase = 0;
	public boolean livingState = true;
	public float gruntStutter = 0;
	public int gruntTexture;
	public boolean withinRange;
	public boolean canSeePlayer;

	public int stutterSpeed = 1;
	private boolean firstStepX = false;
	private boolean firstStepY = false;


	private boolean movedThisFrame;

	private HvlCoord gruntPos = new HvlCoord(0, 0);

	public void update(float delta, Player player) {

		System.out.println(enemyChase);

		gruntPos.x = xPos;
		gruntPos.y = yPos;

		if(withinRange) {
			if(canSeePlayer && (Block.hasLineOfSight(TerrainGeneration.blocks, player.getPlayerPos(), gruntPos))) {
				if(Game.devMode) {
					hvlDraw(hvlLine(xPos, yPos, player.getxPos(), player.getyPos(), 2), Color.red);
				}
			}else{
				if(Game.devMode) {
					hvlDraw(hvlLine(xPos, yPos, player.getxPos(), player.getyPos(), 1), Color.white);
				}
			}
		}


		//Box representing grunt field of view
		//hvlDraw(hvlQuadc(xPos, yPos, LINE_OF_SIGHT, LINE_OF_SIGHT), Color.white);

		movedThisFrame = false;

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




		if(player.getxPos() >=  xPos - Block.BLOCK_SIZE*8 && player.getxPos() <=  xPos  + Block.BLOCK_SIZE*8
				&& player.getyPos() >=  yPos - Block.BLOCK_SIZE*8 && player.getyPos() <=  yPos + Block.BLOCK_SIZE*8) {
			withinRange = true;
		}else {
			withinRange = false;
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

		//END LINE OF SIGHT AND CHASE MECHANICS

	}

	public ArrayList<HvlCoord> pathfind(HvlCoord startPos, HvlCoord endPos){

		startPos.x = startPos.x*Block.BLOCK_SIZE;
		startPos.y = startPos.y*Block.BLOCK_SIZE;

		endPos.x = endPos.x*Block.BLOCK_SIZE;
		endPos.y = endPos.y*Block.BLOCK_SIZE;		

		ArrayList<HvlCoord> tilesToCheck = new ArrayList<HvlCoord>();
		ArrayList<HvlCoord> checkedTiles = new ArrayList<HvlCoord>();

		HashMap<HvlCoord, ArrayList<HvlCoord>> pathToEachTile = new HashMap<>();

		//System.out.println(startPos);

		tilesToCheck.add(startPos);
		pathToEachTile.put(startPos, new ArrayList<HvlCoord>());
		pathToEachTile.get(startPos).add(startPos);

		for(int i = 0; i < PATHFINDING_RANGE; i++) {

			for(HvlCoord tileBeingChecked : new ArrayList<>(tilesToCheck)) {
				if(!(checkedTiles.contains(tileBeingChecked))){

					ArrayList<HvlCoord> pathToTileBeingChecked = pathToEachTile.get(tileBeingChecked);

					if(tileBeingChecked.equals(endPos)) {
						return pathToTileBeingChecked;
					}

					//Right adjacent block
					if(!isAWall(tileBeingChecked.x + Block.BLOCK_SIZE, tileBeingChecked.y)) {

						HvlCoord eastBlock = new HvlCoord(tileBeingChecked.x + Block.BLOCK_SIZE,tileBeingChecked.y);
						tilesToCheck.add(eastBlock);
						pathToEachTile.put(eastBlock, new ArrayList<>(pathToTileBeingChecked));
						pathToEachTile.get(eastBlock).add(eastBlock);
					}
					//Left adjacent block
					if(!isAWall(tileBeingChecked.x - Block.BLOCK_SIZE, tileBeingChecked.y)) {
						HvlCoord westBlock = new HvlCoord(tileBeingChecked.x - Block.BLOCK_SIZE,tileBeingChecked.y);
						tilesToCheck.add(westBlock);
						pathToEachTile.put(westBlock, new ArrayList<>(pathToTileBeingChecked));
						pathToEachTile.get(westBlock).add(westBlock);

					}
					//Upper adjacent block
					if(!isAWall(tileBeingChecked.x, tileBeingChecked.y - Block.BLOCK_SIZE)) {
						HvlCoord northBlock = new HvlCoord(tileBeingChecked.x ,tileBeingChecked.y - Block.BLOCK_SIZE);
						tilesToCheck.add(northBlock);
						pathToEachTile.put(northBlock, new ArrayList<>(pathToTileBeingChecked));
						pathToEachTile.get(northBlock).add(northBlock);
					}
					//Lower adjacent block
					if(!isAWall(tileBeingChecked.x, tileBeingChecked.y + Block.BLOCK_SIZE)) {
						HvlCoord southBlock = new HvlCoord(tileBeingChecked.x,tileBeingChecked.y + Block.BLOCK_SIZE);
						tilesToCheck.add(southBlock);
						pathToEachTile.put(southBlock, new ArrayList<>(pathToTileBeingChecked));
						pathToEachTile.get(southBlock).add(southBlock);

					}

					checkedTiles.add(tileBeingChecked);
					tilesToCheck.remove(tileBeingChecked);
				}

			}
		}

		return new ArrayList<>();

	}

	public boolean isAWall(float xPos, float yPos) {

		for(Block b : TerrainGeneration.blocks) {
			if(b.getxPos() == xPos && b.getyPos()== yPos) {
				if(b.getBlockType() == 1) {
					return true;
				}else {
					return false;
				}
			}
		}
		System.out.println("Could not find");
		return true;
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

}
