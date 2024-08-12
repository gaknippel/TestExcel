package textExcel;

public class ValueCell extends RealCell
{
	private String text;
	
	public ValueCell(String text)
	{
		super(text);
		this.text = text;
		
		if(!this.text.contains("."))
		{
			this.text += ".0";
		}
	}
	
	
}
