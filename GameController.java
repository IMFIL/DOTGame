import java.awt.List;
import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;




public class GameController implements ActionListener {
	int size;
	GameModel gm;
	GameView gv;
	Point [] pos;
	int steps = 0;
	ArrayList <Point> blocked = new ArrayList<Point>();
	
    public GameController(int size) {
    	this.size = size;
        pos = new Point [6];
        
        pos[0] = new Point(0,1);                   
        pos[1] = new Point(0,-1);
        pos[2] = new Point(1,1);
        pos[3] = new Point(1,0);
        pos[4] = new Point(-1,1);
        pos[5] = new Point(-1,0);                                                 
    }

  

    public void start(){
    	gm = new GameModel(size);
    	gv = new GameView(gm,this);
    	
    }

 

    public void reset(){
    	gm .reset();
    	gv.getBoardView().update();
    	steps = 0;
    }
    
    private ArrayList<Point> BlueMove(Point beg){
    	
    	 blocked = new ArrayList<Point>();
    	 
    	 
    	 MQueu <ArrayList<Point>> queu = new MQueu <ArrayList<Point>>();
    	 
    	 ArrayList <Point> tmp = new ArrayList <Point> ();
    	 
    	 ArrayList<Point> L = new ArrayList <Point> ();
    	 
         
         tmp.add(beg);
         
    	 queu.enqueu(tmp);
    	 
    	 tmp = new ArrayList <Point> ();
    	 
    	 ArrayList<Point> q;

    	 while (!queu.isEmpty()){
    		 q = new ArrayList<Point>();
    		 
    		 q = queu.dequeu();
    		 
    		 Point c = q.get(q.size() -1);
    		 L.add(c);
   		 
    		
     		 
    	   for (int i = 0; i < pos.length; i++){
    		   
   			int z = c.x;
   			
	  		  if ((z % 2 == 0)){ 
	    	        pos[0] = new Point(0,1);                   
	    	        pos[1] = new Point(0,-1);
	    	        pos[2] = new Point(1,0);
	    	        pos[3] = new Point(1,-1);
	    	        pos[4] = new Point(-1,0);
	    	        pos[5] = new Point(-1,-1);} 
	  		  
	  		  else{
	  	           pos[0] = new Point(0,1);                   
	  	           pos[1] = new Point(0,-1);
	  	           pos[2] = new Point(1,1);
	  	           pos[3] = new Point(1,0);
	  	           pos[4] = new Point(-1,1);
	  	           pos[5] = new Point(-1,0);    
	  		  }
	  		  
	   			int x = pos[i].x + c.x;
	   			int y = pos[i].y + c.y;
   			
    		if ( checkPath(x,y)){	  
    	       if (reachesPath(x,y)){
    	       q.add(new Point (x,y));
    	       return q;}
    	       else{
    	    	   tmp.addAll(q);
    	    	   tmp.add(new Point(x,y));
    	    	   queu.enqueu(tmp);
    	           blocked.add(new Point(x,y));
    	    	   tmp = new ArrayList <Point> ();

    	       }
    	     }
    	   }
    	 }
    	 return null;
    	}
    
    
    private boolean checkPath(int x , int y){

    	
    	boolean yellowOrno = true;
    	
    	for (int i =0; i < gm.points.length; i++){
    		for (int j =0; j < gm.points.length; j++){
    			
    		if (gm.points[i][j].x == x && gm.points[i][j].y == y){
    			if (!gm.points[i][j].getAvailble()){
    				yellowOrno = false;
    			}
    		}
    		}
    	}
    	
    	for (int i = 0; i < blocked.size();i++){
    		if (blocked.get(i).x == x && blocked.get(i).y == y){
    			yellowOrno = false;
    		}
    	}
    	
    	
    	return yellowOrno;
    }
    
    private boolean reachesPath(int x , int y){
    	if ( y == size -1 || x == 0 || y == 0 || x == size -1){
    		return true;
    	}

    return false;
    }
    
    
     public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "quit"){
        	System.exit(0);
        }
        else if (e.getActionCommand() == "reset"){
        	reset();
        }
        
        else{
        	DotButton db = (DotButton) e.getSource();
        	steps++;
        	
        	int r = db.getRow();
        	int c = db.getColumn();
        	
        	gm.select(r,c);
        	gv.getBoardView().update();
        	
        	BRPath point = new BRPath(gm,size,gm.getCurrentDot());   //Created a class that does the same thing but also implements the selection of  random shortest path 
        	Point tmp = point.GetBest();
        	
        	/*ArrayList <Point> tmpA = BlueMove(gm.getCurrentDot());*/
        	
        	if (tmp/*A*/ != null){
        		
           /* Point tmp = tmpA.get(1);*/
            

        	gm.setCurrentDot(tmp.x, tmp.y);
        	gv.getBoardView().update();
        	if (tmp.y == size -1 || tmp.y == 0 || tmp.x == 0 || tmp.x == size - 1){
        		gm.points[gm.getCurrentDot().x][gm.getCurrentDot().y].DOT = false;
        		gv.getBoardView().update();
        	    String[] options = new String[] {"Quit", "New Game",};
        	    int response = JOptionPane.showOptionDialog(null,"You lost. Would you like to play again?", "Lost",
        	        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null
        	        , options, options[0]);
        	    
        	    if (response == 0){
        	    	System.exit(0);
        	    }
        	    else{
        	    	reset();
        	    }
        	}
        	}
        	else{
        	    String[] options = new String[] {"Quit", "New Game",};
        	    int response = JOptionPane.showOptionDialog(null,"You won in " + steps + " steps. Would you like to play again ?", "Won",
        	        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null
        	        , options, options[0]);
        	    
        	    if (response == 0){
        	    	System.exit(0);
        	    }
        	    else{
        	    	reset();
        	    }
        	}
        }
        }

    }

 
