package kombAlg.task2.tests;

import static org.junit.Assert.*;
import kombAlg.task2.Board;
import kombAlg.task2.Koord;
import kombAlg.task2.KoordException;

public class Test 
{
	@org.junit.Test
	public void testKoord() throws KoordException 
	{
		Koord k1 = new Koord(1, 'b');
		Koord k2 = k1.add(1, 1);
	}
	
	@org.junit.Test
	public void testBoard1() throws KoordException 
	{
		Board b = new Board(new Koord(4, 'd'), new Koord(7, 'd'));
		b.findPath();
		System.out.println("--");
	}
	
	@org.junit.Test
	public void testBoard2() throws KoordException 
	{
		Board b = new Board(new Koord(8, 'a'), new Koord(5, 'a'));
		b.findPath();
	}

}
