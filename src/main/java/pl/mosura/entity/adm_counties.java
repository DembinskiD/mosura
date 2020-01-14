package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class adm_counties{

    @Id
    @GeneratedValue
    private long id;
    private String county_name;

}
