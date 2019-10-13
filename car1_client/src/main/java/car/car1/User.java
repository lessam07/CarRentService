// New version of User POJO
package car.car1;

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

// Old version of User POJO

//package car.car1;
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.Collection;
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//
//import org.hibernate.validator.constraints.NotBlank;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.
//        SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//@Entity
//@Data
//@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
//@RequiredArgsConstructor
//@Table(name="\"users\"")
//public class User {
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private int id;
////    String ROLE_PREFIX = "ROLE_";
//    private String username;
//
//    private String password;
//
//    private String fullname;
//
//    private String role;
//
//    private String phone_number;
//
//}








