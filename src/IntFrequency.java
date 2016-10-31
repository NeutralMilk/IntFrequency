import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IntFrequency
{
    public static void main(String[] args)
    {
        //arraylist to hold ints
        ArrayList<Integer> i = new ArrayList<Integer>();

        //new scanner
        Scanner scanner = new Scanner(System.in);


        int count = 0;
        while(true)
        {
            count++;
            System.out.println("Enter number " + count);

            //if its an integer add it to the list
            if(scanner.hasNextInt())
            {
                int input = scanner.nextInt();
                i.add(input);
            }
            //if not then re enter
            else
            {
                count--;
            }
            //if user types stop then find then go to next step
            if(scanner.hasNextLine())
            {
                String input  = scanner.nextLine();
                if(input.equals(" "))
                {
                    break;
                }//end if
            }//end if
        }//end while

        findFrequency(i);
    }//end main

    //find the most frequent integer
    public static void findFrequency(ArrayList numbers)
    {
        //make a 2D array to store the number and its frequency
        int[][] freq = new int[numbers.size()][2];

        //nested for loops to compare each individual number to every other number in the arraylist
        for(int i = 0; i < numbers.size(); i++)
        {
            for(int j = 0; j < numbers.size(); j++)
            {
                //if the numbers match add it to the array and increase the frequency by 1
                if(numbers.get(i) == numbers.get(j))
                {
                    freq[i][0] = (int)numbers.get(i);
                    freq[i][1]++;
                }//end if
            }//end while
        }//end for

        int max = 0;
        int index = 0;
        //find the highest frequency
        for(int i = 0; i < freq.length; i++)
        {
            if (freq[i][1] > max)
            {
                max = freq[i][1];
                //take a note of the index at which the most frequent number occurs
                index = i;
            }//end if

        }//end for

        System.out.println("Most common integer is " + freq[index][0] + " which occurs " + freq[index][1] + " times");

    }//end findFrequency
}
