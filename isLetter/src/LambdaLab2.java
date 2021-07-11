
public class LambdaLab2 {
	
	public static boolean all_letters(String s1) {
		if(s1.chars().allMatch(Character::isLetter))
			return true;
		else
			return false;
		
	}

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "mdkk22kkk333334jhf";
		
		System.out.println(all_letters(s1)); 
		System.out.println(all_letters(s2)); 
		System.out.println(all_letters("java"));
		System.out.println(all_letters("java8"));

	}

}
