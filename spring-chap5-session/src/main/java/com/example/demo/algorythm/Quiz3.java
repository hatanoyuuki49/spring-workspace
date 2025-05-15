package com.example.demo.algorythm;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("お金を入れてください：");
		int money = scan.nextInt();
		//判定処理
		if (money < 120) {
			System.out.print("お金が足りません");
		} else {
			System.out.print("購入できました。" + "おつりは" + (money - 120) + "円です");
		}

		scan.close();
	}
}
