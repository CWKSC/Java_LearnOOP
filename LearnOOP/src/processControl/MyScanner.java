/*MyScanner.java*/

package processControl;

import java.util.Scanner;

import cHabit.c;

public class MyScanner {
	
	// �@���R�A, �����ϥΪ� Scanner
	// �N�b�{�ǵ����e�Q����
	public static Scanner sc = new Scanner(System.in);
	
	/*�� inputIntWithQuestion() �����\��~�A�[�J�F�W�ɤU�ɪ�����*/
	public static int inputIntWithQuestionWithValueLimit(String question, int lowerLimit, int upperLimit) {
		boolean error;
		int input;
		do {
			error = false;
			input = inputIntWithQuestion(question);
			
			// �W�ɤU�ɭ��� //
			if(input < lowerLimit || input > upperLimit) {
				error = true;
				c.println("Wrong input, please input again.\n");
			}
		}while(error);
		return input;
	}
	
	/*�߰ݰ��D, ��������������J, �]�A���~�B�z*/
	public static int inputIntWithQuestion(String question) {
		int input = -1; //-1 is no meaning, just ensure input or return have initialization
		boolean error;
		
		do {
			error = false;
			
			// �߰ݰ��D
			c.print(question);
			
			try {
				// ��������������J
				input = Integer.parseInt( MyScanner.sc.nextLine() );
			} catch (NumberFormatException ex) {
				// ���~�B�z //
				error = true;
				c.println("Wrong input, please input again.\n");
			}
		}while(error);
		
		// ��^���T����J
		return input;
	}

}
