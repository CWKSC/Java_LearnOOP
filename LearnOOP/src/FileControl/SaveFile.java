/*SaveFile.java*/

package FileControl;

import java.io.*;

import cHabit.c;
import processControl.ProcessControl;
import shapes.*;

public class SaveFile extends ProcessControl {

	public void part() {
		try {
			
			// ���ɮצW�٥[�J���W //
			File fileName = new File(FileControl.getFileName() + ".txt");
			FileWriter file = new FileWriter(fileName);
			BufferedWriter fout = new BufferedWriter(file);
			
			// ���o�ɮ׸�ƪ��ޥ�
			ShapeListFileData shapeListFileData = FileControl.getShapeListFileData();
			
			// ���o�ɮ׸�Ƥ��� Shape �}�C�M�����ƥ� //
			Shape[] shapeList = shapeListFileData.getShapeList();
			int elementNum = shapeListFileData.getElementNum();
			
			// �o�O�@�ӪŪ��}�C, �����ƥج��s
			if(elementNum != 0) {
				// �M�� shapeList , toWriteFileString() �|��^�@�ӲŦX��X�榡���r��
				for(int i = 0; i < elementNum - 1; i++) {
					fout.write(shapeList[i].toWriteFileString());
					fout.newLine();
				}
				fout.write(shapeList[elementNum - 1].toWriteFileString());
			}
			
	        fout.close();
	        
	        c.ln();
	        c.println("Save file Successfully.");
	        
	        // �аO�ק�w�x�s, �S���|���x�s���ק�
	        QuitFile.setHaveChange(false);
	        
	        SystemPause();
		}catch (Exception ex) {
	         ex.printStackTrace();
	    }
		backToUpperLayer();
	}

}
