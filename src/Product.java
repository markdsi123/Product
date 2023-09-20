import jdk.jfr.Description;

import java.util.Calendar;

public class Product {
    private String ID;
    private String ProductName;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return ProductName;
    }

    public void setFirstName(String firstName) {
        this.ProductName = firstName;
    }

    public String getLastName() {
        return Description;
    }

    public void setLastName(String Description) {
        this.Description = Description;
    }


    public int getYob() {
        return Price;
    }

    public void setYob(int yob) {
        this.Price = Price;
    }

    private String Description;

    private int Price;

    public Product(String ID, String firstName, String Description, int Price)
    {
        this.ID = ID;
        this.ProductName = firstName;
        this.Description = Description;
        this.Price = Price;
    }


    public String fullName()
    {
        return ProductName  + " " + Description;
    }
    public String formalName()
    {
        return fullName();
    }
    public int getAge()
    {
        return Calendar.getInstance().get(Calendar.YEAR) - Price;
    }
    public int getAge(int year)
    {
        return year - Price;
    }
    public String toCSVDataRecord()
    {
        return ID + ", " + ProductName + ", " + Description + "," + Price;
    }

}
