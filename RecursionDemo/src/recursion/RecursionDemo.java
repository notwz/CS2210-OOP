package recursion;

public class RecursionDemo {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//	
//	public static boolean isPal(String s) { 
//		if (s.length() <= 1 ) return true;
//		int n = s.length()-1;
//		// s[0] + s[1..n-1] + s[n] 
//		
//		return s.charAt(0) == s.charAt(n) && isPal(s.substring(1, n));
//		
//		
//	}
	
	interface I1 { 
	    void m(); 
	}

	interface I2 { 
	    public void m();
	    public void p();
	}

	class D extends C implements I1, I2 {
	     public void p() {}
	}

	class C implements I2 {
	     public void m(){}

		@Override
		public void p() {
			// TODO Auto-generated method stub
			
		}
	 }

}
