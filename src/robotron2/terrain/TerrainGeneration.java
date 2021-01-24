package robotron2.terrain;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLine;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.HvlMath;
import com.osreboot.ridhvl2.menu.HvlMenu;

import robotron2.Game;
import robotron2.menu.MenuManager;

public class TerrainGeneration {

	public static ArrayList<Block> blocks = new ArrayList<Block>();
	

	
	
	public static Block sampleBlock = new Block(500, 500, true);
	public static Block sampleBlock2 = new Block(600, 600, true);
	public static Block sampleBlock3 = new Block(500, 600, false);
	
	public static void loadBlocks() {
		if(Game.level == 0) {
		//blocks.add(sampleBlock);
		//blocks.add(sampleBlock2);
		//blocks.add(sampleBlock3);
		}else {
			blocks.clear();
			blocks = LevelLoader.blocks;
		}
	}
	
	public static void update() {
		
		System.out.println(blocks.size());
		if(HvlMenu.top() == MenuManager.game) {
			for(int i = 0; i < blocks.size(); i++) {
				//Draw the block
				if(blocks.get(i).getCollidable()) {
					hvlDraw(hvlQuadc(blocks.get(i).getxPos(), blocks.get(i).getyPos(), Block.BLOCK_SIZE, Block.BLOCK_SIZE), Color.blue);
				}else {
					hvlDraw(hvlQuadc(blocks.get(i).getxPos(), blocks.get(i).getyPos(), Block.BLOCK_SIZE, Block.BLOCK_SIZE), Color.gray);	
				}
								
				//Devmode Lines
				if(Game.devMode) {
				hvlDraw(hvlLine(new HvlCoord(blocks.get(i).getxPos() - (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() - (Block.BLOCK_SIZE/2)), new HvlCoord(blocks.get(i).getxPos() + (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() - (Block.BLOCK_SIZE/2)), 3), Color.orange);
				hvlDraw(hvlLine(new HvlCoord(blocks.get(i).getxPos() - (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() - (Block.BLOCK_SIZE/2)), new HvlCoord(blocks.get(i).getxPos() - (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() + (Block.BLOCK_SIZE/2)), 3), Color.orange);
				hvlDraw(hvlLine(new HvlCoord(blocks.get(i).getxPos() + (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() + (Block.BLOCK_SIZE/2)), new HvlCoord(blocks.get(i).getxPos() - (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() + (Block.BLOCK_SIZE/2)), 3), Color.orange);
				hvlDraw(hvlLine(new HvlCoord(blocks.get(i).getxPos() + (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() + (Block.BLOCK_SIZE/2)), new HvlCoord(blocks.get(i).getxPos() + (Block.BLOCK_SIZE/2), blocks.get(i).getyPos() - (Block.BLOCK_SIZE/2)), 3), Color.orange);
				}
				
			}
		}
		

	}
	
}
