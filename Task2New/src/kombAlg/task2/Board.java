package kombAlg.task2;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.*;

public class Board 
{
	private Koord _hKoord;
	private Koord _pKoord;
	
	private Set<Koord> _forbidden;
	private Set<Koord> _visited;
	private List<Koord> _path;
	
	private static final Logger logger = Logger.getLogger(Board.class.getName());
	
	public Board(Koord hKoord, Koord pKoord )
	{
		_hKoord = hKoord;
		_pKoord = pKoord;
		
		_forbidden = new HashSet<Koord>();
		try
		{
			_forbidden.add(_pKoord.add(1, 1));
		}
		catch (KoordException ex)
		{
			
		}
		
		try
		{
			_forbidden.add(_pKoord.add(1, -1));
		}
		catch (KoordException ex)
		{
			
		}
	}
	
	public String findPath( )
	{
		_visited = new HashSet<Koord>();
		_path = new ArrayList<Koord>();
		
		move(_hKoord);
		
		String path = "";
		for (int i=_path.size() - 1; i>=0; i--)
		{
			path += _path.get(i).toStringValue() + "\n";
		}
		path += _pKoord.toStringValue();
		
		return path;
	}
	
	public boolean move(Koord next)
	{
		if (next.equals(_pKoord))
		{
			return true;
		}
		
		if (_forbidden.contains(next))
		{
			return false;
		}
		if (_visited.contains(next))
		{
			return false;
		}
		
		//logger.info(String.format("Move to %s %s", next.toString(), next.toStringValue()));
		_visited.add(next);
		
		boolean flag = false;
		List<Koord> adj = next.getAdjacent();
		//logger.info(adj.toString());
		for (Koord one: adj)
		{
			flag = (flag | move(one));
			if (flag)
			{
				break;
			}
		}
		
		if (flag)
		{
			_path.add(next);
		}
		
		return flag;
	}

}
