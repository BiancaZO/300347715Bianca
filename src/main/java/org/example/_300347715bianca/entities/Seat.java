package org.example._300347715bianca.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    //private int seatNumber;
    private String customerName;
    private String seatCode; //seatNumber
    private boolean isBooked;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date transactionDate;



}
