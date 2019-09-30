/*EditShape.java*/

package FileControl;

import cHabit.c;
import processControl.*;
import shapes.*;

public class EditShape extends ProcessControl{

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
				"Choice a Shape to edit the attributes:", //Question
				1,										  //lowerLimit
				shapeListFileData.getElementNum() + 1);	  //UpperLimit
		// �s�� shapeListFileData.getElementNum() + 1 �����}�ﶵ
		
		// �Τ��ܤF���}���ﶵ
		if(choice == shapeListFileData.getElementNum() + 1) { //Quit
			backToUpperLayer();
			return;
		}
		
		// �����ﶵ���}�C����
		int index = choice - 1;
		
		// ���o�������ު� Shape
		Shape shape = shapeListFileData.getShapeListByIndex(index); //get
		
		// �ϥι������s�边���Τ�ק� attribute
		shape = shape.editer();
		
		// ��ק�᪺ Shape ��J shapeListFileData �ɮ׸��
		shapeListFileData.setShapeListByIndex(shape, index); //set
		
		// ���\�T�� //
		c.ln();
		c.println("Successfully change [ " + shape + " ] into file.");
		
		// �аO���ק�|���x�s
		QuitFile.setHaveChange(true);
		
	}
	
}
