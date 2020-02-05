package pl.mosura.entity;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


@Data
public class userDTO {
    private Long id;
    private String username;
    private List<devDTO> listOfRpis;
    private short language;


    public userDTO(rpi_users rpiUser) {
        this.id = rpiUser.getId();
        this.username = rpiUser.getUsername();
        this.listOfRpis = rpiUser.getListOfRpis().stream()
                .map(devDTO::new)
                .collect(Collectors.toList());
        this.language = rpiUser.getLanguage();
    }


}
