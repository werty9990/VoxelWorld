/**
 * Created by lucaswebb on 5/15/15.
 */

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class GameLoop {
    public void start(){
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        initGL(); // init OpenGL

        while (!Display.isCloseRequested()) {
            renderGL();

            Display.update();
            Display.sync(60); // cap fps to 60fps
        }

        Display.destroy();
    }

    public void update(){

    }

    public void initGL(){
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 0, 600, 600, -600);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public void renderGL() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        Block b = new Block(0,0,0,1,1,1,1);
        b.render();
    }

    public static void main(String[] args){
        GameLoop loop = new GameLoop();
        loop.start();
    }
}