package pl.mosura.entity;

import lombok.Data;

import java.util.List;


@Data
public class userDTO {
    private Long id;
    private String name;
    private List<rpis> ListOfRpis;
    private String surname;


    public userDTO(Long id, String name, List<rpis> listOfRpis, String surname) {
        this.id = id;
        this.name = name;
        ListOfRpis = listOfRpis;
        this.surname = surname;
    }


}
