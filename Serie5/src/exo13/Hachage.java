package exo13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Hachage {

	public static void main(String[] args) {
		
		Map<Integer, String> map = Map.ofEntries(
				Map.entry(3, "one"), 
				Map.entry(4, "four"), 
				Map.entry(5, "three"),
				Map.entry(6, "eleven"));
		
		Map<Integer, String> map2 = new HashMap<>(map);
		
		List<Integer> keys = 
				List.of(1,2,3,4,5,6,7,8);
		
		
		//Question 2 && 3	
		for (int key : keys) {
			map2.putIfAbsent(key, "");
			System.out.println(key + " = " + map2.get(key));
		}
		
		
		
		//Question 4 && 5
		List <String> values = List.of(
				"one","two","three","four","five","six","seven","eight","nine","ten",
				"eleven","twelve");
		
		Map<Integer, List <String>> map3 = new HashMap<>();
		
		for (String value : values) {
			int key=value.length();
			List <String> list = map3.get(key);
			if (list == null) {
				list = new ArrayList<>();
				map3.put(key, list);
			}
			list.add(value);
				
			}
		
		System.out.print("Hash table : ");
		map3.forEach((key, value) -> System.out.print(key + " = " + value));
			
		//Another method with Put if absent
		for (String value : values) {
			int key=value.length();
			map3.putIfAbsent(key, new ArrayList<>());
			List <String> list = map3.get(key);	
			list.add(value);
			}
		
		
		//Another one with Default ! 
		for (String value : values) {
			int key=value.length();
			List <String> list = map3.getOrDefault(keys, new ArrayList<>());	
			list.add(value);
			map3.put(key, list);
			}
		
		//Another one with lambda
		for (String value : values) {
			int key=value.length();
			map3.computeIfAbsent(key, k -> new ArrayList<>()).add(value);	
			}


	}

}
