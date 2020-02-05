package pl.mosura.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "shrimps", catalog = "dictionary")
public class shrimps {

    @Id
    @GeneratedValue
    private Long id;

    private String english;

    private String polish;

//    private String german;

}
