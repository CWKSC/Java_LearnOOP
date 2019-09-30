/*AddEquivalentTriangle.java*/

package AddNewShape;

import FileControl.*;
import cHabit.c;
import processControl.ProcessControl;
import shapes.*;

public class AddEquivalentTriangle extends ProcessControl {

	public void part() {
		
		// �i�J EquivalentTriangle �� attribute �s�边, ��^�g�Τ��J�᪺���G
		EquivalentTriangle equivalentTriangle = new EquivalentTriangle(0, 0, 0).editer();
		
		// ���o�x�s�ɮ׸�ƪ��ޥ�
		ShapeListFileData data = FileControl.getShapeListFileData();
				
		// �� EquivalentTriangle �[���ɮ׸�Ƥ�
		data.addShapeToTheList(equivalentTriangle);
		
		// ��ܦ��\�T�� //
		c.ln();
		c.println("Successfully joined [ " + equivalentTriangle + " ] into file.");
		
		// �аO���ק�|���x�s
		QuitFile.setHaveChange(true);
		
		backToUpperLayer();
	}

}
