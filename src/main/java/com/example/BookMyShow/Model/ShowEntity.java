package com.example.BookMyShow.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "shows")
public class ShowEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "show_date" , columnDefinition = "DATE" , nullable = false)
    private LocalDate date;

    @Column(name = "show_time" , columnDefinition = "TIME" , nullable = false)
    private LocalTime time;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;


    @ManyToOne
    @JsonIgnore
    private MovieEntity movie;

    @ManyToOne
    @JsonIgnore
    private TheatreEntity theatre;


    @OneToMany(mappedBy = "show" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity>tickets;


    @OneToMany(mappedBy = "show" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatEntity> seats;
}
