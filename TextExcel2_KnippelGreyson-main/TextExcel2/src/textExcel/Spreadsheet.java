package textExcel;
 
// Update this file with your own code.
 
public class Spreadsheet extends Grid
{
	private Cell [][]grid;
	private int row;
	private int col;
	
	public Spreadsheet()
	{
		super();
		row = 0;
		col = 0;
		grid = new Cell [20][12];
		
		for(int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[0].length; c++)
			{
				grid[r][c] = new EmptyCell();				
			}
			
		}
		
	}
	@Override
	public String processCommand(String command)
	{

		if (command.contains("=") && command.contains(("\""))) //example input: "B1 = "hi"" //for assigning values to cells
		{
			String cellName = command.substring(0,command.indexOf("=") - 1);
			String cellText = command.substring(command.indexOf("\"") + 1);
			cellText = cellText.substring(0,cellText.indexOf("\""));
			
			SpreadsheetLocation s1 = new SpreadsheetLocation(cellName.toUpperCase());
			
			TextCell tempcell = new TextCell(cellText);
			
			TextCell textcell = new TextCell(tempcell.abbreviatedCellText());

			
			grid[s1.getRow()][s1.getCol()] = tempcell;
			
			return getGridText();
			
		}
		
		if(command.length() <= 3 && !command.contains("=") && !command.contains("clear") && !command.equals("")) //example input: "B1" 
																												//inspecting cell value
		{
			String cellName = command;
			SpreadsheetLocation s1 = new SpreadsheetLocation(cellName.toUpperCase());
			
		
			return grid[s1.getRow()][s1.getCol()].fullCellText();
			

		}
		
		if(command.toLowerCase().contains("clear") && command.length() <=5) //example input: "clear" //for clearing every cell in grid
		{
			for(int r = 0; r < 20; r++)
			{
				for(int c = 0; c < 12; c++)
				{
					grid[r][c] = new EmptyCell();
				}
			}
			return getGridText();


		}
		
		if(command.toLowerCase().contains("clear") && command.length() > 5) //example: clear B1 //for clearing a single cell in grid
		{
			String cellName = command.substring(command.indexOf(" ") + 1);
			SpreadsheetLocation s1 = new SpreadsheetLocation(cellName.toUpperCase());
			grid[s1.getRow()][s1.getCol()] = new EmptyCell();
			
			return getGridText();


		}
		
		
		if(command.contains("%")) //example A1 = 3.14% //for inputs with percent values
		{
			String cellName = command.substring(0,command.indexOf("=") - 1);
			String cellPercentVal = command.substring(command.indexOf("=") + 2,command.indexOf("%"));
			
			SpreadsheetLocation s1 = new SpreadsheetLocation(cellName.toUpperCase());
			
			
			PercentCell Percell = new PercentCell(cellPercentVal);
			
			

			
			grid[s1.getRow()][s1.getCol()] = Percell;
			
			return getGridText();
		}
		
		if(command.toLowerCase().contains(".") && command.length() > 2 || !command.contains("\"") && !command.contains("(") && command.length() >= 3)
		{
			String cellName = command.substring(0,command.indexOf("=") - 1);  //for double value commands. example: D1 = 3.14
			String cellValue = command.substring(command.indexOf("=") + 2);
			
			SpreadsheetLocation s1 = new SpreadsheetLocation(cellName.toUpperCase());
			
			if(!cellValue.contains("."))
			{
				cellValue += ".0";
			}
			
			ValueCell Valcell = new ValueCell(cellValue);
			
			
			

			
			grid[s1.getRow()][s1.getCol()] = Valcell;
			
			return getGridText();

		}
		
		if (command.contains("(") && !command.contains("\"")) //example B1 = ( A1 + A2 ) //for formula cells
		{
			String cellName = command.substring(0,command.indexOf("=") - 1);
			String cellFormula = command.substring(command.indexOf("=") + 2);
			
			SpreadsheetLocation s1 = new SpreadsheetLocation(cellName.toUpperCase());
			
			FormulaCell Formcell = new FormulaCell(cellFormula);
			

			
			grid[s1.getRow()][s1.getCol()] = Formcell;
			
			return getGridText();
		}
	
	
		
		return command;
		
		
		
		
	}
 
	@Override
	public int getRows()
	{	
		return 20;
	}
 
	@Override
	public int getCols()
	{
		return 12;
	}
 
	@Override
	public Cell getCell(Location loc)
	{

		return grid[loc.getRow()][loc.getCol()];
	}
 
	@Override
	public String getGridText()
	{
		String gridText = "";
		
		for(int r = 0; r < 20; r++)
		{
			if(r > 8)
			{
			gridText += r+1 + " ";
			}
			else
			{
			gridText += r+1 + "  ";
			}
			
			//w
			for(int c = 0; c < 12; c++)
			{
				gridText += "|" + grid[r][c].abbreviatedCellText();
			}
			gridText += "|\n";
		}
		return "   |A         |B         |C         |D         |E         |F         |G"
				+ "         |H         |I         |J         |K         |L         |\n" + gridText;	
	}
	
	// You are free to use this helper method.  It takes a column letter (starting at "A")
	// and returns the column number corresponding to that letter (0 for "A", 1 for "B", etc.)  
	// WARNING!!  If the parameter is not a single, capital letter in the range of your Spreadsheet,
	// bad things might happen!
	public static int getColumnNumberFromColumnLetter(String columnLetter)
	{
		return Character.toUpperCase(columnLetter.charAt(0)) - 'A';
	}
 
	// You are free to use this helper method.  It takes a column number (starting at 0)
	// and returns the column letter corresponding to that number ("A" for 0, "B" for 1, etc.)
	// WARNING!!  If the parameter is not a number in the range of your Spreadsheet,
	// bad things might happen!
	public static String getColumnLetterFromColumnNumber(int columnNumber)
	{
		return "" + (char) ('A' + columnNumber);
	}
}