package Main;

import java.util.Arrays;

public class DiverseArray
{
	public static void main(String[] args)
	{
		int[][] arr =
		{
			{1, 2, 3},
			{1, 4, 2},
			{1, 3, 23}
		};

		System.out.println(Arrays.toString(rowSums(arr)));

		System.out.println(isDiverse(arr));
	}

	public static boolean isDiverse(int[][] arr2D)
	{
		int[] sums = rowSums(arr2D);

		for (int i = 0; i < sums.length; ++i)
		{
			for (int j = i + 1; j < sums.length; ++j)
			{
				if (sums[i] == sums[j])
				{
					return false;
				}
			}
		}

		return true;
	}

	public static int[] rowSums(int[][] arr2D)
	{
		int[] ret = new int[arr2D.length];

		for (int i = 0; i < arr2D.length; ++i)
		{
			ret[i] = arraySum(arr2D[i]);
		}

		return ret;
	}

	public static int arraySum(int[] arr)
	{
		int ret = 0;

		for (int i : arr)
		{
			ret += i;
		}

		return ret;
	}
}
