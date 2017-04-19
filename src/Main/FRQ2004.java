package Main;

import java.util.ArrayList;
import java.util.List;

public class FRQ2004
{
	public static void main(String[] args)
	{
		q2();
	}

	public static void q2()
	{
		Cat c = new Cat("Fluffy");
		System.out.println(c.speak()); // should print "meow"
		Dog d = new Dog("Fido");
		LoudDog e = new LoudDog("Spot");
		Kennel k = new Kennel(d, d, d);
		k.allSpeak();
	}
}

abstract class Pet
{
	private String myName;

	public Pet(String name)
	{
		myName = name;
	}

	public String getName()
	{
		return myName;
	}

	public abstract String speak();
}

class Dog extends Pet
{
	public Dog(String name)
	{
		super(name);
	}

	public String speak()
	{
		return "";
	}
}

class Cat extends Pet
{
	public Cat(String name)
	{
		super(name);
	}

	@Override
	public String speak()
	{
		return "meow";
	}
}

class LoudDog extends Dog
{
	public LoudDog(String name)
	{
		super(name);
	}

	@Override
	public String speak()
	{
		return super.speak() + super.speak();
	}
}

class Kennel
{
	private List<Pet> petList;

	public Kennel(Pet p1, Pet p2, Pet p3)
	{
		petList = new ArrayList<Pet>();
		petList.add(p1);
		petList.add(p2);
		petList.add(p3);
	}

	public void allSpeak()
	{
		for (Pet pet : petList)
		{
			System.out.println(pet.getName() + " " + pet.speak());
		}
	}
}