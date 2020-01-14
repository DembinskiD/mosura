package pl.mosura.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class rpi_payments {

    @Id
    @GeneratedValue
    private long id;
    private long user_id;
    private float payment_amount;
    private String payment_date;
    private String payment_source;
}
