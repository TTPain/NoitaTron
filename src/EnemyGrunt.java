public class EnemyGrunt {
	
	public EnemyGrunt(float xPosArg, float yPosArg, boolean livingStateArg) {
		xPos = xPosArg;
		yPos = yPosArg;
		livingState = livingStateArg;
	}
	
	public static final float GRUNT_SIZE = 25;
	
	public float yPos = 0;
	public float xPos = 0;
	public boolean livingState = true;
	public static int gruntStutter=65;
	

	public void update(float delta, Player player) {
		
		//GRUNT SPEED
		if(livingState = true){
			if(player.getxPos() > xPos &&( gruntStutter==0 || gruntStutter==20)) {
				xPos = xPos + 12;
			}
			if(player.getxPos() < xPos && (gruntStutter==0 || gruntStutter==20)) {
				xPos = xPos - 12;
			}
			if(player.getyPos() > yPos && (gruntStutter==0 || gruntStutter==20)) {
				yPos = yPos + 12;
			}
			if(player.getyPos() < yPos && (gruntStutter==0 || gruntStutter==20)) {
				yPos = yPos - 12;
			}
		}
		//END GRUNT SPEED
		//GRUNT HITBOX
		if(((BulletFire.bullet1.getxPos() < xPos + 10) && (BulletFire.bullet1.getxPos() > xPos - 10) &&
			(BulletFire.bullet1.getyPos() < yPos + 10) && (BulletFire.bullet1.getyPos() > yPos - 10)) ||
			((BulletFire.bullet2.getxPos() < xPos + 10) && (BulletFire.bullet2.getxPos() > xPos - 10) &&
			(BulletFire.bullet2.getyPos() < yPos + 10) && (BulletFire.bullet2.getyPos() > yPos - 10)) ||
			((BulletFire.bullet2.getxPos() < xPos + 10) && (BulletFire.bullet2.getxPos() > xPos - 10) &&
			(BulletFire.bullet3.getyPos() < yPos + 10) && (BulletFire.bullet3.getyPos() > yPos - 10)) ||
			((BulletFire.bullet3.getxPos() < xPos + 10) && (BulletFire.bullet3.getxPos() > xPos - 10) &&
			(BulletFire.bullet4.getyPos() < yPos + 10) && (BulletFire.bullet4.getyPos() > yPos - 10)) ||
			((BulletFire.bullet4.getxPos() < xPos + 10) && (BulletFire.bullet4.getxPos() > xPos - 10) &&
			(BulletFire.bullet5.getyPos() < yPos + 10) && (BulletFire.bullet5.getyPos() > yPos - 10)) ||
			((BulletFire.bullet5.getxPos() < xPos + 10) && (BulletFire.bullet5.getxPos() > xPos - 10) &&
			(BulletFire.bullet6.getyPos() < yPos + 10) && (BulletFire.bullet6.getyPos() > yPos - 10)) || 
			((BulletFire.bullet7.getxPos() < xPos + 10) && (BulletFire.bullet7.getxPos() > xPos - 10) &&
			(BulletFire.bullet7.getyPos() < yPos + 10) && (BulletFire.bullet7.getyPos() > yPos - 10)) ||
			((BulletFire.bullet8.getxPos() < xPos + 10) && (BulletFire.bullet8.getxPos() > xPos - 10) &&
			(BulletFire.bullet8.getyPos() < yPos + 10) && (BulletFire.bullet8.getyPos() > yPos - 10))) {
			
			livingState = false;
		
		}
		//END GRUNT HITBOX
	}
		//GRUNT MOVEMENT
	public static void gruntMovementUpdate(float delta){
			if(gruntStutter==0) {
				gruntStutter=100;
			}
			if(gruntStutter>0) {
				gruntStutter=gruntStutter-1;
			}
	}
		//END GRUNT MOVEMENT

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




}
