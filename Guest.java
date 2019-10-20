package P1;

public class Guest {
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Guest newG = (Guest)obj;
        if (super.equals(newG) && // compares the 'Being'-parts of objects
                this.lastName.equals(newG.lastName) &&
                this.firstName.equals(newG.firstName) &&
                this.email.equals(newG.email)&&
                this.phoneNumber.equals(newG.phoneNumber)) {
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "Nume: " + lastName + " " + firstName + ", Email: " + email + ", Telefon: " + phoneNumber;
    }
}
