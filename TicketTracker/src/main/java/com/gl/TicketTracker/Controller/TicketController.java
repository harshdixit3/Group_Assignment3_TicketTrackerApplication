package com.gl.TicketTracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.TicketTracker.entity.Ticket;
import com.gl.TicketTracker.service.TicketSevice;

@Controller  //Controller Class For TicketTrackerService
public class TicketController {

	@Autowired
	TicketSevice ticketSevice;
                                                                     
	@RequestMapping("/homeservice")
	public String home(Model model) {
		List<Ticket> tickets = ticketSevice.getAllTickets();
		model.addAttribute("tickets", tickets);
		return "home";
	}

	@GetMapping("/create")
	public String createTicketForm(@ModelAttribute Ticket ticket) {
		return "create";

	}

	@PostMapping("/save")
	public String createTicket(@ModelAttribute Ticket ticket) {
		ticketSevice.saveTicket(ticket);
		return "redirect:/homeservice";
	}

	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		ticketSevice.deleteTicket(id);
		return "redirect:/homeservice";
	}

	@GetMapping("/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		Ticket ticket = ticketSevice.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "edit";
	}

	@PostMapping("/update/{id}")
	public String updateEmployeeForm(@PathVariable Long id, @ModelAttribute Ticket updatedTicket, Model model) {
		Ticket existingTicket = ticketSevice.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTitle(updatedTicket.getTitle());
		existingTicket.setShortDescription(updatedTicket.getShortDescription());
		existingTicket.setCreatedDate(updatedTicket.getCreatedDate());
		ticketSevice.updateTicket(existingTicket);
		return "redirect:/homeservice";
	}

	@GetMapping("/view/{id}")
	public String viewTicket(Model model) {
		List<Ticket> ticketsList = ticketSevice.getAllTickets();
		model.addAttribute("tickets", ticketsList);
		return "home";
	}

	@GetMapping("/search")
	public String searchTickets(@RequestParam String query, Model model) {
		List<Ticket> searchResult = ticketSevice.searchTickets(query);
		model.addAttribute("tickets", searchResult);
		return "home";
	}

}
