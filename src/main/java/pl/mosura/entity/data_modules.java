package pl.mosura.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class data_modules {

    @Id
    @GeneratedValue
    private long id;
    private long module_id;
    private Integer pid;
    private Boolean enabled;
    private String timestamp;
    private Integer mod_memory;
    private Integer logs_memory;
    private Integer logs_counter;
    private String version;
    private String start_time;
    private String up_time;
}
