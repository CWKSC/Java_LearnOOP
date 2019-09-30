/*MainMenu.java*/

import cHabit.c;
import processControl.*;

public class MainMenu extends ProcessControl {
	
	public void display() {
		c.ln();
		c.println("1. Create new empty file");
		c.println("2. Load exist file");
		c.println("3. Delect exist file");
		c.println("4. Quit");
		c.ln();
	}
	
	public void part() {
		
		// ��ܿﶵ, �D����
		display();
		
		// �߰�, ����Τ��J, ����������i�{
		selection(new CreateNewEmptyFile(),
				  new LoadExistFile(),
				  new DelectExistFile(),
				  new Quit());
	}
	
}
