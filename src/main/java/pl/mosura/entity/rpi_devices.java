package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class rpi_devices {

    @Id
    @GeneratedValue
    private long id;
    private long rpi_id;
    private long config_group_id;
    private String name;
    private Integer pin_pwr;
    private Integer pin_btn;
    private String created_at;
    private String updated_at;

}
