/*DelectExistFile.java*/

import java.io.File;

import FileControl.FileControl;
import cHabit.c;
import processControl.*;

public class DelectExistFile extends ProcessControl {

	// �P LoadExistFile ������������
	// �R���s�b���ɮ� //
	public void part() {
		
		// ���o��e�ؿ��U�i���J���ɮװ}�C
		File[] DataFiles = FileControl.loadFileList("delect");
		
		// ��e�ؿ��U�S���i���J���ɮ� //
		if(DataFiles == null) {
			c.println("No exist file can be delect.");
			backToUpperLayer();
			SystemPause();
			return;
		}
		
		// �߰�, ���o�Τ᪺��J
		int fileChoice = MyScanner.inputIntWithQuestionWithValueLimit(
				"Input your choose: ", //question
				1,					   //lowerLimit
				DataFiles.length + 1); //UpperLimit
		// �s�� DataFiles.length + 1 �����}�ﶵ
		
		// �Τ��ܤF���}���ﶵ
		if(fileChoice == DataFiles.length + 1) { //Quit
			backToUpperLayer();
			return;
		}
		
		// �����ﶵ���}�C����
		int index = fileChoice - 1;
		
		//�R���ɮ�
		DataFiles[index].delete();
		
	}

}
