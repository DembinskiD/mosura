package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class config_triggers {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String created_at;
}