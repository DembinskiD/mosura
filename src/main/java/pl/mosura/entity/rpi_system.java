package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class rpi_system {

    @Id
    @GeneratedValue
    private long id;
    private long rpi_id;
    private String lan_ip;
    private String wlan_ip;
    private String wan_ip;
    private String created_at;
    private String updated_at;
}
