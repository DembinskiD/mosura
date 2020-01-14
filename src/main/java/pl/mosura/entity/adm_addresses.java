package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class adm_addresses {
    @Id
    @GeneratedValue
    private long id;
    private int city_id;
    private String street;
    private String post_code;
    private Long rpi_user_id;
    private String created_at;
    private String updated_at;
}
