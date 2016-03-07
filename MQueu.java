import java.util.LinkedList;
//Implemented using LinkedList, made my own class to practice queues and to avoid confusion in the GameController Class  

public class MQueu<E> {
	LinkedList<E> MList;
	
	public MQueu(){
		MList = new LinkedList<E>();
		
	}
	
	public void enqueu(E add){
		MList.addLast(add);
	}
	
	public E dequeu(){
		return MList.poll();
	}
	public boolean isEmpty(){
		return MList.isEmpty();
	}
}
