package microservices.userdetails;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Entity
@Data
@Table(name="\"users\"")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id

    private int id;

    private String username;

    private String password;

    private String fullname;

    private String role;

    private String phone_number;


    public User(String username, String password, String fullname, String role, String phone_number) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.phone_number = phone_number;
    }

    public User() {
    }
}
