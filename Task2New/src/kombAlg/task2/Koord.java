package kombAlg.task2;

import java.util.ArrayList;
import java.util.List;

public class Koord 
{
	private static String yIndex = "abcdefgh";
	private static String xIndex = "12345678";
	private static int size = 7;
	
	private int _x;
	private int _y;
	
	//Without translation
	public Koord(int x, int y) throws KoordException
	{
		if (x < 0 || x > size)
		{
			throw new KoordException(x, y);
		}
		_x = x;
		
		if (y < 0 || y > size)
		{
			throw new KoordException(x, y);
		}
		_y = y;
	}
	
	//With translation
	public Koord(int x, char y) throws KoordException
	{
		x -= 1;
		if (x < 0 || x > size)
		{
			throw new KoordException(x, y);
		}
		_x = x;
		
		_y = yIndex.indexOf(y);
		if (_y == -1)
		{
			throw new KoordException(x, _y);
		}
	}
	
	public Koord add(int x, int y) throws KoordException
	{
		return new Koord(_x + x, _y + y);
	}
	
	public String toStringValue( )
	{
		return String.format("%s%s", yIndex.charAt(_y), _x + 1);
	}
	
	public String toString( )
	{
		return String.format("%s%s", _x, _y);
	}
	
	public boolean equals(Object another)
	{
		try
		{
			Koord k2 = (Koord) another;
			return (_x == k2._x && _y == k2._y);
		}
		catch (Exception ex)
		{
			return false;
		}
		
	}
	
	public int hashCode( )
	{
		return _x + _y;
	}
	
	public List<Koord> getAdjacent( )
	{
		List<Koord> adj = new ArrayList<Koord>();
		
		try
		{
			adj.add(this.add(2, 1));
		}
		catch (KoordException ex)
		{
			
		}

		try
		{
			adj.add(this.add(2, -1));
		}
		catch (KoordException ex)
		{
			
		}
		
		try
		{
			adj.add(this.add(1, -2));
		}
		catch (KoordException ex)
		{
			
		}
		
		try
		{
			adj.add(this.add(-1, -2));
		}
		catch (KoordException ex)
		{
			
		}
		
		try
		{
			adj.add(this.add(-2, -1));
		}
		catch (KoordException ex)
		{
			
		}
		
		try
		{
			adj.add(this.add(-2, 1));
		}
		catch (KoordException ex)
		{
			
		}
		
		try
		{
			adj.add(this.add(-1, 2));
		}
		catch (KoordException ex)
		{
			
		}
		
		try
		{
			adj.add(this.add(1, 2));
		}
		catch (KoordException ex)
		{
			
		}
		
		return adj;
	}
}
