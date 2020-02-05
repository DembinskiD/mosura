package pl.mosura.entity;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class devDTO {

    private long id;
    private String hostname;
    private Long userId;
    List<rpiDevDTO> rpiDevDTOS;


    public devDTO(rpis rpi) {
        this.id = rpi.getId();
        this.hostname = rpi.getHostname();
        this.userId = rpi.getRpi_user_id();
        this.rpiDevDTOS = rpi.getRpiDevices().stream()
                .map(rpiDevDTO::new)
                .collect(Collectors.toList());
    }


}
