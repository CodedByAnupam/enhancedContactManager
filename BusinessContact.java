
public class BusinessContact extends Contact {
    private String company;
    private String jobTitle;

    public BusinessContact(String name, String phoneNumber, String email, String company, String jobTitle) {
        super(name, phoneNumber, email);
        if (company == null || company.trim().isEmpty()) {
            throw new IllegalArgumentException("Company cannot be empty.");
        }
        if (jobTitle == null || jobTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Job title cannot be empty.");
        }
        this.company = company;
        this.jobTitle = jobTitle;
    }

    
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if (company == null || company.trim().isEmpty()) {
            throw new IllegalArgumentException("Company cannot be empty.");
        }
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        if (jobTitle == null || jobTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Job title cannot be empty.");
        }
        this.jobTitle = jobTitle;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + company + "," + jobTitle;
    }

    @Override
    public String toJSON() {
        return "{ \"name\": \"" + getName() + "\", \"phoneNumber\": \"" + getPhoneNumber() + "\", \"email\": \"" + getEmail() + "\", \"company\": \"" + company + "\", \"jobTitle\": \"" + jobTitle + "\" }";
    }

    @Override
    public String toString() {
        return super.toString() + "\nCompany: " + company + "\nJob Title: " + jobTitle;
    }
}
