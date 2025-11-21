/** Functions for checking if a given string is an anagram. */public class Anagram {
	public static void main(String args[]) {
		System.out.println(isAnagram("silent","listen"));
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller"));
		System.out.println(isAnagram("Madam Curie","Radium came"));
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort"));

		System.out.println(preProcess("What? No way!!!"));
		
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		String str = "1234567";
		Boolean pass = true;
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1);
		String s2 = preProcess(str2);
		if (s1.length() != s2.length()) return false;
		
		boolean[] used = new boolean[s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			boolean found = false;
			for (int j = 0; j < s2.length(); j++) {
				if (!used[j] && s1.charAt(i) == s2.charAt(j)) {
					used[j] = true;
					found = true;
					break;
				}
			}
			if (!found) return false;
		}
		return true;
	}
	   
	public static String preProcess(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isLetter(c)) result += Character.toLowerCase(c);
		}
		return result;
	} 
	   
	public static String randomAnagram(String str) {
		String temp = str;
		String result = "";
		while (temp.length() > 0) {
			int r = (int)(Math.random() * temp.length());
			result += temp.charAt(r);
			temp = temp.substring(0, r) + temp.substring(r + 1);
		}
		return result;
	}
}
