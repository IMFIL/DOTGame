
 class Point {
	 int x;
	 int y;
	 
	 protected boolean selected;
	 protected boolean DOT;
	 protected boolean available;
	 


    public Point(int x, int y){
    	this.x = x;
    	this.y = y;
    	
    	selected = false;
    	DOT = false;
    	available = false;
    }


    public int getX(){ 
    	return this.x;
    }
    

    public int getY(){
    	return this.y;
    }

    public void reset(int x, int y){
    	this.x = x;
    	this.y = y;
    	
    	selected = false;
    	DOT = false;
    	available = false;
    }
    
    
    protected void setSelected(){
    	this.selected = true;
    	this.available = false;
    	
    }
     protected void setDOT(){
    	this.DOT = true;
    	this.available = false;
    }
     protected void setAvailable(){
    	this.available = true;
    }
    
     protected boolean getSelected(){
    	return this.selected;
    	
    }
     protected boolean getDOT(){
    	return this.DOT;
    }
     protected boolean getAvailble(){
    	return this.available;
    }
     protected boolean isEqual(Point other){
    	 boolean ST = true;
    	 if (!(this.x == other.x && this.y == other.y)){
    		 ST = false;
    	 }
    	 
    	 return ST;
     }

 }