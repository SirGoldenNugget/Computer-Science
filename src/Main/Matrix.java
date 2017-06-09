package Main;

public class Matrix
{
	private final int rows;
	private final int cols;
	private double[][] values;

	// values are in row major order
	// vals may be null, must be a deep copy
	public Matrix(double[] vals, int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;

		values = new double[this.rows][this.cols];

		int count = 0;

		for (int i = 0; i < this.rows; ++i)
		{
			for (int j = 0; j < this.cols; ++j)
			{
				values[i][j] = vals[count++];
			}
		}
	}

	public Matrix(double[][] vals)
	{
		this.rows = vals.length;
		this.cols = vals[0].length;
		this.values = vals;
	}

	// copy constructor
	public Matrix(Matrix other)
	{
		this.rows = other.rows;
		this.cols = other.cols;
		this.values = other.values;
	}

	public static void main(String[] args)
	{
		double[] vals = {2, 3, 1, 1, 1, 1, 3, 2, 1};
		Matrix a = new Matrix(vals, 3, 3);
		Matrix b = new Matrix(new double[] {1, 1, 1}, 3, 1);
		Matrix c = new Matrix(new double[] {2, 2, 2}, 3, 1);
		Matrix d = new Matrix(new double[] {1, 2, 3, 4}, 2, 2);
		Matrix e = new Matrix(new double[] {5, 6, 7, 8}, 2, 2);
		Matrix f = new Matrix(new double[] {1, 2, 3, 4, 5, 6}, 3, 2);
		Matrix g = new Matrix(new double[] {7, 8, 9, 10, 11, 12}, 2, 3);

		a.show();
		a.setRow(new double[] {1, 1, 1}, 0);
		a.show();

		b.add(c).show();
		a.scalarMult(2);
		a.show();
		Matrix.identity(8).show();
		a.mult(b).show();
		d.mult(e).show();
		f.mult(g).show();
	}

	// return a square identity matrix
	public static Matrix identity(int dim)
	{
		double[] vals = new double[dim * dim];

		int count = 0;

		for (int i = 0; i < vals.length; ++i)
		{
			if (i != count)
			{
				vals[i] = 0;
			}

			else
			{
				vals[i] = 1;
				count += dim + 1;
			}
		}

		return new Matrix(vals, dim, dim);
	}

	public static double dot(double[] vals1, double[] vals2)
	{
		int sum = 0;

		if (vals1.length == vals2.length)
		{
			for (int i = 0; i < vals1.length; ++i)
			{
				sum += vals1[i] * vals2[i];
			}
		}

		return sum;
	}

	// rElements and cElements can
	// contains any valid row and column
	// index (and repeat them as desires
	// rElements and cElements must have
	// the same size.
	// The dim(new Matrix) == dim(rElements) == dim(cElements)
	// If ret is the returned matrix
	// ret[r][c] == m[ rElements[r][c] ][ cElements[r][c] ]
	// you can create a return matrix larger than original
	public static Matrix partOf(Matrix m, int[][] rElements, int[][] cElements)
	{
		return null; // no comprendo los directiones
	}

	public int getRows()
	{
		return rows;
	}
	// not mutator

	public int getCols()
	{
		return cols;
	}

	// not a mutator
	public Matrix add(Matrix other)
	{
		if (rows == other.rows && cols == other.cols)
		{
			double[] vals = new double[getValues().length];

			for (int i = 0; i < vals.length; ++i)
			{
				vals[i] = getValues()[i] + other.getValues()[i];
			}

			return new Matrix(vals, rows, cols);
		}

		return null;
	}

	// return value in a 1-D array, row major order
	public double[] getValues()
	{
		double[] vals = new double[values.length * values[0].length];

		int count = 0;

		for (int i = 0; i < rows; ++i)
		{
			for (int j = 0; j < cols; ++j)
			{
				vals[count++] = values[i][j];
			}
		}

		return vals;
	}

	// mutator
	public void scalarMult(double fact)
	{
		for (int i = 0; i < rows; ++i)
		{
			for (int j = 0; j < cols; ++j)
			{
				values[i][j] *= fact;
			}
		}
	}

	// So a.mult(b) is a*b matrix mult
	// To be allowable, the number of cols
	// in a has to be equal to the number of rows
	// in b. Throw an IllegalArgumentException
	// if this condition is not met
	public Matrix mult(Matrix other) throws IllegalArgumentException
	{
		if (cols != other.getRows())
		{
			throw new IllegalArgumentException();
		}

		double[][] vals = new double[rows][other.getCols()];

		for (int i = 0; i < vals.length; ++i)
		{
			for (int j = 0; j < vals[i].length; ++j)
			{
				for (int k = 0; k < getRow(i).length; ++k)
				{
					vals[i][j] += getRow(i)[k] * other.getCol(j)[k];
				}
			}
		}

		return new Matrix(vals);
	}

	// mutator
	public void set(double v, int r, int c)
	{
		if (r < rows && c < cols)
		{
			values[r][c] = v;
		}
	}

	public void setRow(double[] v, int r)
	{
		if (r < rows && v.length == cols)
		{
			values[r] = v;
		}
	}

	public void setCol(double[] v, int c)
	{
		if (c < cols && v.length == rows)
		{
			int count = 0;

			for (int i = 0; i < rows; ++i)
			{
				values[i][c] = v[count++];
			}
		}
	}

	public double[] getRow(int r)
	{
		return values[r];
	}

	public double[] getCol(int c)
	{
		double[] col = new double[rows];

		int count = 0;

		for (int i = 0; i < rows; ++i)
		{
			col[count++] = values[i][c];
		}

		return col;
	}

	// print out matrix entries, 1 row per line
	public void show()
	{
		for (double[] vals : values)
		{
			for (double value : vals)
			{
				System.out.print(value + " ");
			}

			System.out.println();
		}

		System.out.println();
	}
}

abstract class Vector extends Matrix
{
	// can be a row or column vector
	public Vector(double[] vals, boolean bRow)
	{
		super(vals, bRow ? 1 : vals.length, bRow ? vals.length : 1);
	}

	public abstract double dot(Vector other);
}

// has only 1 row
class RVector extends Vector
{
	public RVector(double[] vals)
	{
		super(vals, true);
	}

	public double dot(Vector other)
	{
		return Matrix.dot(this.getValues(), other.getValues());
	}
}

// has only 1 column
class CVector extends Vector
{
	public CVector(double[] vals)
	{
		super(vals, false);
	}

	public double dot(Vector other)
	{
		return Matrix.dot(this.getValues(), other.getValues());
	}
}