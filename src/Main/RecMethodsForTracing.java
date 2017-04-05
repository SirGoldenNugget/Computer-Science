package Main;

public class RecMethodsForTracing
{
	public static void main(String[] args)
	{
		System.out.print(r7(3));
	}

	public static void r1(int n)
	{
		if (n > 0)
		{
			r1(n - 1);
			System.out.println(n);
			r1(n - 1);
		}
	}

	public static int r2(int n)
	{
		if (n == 1)
		{
			return 2;
		}
		else
		{
			return 2 * r2(n - 1);
		}
	}

	public static int r3(int n, int a, int d)
	{
		if (n == 1)
		{
			return a;
		}
		else
		{
			return d + r3(n - 1, a, d);
		}
	}

	public static int r4(int k, int n)
	{
		if (n == k)
		{
			return k;
		}
		else if (n > k)
		{
			return r4(k, n - k);
		}
		else
		{
			return r4(k - n, n);
		}
	}

	public static int r5(int[] x, int n)
	{
		if (n == 1)
		{
			return x[0];
		}
		else
		{
			int t = r5(x, n - 1);
			if (x[n - 1] > t)
			{
				return x[n - 1];
			}
			else
			{
				return t;
			}
		}

	}

	public static int r6(int n)
	{
		if (n <= 10)
		{
			return n * 2;
		}
		else
		{
			return r6(r6(n / 3));
		}
	}

	public static int r65(int n)
	{
		if (n <= 10)
		{
			return n * 2;
		}

		else
		{
			int temp = r6(n / 3);
			return r6(temp);
		}
	}

	public static int r7(int n)
	{
		if (n < 0)
		{
			return 2;
		}
		else
		{
			return r7(n - 1) + r7(n - 3);
		}
	}

	public static void r8(int n)
	{
		if (n < 0)
		{
			System.out.print("b");
		}

		else
		{
			r8(n - 1);
			System.out.print(":");
			System.out.print(n + "|");
			r8(n - 2);
			System.out.print("*");
		}
	}
}