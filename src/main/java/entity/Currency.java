package entity;
import jakarta.persistence.*;

@Entity
public class Currency {
    @Id
    private String code;

    // Constructors, getters, and setters
    public Currency() {
    }

    public Currency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}