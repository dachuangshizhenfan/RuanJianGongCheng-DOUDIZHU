package model;

public class GameUtil {

	public static void move(PokerLabel pokerLabel,int x,int y)
	{
		 pokerLabel.setLocation(x, y);
		 
		 try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void move2(PokerLabel pokerLabel,int x,int y)
	{
		 pokerLabel.setLocation(x, y);
		 
		
	}
	
	
}
