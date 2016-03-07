
public class CircleTheDot {


     public static void main(String[] args) {
        int size = 9;
        if (args.length == 1) {
            try{
                size = Integer.parseInt(args[0]);
                if(size<4){
                    System.out.println("Invalide argument, using default...");
                    size = 9;
                }
            } catch(NumberFormatException e){
                System.out.println("Invalide argument, using default...");
            }
        }
        GameController game = new GameController(size);
        StudentInfo.display();
        game.start();
    }
     
     
     public static class StudentInfo {


    	    public static void display() {

    		System.out.println("************************************************************");
    		System.out.println("*    Names:  Filip Slatinac and Anthony A.Nader            *");
    		System.out.println("*       ID:  8273487            8426875                    *");
    		System.out.println("*Section B:  ITI1121B           ITI1121B                   *");
    		System.out.println("*                                                          *");
    		System.out.println("************************************************************");
    		System.out.println();

    	    }

    	}


}