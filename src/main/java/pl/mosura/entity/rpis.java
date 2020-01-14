package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class rpis {

    @Id
    @GeneratedValue
    private long id;
    private String hostname;
    private long rpi_user_id;
    private String created_at;
}
