package com.gl.TicketTracker.service;

import java.util.List;

import com.gl.TicketTracker.entity.Ticket;

// These Are all services That TickerTrackerApplication Can Do.
public interface TicketSevice {
	
	List<Ticket> getAllTickets();
	
	Ticket getTicketById(Long id);
	
	Ticket saveTicket(Ticket ticket);
	
	void deleteTicket(Long id);
	
	Ticket updateTicket(Ticket ticket);
	
	List<Ticket> searchTickets(String query);
	

}
