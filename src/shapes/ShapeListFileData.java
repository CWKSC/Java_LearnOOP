/*ShapeListFileData.java*/

package shapes;

import cHabit.c;

// �x�s�ɮ׸�ƪ����O //
public class ShapeListFileData {
	
	// �x�s Shape ���}�C, �M�����ƥ� //
	private Shape[] shapeList;
	private int elementNum = 0;
	
	// ��� shapeList �}�C�� getter �M setter //
	public Shape[] getShapeList() { return shapeList; }
	public void setShapeList(Shape[] input) { shapeList = input; }
	
	// ���ӿ�J������, shapeList ���䤤�@�Ӥ����� getter �M setter //
	public Shape getShapeListByIndex(int index) { return shapeList[index]; }
	public void setShapeListByIndex(Shape input, int index) {
		shapeList[index] = input;
	}
	
	// elementNum �����ƥت� getter �M setter //
	public int getElementNum() { return elementNum; }
	public void setElementNum(int input) { elementNum = input; }
	
	// �C�X shapeList �C��T�� //
	public boolean listShape(boolean quitChioceDisplay) {
		c.ln();
		
		// shapeList �O�Ű}�C(null), �S���x�s���� Shape
		if(elementNum == 0) {
			c.println("Haven't Any Shape at file.");
			return false;
		}
		
		// ��� shapeList ���C��T��
		c.println("There are " + elementNum + " shapes:");
		for(int i = 0; i < elementNum; i++) {
			c.println("\t" + (i+1) + ". " + shapeList[i]);
		}
		
		// �ھڰѼƨM�w�O�_��ܰh�X�ﶵ(�̫�@��)
		if(quitChioceDisplay) {
			c.println((elementNum + 1) + ". Quit");
		}
		
		c.ln();
		return true; // �N�� shapeList �ëD�Ű}�C
	}
	
	// ���o shapeList �����`���n //
	public double getTotalArea() {
		double totalArea = 0;
		for(int i = 0; i < elementNum; i++) {
			totalArea += shapeList[i].getArea();
		}
		return totalArea;
	}
	
	// ���o shapeList �����`�P�� //
	public double getTotalPerimeter() {
		double totalPerimeter = 0;
		for(int i = 0; i < elementNum; i++) {
			totalPerimeter += shapeList[i].getPerimeter();
		}
		return totalPerimeter;
	}
	
	// �X�j�}�C, �����[�@
	public void expandShapeListSpace() {
		elementNum++;
		shapeList = new Shape[elementNum];
	}
	
	// ���J���Ѽƥ[�J shapeList �}�C��
	public void addShapeToTheList(Shape input){
		Shape[] tempShapeList = shapeList;
		expandShapeListSpace();
		int indexOfLastElement = elementNum - 1;
		for(int i = 0; i < indexOfLastElement; i++) {
			shapeList[i] = tempShapeList[i];
		}
		shapeList[indexOfLastElement] = input;
	}
	
	// �Y�p�}�C, ������@
	public void reduceShapeListSpace() {
		elementNum--;
		shapeList = new Shape[elementNum];
	}
	
	// ���J���ѼƦb shapeList �}�C���R��
	public void delectShapeAtTheList(int index){
		Shape[] tempShapeList = shapeList;
		reduceShapeListSpace();
		for(int i = 0, j = 0; i < elementNum + 1; i++) {
			if(i != index) {
				shapeList[j] = tempShapeList[i];
				j++;
			}
		}
	}
	
}
