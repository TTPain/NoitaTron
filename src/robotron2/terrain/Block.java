package robotron2.terrain;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.HvlMath;

public class Block {
	
	//Blocks still only support two states (wall or air), need to extend to support new Gird Maker files

	public static final float BLOCK_SIZE = 60;

	private float xPos;
	private float yPos;
	private boolean collidable;
	private int blockType;

	public Block(float xArg, float yArg, boolean isCollidable, int blockTypeArg) {

		xPos = xArg;
		yPos = yArg;
		collidable = isCollidable;
		blockType = blockTypeArg;

	}

	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xArg) {
		xPos = xArg;
	}
	
	public void test() {
		hvlDraw(hvlQuadc(xPos, yPos, 10, 10), Color.white);
	}

	public float getyPos() {
		return yPos;
	}

	public void setyPos(float yArg) {
		yPos = yArg;
	}

	public boolean getCollidable() {
		return collidable;
	}
	


	//Checks if the line between two points (startPoint and endPoint) is intersected by a (square) block.
	public static boolean hasLineOfSight(ArrayList<Block> blocks, HvlCoord startPoint, HvlCoord endPoint) {
		boolean hasLineOfSight = true;

		for(int i = 0; i < blocks.size(); i++) {
			if(blocks.get(i) != null && blocks.get(i).getCollidable()==true) {
				if(
						HvlMath.intersection(startPoint, endPoint,
								new HvlCoord(blocks.get(i).getxPos() - (BLOCK_SIZE/2), blocks.get(i).getyPos() - (BLOCK_SIZE/2)),
								new HvlCoord(blocks.get(i).getxPos() + (BLOCK_SIZE/2), blocks.get(i).getyPos() - (BLOCK_SIZE/2)))!=null ||

								HvlMath.intersection(startPoint, endPoint,
										new HvlCoord(blocks.get(i).getxPos() - (BLOCK_SIZE/2), blocks.get(i).getyPos() - (BLOCK_SIZE/2)),
										new HvlCoord(blocks.get(i).getxPos() - (BLOCK_SIZE/2), blocks.get(i).getyPos() + (BLOCK_SIZE/2)))!=null ||

										HvlMath.intersection(startPoint, endPoint,
												new HvlCoord(blocks.get(i).getxPos() + (BLOCK_SIZE/2), blocks.get(i).getyPos() + (BLOCK_SIZE/2)),
												new HvlCoord(blocks.get(i).getxPos() - (BLOCK_SIZE/2), blocks.get(i).getyPos() + (BLOCK_SIZE/2)))!=null ||

												HvlMath.intersection(startPoint, endPoint, 
														new HvlCoord(blocks.get(i).getxPos() + (BLOCK_SIZE/2), blocks.get(i).getyPos() + (BLOCK_SIZE/2)),
														new HvlCoord(blocks.get(i).getxPos() + (BLOCK_SIZE/2), blocks.get(i).getyPos() - (BLOCK_SIZE/2)))!=null)
				{
					hasLineOfSight = false;			
				}
			}
		}
		return hasLineOfSight;
	}
	
	

	public int getBlockType() {
		return blockType;
	}

	public void setBlockType(int blockType) {
		this.blockType = blockType;
	}


}
/*
 * Levels are room based with randomly placed obstacles
 * After completing a room the player is given a choice of new rooms
 * Player has a general idea of what the next room contains/how difficult it is
 * Harder rooms give more rewards, shops and upgrades are semi-random
 * All paths converge to a final room(?)
 * Map system similar to slay the spire
 */
