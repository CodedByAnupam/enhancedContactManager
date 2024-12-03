
public class PersonalContact extends Contact {
    private String birthday; 

    public PersonalContact(String name, String phoneNumber, String email, String birthday) {
        super(name, phoneNumber, email);
        if (birthday == null || birthday.trim().isEmpty()) {
            throw new IllegalArgumentException("Birthday cannot be empty.");
        }
        this.birthday = birthday;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        if (birthday == null || birthday.trim().isEmpty()) {
            throw new IllegalArgumentException("Birthday cannot be empty.");
        }
        this.birthday = birthday;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + birthday;
    }

    @Override
    public String toJSON() {
        return "{ \"name\": \"" + getName() + "\", \"phoneNumber\": \"" + getPhoneNumber() + "\", \"email\": \"" + getEmail() + "\", \"birthday\": \"" + birthday + "\" }";
    }

    @Override
    public String toString() {
        return super.toString() + "\nBirthday: " + birthday;
    }
}
