package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "adm_counties", schema = "shrimps")
public class adm_counties{

    @Id
    @GeneratedValue
    private long id;
    private String county_name;

}
