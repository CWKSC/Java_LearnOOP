/*Quit.java*/

package processControl;

public class Quit extends ProcessControl{
	
	// �O�_��^�W�@�h���аO
	private static boolean quitState = false;
	
	// quitState �� getter �M setter
	public static boolean getState() { return quitState; }
	public static void setState(boolean input) { quitState = input; }
	
	// �S������u�@, �@���Q instanceof �ˬd���s�b, �q�{�аO��^�W�@�h
	// �i�Ѭ� ProcessControl ���� selection
	public void part() { }
	
}
