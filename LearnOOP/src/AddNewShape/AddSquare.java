/*AddSquare.java*/

package AddNewShape;

import FileControl.*;
import cHabit.c;
import processControl.ProcessControl;
import shapes.*;

public class AddSquare extends ProcessControl {

	public void part() {
		
		// �i�J Square �� attribute �s�边, ��^�g�Τ��J�᪺���G
		Square square = new Square(0, 0, 0).editer();
		
		// ���o�x�s�ɮ׸�ƪ��ޥ�
		ShapeListFileData data = FileControl.getShapeListFileData();
				
		// �� Square �[���ɮ׸�Ƥ�
		data.addShapeToTheList(square);
		
		// ��ܦ��\�T�� //
		c.ln();
		c.println("Successfully joined [ " + square + " ] into file.");
		
		// �аO���ק�|���x�s
		QuitFile.setHaveChange(true);
		
		backToUpperLayer();
	}

}
