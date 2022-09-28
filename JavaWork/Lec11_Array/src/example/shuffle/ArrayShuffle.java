package example.shuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayShuffle {

	public static void main(String[] args) {
		String str = "김대진\r\n"
				+ "김재윤\r\n"
				+ "김정홍\r\n"
				+ "김종훈\r\n"
				+ "노진수\r\n"
				+ "안일찬\r\n"
				+ "이수민\r\n"
				+ "이지민\r\n"
				+ "장준희\r\n"
				+ "정의형\r\n"
				+ "진하륜";
		
		String [] arr = str.split("\\s+");
		List<String> list = Arrays.asList(arr);
		Collections.shuffle(list);
		System.out.println(Arrays.toString(list.toArray()));

	}

}
