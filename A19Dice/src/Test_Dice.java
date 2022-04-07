
class Dice
{
	private int diceFace;
	private int userGuess;

	
	public int getDiceFace() {
		return diceFace;
	}
	public void setDiceFace(int diceFace) {
		this.diceFace = diceFace;
	}
	public int getUserGuess() {
		return userGuess;
	}
	public void setUserGuess(int userGuess) {
		this.userGuess = userGuess;
	}
		
	
	
	/*
	public int getDiceFace()
	{
		return this.diceFace;
	}
	
	public void setDiceFace(int diceFace)
	{
		this.diceFace = diceFace;
	}
	
	
	
	public int getUserGuess()
	{
		return this.userGuess;
	}
	
	public void setUserGuess(int userGuess)
	{
		this.userGuess = userGuess;
	}
	*/
	
}




public class Test_Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dice myDice = new Dice();
		myDice.setDiceFace(1);
		
		System.out.println(myDice.getDiceFace());
		
		
		
		
		
		
		
		
		
	}

}
