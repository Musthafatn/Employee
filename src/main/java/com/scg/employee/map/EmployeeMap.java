package com.scg.employee.map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EmployeeMap {

	public static void main(final String[] args) throws Exception {
		demo1();
//		demo2();
	}

	static void demo1() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final Map<Integer, List<String>> empMap = new LinkedHashMap<>();
		boolean flag = true;
		while (flag) {
			final var id = Integer.parseInt(br.readLine());
			final String name = br.readLine();
//			empMap.putIfAbsent(id, new ArrayList<>());
			empMap.computeIfAbsent(id, k -> new ArrayList<>());
			empMap.get(id).add(name);
			System.out.println("Continue?");
			final String reply = br.readLine();
			flag = "Y".equalsIgnoreCase(reply);

		}
		System.out.println(empMap);
		br.close();
	}

	static void demo2() {

//		final Map<Integer, String> map = new HashMap<>();
//		map.put(1, "one");
//		map.computeIfAbsent(12, s -> "one ".concat("two"));
//		System.out.println(map);

//		 putIfAbsent same as
//		 List<String> list = new ArrayList<>();
//		 if (map.get("key") == null) {
//		 map.put("key",list);
//		 }
//
//		 computIfAbsent same as
//		 if (map.get("key") == null) {
//		 map.put("key",new ArrayList<>());
//		 }

	}

}
