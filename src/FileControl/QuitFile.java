/*QuitFile.java*/

package FileControl;

import cHabit.c;
import processControl.*;

public class QuitFile extends Quit {
	
	// ���S���ק�|���x�s���аO
	private static boolean haveChange = false;
	
	// haveChange �� getter �M setter
	public static boolean isItHaveChange() { return haveChange; }
	public static void setHaveChange(boolean input) { haveChange = input; }
	
	//�T��, �߰�, �ﶵ
	public void display() {
		c.ln();
		c.println("Since you have changes that have not been saved yet,");
		c.println("Area you sure Quit now?");
		c.println("1. Yes, Directly Quit and No Save.");
		c.println("2. Yes, but Save the changes.");
		c.println("3. No, go back, i want to do some change.");
		c.ln();
	}
	
	public void part() {
		
		// ���}�e���˴�, �˴����S���ק�|���x�s
		if(haveChange) {
			
			// �i�D�Τᦳ�ק�|���x�s, ���X�ﶵ, �߰�
			display();
			
			// ����Τ��J
			int choice = MyScanner.inputIntWithQuestionWithValueLimit(
					"Input your choose: ", //question
					1,					   //lowerLimit
					3);					   //UpperLimit
			
			// �����Τ��J���u�@
			switch(choice) {
			
			//�������}
			case 1: break;
			
			//�x�s�A���}
			case 2: new SaveFile().part(); break;
			
			//��^
			case 3: keepInThisLayer(); break;
			}
			
		}
		
		// �`�N QuitFile �~�ӤF Quit �ӨëD ProcessControl
		// �b selection() ���|�Q���� Quit, �q�{��^�W�@�h, �Y: Quit.setState(true);
		// �G�����ݭn�ե� backToUpperLayer(), �N�������}
		
	}

}
