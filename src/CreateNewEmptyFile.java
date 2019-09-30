/*CreateNewEmptyFile.java*/

import FileControl.FileControl;
import cHabit.c;
import processControl.*;
import shapes.ShapeListFileData;

public class CreateNewEmptyFile extends ProcessControl {
	
	public void display() {
		c.ln();
		c.print("New Empty File name:");
	}
	
	public void part() {
		String inputFileName;
		
		// ��J�ɮצW�٪��ܦX�k���ɮצW�� //
		boolean isItIllFileName;
		do {
			
			// �߰�
			display();
			
			inputFileName = MyScanner.sc.nextLine();
			
			// �P�_�D�k���ɮצW��
			isItIllFileName = FileControl.isItIllFileName(inputFileName);
			if(isItIllFileName) {
				c.println("Illegal file name, please enter again. �D�k���ɮצW�١A�Э��s��J�C");
			}
			
		}while(isItIllFileName);
		
		// �ͦ����ɮ� //
		//���J�ɮצW��, �Ū� ShapeListFileData
		FileControl.setFileName(inputFileName);
		FileControl.setShapeListFileData(new ShapeListFileData());
		
		//�i�J�s��, �����ɮ׸�ƪ�����
		(new FileControl()).startPart();
		
		backToUpperLayer();
	}
	
}
