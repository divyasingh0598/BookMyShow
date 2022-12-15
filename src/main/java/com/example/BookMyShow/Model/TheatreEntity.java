package com.example.BookMyShow.Model;

import com.example.BookMyShow.enums.SeatType;
import com.example.BookMyShow.enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "theatres")
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name" , nullable = false)
    private String name;

    private SeatType seatType;

    @Column(name = "address" , nullable = false)
    private String address;

    @Column(name = "city" , nullable = false)
    private String city;


    @OneToMany( mappedBy = "theatre" , cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowEntity> shows;

    TheatreType type;
    @OneToMany(mappedBy = "theatre" , cascade = CascadeType.ALL)
    @JsonIgnore
    List<TheatreSeatEntity>seats;
}
