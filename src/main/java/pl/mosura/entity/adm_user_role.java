package pl.mosura.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "adm_user_role")
public class adm_user_role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "usr_role")
    private String usr_role;



}
