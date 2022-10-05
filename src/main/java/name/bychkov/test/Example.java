package name.bychkov.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Example {

    @Id
    @GeneratedValue
    private Long id;
    private String addressLine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    @Override
    public String toString() {
        return "Example[id: " + getId() + ", addressLine: " + getAddressLine() + "]";
    }

}
