import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;

public class BulletFire {
	
	public static boolean fire1 = false;
	public static boolean fire2 = false;
	public static boolean fire3 = false;
	public static boolean fire4 = false;
	public static boolean fire5 = false;
	public static boolean fire6 = false;
	public static boolean fire7 = false;
	public static boolean fire8 = false;
	
	public static boolean b1drawn = false;
	public static boolean b2drawn = false;
	public static boolean b3drawn = false;
	public static boolean b4drawn = false;
	public static boolean b5drawn = false;
	public static boolean b6drawn = false;
	public static boolean b7drawn = false;
	public static boolean b8drawn = false;
	
	private static float bSpeedC = 1000;
	private static float bSpeedD = 700;

	private static int bulletDirection=0;
	private static float cooldown = 0.0f;
	private static float cooldownSpeed = 10;

	static Bullet bullet1 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet2 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet3 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet4 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet5 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet6 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet7 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	static Bullet bullet8 = new Bullet(Game.player.getxPos(),Game.player.getyPos(),0,0);
	
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

if(fire1==false && bulletDirection>0 && (cooldown==0)) {
	fire1=true;
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
	
if(b1drawn==true && fire1==true && fire2==false && bulletDirection>0 && cooldown==0 ) {
	fire2=true;
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

if(b1drawn==true && b2drawn==true && fire1==true && fire2==true && fire3==false && bulletDirection>0 && cooldown==0 ) {
	fire3=true;
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



if(b1drawn==true && b2drawn==true && b3drawn==true && fire1==true && fire2==true && fire3==true && fire4==false && bulletDirection>0 && cooldown==0 ) {
	fire4=true;
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




if(b1drawn==true && b2drawn==true && b3drawn==true && b4drawn==true && fire1==true && fire2==true && fire3==true
&& fire4==true && fire5==false && bulletDirection>0 && cooldown==0 ) {
	fire5=true;
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

if(b1drawn==true && b2drawn==true && b3drawn==true && b4drawn==true && b5drawn == true && fire1==true && fire2==true && fire3==true
	&& fire4==true && fire5==true && fire6==false && bulletDirection>0 && cooldown==0 ) {
	fire6=true;
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

if(b1drawn==true && b2drawn==true && b3drawn==true && b4drawn==true && b5drawn == true && b6drawn == true && fire1==true && fire2==true && fire3==true
&& fire4==true && fire5==true && fire6==true && fire7==false && bulletDirection>0 && cooldown==0 ) {
	fire7=true;
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

if(b1drawn==true && b2drawn==true && b3drawn==true && b4drawn==true && b5drawn==true && b6drawn==true && b7drawn==true && fire1==true && fire2==true && fire3==true
&& fire4==true && fire5==true && fire6==true && fire7==true && fire8==false && bulletDirection>0 && cooldown==0 ) {
	fire8=true;
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
if(bullet1.isOnScreen() && fire1==true) {
	bullet1.draw(delta);
	b1drawn=true;
}
else {
	fire1=false;
	bullet1.setxPos(player.getxPos());
	bullet1.setyPos(player.getyPos());
	bullet1.setxSpeed(0);
	bullet1.setySpeed(0);
	bulletDirection=0;
	b1drawn=false;
}


if(bullet2.isOnScreen()) {
	bullet2.setyPos(bullet2.getyPos()+(delta*bullet2.getySpeed()));
	bullet2.setxPos(bullet2.getxPos()+(delta*bullet2.getxSpeed()));
}
if(bullet2.isOnScreen() && fire2==true) {
	bullet2.draw(delta);
	b2drawn = true;
}
else {
	fire2=false;
	bullet2.setxPos(player.getxPos());
	bullet2.setyPos(player.getyPos());
	bullet2.setxSpeed(0);
	bullet2.setySpeed(0);
	bulletDirection=0;
	b2drawn = false;
}

if(bullet3.isOnScreen()) {
	bullet3.setyPos(bullet3.getyPos()+(delta*bullet3.getySpeed()));
	bullet3.setxPos(bullet3.getxPos()+(delta*bullet3.getxSpeed()));
}
if(bullet3.isOnScreen() && fire3==true) {
	bullet3.draw(delta);
	b3drawn = true;
}
else {
	fire3=false;
	bullet3.setxPos(player.getxPos());
	bullet3.setyPos(player.getyPos());
	bullet3.setxSpeed(0);
	bullet3.setySpeed(0);
	bulletDirection=0;
	b3drawn = false;
}

if(bullet4.isOnScreen()) {
	bullet4.setyPos(bullet4.getyPos()+(delta*bullet4.getySpeed()));
	bullet4.setxPos(bullet4.getxPos()+(delta*bullet4.getxSpeed()));
}
if(bullet4.isOnScreen() && fire4==true) {
	bullet4.draw(delta);
	b4drawn = true;
}
else {
	fire4=false;
	bullet4.setxPos(player.getxPos());
	bullet4.setyPos(player.getyPos());
	bullet4.setxSpeed(0);
	bullet4.setySpeed(0);
	bulletDirection=0;
	b4drawn = false;
}

if(bullet5.isOnScreen()) {
	bullet5.setyPos(bullet5.getyPos()+(delta*bullet5.getySpeed()));
	bullet5.setxPos(bullet5.getxPos()+(delta*bullet5.getxSpeed()));
}
if(bullet5.isOnScreen() && fire5==true) {
	bullet5.draw(delta);
	b5drawn = true;
}
else {
	fire5=false;
	bullet5.setxPos(player.getxPos());
	bullet5.setyPos(player.getyPos());
	bullet5.setxSpeed(0);
	bullet5.setySpeed(0);
	bulletDirection=0;
	b5drawn = false;
}

if(bullet6.isOnScreen()) {
	bullet6.setyPos(bullet6.getyPos()+(delta*bullet6.getySpeed()));
	bullet6.setxPos(bullet6.getxPos()+(delta*bullet6.getxSpeed()));
}
if(bullet6.isOnScreen() && fire6==true) {
	bullet6.draw(delta);
	b6drawn = true;
}
else {
	fire6=false;
	bullet6.setxPos(player.getxPos());
	bullet6.setyPos(player.getyPos());
	bullet6.setxSpeed(0);
	bullet6.setySpeed(0);
	bulletDirection=0;
	b6drawn = false;
}

if(bullet7.isOnScreen()) {
	bullet7.setyPos(bullet7.getyPos()+(delta*bullet7.getySpeed()));
	bullet7.setxPos(bullet7.getxPos()+(delta*bullet7.getxSpeed()));
}
if(bullet7.isOnScreen() && fire7==true) {
	bullet7.draw(delta);
	b7drawn = true;
}
else {
	fire7=false;
	bullet7.setxPos(player.getxPos());
	bullet7.setyPos(player.getyPos());
	bullet7.setxSpeed(0);
	bullet7.setySpeed(0);
	bulletDirection=0;
	b7drawn = false;
}

if(bullet8.isOnScreen()) {
	bullet8.setyPos(bullet8.getyPos()+(delta*bullet8.getySpeed()));
	bullet8.setxPos(bullet8.getxPos()+(delta*bullet8.getxSpeed()));
}
if(bullet8.isOnScreen() && fire8==true) {
	bullet8.draw(delta);
	b8drawn = true;
}
else {
	fire8=false;
	bullet8.setxPos(player.getxPos());
	bullet8.setyPos(player.getyPos());
	bullet8.setxSpeed(0);
	bullet8.setySpeed(0);
	bulletDirection=0;
	b8drawn = false;
}
	
//System.out.println(bullet1.getxSpeed());
//System.out.println(cooldown);
} //End of Update




}
