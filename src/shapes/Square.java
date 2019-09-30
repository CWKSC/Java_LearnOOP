/*Square*/

package shapes;
import cHabit.c;
import processControl.MyScanner;
import shapes.Shape;

// ����� //
public class Square extends Shape {
	
	// ����Ϊ����
	private int length;
	
	// Rectangle �� constructor //
	public Square(int x, int y, int side) {
		super("Square", x, y);
		setLength(side);
	}
	
	// length �� getter �M setter //
	public int getLength() { return length; }
	public void setLength(int length) { this.length = length; }
	
	// ��^ Square ���T�����r��
	public String toString() {
		return super.toString() + "length " + getLength();
	}

	@Override
	// �p�� Square �����n
	public double getArea() {
		return Math.pow(length, 2);
	}

	@Override
	// �p�� Square ���P��
	public double getPerimeter() {
		return 4.0 * length;
	}

	@Override
	// �w�� Square �� attribute �s�边
	public Square editer() {
		c.ln();
		int x = MyScanner.inputIntWithQuestion("input x:");
		int y = MyScanner.inputIntWithQuestion("input y:");
		int s = MyScanner.inputIntWithQuestion("input side:");
		return new Square(x, y, s);
	}
	
	// ��^�ŦX��X�榡���r��
	public String toWriteFileString() {
		return super.toWriteFileString() + getLength();
	}
}
