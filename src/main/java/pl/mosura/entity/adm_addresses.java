package pl.mosura.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "adm_addresses", schema = "shrimps")
public class adm_addresses {

    @Id
    private long id;
    private int city_id;
    private String street;
    private String post_code;
    private Long rpi_user_id;
    private String created_at;
    private String updated_at;

    @OneToOne
    private rpi_users rpiusers;
}
