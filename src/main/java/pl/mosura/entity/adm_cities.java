package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class adm_cities {
    @Id
    @GeneratedValue
    private long id;
    private String city;
    private Long county_id;
    private Long country_id;
}
