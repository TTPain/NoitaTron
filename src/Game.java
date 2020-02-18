import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

public class Game {

    public static Player player;
    public static Bullet bullet;

    public static void initialize(){
        player = new Player(Player.PLAYER_START_X, Player.PLAYER_START_Y);
        bullet = new Bullet(Player.PLAYER_START_X, Player.PLAYER_START_Y,1,1);
    }

    public static void update(float delta){
    player.update(delta);
    player.draw(delta);
    BulletFire.update(delta, player);

    if(bullet.isFired()) {
    bullet.draw(delta);

    }

}
}