public class Algebra {
	public static void main(String args[]) {
	    System.out.println(plus(2,3));
	    System.out.println(minus(7,2));
   		System.out.println(minus(2,7));
 		System.out.println(times(3,4));
   		System.out.println(plus(2,times(4,2)));
   		System.out.println(pow(5,3));
   		System.out.println(pow(3,5));
   		System.out.println(div(12,3));   
   		System.out.println(div(5,5));    
   		System.out.println(div(25,7));   
   		System.out.println(mod(25,7));   
   		System.out.println(mod(120,6));  
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	public static int plus(int x1, int x2) {
		if (x2 < 0) return minus(x1, -x2);
		for (int i=0;i<x2;i++){
			x1++;
		}
		return x1;
	}

	public static int minus(int x1, int x2) {
		if (x2 < 0) return plus(x1, -x2);
		for (int i=0;i<x2;i++){
			x1--;
		}
		return x1;
	}

	public static int times(int x1, int x2) {
		boolean negative = false;
		if (x1 < 0) { x1 = -x1; negative = !negative; }
		if (x2 < 0) { x2 = -x2; negative = !negative; }
		int sum = 0;
		for (int i=0;i<x2;i++){
			sum = plus(sum, x1);
		}
		return negative ? -sum : sum;
	}

	public static int pow(int x, int n) {
		boolean negative = false;
		if (x < 0 && n % 2 != 0) negative = true;
		if (x < 0) x = -x;
		int sum = 1;
		for (int i=0;i<n;i++){
			sum = times(sum, x);
		}
		return negative ? -sum : sum;
	}

	public static int div(int x1, int x2) {
		if (x2 == 0) throw new ArithmeticException("Division by zero");
		boolean negative = false;
		if (x1 < 0) { x1 = -x1; negative = !negative; }
		if (x2 < 0) { x2 = -x2; negative = !negative; }
		int count = 0;
		int sum = 0;
		while (plus(sum, x2) <= x1) {
			sum = plus(sum, x2);
			count++;
		}
		return negative ? -count : count;
	}

	public static int mod(int x1, int x2) {
		int q = div(x1, x2);
		int p = times(q, x2);
		return minus(x1, p);
	}	

	public static int sqrt(int x) {
		int r = 0;
		while (times(r, r) <= x) {
			r++;
		}
		return r - 1;
	}	  	  	
}
