package textExcel;

public class TextCell extends Cell
{
	private String text;
	private String temptext;
	
	public TextCell(String text)
	{
		this.text = text;
		temptext = text;
	}
	
	public String abbreviatedCellText() 
	{
		String spaces = "";
		
		if (this.text.length() > 10)
		{
			return temptext.substring(0, 10);
		}
		
		else
		{
			for(int i = 0; i < 10 - this.text.length(); i++)
			{
				spaces += " ";
			}
			return temptext + spaces;
		}
			
	}
	
	public String fullCellText() 
	{ 
		return "\"" + text + "\"";
	}
}
