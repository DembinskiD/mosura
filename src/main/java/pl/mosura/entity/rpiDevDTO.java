package pl.mosura.entity;


import lombok.Data;

@Data
public class rpiDevDTO {

    private Long id;
    private String name;
    private data_temperature latestTemp;

    public rpiDevDTO(rpi_devices rpi_devices) {
        this.id = rpi_devices.getId();
        this.name = rename(rpi_devices.getName());
        getTemp(rpi_devices);
    }

    private String rename(String inputString) {
        return inputString.replaceAll("[T,t]emp_", "");

    }

    private void getTemp(rpi_devices rpi_devices) {
        int count = rpi_devices.getDataTemperatures().size();
        if(count > 0) {
            this.latestTemp = rpi_devices.getDataTemperatures()
                    .stream()
                    .skip(rpi_devices.getDataTemperatures().size() - 1)
                    .findFirst()
                    .orElseGet(data_temperature::new);
        } else {
            this.latestTemp = new data_temperature();
        }
    }
}
