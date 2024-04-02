import java.awt.*;
public class Paddle {
	private int height, x, y, speed;
    private Color color;
    static final int width = 15;
    //private int up, down;
    
	public Paddle(int x, int y, int height, int speed, Color color) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.speed = speed;
		this.color = color;
	}
    
	public void paint(Graphics g){
	    g.setColor(color);
	    g.fillRect(x, y, width, height);
	}
	
	public void moveTo(int toY) {
		int center = y + height/2;
		
		if (Math.abs(center - toY) > height/2) {
			if(center > toY){
				y -= speed;
				if (toY == height) {
					y += 1;
				}
			}
			
			if(center < toY){
				y += speed;
				if (600 == (toY - height)) {
					y -= 1;
				}
			}
		}
	}
	
	public boolean checkCollision(Ball b){
		int rightX = x + width;
	    int bottomY = y + height;
	    
	    if (b.getX() > (x - b.getSize()) && b.getX() < rightX) {
			if (b.getY() > y && b.getY() < bottomY) {
				return true;
			}
		}
	    return false;
	}
	
}
