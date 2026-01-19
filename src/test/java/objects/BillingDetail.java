package objects;

public class BillingDetail {
    private String billingFirstName;
    private String billingLastName;
    private String billingAddressLine1;
    private String billingZipCode;
    private String billingEmail;

    private Country country;
    private String billingState;
    private String billingCity;

    public BillingDetail(String firstName,
                         String lastName,
                         String addressLine1,
                         String zipCode,
                         String email,
                         String state,
                         String city,
                         Country country){
        this.billingFirstName = firstName;
        this.billingLastName = lastName;
        this.billingAddressLine1 = addressLine1;
        this.billingZipCode = zipCode;
        this.billingEmail = email;
        this.billingState = state;
        this.billingCity = city;
        this.country = country;
    }

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public String getBillingAddressLine1() {
        return billingAddressLine1;
    }

    public void setBillingAddressLine1(String billingAddressLine1) {
        this.billingAddressLine1 = billingAddressLine1;
    }

    public String getBillingZipCode() {
        return billingZipCode;
    }

    public void setBillingZipCode(String billingZipCode) {
        this.billingZipCode = billingZipCode;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }
}
