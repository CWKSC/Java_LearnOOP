/*Shape.java*/

package shapes;

// �ϧ� //
public abstract class Shape{
	
	// �ϧΦW��, x, y �y�� //
	private String shapeType;
	private int x;
	private int y;
	
	// Shape �� constructor //
	public Shape(String shapeType, int x, int y) {
		setShapeType(shapeType);
		setX(x);
		setY(y);
	}
	
	// x �� getter �M setter //
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	
	// y �� getter �M setter //
	public int getY() { return y; }
	public void setY(int y) { this.y = y; }
	
	// shapeType �� getter �M setter //
	public String getShapeType() { return shapeType; }
	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}
	
	// ��^ Shape ���T�����r��
	public String toString() {
		return getShapeType() + " at (" + getX() + "," + getY() + ") has ";
	}
	
	// �� 3 �� abstract �ݭn�l���O�h�~��, ���F�i��h�� //
	public abstract double getArea(); // �p�⭱�n
	public abstract double getPerimeter(); // �p��P��
	public abstract Shape editer(); // �w�� attribute �s�边
	
	// ��^�ŦX��X�榡���r��
	public String toWriteFileString() {
		return getShapeType() + ", " + getX() + ", " + getY() + ", ";
	}
}
