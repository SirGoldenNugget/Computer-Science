package Main;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println(r2(2));
	}

	public static void rec1(String str)
	{
		int len = str.length();

		if (len > 1)
		{
			String temp = str.substring(0, len - 1);
			rec1(temp);
			System.out.println(temp);
		}
	}

	public static int r2(int n)
	{
		if (n == 1)
		{
			return 3;
		}
		else
		{
			return 3 * r2(n - 1);
		}
	}


	public static void r01(int n)
	{
		int stop = 4;
		if (n <= stop)
		{
			System.out.print(Math.max(n, stop));
		}
		else
		{
			r01(n - 1);
			System.out.print(n);
		}
	}

	public static void r02(int n)
	{

		if (n <= 1)
		{
			System.out.println(1);
		}
		else
		{
			r02(n - 1);
			System.out.println(n);
		}
	}

	public static void r03(int n)
	{
		if (n <= 1)
		{
			System.out.println(1);
		}
		else
		{
			System.out.println(n);
			r03(n - 1);
		}
	}

	public static void whatsItDo(String str)
	{

		int len = str.length();

		if (len > 1)

		{

			String temp = str.substring(0, len - 1);

			whatsItDo(temp);

			System.out.println(temp);

		}
	}

	public static void rec2(String str)
	{
		if (str.length() < 15)
		{
			System.out.println(str);
			rec2(str + "*");
		}
	}

	public static int rec3(int n, int a, int d)
	{
		if (n == 1)
		{
			return a;
		}
		else
		{
			return d + rec3(n - 1, a, d);
		}
	}

	public static int r04(int n)
	{
		if (n == 1)
		{
			return 1;
		}
		else
		{
			return (2 * n - 1) + r04(n - 1);
		}
	}

	public static int recur(int n)
	{

		if (n <= 10)

		{
			return n * 2;
		}

		else

		{

			int temp1 = recur(n / 3);

			int ret = recur(temp1);

			return ret;

		}

	}
}
