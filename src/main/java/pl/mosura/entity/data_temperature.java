package pl.mosura.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "data_temperature", schema = "shrimps")
public class data_temperature {

    @Id
    @GeneratedValue
    private Long id;
    private Long rpi_device_id;
    private String sensor_data;
    private String timestamp;
    private String heartbeat;
}
