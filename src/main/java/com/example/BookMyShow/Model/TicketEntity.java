package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tickets")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "alloted_seats", nullable = false)
    private String allotedSeats;

    @Column(name = "amounts" , nullable = false)
    private double amounts;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "boooked_at" , nullable = false)
    private Date bookedAt;


    @ManyToMany
    @JoinColumn
    @JsonIgnore
    UserEntity user;
}
