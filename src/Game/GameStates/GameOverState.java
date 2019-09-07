package Game.GameStates;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;
import java.awt.*;

public class GameOverState extends State {
     private int count = 0;
    
     private UIManager uiManager;
     public GameOverState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);
        
     }
     @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
        count++;
        if( count>=30){
            count=30;
        }
        if(handler.getKeyManager().pbutt && count>=30){
            count=0;
             State.setState(handler.getGame().gameState);
        }
     }
     @Override
    public void render(Graphics g) {
        g.drawImage(Images.GameOver, 0, 0, 600, 600, null);
        uiManager.Render(g);
     }
}
