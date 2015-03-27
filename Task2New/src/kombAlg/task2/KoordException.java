package kombAlg.task2;

public class KoordException extends Exception
{
	private String _message;
	
	public KoordException(int x, int y)
	{
		_message = String.format("No cell with koord %s%s", x, y);
	}
	
	public String getMessage() {return _message;}

}
