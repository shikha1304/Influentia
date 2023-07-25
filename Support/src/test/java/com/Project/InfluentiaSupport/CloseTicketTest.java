package com.Project.InfluentiaSupport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;
import com.Project.InfluentiaSupport.service.CloseTicket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CloseTicketTest {

    @Mock
    private SupportTicketsRepo supportTicketsRepo;

    @InjectMocks
    private CloseTicket closeTicket;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateTicketByRes_Success() throws ResourceNotFoundException {
        // Arrange
        int ticketId = 1;
        SupportTickets supportTicket = new SupportTickets();
        supportTicket.setTicketId(ticketId);
        supportTicket.setTicketStatus("Open");
        when(supportTicketsRepo.findById(ticketId)).thenReturn(java.util.Optional.of(supportTicket));

        // Act
        closeTicket.updateTicketByRes(ticketId);

        // Assert
        assertEquals("Close", supportTicket.getTicketStatus());
        verify(supportTicketsRepo, times(1)).findById(ticketId);
        verify(supportTicketsRepo, times(1)).save(supportTicket);
    }

    @Test
    public void testUpdateTicketByRes_ThrowsResourceNotFoundException() {
        // Arrange
        int ticketId = 1;
        when(supportTicketsRepo.findById(ticketId)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> closeTicket.updateTicketByRes(ticketId));
        verify(supportTicketsRepo, times(1)).findById(ticketId);
        verify(supportTicketsRepo, never()).save(any(SupportTickets.class));
    }
}