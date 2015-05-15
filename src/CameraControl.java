/**
 * Created by lucaswebb on 5/15/15.
 */

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class CameraControl {
    private Vector3f position = null;
    private float yaw = 0.0f;
    private float pitch = 0.0f;

    public CameraControl(float x, float y, float z){
        position = new Vector3f(x,y,z);
    }

    public void incrementYaw(float amount){
        yaw +=amount;
    }

    public void incrementPitch(float amount){
        pitch += amount;
    }

    public void walkForward(float distance)
    {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw));
    }

    public void walkBackwards(float distance)
    {
        position.x += distance * (float)Math.sin(Math.toRadians(yaw));
        position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
    }

    public void strafeLeft(float distance)
    {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw-90));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw-90));
    }

    public void strafeRight(float distance)
    {
        position.x -= distance * (float)Math.sin(Math.toRadians(yaw+90));
        position.z += distance * (float)Math.cos(Math.toRadians(yaw+90));
    }
}