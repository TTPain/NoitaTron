package robotron2;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlSound;

import java.util.ArrayList;

import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;

import com.osreboot.ridhvl2.loader.HvlLoaderSound;

public class BulletFire {
	
	private static float bSpeedC = 1000;
	private static float bSpeedD = 700;

	private static int bulletDirection=0;
	
	private static float cooldown = 0.0f;
	private static float cooldownSpeed = 10;
		
	public static ArrayList<Bullet> bullets = new ArrayList<>();

											  //xArg, yArg, xSpeed, ySpeed, fired, drawn
	public static Bullet bullet1 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0, false, false);
	public static Bullet bullet2 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0, false, false);
	public static Bullet bullet3 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0, false, false);
	public static Bullet bullet4 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0, false, false);
	public static Bullet bullet5 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0, false, false);
	public static Bullet bullet6 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0, false, false);
	public static Bullet bullet7 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0, false, false);
	public static Bullet bullet8 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0, false, false);
	
	
	public static void initialize() {
		bullets.add(bullet1);
		bullets.add(bullet2);
		bullets.add(bullet3);
		bullets.add(bullet4);
		bullets.add(bullet5);
		bullets.add(bullet6);
		bullets.add(bullet7);
		bullets.add(bullet8);
	}
	
	
public static void update(float delta,Player player) {

if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
	bulletDirection=1;	
}

if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
	bulletDirection=5;	
}

if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
	bulletDirection=7;
}

if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
	bulletDirection=3;	
}

if(Keyboard.isKeyDown(Keyboard.KEY_UP) && (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))) {
	bulletDirection=2;	
}

if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))) {
	bulletDirection=4;	
}

if(Keyboard.isKeyDown(Keyboard.KEY_DOWN) && (Keyboard.isKeyDown(Keyboard.KEY_LEFT))) {
	bulletDirection=6;
}

if(Keyboard.isKeyDown(Keyboard.KEY_UP) && (Keyboard.isKeyDown(Keyboard.KEY_LEFT))) {
	bulletDirection=8;
}

if(cooldown>0) {
		cooldown = cooldown-(delta*cooldownSpeed);
}

if(cooldown<0) {
		cooldown=0;
}

//draw bullet if it is in playfield and make it move in the direction specified, below

if(bullet1.isFired()==false && bulletDirection>0 && (cooldown==0)) {
	bullet1.setFired(true);
	hvlSound(0).playAsSoundEffect(1, 1, false);
	if(cooldown==0) {
		cooldown=1;
	}
	if(bulletDirection==1) {
		bullet1.setySpeed(-bSpeedC);
		bullet1.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet1.setySpeed(-bSpeedD);
		bullet1.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==3) {
		bullet1.setySpeed(0);
		bullet1.setxSpeed(bSpeedC);
	}
	else if(bulletDirection==4) {
		bullet1.setySpeed(bSpeedD);
		bullet1.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==5) {
		bullet1.setySpeed(bSpeedC);
		bullet1.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet1.setySpeed(bSpeedD);
		bullet1.setxSpeed(-bSpeedD);
	}
	else if(bulletDirection==7) {
		bullet1.setySpeed(0);
		bullet1.setxSpeed(-bSpeedC);
	}
	else if(bulletDirection==8) {
		bullet1.setySpeed(-bSpeedD);
		bullet1.setxSpeed(-bSpeedD);
	}
}
	
if(bullet1.isBulletDrawn() && (bullet1.isFired()) && !(bullet2.isFired()) && bulletDirection>0 && cooldown==0 ) {
	bullet2.setFired(true);
	hvlSound(0).playAsSoundEffect(1, 1, false);
	if(cooldown==0) {
		cooldown=1;
	}
	if(bulletDirection==1) {
		bullet2.setySpeed(-bSpeedC);
		bullet2.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet2.setySpeed(-bSpeedD);
		bullet2.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==3) {
		bullet2.setySpeed(0);
		bullet2.setxSpeed(bSpeedC);
	}
	else if(bulletDirection==4) {
		bullet2.setySpeed(bSpeedD);
		bullet2.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==5) {
		bullet2.setySpeed(bSpeedC);
		bullet2.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet2.setySpeed(bSpeedD);
		bullet2.setxSpeed(-bSpeedD);
	}
	else if(bulletDirection==7) {
		bullet2.setySpeed(0);
		bullet2.setxSpeed(-bSpeedC);
	}
	else if(bulletDirection==8) {
		bullet2.setySpeed(-bSpeedD);
		bullet2.setxSpeed(-bSpeedD);
	}
}

