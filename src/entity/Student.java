package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student {

    private String SID;
    private String name;
    @Id
    private String NIC;
    private String address;
    private String contact;
    private String dOfBirth;
    private String age;

    @OneToMany(mappedBy = "student")
    private List<Registration> registrationList;

    public Student(String SID, String name, String NIC, String address, String contact, String dOfBirth, String age) {
        this.SID = SID;
        this.name = name;
        this.NIC = NIC;
        this.address = address;
        this.contact = contact;
        this.dOfBirth = dOfBirth;
        this.age = age;
    }

    public Student(String SID, String name, String NIC, String address, String contact, String dOfBirth, String age, List<Registration> registrationList) {
        this.SID = SID;
        this.name = name;
        this.NIC = NIC;
        this.address = address;
        this.contact = contact;
        this.dOfBirth = dOfBirth;
        this.age = age;
        this.registrationList = registrationList;
    }

    public Student() {
    }

    public String getSID() {
        return SID;
    }

    public void setsID(String SID) {
        this.SID = SID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void getNIC(String NIC) {
        this.NIC = NIC;
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
                "sID='" + SID + '\'' +
                ", name='" + name + '\'' +
                ", nIC='" + NIC + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dOfBirth='" + dOfBirth + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
