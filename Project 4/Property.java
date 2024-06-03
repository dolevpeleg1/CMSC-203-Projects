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
* This class represents a property
* Has a propertyName, city, rentAmount, owner, and a plot
*/
public class Property 
{
	// Creating private fields
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	/**
	 * No-argument constructor. Creates a property with an empty strings for propertyName, city, and owner. Creates a new default plot
	 */
	public Property()
	{
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.plot = new Plot();
	}	
	
	/**
	 * Constructors that takes a propertyName, city, rentAmount, and an owner as arguments
	 * Creates a property based on the given arguments, creates a new default plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}	
	
	/**
	 * Constructors that takes a propertyName, city, rentAmount, owner, x, y, width, and depth as arguments
	 * Creates a property based on the given arguments, and creates a new plot based on the given arguments
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * Constructor that takes another property object as an argument
	 * Constructors that creates a property as a deep copy of another property
	 */
	public Property(Property otherProperty)
	{
		this.propertyName = otherProperty.getPropertyName();
		this.city = otherProperty.getCity();
		this.rentAmount = otherProperty.getRentAmount();
		this.owner = otherProperty.getOwner();
		this.plot = new Plot(otherProperty.getPlot());
	}	
	
	// Getters for each field
	public Plot getPlot() 
	{
		return plot;
	}
	
	public String getPropertyName() 
	{
		return propertyName;
	}

	public String getCity() 
	{
		return city;
	}

	public double getRentAmount() 
	{
		return rentAmount;
	}
	
	public String getOwner() 
	{
		return owner;
	}
	
	/**
	 * Overrides the toString method. Returns a String that represents all fields of the property
	 * @return a String that represents all fields of the property
	 */
	@Override
	public String toString()
	{
		String returnString = "Property Name: " + getPropertyName() + "\nLocated in: " + getCity() +
				"\nBelongs to: " + getOwner() + "\nRent Amount: " + getRentAmount() + "\n";
		return returnString;
	}
	
	
}
