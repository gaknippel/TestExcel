package textExcel;

public class PercentCell extends RealCell
{
private String text;
private String finalText;
private double parseText;
	
	public PercentCell(String text)
	{
		super(text);
		this.text = text;
		
		parseText = Double.parseDouble(text);
		double roundedText = Math.floor(parseText);
		
		
		int parseTextInt = (int)roundedText;
		
		finalText = parseTextInt + "%";
		
	}
	
	public String abbreviatedCellText() 
	{
		String spaces = "";
		
		
		
		if (finalText.length() > 10)
		{
			return finalText.substring(0, 10);
		}
		
		else
		{
			for(int i = 0; i < 10 - finalText.length(); i++)
			{
				spaces += " ";
			}
			return finalText + spaces;
		}
			
	}
	
	public String fullCellText() 
	{ 
		double divhundred = parseText/100;
		return divhundred + "";
	}
	
	public double getDoubleValue() 
	{ 
		double truncate = Double.parseDouble(text);
		
		
		
		return truncate; 
	}
}