if(bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet1.isFired() && bullet2.isFired() && !(bullet3.isFired()) && bulletDirection>0 && cooldown==0 ) {
	bullet3.setFired(true);
	hvlSound(0).playAsSoundEffect(1, 1, false);
	if(cooldown==0) {
		cooldown=1;
	}
	if(bulletDirection==1) {
		bullet3.setySpeed(-bSpeedC);
		bullet3.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet3.setySpeed(-bSpeedD);
		bullet3.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==3) {
		bullet3.setySpeed(0);
		bullet3.setxSpeed(bSpeedC);
	}
	else if(bulletDirection==4) {
		bullet3.setySpeed(bSpeedD);
		bullet3.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==5) {
		bullet3.setySpeed(bSpeedC);
		bullet3.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet3.setySpeed(bSpeedD);
		bullet3.setxSpeed(-bSpeedD);
	}
	else if(bulletDirection==7) {
		bullet3.setySpeed(0);
		bullet3.setxSpeed(-bSpeedC);
	}
	else if(bulletDirection==8) {
		bullet3.setySpeed(-bSpeedD);
		bullet3.setxSpeed(-bSpeedD);
	}
}



if(bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet1.isFired() && bullet2.isFired() && bullet3.isFired() && !(bullet4.isFired()) && bulletDirection>0 && cooldown==0 ) {
	bullet4.setFired(true);
	hvlSound(0).playAsSoundEffect(1, 1, false);
	if(bulletDirection==1) {
		bullet4.setySpeed(-bSpeedC);
		bullet4.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet4.setySpeed(-bSpeedD);
		bullet4.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==3) {
		bullet4.setySpeed(0);
		bullet4.setxSpeed(bSpeedC);
	}
	else if(bulletDirection==4) {
		bullet4.setySpeed(bSpeedD);
		bullet4.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==5) {
		bullet4.setySpeed(bSpeedC);
		bullet4.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet4.setySpeed(bSpeedD);
		bullet4.setxSpeed(-bSpeedD);
	}
	else if(bulletDirection==7) {
		bullet4.setySpeed(0);
		bullet4.setxSpeed(-bSpeedC);
	}
	else if(bulletDirection==8) {
		bullet4.setySpeed(-bSpeedD);
		bullet4.setxSpeed(-bSpeedD);
	}
	if(cooldown==0) {
		cooldown=1;
	}
}




if(bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet4.isBulletDrawn() && bullet1.isFired() && bullet2.isFired() && bullet3.isFired()
&& bullet4.isFired() && !(bullet5.isFired()) && bulletDirection>0 && cooldown==0 ) {
	bullet5.setFired(true);
	hvlSound(0).playAsSoundEffect(1, 1, false);
	if(bulletDirection==1) {
		bullet5.setySpeed(-bSpeedC);
		bullet5.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet5.setySpeed(-bSpeedD);
		bullet5.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==3) {
		bullet5.setySpeed(0);
		bullet5.setxSpeed(bSpeedC);
	}
	else if(bulletDirection==4) {
		bullet5.setySpeed(bSpeedD);
		bullet5.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==5) {
		bullet5.setySpeed(bSpeedC);
		bullet5.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet5.setySpeed(bSpeedD);
		bullet5.setxSpeed(-bSpeedD);
	}
	else if(bulletDirection==7) {
		bullet5.setySpeed(0);
		bullet5.setxSpeed(-bSpeedC);
	}
	else if(bulletDirection==8) {
		bullet5.setySpeed(-bSpeedD);
		bullet5.setxSpeed(-bSpeedD);
	}
	if(cooldown==0) {
		cooldown=1;
	}
}

if(bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet4.isBulletDrawn() && bullet5.isBulletDrawn() && bullet1.isFired() && bullet2.isFired() && bullet3.isFired()
	&& bullet4.isFired() && bullet5.isFired() && !(bullet6.isFired()) && bulletDirection>0 && cooldown==0 ) {
	bullet6.setFired(true);
	hvlSound(0).playAsSoundEffect(1, 1, false);
	if(bulletDirection==1) {
		bullet6.setySpeed(-bSpeedC);
		bullet6.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet6.setySpeed(-bSpeedD);
		bullet6.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==3) {
		bullet6.setySpeed(0);
		bullet6.setxSpeed(bSpeedC);
	}
	else if(bulletDirection==4) {
		bullet6.setySpeed(bSpeedD);
		bullet6.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==5) {
		bullet6.setySpeed(bSpeedC);
		bullet6.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet6.setySpeed(bSpeedD);
		bullet6.setxSpeed(-bSpeedD);
	}
	else if(bulletDirection==7) {
		bullet6.setySpeed(0);
		bullet6.setxSpeed(-bSpeedC);
	}
	else if(bulletDirection==8) {
		bullet6.setySpeed(-bSpeedD);
		bullet6.setxSpeed(-bSpeedD);
	}
	if(cooldown==0) {
		cooldown=1;
	}
}

