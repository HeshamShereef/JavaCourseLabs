import java.util.function.BiPredicate;



public class LambdaLab1 {
	
	public static String betterString(String s1, String s2, BiPredicate<String, String>p) {
		if (p.test(s1, s2))
			return s1;
		else return s2;
			
	}
	

	public static void main(String[] args) {
		
		String string1 = "sdsjaddsjfsajfjfa";
		String string2 = "asfjfasnfnasfnfnfnfnfnfnfnfnasnf";
		String longer = betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
		String first = betterString(string1, string2, (s1, s2) -> true);
		
		System.out.println(longer);
		System.out.println(first);


	}
}




