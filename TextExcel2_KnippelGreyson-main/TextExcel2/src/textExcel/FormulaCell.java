package textExcel;

public class FormulaCell extends RealCell 
{
	
	public FormulaCell(String text)
	{
		super(text);
	}
	
	public double getDoubleValue() 
	{ 
		return 0.0;
	}
}