if(bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet4.isBulletDrawn() && bullet5.isBulletDrawn() && bullet6.isBulletDrawn() && bullet1.isFired() && bullet2.isFired() && bullet3.isFired()
&& bullet4.isFired() && bullet5.isFired() && bullet6.isFired() && !(bullet7.isFired()) && bulletDirection>0 && cooldown==0 ) {
	bullet7.setFired(true);
	hvlSound(0).playAsSoundEffect(1, 1, false);
	if(bulletDirection==1) {
		bullet7.setySpeed(-bSpeedC);
		bullet7.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet7.setySpeed(-bSpeedD);
		bullet7.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==3) {
		bullet7.setySpeed(0);
		bullet7.setxSpeed(bSpeedC);
	}
	else if(bulletDirection==4) {
		bullet7.setySpeed(bSpeedD);
		bullet7.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==5) {
		bullet7.setySpeed(bSpeedC);
		bullet7.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet7.setySpeed(bSpeedD);
		bullet7.setxSpeed(-bSpeedD);
	}
	else if(bulletDirection==7) {
		bullet7.setySpeed(0);
		bullet7.setxSpeed(-bSpeedC);
	}
	else if(bulletDirection==8) {
		bullet7.setySpeed(-bSpeedD);
		bullet7.setxSpeed(-bSpeedD);
	}
	if(cooldown==0) {
		cooldown=1;
	}
}

if(bullet1.isBulletDrawn() && bullet2.isBulletDrawn() && bullet3.isBulletDrawn() && bullet4.isBulletDrawn() && bullet5.isBulletDrawn() && bullet6.isBulletDrawn() && bullet7.isBulletDrawn() && bullet1.isFired() && bullet2.isFired() && bullet3.isFired()
&& bullet4.isFired() && bullet5.isFired() && bullet6.isFired() && bullet7.isFired() && !(bullet8.isFired()) && bulletDirection>0 && cooldown==0 ) {
	bullet8.setFired(true);
	hvlSound(0).playAsSoundEffect(1, 1, false);
	if(bulletDirection==1) {
		bullet8.setySpeed(-bSpeedC);
		bullet8.setxSpeed(0);
	}
	else if(bulletDirection==2) {
		bullet8.setySpeed(-bSpeedD);
		bullet8.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==3) {
		bullet8.setySpeed(0);
		bullet8.setxSpeed(bSpeedC);
	}
	else if(bulletDirection==4) {
		bullet8.setySpeed(bSpeedD);
		bullet8.setxSpeed(bSpeedD);
	}
	else if(bulletDirection==5) {
		bullet8.setySpeed(bSpeedC);
		bullet8.setxSpeed(0);
	}
	else if(bulletDirection==6) {
		bullet8.setySpeed(bSpeedD);
		bullet8.setxSpeed(-bSpeedD);
	}
	else if(bulletDirection==7) {
		bullet8.setySpeed(0);
		bullet8.setxSpeed(-bSpeedC);
	}
	else if(bulletDirection==8) {
		bullet8.setySpeed(-bSpeedD);
		bullet8.setxSpeed(-bSpeedD);
	}
	if(cooldown==0) {
		cooldown=1;
	}
}

if(bullet1.isOnScreen()) {
	bullet1.setyPos(bullet1.getyPos()+(delta*bullet1.getySpeed()));
	bullet1.setxPos(bullet1.getxPos()+(delta*bullet1.getxSpeed()));
}
if(bullet1.isOnScreen() && bullet1.isFired()) {
	bullet1.draw(delta);
	bullet1.setBulletDrawn(true);
}
else {
	bullet1.setFired(false);
	bullet1.setxPos(player.getxPos());
	bullet1.setyPos(player.getyPos());
	bullet1.setxSpeed(0);
	bullet1.setySpeed(0);
	bulletDirection=0;
	bullet1.setBulletDrawn(false);
}


if(bullet2.isOnScreen()) {
	bullet2.setyPos(bullet2.getyPos()+(delta*bullet2.getySpeed()));
	bullet2.setxPos(bullet2.getxPos()+(delta*bullet2.getxSpeed()));
}
if(bullet2.isOnScreen() && bullet2.isFired()) {
	bullet2.draw(delta);
	bullet2.setBulletDrawn(true);
}
else {
	bullet2.setFired(false);
	bullet2.setxPos(player.getxPos());
	bullet2.setyPos(player.getyPos());
	bullet2.setxSpeed(0);
	bullet2.setySpeed(0);
	bulletDirection=0;
	bullet2.setBulletDrawn(false);
}

