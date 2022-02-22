package com.patikapaycore.TourAgencySystem.model.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @NotNull(message = "seats can not be null")
    private Integer seats;

    @NotNull(message = "start date can not be null")
    @Column(name = "start_date")
    private Date startDate;

    @NotNull(message = "end date can not be null")
    @Column(name = "end_date")
    private Date endDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "traveller_id")
    private Traveller traveller;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private Tour tour;
}
