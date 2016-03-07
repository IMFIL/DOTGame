import java.util.ArrayList;
import java.util.*;

public class BRPath {
	
	ArrayList<Point> blocked;
    Point[] pos = new Point [6];
    GameModel gm;
    int size;
    Point beg;
    
   ArrayList <ArrayList <Point>> BestPaths;
   ArrayList <ArrayList <Point>> BestPath2 = new ArrayList<ArrayList<Point>>(); 
   ArrayList<Point> blocked2 = new ArrayList<Point>();

    public BRPath(GameModel GM, int S, Point beg){
    	this.beg = beg;
    	
        pos[0] = new Point(0,1);                   
        pos[1] = new Point(0,-1);
        pos[2] = new Point(1,1);
        pos[3] = new Point(1,0);
        pos[4] = new Point(-1,1);
        pos[5] = new Point(-1,0);
        
        gm = GM;
        
        size = S;

    }
    
    
    public Point GetBest(){
    	
    	Random random = new Random();
    	int tmp;
    	
    	int len;
    	BlueMove(beg);
    	ArrayList <ArrayList <Point>> equalminimal = new ArrayList <ArrayList <Point>>();
    	
    	if (BestPath2.size() == 0){
    		return null;
    	}
    	

    	else{
    		
    		len = BestPath2.get(0).size();

    	
    	
    	for(int i= 0; i < BestPath2.size();i++){
    		
    		if (BestPath2.get(i).size() < len){
    			
    			len = BestPath2.get(i).size();
    			
    		}

    	}
    	
    	for(int i = 0; i < BestPath2.size();i++){
    		if (BestPath2.get(i).size() == len){
    			equalminimal.add(BestPath2.get(i));
    		}
    	}
    	
    	
    	tmp = random.nextInt(equalminimal.size());
    	
    	return equalminimal.get(tmp).get(1);
    	
    	
  
    }
    }
  
  
    
    private ArrayList<Point> BlueMove(Point beg){
     blocked = new ArrayList<Point>();
	
     BestPaths = new ArrayList<ArrayList<Point>>();

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
   	       BestPaths.add(q);
   	       blocked2.addAll(q);
   	       BestPath2.addAll(BestPaths);
   	  
   	       BlueMove(beg);
   	       }
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
    	
    	for (int i = 0; i < blocked2.size();i++){
    		if (blocked2.get(i).x == x && blocked2.get(i).y == y){
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
    

}
