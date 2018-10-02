package learning.rasw.designpatterns.builder;


public class Address {

    private final String street;
    private final String houseNumber;
    private final String localNumber;

    private Address(String street, String houseNumber, String localNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.localNumber = localNumber;
    }
    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public static class Builder {
        private String street;
        private String houseNumber;
        private String localNumber;


        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder houseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder localNumber(String localNumber) {
            this.localNumber = localNumber;
            return this;
        }

        public Address build() {
            return new Address(street, houseNumber, localNumber);
        }
    }
}
