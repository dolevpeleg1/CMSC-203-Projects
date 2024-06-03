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
* This class represents a management company
* Has a name, taxID, mgmFee, plot, propertiesList, and numofProperties
*/
public class ManagementCompany 
{
	// Creating private fields
	private String name;
	private String taxID;
	private double mgmFee;
	private Plot plot;
	private Property[] propertiesList;
	private int numOfPropeties = 0;
	
	// Creating and initializing static constants
	static final int MAX_PROPERTY = 5;
	static final int MGMT_WIDTH = 10;
	static final int MGMT_DEPTH = 10;
	
	
	/**
	 * No-argument constructor. Creates a management company with an empty name, empty taxID, creates a new default plot, sets the with and the depth to the max values, and initializes the properties list
	 */
	public ManagementCompany()
	{
		this.name = "";
		this.taxID = "";
		plot = new Plot();
		plot.setWidth(MGMT_WIDTH);
		plot.setDepth(MGMT_DEPTH);
		this.propertiesList = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Constructors that takes a name, taxID, and mgmFee as arguments
	 * Creates a management company based on the given arguments, creates a new default plot, sets the with and the depth to the max values, and initializes the properties list
	 */
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot();
		plot.setWidth(MGMT_WIDTH);
		plot.setDepth(MGMT_DEPTH);
		this.propertiesList = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Constructors that takes a name, taxID, mgmFee, x, y, width, and depth as arguments
	 * Creates a management company based on the given arguments, creates a new plot based on the given arguments, and initializes the properties list
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(x, y, width, depth);
		this.propertiesList = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Constructor that takes another management company object as an argument
	 * Constructors that creates a management company as a deep copy of another company
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.getName();
		this.taxID = otherCompany.getTaxID();
		this.mgmFee = otherCompany.getMgmFee();
		this.propertiesList = new Property[MAX_PROPERTY];
		
		// Creating a deep copy of the property list from the other company
		for (int counter = 0; counter < otherCompany.getProperties().length; counter++) 
		{
			propertiesList[counter] = new Property(otherCompany.getProperties()[counter]);
		}
	}
	
	/**
	 * Add a property to the list of properties, overloaded method
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return an int, -1 if the array is full, -2 if the property is null, -3 if it is not encompassed by the company, -4 if it overlaps another property, the index number if added successfully
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		// Returning an int using the overloaded addProperty method
		return (addProperty(new Property(name, city, rent, owner)));
	}
	
	/**
	 * Add a property to the list of properties, overloaded method
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return an int, -1 if the array is full, -2 if the property is null, -3 if it is not encompassed by the company, -4 if it overlaps another property, the index number if added successfully
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		// Returning an int using the overloaded addProperty method
		return (addProperty(new Property(name, city, rent, owner, x, y, width, depth)));
	}
	
	/**
	 * Add a property to the list of properties, overloaded method
	 * @param otherProperty
	 * @return an int, -1 if the array is full, -2 if the property is null, -3 if it is not encompassed by the company, -4 if it overlaps another property, the index number if added successfully
	 */
	public int addProperty(Property otherProperty)
	{
		// Creating a new property based on the arguments passed to the method
		Property property = new Property(otherProperty);
		
		// Creating a boolean that holds the value to whether the plot overlaps another on the list
		boolean isOverlapping = false;
		
		// Checking if the plot overlaps another on the list
		for (int counter = 0; counter < numOfPropeties; counter++)
		{
			if(property.getPlot().overlaps(propertiesList[counter].getPlot()))
			{
				isOverlapping = true;
				break;
			}
		}
		
		// Creating a return value
		int returnVal = 0;
		
		// If the array is already full, return -1
		if (isPropertiesFull())
		{
			returnVal = -1;
		}
		
		// If the property is null, return -2 
		else if (property == null)
		{
			returnVal = -2;
		}
		
		// If the company does not encompasses the property plot, return -3
		else if(plot.encompasses(property.getPlot()) == false)
		{
			returnVal = -3;
		}
		
		// If the property overlaps any properties in the array, return -4
	    else if (isOverlapping)
		{
			returnVal = -4;
		}
	    
	    // Adding the property into the property list, incrementing the number of properties in the array, returning the index of the new property
	    else
	    {
	    	propertiesList[numOfPropeties] = property;
	 	    numOfPropeties++;
	 	    returnVal = (numOfPropeties -1);
	    }
		
		// Return the returned value
		return returnVal;
	}
	
	/**
	 * Removes the last property
	 */
	public void removeLastProperty()
	{
		// Nullifying the the last property in the list
		propertiesList[numOfPropeties - 1] = null;
		numOfPropeties--;
	}
	
	/**
	 * Removes the last property
	 * @return a boolean, true it the array is full, false if not
	 */
	public boolean isPropertiesFull()
	{
		// If the number of properties in the list is 5, return true, else return false
		if (numOfPropeties == MAX_PROPERTY)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Removes the last property
	 * @return an int, the number of properties in the company
	 */
	public int getPropertiesCount()
	{
		// Return the number of properties in the list
		return numOfPropeties;
	}
	
	/**
	 * Removes the last property
	 * @return a double, the total rent of all the properties combined
	 */
	public double getTotalRent()
	{
		// Creating a for loop that adds all the properties' rent into totalRent, and return that value
		double totalRent = 0;
		for (int counter = 0; counter < numOfPropeties; counter++)
		{
			totalRent += propertiesList[counter].getRentAmount();
			
		}
		return totalRent;
	}
	
	/**
	 * Removes the last property
	 * @return a Property, property with the highest rent
	 */
	public Property getHighestRentPropperty()
	{
		// Creating a for loop that goes through all the properties in the array, assigning index to the element in the array with the highest rent
		double highestRent = 0;
		int index = 0;
		for (int counter = 0; counter < numOfPropeties; counter++)
		{
			if (propertiesList[counter].getRentAmount() > highestRent)
			{
				highestRent = propertiesList[counter].getRentAmount();
				index = counter;
			}
		}
		
		// Returns the property with the highest rent using the index from the for loop
		return propertiesList[index];
	}
	
	/**
	 * Removes the last property
	 * @return a boolean, true it the management fee valid, false if not
	 */
	public boolean isManagementFeeValid()
	{
		// If the getMgmFee returns a number between 0 and 100 (inclusive), returns true, else return false
		if (getMgmFee() >= 0 && getMgmFee() <= 100)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public Property[] getProperties()
	{
		return propertiesList;
	}
	
	public Plot getPlot()
	{
		return new Plot(plot);
	}

	public double getMgmFee() 
	{
		return mgmFee;
	}
	
	/**
	 * Overrides the toString method. Returns a String that represents all fields of the property
	 * @return a String that represents all fields of the properties of the company
	 */
	@Override
	public String toString()
	{
		String returnedString = "List of the properties for " + getName() + ", taxID: " + getTaxID() + "\n";
		{
			for (int counter = 0; counter < 45; counter ++)
			{
				returnedString += "_";
			}
			returnedString += "\n";
		}
		
		for (int counter = 0; counter < numOfPropeties; counter++)
		{
			returnedString += propertiesList[counter].toString() + "\n";
		}
		
		for (int counter = 0; counter < 45; counter ++)
		{
			returnedString += "_";
		}
		returnedString += "\n\ntotal management Fee: " + getMgmFee();
		return returnedString;
		
	}
}
