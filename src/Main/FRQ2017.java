package Main;

import java.util.ArrayList;

// For Testing.

interface StudyPractice
{
	String getProblem();

	void nextProblem();
}

// Question 1.

public class FRQ2017
{
	public static void main(String[] args)
	{
		Digits digits = new Digits(12345);
		System.out.println(digits.getDigitList().toString());
		System.out.println(digits.isStrictlyIncreasing());

		Phrase phrase = new Phrase("HelloAndHello");
		System.out.println(phrase.findLastOccurence("lo"));
	}
}

// Question 2.

class Digits
{
	private ArrayList<Integer> digitList;

	// Part A.

	public Digits(int num)
	{
		digitList = new ArrayList<>();

		while (num > 0)
		{
			digitList.add(0, num % 10);
			num /= 10;
		}
	}

	// Part B.

	public boolean isStrictlyIncreasing()
	{
		int previous = digitList.get(0).intValue();

		for (int i = 1; i < digitList.size(); ++i)
		{
			if (digitList.get(i).intValue() < previous)
			{
				return false;
			}

			previous = digitList.get(i).intValue();
		}

		return true;
	}

	public ArrayList<Integer> getDigitList()
	{
		return digitList;
	}
}

class MultPractice implements StudyPractice
{
	int i, j;

	public MultPractice(int i, int j)
	{
		this.i = i;
		this.j = j;
	}

	@Override
	public String getProblem()
	{
		return i + " TIMES " + j;
	}

	@Override
	public void nextProblem()
	{
		++j;
	}
}

// Question 3.

class Phrase
{
	private String currentPhrase;

	public Phrase(String p)
	{
		currentPhrase = p;
	}

	public void replaceNthOccurence(String str, int n, String repl)
	{
		int index = findNthOccurence(str, n);

		if (index >= 0)
		{
			currentPhrase = currentPhrase.substring(0, index) + repl + currentPhrase.substring(index + repl.length());
		}
	}

	public int findNthOccurence(String str, int n)
	{
		return 0; // Implementation Not Shown.
	}

	public int findLastOccurence(String str)
	{
		int index = 0;
		int count = 0;

		String temp = currentPhrase;

		while (temp.indexOf(str) >= 0)
		{
			index = temp.indexOf(str);
			count += index + str.length();
			temp = temp.substring(index + str.length());
		}

		return count;
	}
}

// Question 4.

class Position
{
	public Position(int r, int c)
	{
		// Implementation Not Shown.
	}

	public static Position findPosition(int num, int[][] intArr)
	{
		for (int r = 0; r < intArr.length; ++r)
		{
			for (int c = 0; c < intArr[r].length; ++c)
			{
				if (intArr[r][c] == num)
				{
					return new Position(r, c);
				}
			}
		}

		return null;
	}

	public static Position[][] getSuccessorArray(int[][] intArr)
	{
		Position[][] positions = new Position[intArr.length][intArr[0].length];

		for (int r = 0; r < intArr.length; ++r)
		{
			for (int c = 0; c < intArr[r].length; ++c)
			{
				positions[r][c] = findPosition(intArr[r][c] + 1, intArr);
			}
		}

		return positions;
	}
}