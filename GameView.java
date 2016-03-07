import java.awt.*;
import javax.swing.*;


public class GameView  extends JFrame{
	GameModel model;
	private BoardView bv;
	GameController gc;



	
      public GameView ( GameModel model, GameController gameController){
    	  
    	super("Dot!");
		this.model = model;
		gc = gameController;
		bv = new BoardView(model,gameController);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		JButton quit = new JButton("Quit");
		JButton reset = new JButton ("reset");
		
		quit.addActionListener(gameController);
		reset.addActionListener(gameController);
		
		quit.setActionCommand("quit");
		reset.setActionCommand("reset");

		
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		
		bottom.add(reset);
		bottom.add(quit);
		
		
		add(bottom,BorderLayout.SOUTH);
		add(bv,BorderLayout.CENTER);
		pack();
		setVisible(true);
		

      }
      public BoardView getBoardView(){
    		  return bv;
      }
      
      
}
