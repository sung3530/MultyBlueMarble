package MainSource;

public class dice {

		private int firstDice;
		private int secondDice;
		private boolean doubleState; 
		private int doubleCount;
		public boolean getDoubleState() {
			// TODO Auto-generated method stub
			return doubleState;
		}
		public int Rolling() {
			firstDice=(int)( Math.random()*6+1);
			secondDice=(int)( Math.random()*6+1);
			doubleState=false;
			System.out.println("first : "+firstDice+"secondice :"+secondDice+"\n");
			if(firstDice==secondDice)
				doubleState=true;
			
			return firstDice+secondDice;
			// TODO Auto-generated method stub
		}
}
