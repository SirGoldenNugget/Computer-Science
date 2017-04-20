package Main;

interface Item
{
	double purchasePrice();
}

public class FRQ2006
{
	public static void main(String[] args)
	{
		q2();
	}

	public static void q2()
	{
		Vehicle car = new Vehicle(20000, 1000, 0.10);
		System.out.println("The car will cost you" + car.purchasePrice());
	}

}

abstract class TaxableItem implements Item
{
	private double taxRate;

	public TaxableItem(double rate)
	{
		taxRate = rate;
	}

	public abstract double getListPrice();

	public double purchasePrice()
	{
		return getListPrice() * (taxRate + 1.0);
	}
}

class Vehicle extends TaxableItem
{
	private double cost;
	private double markup;

	public Vehicle(double cost, double markup, double taxrate)
	{
		super(taxrate);

		this.cost = cost;
		this.markup = markup;
	}

	@Override
	public double getListPrice()
	{
		return cost + markup;
	}

	public void chnageMarkup(double markup)
	{
		this.markup = markup;
	}
}
