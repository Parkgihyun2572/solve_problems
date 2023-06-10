package baekjoon;

import java.util.Scanner;

public class B13305 {
	
	public static void main(String[] args) {
		
		// 입력 받기
		// 거리와 유가는 int형의 범위를 오버하기에 long타입으로 받아야 함
		Scanner scan = new Scanner(System.in);
		int numberOfCitys = scan.nextInt();
		long[] roadsLength = new long[numberOfCitys - 1];
		for (int i = 0; i < roadsLength.length; i++) {
			roadsLength[i] = scan.nextLong();
		}
		long[] citysOilPrice = new long[numberOfCitys];
		for (int i = 0; i < citysOilPrice.length; i++) {
			citysOilPrice[i] = scan.nextLong();
		}
		scan.close();
		
		// 유가가 큰 도시에서는 최대한 주유를 적게 하고, 낮은 도시에서는 주유를 많이
		// 이는 유가가 이전보다 큰 도시에서는 이전에 작은 값으로 주유하는 것과 같다.
		long minPrice = citysOilPrice[0];
		for (int i = 1; i < citysOilPrice.length - 1; i++) {
			if(minPrice >= citysOilPrice[i]) {
				minPrice = citysOilPrice[i];
			} else {
				citysOilPrice[i] = minPrice;
			}
		}
		
		long totalPrice = 0;
		for(int i = 0; i < roadsLength.length; i++) {
			totalPrice += (roadsLength[i] * citysOilPrice[i]);
		}
		System.out.println(totalPrice);
		
	}

}
