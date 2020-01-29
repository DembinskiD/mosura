package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class rpi_modules {

    @Id
    private Long id;
    private Long rpi_id;
    private String mod_name;
    private Timestamp heartbeat;
    private int fixed;
}
