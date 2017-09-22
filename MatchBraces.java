import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MatchBraces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcs = Integer.parseInt(br.readLine());
		try{
			for(int t=1; t<=tcs; t++){
				String str = br.readLine();
				if(IsValidString(str) == true){
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		} catch(Exception ex){
			System.err.println("Invalid Format");
		}
	}
	
	public static boolean IsValidString(String str){
		Stack<Character> stk = new Stack<Character>();
		for(char c: str.toCharArray()){
			if(c == '(' || c == '[' || c == '{' ){
				stk.push(c);
			} else if( (c == ')' && stk.peek() == '(') || 
					   (c == ']' && stk.peek() == '[') ||
					   (c == '}' && stk.peek() == '{') ) { 
				stk.pop();	
			} else {
				return false;
			}
		}
		if(stk.empty() == true)
			return true;
		return false;
	}
}
