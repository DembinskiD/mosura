package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class data_sensors {

    @Id
    @GeneratedValue
    private long id;
    private long rpi_device_id;
    private String sensor_data;
    private String created_at;
    private String updated_at;
}
