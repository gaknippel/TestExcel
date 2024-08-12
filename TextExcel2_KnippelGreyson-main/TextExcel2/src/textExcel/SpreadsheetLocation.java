package textExcel;
 
//Update this file with your own code.
 
public class SpreadsheetLocation extends Location
{
	
	private String Cname;
	private int colNum;
	private int rowNum;
   
    
    public SpreadsheetLocation(String cellName)
    {
    	super();
    	Cname = cellName;
    	rowNum = Integer.parseInt(cellName.substring(1)) - 1;
    	colNum = Spreadsheet.getColumnNumberFromColumnLetter(cellName.substring(0, 1));
    }
    
    @Override
    public int getRow()
    {
        return rowNum;
    }
 
    @Override
    public int getCol()
    {
        return colNum;
    }
 
}