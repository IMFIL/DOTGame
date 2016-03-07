
import javax.swing.*;
import java.awt.*;

public  class DotButton extends JButton {
	int row;
	int column;
	int type;
	
	ImageIcon image;


    public DotButton(int row, int column, int type) {
    	this.row = row;
    	this.column = column;
    	this.type = type; 
    	
    	if (type == 0){
    		image = new ImageIcon("DATA/ball-0.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    	
    	}
    	else if(type == 1){
    		image = new ImageIcon("DATA/ball-1.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    		setEnabled(false);
    		setDisabledIcon(image);
    	}
    	else if(type == 2){
    		image = new ImageIcon("DATA/ball-2.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    		setEnabled(false);
    		setDisabledIcon(image);

    	}

    }


	public void setType(int type) {
    	this.type = type;
    	
    	if (type == 0){
    		image = new ImageIcon("DATA/ball-0.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    	
    	}
    	else if(type == 1){
    		image = new ImageIcon("DATA/ball-1.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    		setEnabled(false);
    		setDisabledIcon(image);

    	}
    	else if(type == 2){
    		image = new ImageIcon("DATA/ball-2.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    		setEnabled(false);
    		setDisabledIcon(image);

    	}
    	
    }

    public int getRow() {
    	return row;
    }
    public int getColumn() {
    	return column;
    }
    

}