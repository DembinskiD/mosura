package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "adm_cities", schema = "shrimps")
public class adm_cities {
    @Id
    @GeneratedValue
    private long id;
    private String city;
    private Long county_id;
    private Long country_id;
}
