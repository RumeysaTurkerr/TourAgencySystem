package com.patikapaycore.TourAgencySystem.service;
import com.patikapaycore.TourAgencySystem.model.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    List<Ticket> getAllTickets();

    Ticket getTicket(Integer id);

    void addTicket(Ticket ticket);

    Ticket updateTicket(Ticket ticket);

    boolean deleteTicket(Integer id);

}
