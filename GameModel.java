import java.util.Random;


public class GameModel {
    protected Point [][] points;
 	public static final int AVAILABLE 	= 0;
	public static final int SELECTED 	= 1;
	public static final int DOT 		= 2;
	
	protected int size;
	protected int steps = 0;


    public GameModel(int size) {
    	this.size = size;
    	playG();
    }



    public void reset(){
    	steps = 0;
    	playG();
    	

    }


 
    public  int getSize(){
    	return size;
   }

  
    public int getCurrentStatus(int i, int j){
    	if (points ==null){
    		return -1;}
    	if (points[i][j].getDOT()){
    		return DOT;
    	}
    	else if(points[i][j].getSelected()){
    		return SELECTED;
    	}
    	return AVAILABLE;
    }



    public void select(int i, int j){
    	if (points != null){
    		if (points[i][j].getDOT() || points[i][j].getSelected()){
    			
    		}
    		else{
    			points[i][j].setSelected();
    			steps++;
    		}
    	
    }
    }

    
 
    public void setCurrentDot(int i, int j){
        if ( i != -1){
    	for (int t = 0; t < size; t++){
    		for (int w = 0; w < size; w++){
    			if (points[t][w].getDOT()){
    				points[t][w].reset(t,w);
    				points[t][w].setAvailable();
    			}
    		}
    	}
    	
    	points[i][j].setDOT();

   }
    }

 
    public Point getCurrentDot(){
    	Point tmp = null;
    	for ( int i = 0; i< size;i++){
    		for (int j = 0; j < size; j ++){
    			if (points[i][j].getDOT()){
    				return points[i][j];
    			}
    		}
    	}
    	
    	return tmp;

    }

  
    public int getNumberOfSteps(){
    	return steps;

    }
    
    private void playG(){
		Random odds = new Random();
		int chance = odds.nextInt(5);
        points = new Point[size][size];
        Point [] tmp = new Point [size];
    	
    	for (int i = 0; i < size; i++ ){
    		for(int j = 0; j< size; j++){
    			tmp[j] = new Point(i,j);
    		}
    		points[i] = tmp;
    		tmp = new Point[size];
	
    	}
    	
    	if (size%2 == 0){
    		Random random1 = new Random();
    		int blue = random1.nextInt(4);
    		
    		if (blue == 0){
    			points[size/2 -1][size/2 -1].setDOT();
    			}
    		
    		else if (blue == 1){
    			points[size/2 -1][size/2].setDOT();
    		}
    		
    		else if(blue == 2){
    			points[size/2][size/2 -1].setDOT();
    		}
    		
    		else{
    			points[size/2][size/2].setDOT();
    		}
    		
    		}
    	
    	else{
    		Random random1 = new Random();
    		int blue = random1.nextInt(9);
    		
    		if (blue == 0){
    			points[(int)size/2 -1][(int)size/2 -1].setDOT();
    		}
    		
    		else if (blue == 1){
    			points[(int)size/2 -1][(int)size/2].setDOT();

    		}
    		
    		else if (blue == 2){
    			points[(int)size/2 -1][(int)size/2 +1].setDOT();

    		}
    		else if (blue == 3){
    			points[(int)size/2][(int)size/2 -1].setDOT();

    		}
    		
    		else if (blue == 4){
    			points[(int)size/2][(int)size/2].setDOT();

    		}
    		
    		else if (blue == 5){
    			points[(int)size/2][(int)size/2 +1].setDOT();

    		}
    		
    		else if (blue == 6){
    			points[(int)size/2 +1][(int)size/2 -1].setDOT();

    		}
    		
    		else if (blue == 7){
    			points[(int)size/2 +1][(int)size/2].setDOT();

    		}
    		
    		else {
    			points[(int)size/2 +1][(int)size/2 +1].setDOT();
    		}

    	}
    	for (int i = 0; i < size; i++){
    		for ( int j = 0; j < size; j++){
    			Random cb = new Random();
    			int combo = cb.nextInt(10);
    			if (combo == chance && !(points[i][j].getDOT())){
    				points[i][j].setSelected();
    			}
    		}
    	}
    	
    	for (int i  = 0; i < size; i++){
    		for (int j = 0; j < size; j++){
    			if (!(points[i][j].getDOT() || points[i][j].getSelected())){
    				points[i][j].setAvailable();
    			}
    		}
    	}
    }

}