/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Write an application that lets the user create a management company and add the properties managed by the company to its list
 * Due: 10/24/2022
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dolev Peleg
*/

/**
* This class represents a plot
* Has an x, y, width, and depth
*/
public class Plot 
{
	//Creating private data fields
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 * No-argument constructor. Creates a plot with a default values for x and y, and 1 for width and depth
	 */
	public Plot()
	{
		this.width = 1;
		this.depth = 1;
	}
	
	/**
	 * Constructors that takes an x, y, width, and depth as arguments
	 * Creates a plot based on the passed arguments
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Constructors that takes another plot as an argument
	 * Creates a deep copy of another plot object
	 */
	public Plot (Plot otherPlot)
	{
		this.x = otherPlot.getX();
		this.y = otherPlot.getY();
		this.width = otherPlot.getWidth();
		this.depth = otherPlot.getDepth();	
	}

	/**
	 * Checks if a plot encompasses another
	 * @param otherPlot
	 * @return a boolean, true it encompasses false if not
	 */
	boolean encompasses(Plot otherPlot)
	{
		// Checks if the x and y values of the plot are both lower than the other plot's, AND the width and depth values of the plot are higher than the other plot's. Return true only if all the conditions are true,
		// else return false
		if (x < otherPlot.getX() &&
			y < otherPlot.getY() &&
			width > (otherPlot.getX() + otherPlot.getWidth()) &&
			depth > (otherPlot.getY() + otherPlot.getDepth()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Getters and Setters for all the private fields
	public int getDepth() 
	{
		return depth;
	}
	
	public int getWidth() 
	{
		return width;
	}
	
	public int getX() 
	{
		return x;
	}
	
	public int getY() 
	{
		return y;
	}
	
	public void setDepth(int depth) 
	{
		this.depth = depth;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}
	
	public void setX(int x) 
	{
		this.x = x;
	}

	public void setY(int y) 
	{
		this.y = y;
	}
	
	/**
	 * Checks if a plot overlaps another
	 * @param otherPlot
	 * @return a boolean, true it overlaps false if not
	 */
	boolean overlaps(Plot otherPlot)
	{
		//	Checks if the either of the plots are to the left of each other, or above each other. If any of the conditions are true, return true, else return false
		if (y >= (otherPlot.getY() + otherPlot.getDepth()) || (y + depth) <= otherPlot.getY())
		{
			return false;
		}
		else if ((x + width) <= otherPlot.getX() || x >= (otherPlot.getX() + otherPlot.getWidth()))
		{
			
			return false;
		}
		else
		{
			return true;
		}
	}
	
	// Overriding the toString method
	@Override
	public String toString()
	{
		return(this.getX() + "," + this.getY() + "," + this.getWidth() + "," + this.getDepth());
	}
}
