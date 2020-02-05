package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Target;

@Data
@Entity
@Table(name = "adm_countries", schema = "shrimps")
public class adm_countries {

    @Id
    @GeneratedValue
    private int id;
    private String country;
}
