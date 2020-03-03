package opencart.model;

public class Customer {

    private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    private String password;

    public static Builder newEntity() { return new Customer().new Builder(); }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public class Builder {
        private Builder() {}
        public Builder withFirstname(String firstname) { Customer.this.firstname = firstname; return this; }
        public Builder withLastname(String lastname) { Customer.this.lastname = lastname; return this; }
        public Builder withEmail(String email) { Customer.this.email = email; return this; }
        public Builder withPhone(String phone) { Customer.this.telephone = phone; return this; }
        public Builder withPassword(String password) { Customer.this.password = password; return this; }
        public Customer build() {return Customer.this; }
    }

}