if(bullet3.isOnScreen()) {
	bullet3.setyPos(bullet3.getyPos()+(delta*bullet3.getySpeed()));
	bullet3.setxPos(bullet3.getxPos()+(delta*bullet3.getxSpeed()));
}
if(bullet3.isOnScreen() && bullet3.isFired()) {
	bullet3.draw(delta);
	bullet3.setBulletDrawn(true);
}
else {
	bullet3.setFired(false);
	bullet3.setxPos(player.getxPos());
	bullet3.setyPos(player.getyPos());
	bullet3.setxSpeed(0);
	bullet3.setySpeed(0);
	bulletDirection=0;
	bullet3.setBulletDrawn(false);
}

if(bullet4.isOnScreen()) {
	bullet4.setyPos(bullet4.getyPos()+(delta*bullet4.getySpeed()));
	bullet4.setxPos(bullet4.getxPos()+(delta*bullet4.getxSpeed()));
}
if(bullet4.isOnScreen() && bullet4.isFired()) {
	bullet4.draw(delta);
	bullet4.setBulletDrawn(true);
}
else {
	bullet4.setFired(false);
	bullet4.setxPos(player.getxPos());
	bullet4.setyPos(player.getyPos());
	bullet4.setxSpeed(0);
	bullet4.setySpeed(0);
	bulletDirection=0;
	bullet4.setBulletDrawn(false);
}

if(bullet5.isOnScreen()) {
	bullet5.setyPos(bullet5.getyPos()+(delta*bullet5.getySpeed()));
	bullet5.setxPos(bullet5.getxPos()+(delta*bullet5.getxSpeed()));
}
if(bullet5.isOnScreen() && bullet5.isFired()) {
	bullet5.draw(delta);
	bullet5.setBulletDrawn(true);
}
else {
	bullet5.setFired(false);
	bullet5.setxPos(player.getxPos());
	bullet5.setyPos(player.getyPos());
	bullet5.setxSpeed(0);
	bullet5.setySpeed(0);
	bulletDirection=0;
	bullet5.setBulletDrawn(false);
}

if(bullet6.isOnScreen()) {
	bullet6.setyPos(bullet6.getyPos()+(delta*bullet6.getySpeed()));
	bullet6.setxPos(bullet6.getxPos()+(delta*bullet6.getxSpeed()));
}
if(bullet6.isOnScreen() && bullet6.isFired()) {
	bullet6.draw(delta);
	bullet6.setBulletDrawn(true);
}
else {
	bullet6.setFired(false);
	bullet6.setxPos(player.getxPos());
	bullet6.setyPos(player.getyPos());
	bullet6.setxSpeed(0);
	bullet6.setySpeed(0);
	bulletDirection=0;
	bullet6.setBulletDrawn(false);
}

if(bullet7.isOnScreen()) {
	bullet7.setyPos(bullet7.getyPos()+(delta*bullet7.getySpeed()));
	bullet7.setxPos(bullet7.getxPos()+(delta*bullet7.getxSpeed()));
}
if(bullet7.isOnScreen() && bullet7.isFired()) {
	bullet7.draw(delta);
	bullet7.setBulletDrawn(true);
}
else {
	bullet7.setFired(false);
	bullet7.setxPos(player.getxPos());
	bullet7.setyPos(player.getyPos());
	bullet7.setxSpeed(0);
	bullet7.setySpeed(0);
	bulletDirection=0;
	bullet7.setBulletDrawn(false);
}

if(bullet8.isOnScreen()) {
	bullet8.setyPos(bullet8.getyPos()+(delta*bullet8.getySpeed()));
	bullet8.setxPos(bullet8.getxPos()+(delta*bullet8.getxSpeed()));
}
if(bullet8.isOnScreen() && bullet8.isFired()) {
	bullet8.draw(delta);
	bullet8.setBulletDrawn(true);
}
else {
	bullet8.setFired(false);
	bullet8.setxPos(player.getxPos());
	bullet8.setyPos(player.getyPos());
	bullet8.setxSpeed(0);
	bullet8.setySpeed(0);
	bulletDirection=0;
	bullet8.setBulletDrawn(false);
}
	
//System.out.println(bullet1.getxSpeed());
//System.out.println(cooldown);
} //End of Update




}
