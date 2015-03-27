package kombAlg.task2;

import java.io.FileWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Runner 
{
	public static void main(String [] args)
	{
		try
		{
			Scanner sc = new Scanner(
							new FileReader(System.getProperty("user.dir") + "/in.txt"));
			FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/out.txt");
			try
			{
				String first = sc.nextLine();
				char hY = first.charAt(0);
				int hX = Integer.parseInt(first.substring(1, 2));
				String second = sc.nextLine();
				char pY = second.charAt(0);
				int pX = Integer.parseInt(second.substring(1, 2));
				Board board = new Board(new Koord(hX, hY), new Koord(pX, pY));
				String path = board.findPath();
				writer.write(path);
				System.out.println("Done");
			}
			finally
			{
				sc.close();
				writer.flush();
				writer.close();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
