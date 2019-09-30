/*Rectangle.java*/

package shapes;

import cHabit.c;
import processControl.MyScanner;
import shapes.Shape;

// ����� //
public class Rectangle extends Shape {
	
	// ����Ϊ���, �� //
	private int width;
	private int height;
	
	// Rectangle �� constructor //
	public Rectangle(int x, int y, int width, int height) {
		super("Rectangle", x, y);
		setWidth(width);
		setHeight(height);
	}
	
	// width �� getter �M setter //
	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }
	
	// height �� getter �M setter //
	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
	
	// ��^ Rectangle ���T�����r��
	public String toString() {
		return super.toString() + 
				"width " + getWidth() + 
				" and height " + getHeight();
	}

	@Override
	// �p�� Rectangle �����n
	public double getArea() {
		return width * height;
	}

	@Override
	// �p�� Rectangle ���P��
	public double getPerimeter() {
		return 2 * ( width + height );
	}

	@Override
	// �w�� Rectangle �� attribute �s�边
	public Rectangle editer() {
		c.ln();
		int x = MyScanner.inputIntWithQuestion("input x:");
		int y = MyScanner.inputIntWithQuestion("input y:");
		int w = MyScanner.inputIntWithQuestion("input width:");
		int h = MyScanner.inputIntWithQuestion("input height:");
		return new Rectangle(x, y, w, h);
	}
	
	// ��^�ŦX��X�榡���r��
	public String toWriteFileString() {
		return super.toWriteFileString() + getWidth() + ", " + getHeight();
	}
}
