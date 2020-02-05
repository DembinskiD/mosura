package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "data_lights", schema = "shrimps")
public class data_lights {

    @Id
    @GeneratedValue
    private long id;
    private long rpi_device_id;
    private long config_trigger_id;
    private boolean device_status;
    private String created_at;
    private String updated_at;
}
