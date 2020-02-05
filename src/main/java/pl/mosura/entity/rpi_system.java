package pl.mosura.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "rpi_system", schema = "shrimps")

public class rpi_system {

    @Id
    private Long id;
    private Long rpi_id;
    private Timestamp timestamp;
    private String uptime;
    private String system_type;
    private String distro;
    private String distro_version;
    private String distro_release;
    private String kernel_version;
    private String kernel_release;
    private String kernel_arch;
    private String dev_py_version;
    private String dev_py_build;
    private String dev_platform;
    private String dev_compiler;

    @OneToOne
    private rpis rpis;



}
