/*DelectShape.java*/

package FileControl;

import cHabit.c;
import processControl.*;
import shapes.ShapeListFileData;

public class DelectShape extends ProcessControl {

	public void part() {
		
		// ���o�ɮ׸�ƪ��ޥ�
		ShapeListFileData shapeListFileData = FileControl.getShapeListFileData();
		
		// �C�X shapeList �C��T��, �Y�G�ɮפ��S������ shape, ��^ false
		if(shapeListFileData.listShape(true) == false){
			SystemPause();
			backToUpperLayer();
			return;
		}
		
		// �߰�, ���o�Τ᪺��J
		int choice = MyScanner.inputIntWithQuestionWithValueLimit(
				"Choice to delect a Shape :", 				//question
				1,										    //lowerLimit
				shapeListFileData.getElementNum() + 1);		//UpperLimit
		// �s�� shapeListFileData.getElementNum() + 1 �����}�ﶵ
		
		// �Τ��ܤF���}���ﶵ
		if(choice == shapeListFileData.getElementNum() + 1) { //Quit
			backToUpperLayer();
			return;
		}
		
		// �����ﶵ���}�C����
		int index = choice - 1;
		
		// �R���ɮ׸�Ƥ� �������ު� Shape
		shapeListFileData.delectShapeAtTheList(index);
		
		// ���\�T�� //
		c.ln();
		c.println("Successfully delect the shape in the file.");
		
		// �аO���ק�|���x�s
		QuitFile.setHaveChange(true);
		
	}

}
