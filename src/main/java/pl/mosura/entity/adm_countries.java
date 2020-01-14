package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class adm_countries {

    @Id
    @GeneratedValue
    private int id;
    private String country;
}
