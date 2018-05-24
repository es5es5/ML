package com.lhw.marry.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MMain {

	public static void main(String[] args) {
		// 파일에서 불러다가 HashMap<String, ArrayList>
		HashMap<String, ArrayList> trainData = kNN.trainFromFile(
				"C:\\Users\\soldesk\\Desktop\\lhw\\ML\\May24_kNN_Marriage\\src\\com\\lhw\\marry\\main\\datingTestSet.txt");

		// 각 축간에 값 차이가 너무 커서
		// 값을 그냥 쓰지 않고 비율로 변환해서 사용
		// 최대값을 1로, 최소값을 0으로.
		trainData = kNN.normalizeTrainData(trainData);

		// 입력
		Scanner s = new Scanner(System.in);
		System.out.println("1년 비행기 마일리지 : ");
		double a = s.nextDouble();

		System.out.println("하루 중 몇 %의 시간 동안 게임하나 : ");
		double b = s.nextDouble();

		System.out.println("일주일동안 아이스크림 몇 L먹나 : ");
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
