import java.util.Objects;

/**
 * Class that describes employee address.
 */
public class Address {

    private String city;
    private String street;

    /**
     * Creates address object.
     *
     * @param city city name
     * @param street street name
     */
    public Address(String city, String street) {
        setCity(city);
        setStreet(street);
    }

    /**
     * Copy constructor.
     *
     * @param address source address
     */
    public Address(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }

        this.city = address.city;
        this.street = address.street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty.");
        }

        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street cannot be empty.");
        }

        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{city='" + city + "', street='" + street + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Address)) {
            return false;
        }

        Address address = (Address) obj;

        return Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street);
    }
}