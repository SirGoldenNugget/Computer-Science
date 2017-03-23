package Main;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Recur
{
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		long number;

		int num, response = 1;

		do
		{
			System.out.println();
			System.out.print("Make a selection" + "\n");
			System.out.print("    (1) Count Up" + "\n");
			System.out.print("    (2) Number of factors of two" + "\n");
			System.out.print("    (3) Perfect power of three?" + "\n");
			System.out.print("    (4) Reverse a number" + "\n");
			System.out.print("    (5) Change to base 2" + "\n");
			System.out.print("    (6) Print with Commas" + "\n");
			System.out.print("    (0) To quit" + "\n");
			response = Integer.parseInt(JOptionPane.showInputDialog("Enter a number:"));
			System.out.println();

			switch (response)
			{
				case 1:
					num = Integer.parseInt(JOptionPane.showInputDialog("What number should we count to?  "));
					countUp(num);
					break;
				case 2:
					num = Integer.parseInt(JOptionPane.showInputDialog("How many factors of 2 in what number?  "));
					System.out.print("There are " + twos(num) + " factors of two in " + num + "\n");
					break;
				case 3:
					num = Integer.parseInt(JOptionPane.showInputDialog("Perfect power of 3?  What positive integer? "));
					System.out.print(num + " is ");
					if (!powerOfThree(num))
					{
						System.out.print("not ");
					}
					System.out.print("a perfect power of three. " + "\n");
					break;
				case 4:
					number = Long.parseLong(JOptionPane.showInputDialog("What integer to reverse? "));
					System.out.print("The number " + number + " reversed is ");
					System.out.println(reverse(number));
					System.out.println();
					break;
				case 5:
					num = Integer.parseInt(JOptionPane.showInputDialog("Change what number to base 2? "));
					System.out.print(num + " written in base 2 is ");
					base2(num);
					System.out.println();
					break;
				case 6:
					number = Long.parseLong(JOptionPane.showInputDialog("What number to print with commas? "));
					printWithCommas(number);
					System.out.println();
					break;
				case 0:
					System.out.println("Good-bye.");
					System.exit(0);
					break;
				default:
					break;
			}

			System.out.println();

		} while (response > 0);

		System.out.println("Negative.");
		System.exit(0);
	}

	public static void countUp(int num)
	{
		/************************/
	      /*                    */
      	/* Your code goes here. */
      	/*                      */
		/************************/
	}

	public static int twos(int num)
	{
		/************************/
      	/*                      */
      	/* Your code goes here. */
      	/*                      */
		/************************/
		return -1;
	}

	public static boolean powerOfThree(int num)
	{
		/************************/
      	/*                      */
      	/* Your code goes here. */
      	/*                      */
		/************************/
		return true;
	}

	public static long reverse(long number)
	{
		/************************/
      	/*                      */
      	/* Your code goes here. */
      	/*                      */
		/************************/
		return -1;
	}

	public static void base2(int num)
	{
		/************************/
      	/*                      */
      	/* Your code goes here. */
      	/*                      */
		/************************/
	}

	public static void printWithCommas(long number)
	{
		/************************/
      	/*                      */
      	/* Your code goes here. */
      	/*                      */
		/************************/
	}
}