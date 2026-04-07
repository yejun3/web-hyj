package ex3_String;

import java.util.Arrays;

public class ByteToStringExample {
	public static void main(String[] args) {
		String data ="자바";
		
		//String -> byte 배열
		byte [] arr1 = data.getBytes();
		//배열에 들어있는 내용 출력하기
		//for문 사용, Arrays.toString()사용
		System.out.println("arr1:"+ Arrays.toString(arr1));
		
		// byte배열 -> String 문자열
		String str1 = new String(arr1);
		System.out.println("str1: " + str1);
		
	}

}
