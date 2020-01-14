package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class rpi_modules {

    @Id
    @GeneratedValue
    private long id;
    private long rpi_id;
    private String mod_name;
}
