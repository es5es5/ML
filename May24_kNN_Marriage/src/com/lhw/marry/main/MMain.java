package com.lhw.marry.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MMain {

	public static void main(String[] args) {
		// ���Ͽ��� �ҷ��ٰ� HashMap<String, ArrayList>
		HashMap<String, ArrayList> trainData = kNN.trainFromFile(
				"C:\\Users\\soldesk\\Desktop\\lhw\\ML\\May24_kNN_Marriage\\src\\com\\lhw\\marry\\main\\datingTestSet.txt");

		// �� �ణ�� �� ���̰� �ʹ� Ŀ��
		// ���� �׳� ���� �ʰ� ������ ��ȯ�ؼ� ���
		// �ִ밪�� 1��, �ּҰ��� 0����.
		trainData = kNN.normalizeTrainData(trainData);

		// �Է�
		Scanner s = new Scanner(System.in);
		System.out.println("1�� ����� ���ϸ��� : ");
		double a = s.nextDouble();

		System.out.println("�Ϸ� �� �� %�� �ð� ���� �����ϳ� : ");
		double b = s.nextDouble();

		System.out.println("�����ϵ��� ���̽�ũ�� �� L�Գ� : ");
		double c = s.nextDouble();

		double[] data = { a, b, c };
		data = kNN.normalizeTestData(data, trainData);
		System.out.println(data[0] + " " + data[1] + " " + data[2]);
		
		System.out.println("k : ");
		int k = s.nextInt();
		
		String result = kNN.do_kNN(data, trainData, k);
		System.out.println(result);

	}
}
