package sherlockandthebeast;

import java.util.Scanner;

/**
 *
 * @author Slava
 * 
 * Sherlock and The Beast
 * 
 * Sherlock Holmes suspects his archenemy, Professor Moriarty, is once again plotting something diabolical. 
 * Sherlock's companion, Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their supercomputer, The Beast.
 *
 * Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting
 * about infecting The Beast with a virus; however, he also gives him a clue—a number, N. 
 * Sherlock determines the key to removing the virus is to find the largest Decent Number having N digits.
 *
 * A Decent Number has the following properties:
 * Its digits can only be 3's and/or 5's.
 * The number of 3's it contains is divisible by 5.
 * The number of 5's it contains is divisible by 3.
 * If there are more than one such number, we pick the largest one.
 * Moriarty's virus shows a clock counting down to The Beast's destruction, and time is running out fast. 
 * Your task is to help Sherlock find the key before The Beast is destroyed!
 *
 * Input Format
 *
 * The first line is an integer, , denoting the number of test cases.
 *
 * The  subsequent lines each contain an integer, , detailing the number of digits in the number.
 *
 * Output Format
 *
 * Print the largest Decent Number having  digits; if no such number exists, tell Sherlock by printing -1.
 *
 * Sample Input
 * 4
 * 1
 * 3
 * 5
 * 11
 * 
 * Sample Output
 * -1
 * 555
 * 33333
 * 55555533333
 * 
 */
public class SherlockAndTheBeast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] nrOfDigitsArray = new int[t];
        
        for(int a0 = 0; a0 < t; a0++){
            nrOfDigitsArray[a0] = in.nextInt(); 
        }
        
        for(int i = 0; i < nrOfDigitsArray.length; i++)
        {
            int[] result = getDecentNumber(nrOfDigitsArray[i]);
            
            if(result[0] == -1)
                System.out.println(-1);
            else
            {
                for(int fives = 0; fives < result[0]; fives++)
                    System.out.print(5);
                for(int threes = 0; threes < result[1]; threes++)
                    System.out.print(3);
                
                System.out.println();
            }
        }
    }
    
    private static int[] getDecentNumber(int nrOfDigits)
    {
        int nrOf3s = ((2 * nrOfDigits) % 3) * 5;
        
        if(nrOf3s > nrOfDigits)
            return new int[]{-1, -1};
            
        return new int[]{nrOfDigits - nrOf3s, nrOf3s};
    }
    
    private static int[] getDecentNumberBruteforce(int nrOfDigits)
    {
        int nrOf5s = nrOfDigits;
        int nrOf3s = 0;
        int[] result = new int[]{-1, -1};
        
        for(int i = 0; i <= nrOfDigits; i++)
        {
            if(nrOf5s % 3 == 0 && nrOf3s % 5 == 0)
            {
                result[0] = nrOf5s;
                result[1] = nrOf3s;
                
                return result;
            }
            
            nrOf5s--;
            nrOf3s++;
        }
        
        return result;
    }
}
