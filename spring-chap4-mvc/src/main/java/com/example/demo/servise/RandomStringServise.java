package com.example.demo.servise;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomStringServise {
	private static final int generate_num = 10;

	@SuppressWarnings("deprecation")
	public List generate(int charLength, boolean withNumber) {
		// TODO 自動生成されたメソッド・スタブ
		List<String> list = new ArrayList<>();//<>の中は左と同じものが入る
		String word = "";
		for (int i = 0; i < generate_num; i++) {//拡張for文
			if (withNumber == false) {
				word = RandomStringUtils.randomAlphabetic(charLength);//()内は文字数の変数
				list.add(word);
			} else {
				word = RandomStringUtils.randomAlphanumeric(charLength);//()内は文字数の変数
				list.add(word);
			}

		}
		return list;

	}
}
