package dto;

public class StudentDTO {
    private String sID;
    private String name;
    private String nIC;
    private String address;
    private String contact;
    private String dOfBirth;
    private String age;

    public StudentDTO(String sID, String name, String nIC, String address, String contact, String dOfBirth, String age) {
        this.sID = sID;
        this.name = name;
        this.nIC = nIC;
        this.address = address;
        this.contact = contact;
        this.dOfBirth = dOfBirth;
        this.age = age;
    }

    public StudentDTO() {
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getnIC() {
        return nIC;
    }

    public void setnIC(String nIC) {
        this.nIC = nIC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getdOfBirth() {
        return dOfBirth;
    }

    public void setdOfBirth(String dOfBirth) {
        this.dOfBirth = dOfBirth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "sID='" + sID + '\'' +
                ", name='" + name + '\'' +
                ", nIC='" + nIC + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dOfBirth='" + dOfBirth + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
