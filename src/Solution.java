import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {
    
    
    public static void removeInvalidParanthesis(String expression){
       
        if(expression == null || expression.trim().length() == 0){
            //Invalid input;
            return;
        }
        
        Set<String> visited = new TreeSet<>();
        Queue<String> q = new LinkedList<String>();
        boolean level = false; 
        
        q.add(expression); 
        visited.add(expression);
        while (!q.isEmpty())
        {
          String  str = q.peek();  q.remove();
            if (isValidString(str))
            {
                System.out.println(str);
     
                // If answer is found, make level true
                // so that valid string of only that level
                // are processed.
                level = true;
            }
            if (level)
                continue;
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++)
            {
                if (!isParenthesis(ch[i]))
                    continue;
     
                // Removing parenthesis from str and
                // pushing into queue,if not visited already
                String temp = str.substring(0, i) + str.substring(i + 1);
                if (visited.contains(temp) == visited.isEmpty())
                {
                    q.add(temp);
                    visited.add(temp);
                }
            }
        }
    }
    static boolean  isValidString(String exp)
    {
        int cnt = 0;
        char str[] = exp.toCharArray();
        for (int i = 0; i < str.length; i++)
        {
            if (str[i] == '(')
                cnt++;
            else if (str[i] == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }
    
    
    static boolean isParenthesis(char c)
    {
        return ((c == '(') || (c == ')'));
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String expression =  sc.next();
        
        Solution.removeInvalidParanthesis(expression);
        
        
        /*
         * 
         * Testcase
         * 
         * ()()))
			Your Output

			(())
			()()
			
			
			2
			
			
			()()
(())
         * 
         * 
         */
      
    }
}