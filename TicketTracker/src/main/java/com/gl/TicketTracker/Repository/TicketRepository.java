package com.gl.TicketTracker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.TicketTracker.entity.Ticket;

@Repository    //TickerRepository is interface For Hibernate To MySql That uses JpaRepository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	List<Ticket> findByTitleContainingOrShortDescriptionContaining(String title, String shortDescription);

}
