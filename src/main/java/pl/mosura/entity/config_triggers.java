package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "config_triggers", schema = "shrimps")
public class config_triggers {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String created_at;
}