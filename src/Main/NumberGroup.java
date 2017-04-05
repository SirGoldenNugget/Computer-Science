package Main;

import java.util.ArrayList;
import java.util.List;

public interface NumberGroup
{
	boolean contains(int number);
}

class Range implements NumberGroup
{
	int min;
	int max;

	public Range(int min, int max)
	{
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean contains(int number)
	{
		return number >= min && number <= max;
	}
}

class MultipleGroups implements NumberGroup
{
	private List<NumberGroup> groupList;

	public MultipleGroups()
	{
		groupList = new ArrayList<NumberGroup>();
	}

	@Override
	public boolean contains(int number)
	{
		for (NumberGroup group : groupList)
		{
			if (group.contains(number))
			{
				return true;
			}
		}

		return false;
	}
}
