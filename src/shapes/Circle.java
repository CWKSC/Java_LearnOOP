/*Circle.java*/

package shapes;

import cHabit.c;
import processControl.MyScanner;
import shapes.Shape;

// ��� //
public class Circle extends Shape{
	
	// ��Υb�|
	private int radius;
	
	// Circle �� constructor //
	public Circle(int x, int y, int radius) {
		super("Circle", x, y);
		setRadius(radius);
	}
	
	// radius �b�|�� getter �M setter //
	public int getRadius() { return radius; }
	public void setRadius(int radius) { this.radius = radius; }
	
	// ��^ Circle ���T�����r��
	public String toString() {
		return super.toString() + "radius " + getRadius();
	}

	@Override
	// �p�� Circle �����n
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	// �p�� Circle ���P��
	public double getPerimeter() {
		return 2.0 * Math.PI * radius;
	}

	@Override
	// �w�� Circle �� attribute �s�边
	public Circle editer() {
		c.ln();
		int x = MyScanner.inputIntWithQuestion("input x:");
		int y = MyScanner.inputIntWithQuestion("input y:");
		int r = MyScanner.inputIntWithQuestion("input radius:");
		return new Circle(x, y, r);
	}
	
	// ��^�ŦX��X�榡���r��
	public String toWriteFileString() {
		return super.toWriteFileString() + getRadius();
	}
	
}
