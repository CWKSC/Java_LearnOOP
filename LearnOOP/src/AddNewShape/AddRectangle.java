/*AddRectangle.java*/

package AddNewShape;

import FileControl.*;
import cHabit.c;
import processControl.ProcessControl;
import shapes.*;

public class AddRectangle extends ProcessControl {

	public void part() {
		
		// �i�J Rectangle �� attribute �s�边, ��^�g�Τ��J�᪺���G
		Rectangle rectangle = new Rectangle(0, 0, 0, 0).editer();
		
		// ���o�x�s�ɮ׸�ƪ��ޥ�
		ShapeListFileData data = FileControl.getShapeListFileData();
				
		// �� Rectangle �[���ɮ׸�Ƥ�
		data.addShapeToTheList(rectangle);
		
		// ��ܦ��\�T�� //
		c.ln();
		c.println("Successfully joined [ " + rectangle + " ] into file.");
		
		// �аO���ק�|���x�s
		QuitFile.setHaveChange(true);
		
		backToUpperLayer();
	}

}
