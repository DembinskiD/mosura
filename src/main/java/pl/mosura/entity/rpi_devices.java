package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class rpi_devices {

    @Id
    @GeneratedValue
    private long id;
    private long rpi_id;
    private long group_id;
    private String name;
    private Integer pin_pwr;
    private Integer pin_btn;
    private String created;

    @OneToMany(mappedBy = "rpi_device_id")
    List<data_temperature> dataTemperatures;

}
