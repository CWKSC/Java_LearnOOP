/*ListShape.java*/

package FileControl;

import cHabit.c;
import processControl.ProcessControl;
import shapes.ShapeListFileData;

public class ListShape extends ProcessControl {
	
	public void part() {
		
		// ����ɮ׸��
		ShapeListFileData data = FileControl.getShapeListFileData();
		
		// �C�X�ɮ׸�� //
		data.listShape(false);
		c.printf("The total area is %.2f, and\n", data.getTotalArea());
		c.printf("thw total perimeter "
				+ "is %.2f\n", data.getTotalPerimeter());
		
		// �Ȱ��i�{, ��^�W�@�h
		SystemPause();
		backToUpperLayer();
		
	}

}
