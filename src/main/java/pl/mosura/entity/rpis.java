package pl.mosura.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class rpis {

    @Id
    @GeneratedValue
    private long id;
    private String hostname;

    private Long rpi_user_id;

    private String created_at;
    private String timestamp;
    private String LAN;
    private String WAN;
    private String wlan0;
    private String tun0;
    private String MAC;


    @OneToMany(mappedBy = "rpi_id")
    private List<rpi_devices> rpiDevices;
}
