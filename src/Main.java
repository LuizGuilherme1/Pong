import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
	static JFrame f = new JFrame("Pong");
	static final int Width = 820, Height = 640;
	
    public static void main(String[] args) {
    	String resposta1 = JOptionPane.showInputDialog("voce quer ser o jogador da esquerda? [y/n]");
    	System.out.print(resposta1);
    	
    	String resposta2 = JOptionPane.showInputDialog("voce quer ser o vermelho? [y/n]");
    	System.out.println(resposta2);
    	
    	Game game = new Game(resposta1, resposta2);
    	
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(Width,Height);
        f.setMinimumSize(new Dimension(Width,Height));
        f.setLocationRelativeTo(null);
        
        f.add(game);
        f.setVisible(true);
        
        //
        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	game.gameLogic();
                game.repaint();
            }
        });
        //
        
        timer.start();
	}
    
    }
