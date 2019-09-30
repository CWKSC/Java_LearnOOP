/*FileControl.java*/

package FileControl;

import java.io.*;

import AddNewShape.AddNewShape;
import cHabit.c;
import processControl.ProcessControl;
import shapes.ShapeListFileData;

public class FileControl extends ProcessControl{
	
	private static String fileName;
	private static ShapeListFileData shapeListFileData;
	
	/*getter and setter of fileName (String)*/
	public static String getFileName() { return fileName; }
	public static void setFileName(String fileName) { FileControl.fileName = fileName; }
	
	/*getter and setter of shapeListFileData (ShapeListFileData)*/
	public static ShapeListFileData getShapeListFileData() { return shapeListFileData; }
	public static void setShapeListFileData(ShapeListFileData shapeListFileData) { FileControl.shapeListFileData = shapeListFileData; }
	
	// ����ɮצ��
	public static int getFileLineNum(String filename) {
		return getFileLineNum(new File(filename));
	}
	public static int getFileLineNum(File filename) {
		int count = 0;
		try {
			BufferedReader file = new BufferedReader(new FileReader(filename));
			
			// �p����
			while (file.readLine() != null) { count++; }
			
			file.close();
		}catch(IOException ex) {
			System.out.println(ex);
			return -1; //�L�kŪ���ɮ�
		}
		
		// ��^���
		return count;
	}
	
	// �����e�ؿ���, ���W�� suffix ���ɮצC�� ( �}�C )
	public static File[] currentDirDataFileArr(String suffix) {
		
		// ��e�ؿ� Current directory
		File currentDir = new File(".");
		
		// �إ� FilenameFilter
		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return (name.indexOf(suffix) != -1);
			}
			
		};
		
		// ��^ FilenameFilter �L�o�᪺���G
		return currentDir.listFiles(filter);
	}
	
	// ��^��e�ؿ��U�i���J���ɮװ}�C, ������ɮצC��T��
	public static File[] loadFileList(String text) {
		c.ln();
		
		// �����e�ؿ���, ���W�� ".txt" ���ɮצC�� ( �}�C )
		File[] DataFiles = FileControl.currentDirDataFileArr(".txt");
		String strFileName;
		
		// ��e�ؿ��U�S���i���J���ɮ� //
		if(DataFiles.length == 0) {
			return null;
		}
		
		// ����ɮצC��T�� //
		c.println("There are " + DataFiles.length + " file can be " + text + " :");
		for(int i = 0; i < DataFiles.length; i++) {
			strFileName = DataFiles[i].toString();
			strFileName = strFileName.substring("./".length(), strFileName.length() - ".txt".length());
			c.println("\t" + (i+1) + ". " + strFileName);
		}
		c.println((DataFiles.length + 1) + ". Quit");
		c.ln();
		
		// ��^��e�ؿ��U�i���J���ɮװ}�C
		return DataFiles;
	}
	
	// �˴��D�k���ɮצW�� //
	public static boolean isItIllFileName(String fileName) {
		final char[] illCharArr = { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};
		if(fileName.equals("")) {
			return true;
		}
		for(int i = 0; i < illCharArr.length; i++) {
			if(fileName.indexOf(illCharArr[i]) != -1) {
				return true;
			}
		}
		return false;
	}
	
	void display() {
		c.ln();
		c.println("Current File Name: [" + fileName + "]");
		c.println("1. Add new Shape");
		c.println("2. Edit exist Shape");
		c.println("3. Delect Shape");
		c.println("4. List infomation of All Shape and");
		c.println("    Show total Area and Perimeter");
		c.println("5. Save");
		c.println("6. Quit");
		c.ln();
	}
	
	public void part() {
		display();
		selection(new AddNewShape(),
				  new EditShape(),
				  new DelectShape(),
				  new ListShape(),
				  new SaveFile(),
				  new QuitFile());
	}
	
}
