import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int x, y, cx, cy, speed, size;
    private Color color;
    static final int maxSpeed = 10;
    
    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.color = color;
        this.size = size;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
    
    public void moveBall(){
        x += cx;
        y += cy;
    }
    
    public void bounceOffEdges(int top, int bottom){
    	if(y > bottom - size) {
    		reverseY();
    	}else if (y < top) {
    		reverseY();
		}
    	
    }
    
    public void increaseSpeed() {
    	if(speed < maxSpeed) {
    		speed++;
    		
    		if (cx > 0) {
				cx = speed;
			}else if (cx < 0) {
				cx = speed * -1;
			}
    		
    		if (cy > 0) {
				cy = speed;
			}else if (cy < 0) {
				cy = speed * -1;
			}
        }
    }
    
    public void reverseX(){
        cx *= -1;
    }
    
    public void reverseY(){
        cy *= -1;
    }
    
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCx() {
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
	}

	public int getCy() {
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSize() {
    	return size;
    }
    
}
