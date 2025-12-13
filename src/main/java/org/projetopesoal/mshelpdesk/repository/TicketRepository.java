package org.projetopesoal.mshelpdesk.repository;

import org.projetopesoal.mshelpdesk.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
