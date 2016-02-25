package MainSource;

public class dice {

		private int firstDice;
		private int secondDice;
		private boolean doubleState; 
		public boolean getDoubleState() {
			// TODO Auto-generated method stub
			return doubleState;
		}
		public void Rolling() {
			firstDice=(int)( Math.random()*6+1);
			secondDice=(int)( Math.random()*6+1);
			doubleState=false;
			if(firstDice==secondDice)
				doubleState=true;
		
			// TODO Auto-generated method stub
		}
		public int getFirstDice(){
			return firstDice;
		}
		public int getSecondDice(){
			return secondDice;
		}
}
