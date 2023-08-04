public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String city;

    Account account;

    private static int sayacCustomer = 1000;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String city) {
        setCustomerId(sayacCustomer++);
        setFirstName(firstName);
        setLastName(lastName);
        setCity(city);

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
