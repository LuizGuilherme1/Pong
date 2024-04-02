import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
public class Game extends JPanel implements MouseMotionListener{
	static final int WIDTH = 800, HEIGHT = 600;
	private Ball gameBall;
	private Paddle player1, player2;
	private int esq = 30;
	private int dir = 760;
	private Color red = Color.RED;
	private Color blue = Color.BLUE;
	private int userMouseY;
	private int p1Score, p2Score;
	private int bounceCount;
	private boolean p1Choice1, p2Choice1, p1Choice2, p2Choice2;
	
	public Game(String resposta1, String resposta2) {
		this.choice1(resposta1);
		this.choice2(resposta2);
		
	    gameBall = new Ball(WIDTH/2, HEIGHT/2, 5, 5, 5, Color.YELLOW, 10);
	    player1 = new Paddle(esqOuDir(p1Choice1), (HEIGHT/2), 75, 3, redOrBlue(p1Choice2));
	    player2 = new Paddle(esqOuDir(p2Choice1), (HEIGHT/2), 75, 3, redOrBlue(p2Choice2));
	    userMouseY = 0;
	    
	    bounceCount = 0;
	    p1Score = 0; p2Score = 0;
	    
	    addMouseMotionListener(this);
	}
	
	public void choice1(String choice1) {
		if (choice1.equals("y")) {
			p1Choice1 = true;
			p2Choice1 = false;
		}else {
			p1Choice1 = false;
			p2Choice1 = true;
		}
	}
	
	public void choice2(String choice2) {
		if (choice2.equals("y")) {
			p1Choice2 = true;
			p2Choice2 = false;
		}else {
			p1Choice2 = false;
			p2Choice2 = true;
		}
	}
	
	public int esqOuDir(boolean choice1) {
		if (choice1 == true) {
			return esq;
		}else{
			return dir;
		}
	}
	
	public Color redOrBlue(boolean choice2) {
		if (choice2 == true) {
			return red;
		}else {
			return blue;
		}
	}
	
	public void gameLogic(){
	    gameBall.moveBall();
	    gameBall.bounceOffEdges(0, HEIGHT);
	    player1.moveTo(userMouseY);
	    player2.moveTo(gameBall.getY());
	    if(player1.checkCollision(gameBall) || player2.checkCollision(gameBall)) {
	    	gameBall.reverseX();
	    	bounceCount++;
	    }
	    if(bounceCount == 5) {
	    	bounceCount=0;
	    	gameBall.increaseSpeed();
	    }
	    
	    if (p1Choice1 == true) {
	    	if(gameBall.getX() < 0){
		        p2Score++;
		        reset();
		    }else if(gameBall.getX() > WIDTH){
		        p1Score++;
		        reset();
		    }
		}else {
			if(gameBall.getX() > WIDTH){
		        p2Score++;
		        reset();
		    }else if(gameBall.getX() < 0){
		        p1Score++;
		        reset();
		    }
		}
	}
	
	public void reset(){
        gameBall.setX(WIDTH/2);
        gameBall.setY(HEIGHT/2);
        gameBall.setCx(5);
        gameBall.setCy(5);
        gameBall.setSpeed(5);
        bounceCount = 0;
    }
	
	public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        gameBall.paint(g);
        player1.paint(g);
        player2.paint(g);
        g.setColor(Color.WHITE);
        g.drawString("Score - P1 [ " + p1Score + " ]   P2 [ " + p2Score + " ]", 350, 20);
    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		userMouseY = e.getY();
		
	}
}
