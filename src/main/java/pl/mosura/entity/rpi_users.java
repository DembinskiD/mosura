package pl.mosura.entity;



import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Data
@Entity
@Table(name = "rpi_users")
public class rpi_users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "role_id")
    private int role_id;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "password_digest")
    private String password_digest; //hash

    @Column(name = "status")
    private int status;

    @Column(name = "created_at")
    private String created_at;


    @OneToMany(mappedBy = "rpi_user_id")
    private List<rpis> listOfRpis;


    public userDTO getDAO() {
        return new userDTO(this.id, this.name, this.listOfRpis, this.surname);

    }



    public boolean digestPass(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(password.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String hashText = no.toString(16);
        while(hashText.length() < 32) {
            hashText = "0" + hashText;
        }
        return hashText.equals(password_digest);
    }

}
