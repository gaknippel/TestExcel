package textExcel;

public class RealCell extends Cell
{
	private String text;
	
	public RealCell (String text)
	{
		super();
		this.text = text;
	}
	
	public String abbreviatedCellText() 
	{
		String spaces = "";
		
		if (this.text.length() > 10)
		{
			return text.substring(0, 10);
		}
		
		else
		{
			for(int i = 0; i < 10 - this.text.length(); i++)
			{
				spaces += " ";
			}
			return text + spaces;
		} 
	}
	
	public String fullCellText() 
	{ 
		return text;
	}
	
	public double getDoubleValue() 
	{ 
		return Double.parseDouble(text); 
	}
}
