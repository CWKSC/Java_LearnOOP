/*AddCircle.java*/

package AddNewShape;

import FileControl.*;
import cHabit.c;
import processControl.ProcessControl;
import shapes.*;

public class AddCircle extends ProcessControl {
	
	public void part() {
		
		// �i�J Circle �� attribute �s�边, ��^�g�Τ��J�᪺���G
		Circle circle = new Circle(0, 0, 0).editer();
		
		// ���o�x�s�ɮ׸�ƪ��ޥ�
		ShapeListFileData data = FileControl.getShapeListFileData();
		
		// �� Circle �[���ɮ׸�Ƥ�
		data.addShapeToTheList(circle);
		
		// ��ܦ��\�T�� //
		c.ln();
		c.println("Successfully joined [ " + circle + " ] into file.");
		
		// �аO���ק�|���x�s
		QuitFile.setHaveChange(true);
		
		backToUpperLayer();
	}

}
