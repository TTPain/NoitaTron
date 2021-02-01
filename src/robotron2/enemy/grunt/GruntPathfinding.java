package robotron2.enemy.grunt;

import java.util.ArrayList;
import java.util.HashMap;

import com.osreboot.ridhvl2.HvlCoord;

import robotron2.terrain.Block;
import robotron2.terrain.TerrainGeneration;

public class GruntPathfinding {
	
	
	
	public static ArrayList<HvlCoord> pathfind(HvlCoord startPos, HvlCoord endPos){

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

		for(int i = 0; i < EnemyGrunt.PATHFINDING_RANGE; i++) {

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

		
		//System.out.println("Could not find player!");
		return new ArrayList<>();

	}
	
	public static boolean isAWall(float xPos, float yPos) {

		for(Block b : TerrainGeneration.blocks) {
			if(b.getxPos() == xPos && b.getyPos()== yPos) {
				if(b.getBlockType() == 1) {
					return true;
				}else {
					return false;
				}
			}
		}
		return true;
	}

}
