/*LoadExistFile.java*/

import java.io.*;

import FileControl.FileControl;
import cHabit.c;
import processControl.*;
import shapes.*;

public class LoadExistFile extends ProcessControl {
	
	public void part() {
		
		// ���o��e�ؿ��U�i���J���ɮװ}�C
		File[] DataFiles = FileControl.loadFileList("load");
		
		// ��e�ؿ��U�S���i���J���ɮ� //
		if(DataFiles == null) {
			c.println("No exist file can be load.");
			backToUpperLayer();
			SystemPause();
			return;
		}
		
		// �߰�, ���o�Τ᪺��J
		int fileChoice = MyScanner.inputIntWithQuestionWithValueLimit(
				"Input your choose: ", //Question
				1,					   //LowerLimit
				DataFiles.length + 1); //UpperLimit
		// �s�� DataFiles.length + 1 �����}�ﶵ
		
		// �Τ��ܤF���}���ﶵ
		if(fileChoice == DataFiles.length + 1) { 
			backToUpperLayer();
			return;
		}
		
		// �����ﶵ���}�C����
		int index = fileChoice - 1;
		
		// ���o�ɮת��r��W��, �h���Y����������J FileControl //
		String strFileName = DataFiles[index].toString();
		String strWithOutHeadAndTail = strFileName.substring("./".length(),
				strFileName.length() - ".txt".length());
		FileControl.setFileName(strWithOutHeadAndTail);
		
		// ���榡Ū���ɮ� //
		try {
			FileReader file = new FileReader(strFileName);
			BufferedReader fin = new BufferedReader(file);
			
			// ���o�ɮצ��
			int fileLineNum = FileControl.getFileLineNum(strFileName);
			
			// ��Ƭ��s, �o�O�@�Ӫ��ɮ�
			if(fileLineNum == 0) {
				fin.close();
				
				// �ͦ����ɮ� //
				// ���J�ɮצW��, �Ū� ShapeListFileData
				FileControl.setFileName(strWithOutHeadAndTail);
				FileControl.setShapeListFileData(new ShapeListFileData());
				
				// �i�J�s��, �����ɮ׸�ƪ�����
				(new FileControl()).startPart();
				
				backToUpperLayer();
				return;
			}
			
			Shape[] shapeList = new Shape[fileLineNum];
			
			String[] tempStr = new String[fileLineNum];
			String[] fields = new String[fileLineNum];
			
			// �M��, �@��@��a���ɮ׸�Ƹ��J tempStr, �M��i��榡���//
			for(int i = 0; i < fileLineNum; i++) {
				tempStr[i] = fin.readLine();
				
				// �����s�b�Ŧ� //
				if(tempStr[i].equals("")) {
					fin.close();
					c.println("Should not be empty line.");
					throw new NumberFormatException();
				}
				
				// ���Ӯ榡���
				fields = tempStr[i].split(",");
				
				// ���Ӧܤ֦��|�� attributes
				if(fields.length < 4) {
					fin.close();
					c.println("At least 4 attributes.");
					throw new NumberFormatException();
				}
				
				/*�M�� fields �A�h���Y���Ů�*/
				for(int j = 0; j < fields.length; j++) {
					fields[j] = fields[j].trim();
				}
				
				// ���J x, y �y��
				int x = Integer.parseInt(fields[1]);
				int y = Integer.parseInt(fields[2]);
				
				// �����Ĥ@���Ѽƪ������W��, ���J������ shape �� shapeList ��
				if(fields[0].equals("Circle")) {
					int r = Integer.parseInt(fields[3]);
					shapeList[i] = new Circle(x, y, r);
					
				}else if(fields[0].equals("EquivalentTriangle")) {
					int l = Integer.parseInt(fields[3]);
					shapeList[i] = new EquivalentTriangle(x, y, l);
					
				}else if(fields[0].equals("Rectangle")) {
					int w = Integer.parseInt(fields[3]);
					int h = Integer.parseInt(fields[3]);
					shapeList[i] = new Rectangle(x, y, w, h);
					
				}else if(fields[0].equals("Square")) {
					int l = Integer.parseInt(fields[3]);
					shapeList[i] = new Square(x, y, l);
					
				}else {
					// �䤣������������W�� //
					fin.close();
					c.println("No corresponding shape type name.");
					throw new NumberFormatException();
				}
			}
			
			fin.close();
			
			//�i�J�s��, �����ɮ׸�ƪ�����
			(new FileControl()).startPart();
			
		}catch (NumberFormatException ex) {
			
			// �s�b�榡���~���T��
	    	c.println("The loading file have wrong format. ���J���ɮצs�b���~�榡�C");
	    	
		}catch (IOException ex) {
	         ex.printStackTrace();
	    }
		
		backToUpperLayer();
	}
	
}
