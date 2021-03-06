package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ar_internal_metadata {

    @Id
    @GeneratedValue
    private String key;
    private String value;
    private String created_at;
    private String updated_at;
}

