/*ProcessControl.java*/

package processControl;

import cHabit.c;

public abstract class ProcessControl{
	// �i�{�ݭn��{������u�@����
	public abstract void part();
	
	// �i�{�Ȱ�
	public void SystemPause() {
		System.out.print("\nPress Enter To Continue...");
		MyScanner.sc.nextLine();
	}
	
	// �]�w�O�_��^�W�@�h���аO //
	public void backToUpperLayer() { Quit.setState(true); }
	public void keepInThisLayer() { Quit.setState(false); }
	
	// �B������i�{������, ���O�b�`����, ���ܪ�^�W�@�h���аO���u
	public void startPart() {
		do {
			part();
		}while(!Quit.getState());
		Quit.setState(false);
	}
	
	// ��ܶi�{
	public void selection(ProcessControl... selectcase) {
		// ����Τ��ܪ��i�{
		ProcessControl choice = selectUntilCorrectInput(selectcase);
		
		// ��ܪ��i�{�O Quit
		if(choice instanceof Quit) {
			Quit.setState(true);
			choice.part();
			return;
		}
		
		// ��������i�{������
		choice.startPart();
	}
	
	// �ե� selectProcess() �����J, ���Ƹ߰�, ������o���T����J
	public ProcessControl selectUntilCorrectInput(ProcessControl... selectcase) {
		ProcessControl choice;
		
		do {
			//����Τ��J
			choice = selectProcess(selectcase);
		}while(choice == null); // null �N�� ���~��J
		
		//��^���T����J�ҹ������i�{
		return choice;
	}
	
	// �߰�, ��J, ���T�h��^�ҿ�ܪ��i�{, ���~��^ null
	public ProcessControl selectProcess(ProcessControl... selectcase) {
		c.print("Input your choose: ");
		
		try {
			
			int index = Integer.parseInt( MyScanner.sc.nextLine() ) - 1;
			
			// �˴��W�ɤU�� //
			if(index < 0 || index >= selectcase.length) {
				throw new NumberFormatException();
			}else {
				// ���T��J
				return selectcase[index];
			}
		
		} catch (NumberFormatException ex) {
			// ���~��J //
			c.println("Wrong input, please input again.\n");
			return null;
		}
		
	}

}
