import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;

public class EnemyGrunt {
	
	public EnemyGrunt(float xPosArg, float yPosArg, boolean livingStateArg, int stutterArg, int textureArg) {
		xPos = xPosArg;
		yPos = yPosArg;
		livingState = livingStateArg;
		gruntStutter = stutterArg;
		gruntTexture = textureArg;
	}
	
	public static final float GRUNT_SIZE = 25;
	
	public float yPos = 0;
	public float xPos = 0;
	public boolean livingState = true;
	public int gruntStutter = 0;
	public int gruntTexture;
	
	//
	
	private boolean movedThisFrame;
	
	public void update(float delta, Player player) {
		
		movedThisFrame = false;
		//GRUNT MOVEMENT AND SPRITE CHANGE
		if(livingState = true){
			if(player.getxPos() > xPos &&( gruntStutter==0 || gruntStutter==20)) {
				xPos = xPos + 12;
				if(gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				}else if(gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			}
			else if(player.getxPos() < xPos && (gruntStutter==0 || gruntStutter==20)) {
				xPos = xPos - 12;
				if(gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				}else if(gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			}
			if(player.getyPos() > yPos && (gruntStutter==0 || gruntStutter==20)) {
				yPos = yPos + 12;
				if(gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				}else if(gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			}
			else if(player.getyPos() < yPos && (gruntStutter==0 || gruntStutter==20)) {
				yPos = yPos - 12;
				if(gruntTexture == 4 && movedThisFrame == false) {
					gruntTexture = 5;
					movedThisFrame = true;
				}else if(gruntTexture == 5 && movedThisFrame == false) {
					gruntTexture = 4;
					movedThisFrame = true;
				}
			}
		}
		//END MOVEMENT AND SPRITE CHANGE
		//GRUNT HITBOX
		if(((BulletFire.bullet1.getxPos() < xPos + 15) && (BulletFire.bullet1.getxPos() > xPos - 15) &&
			(BulletFire.bullet1.getyPos() < yPos + 15) && (BulletFire.bullet1.getyPos() > yPos - 15))){
				livingState = false;
				BulletFire.fire1 = false;
				BulletFire.b1drawn=false;
			}
			if((BulletFire.bullet2.getxPos() < xPos + 15) && (BulletFire.bullet2.getxPos() > xPos - 15) &&
			(BulletFire.bullet2.getyPos() < yPos + 15) && (BulletFire.bullet2.getyPos() > yPos - 15)) {
				livingState = false;
				BulletFire.fire2 = false;
				BulletFire.b2drawn=false;
				
			}
			if((BulletFire.bullet3.getxPos() < xPos + 15) && (BulletFire.bullet3.getxPos() > xPos - 15) &&
			(BulletFire.bullet3.getyPos() < yPos + 15) && (BulletFire.bullet3.getyPos() > yPos - 15)) {
				livingState = false;
				BulletFire.fire3 = false;
				BulletFire.b3drawn=false;
				
			}
			if((BulletFire.bullet4.getxPos() < xPos + 15) && (BulletFire.bullet4.getxPos() > xPos - 15) &&
			(BulletFire.bullet4.getyPos() < yPos + 15) && (BulletFire.bullet4.getyPos() > yPos - 15)){
				livingState = false;
				BulletFire.fire4 = false;
				BulletFire.b4drawn=false;
				
			}
			if((BulletFire.bullet5.getxPos() < xPos + 15) && (BulletFire.bullet5.getxPos() > xPos - 15) &&
			(BulletFire.bullet5.getyPos() < yPos + 15) && (BulletFire.bullet5.getyPos() > yPos - 15)) {
				livingState = false;
				BulletFire.fire5 = false;
				BulletFire.b5drawn=false;
				
			}
			if((BulletFire.bullet6.getxPos() < xPos + 15) && (BulletFire.bullet6.getxPos() > xPos - 15) &&
			(BulletFire.bullet6.getyPos() < yPos + 15) && (BulletFire.bullet6.getyPos() > yPos - 15)) {
				livingState = false;
				BulletFire.fire6 = false;
				BulletFire.b6drawn=false;
				
			}
			if((BulletFire.bullet7.getxPos() < xPos + 15) && (BulletFire.bullet7.getxPos() > xPos - 15) &&
			(BulletFire.bullet7.getyPos() < yPos + 15) && (BulletFire.bullet7.getyPos() > yPos - 15)) {
				livingState = false;
				BulletFire.fire7 = false;
				BulletFire.b7drawn=false;
				
			}
			if((BulletFire.bullet8.getxPos() < xPos + 15) && (BulletFire.bullet8.getxPos() > xPos - 15) &&
			(BulletFire.bullet8.getyPos() < yPos + 15) && (BulletFire.bullet8.getyPos() > yPos - 15)) {
				livingState = false;
				BulletFire.fire8 = false;
				BulletFire.b8drawn=false;
		
		}
		//END GRUNT HITBOX
		//GRUNT STUTTER SPEED
		if(gruntStutter==0) {
			gruntStutter=100;
		}
		else{
			gruntStutter=gruntStutter-1;
		}
	}
		//END GRUNT STUTTER SPEED
		

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
