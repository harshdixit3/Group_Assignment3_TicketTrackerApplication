package com.gl.TicketTracker.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.TicketTracker.Repository.TicketRepository;
import com.gl.TicketTracker.entity.Ticket;
import com.gl.TicketTracker.service.TicketSevice;

@Service //This is a Service ClassS
public class TicketServiceImpl implements TicketSevice {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicket(Long id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> searchTickets(String query) {
		return ticketRepository.findByTitleContainingOrShortDescriptionContaining(query, query);
	}

}
