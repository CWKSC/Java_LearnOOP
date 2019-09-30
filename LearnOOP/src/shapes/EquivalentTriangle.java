/*EquivalentTriangle.java*/

package shapes;

import cHabit.c;
import processControl.MyScanner;
import shapes.Shape;

// ���T���� //
public class EquivalentTriangle extends Shape {
	
	// ���T�������
	private int length;
	
	// EquivalentTriangle �� constructor //
	public EquivalentTriangle(int x, int y, int side) {
		super("EquivalentTriangle", x, y);
		setLength(side);
	}
	
	// length �� getter �M setter
	public int getLength() { return length; }
	public void setLength(int length) { this.length = length; }
	
	// ��^ EquivalentTriangle ���T�����r��
	public String toString() {
		return super.toString() + "length " + getLength();
	}

	@Override
	// �p�� EquivalentTriangle �����n
	public double getArea() {
		return (Math.sqrt(3.0) / 4.0) * Math.pow(length, 2);
	}

	@Override
	// �p�� EquivalentTriangle ���P��
	public double getPerimeter() {
		return 3.0 * length;
	}

	@Override
	// �w�� EquivalentTriangle �� attribute �s�边
	public EquivalentTriangle editer() {
		c.ln();
		int x = MyScanner.inputIntWithQuestion("input x:");
		int y = MyScanner.inputIntWithQuestion("input y:");
		int s = MyScanner.inputIntWithQuestion("input side:");
		return new EquivalentTriangle(x, y, s);
	}

	// ��^�ŦX��X�榡���r��
	public String toWriteFileString() {
		return super.toWriteFileString() + getLength();
	}
}
