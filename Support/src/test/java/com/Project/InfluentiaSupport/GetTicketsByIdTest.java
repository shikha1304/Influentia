package com.Project.InfluentiaSupport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;
import com.Project.InfluentiaSupport.service.GetTicketsById;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetTicketsByIdTest {

    @Mock
    private SupportTicketsRepo supportTicketsRepo;

    @InjectMocks
    private GetTicketsById getTicketsById;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTicketByTicketId_WhenTicketExists() throws ResourceNotFoundException {
        // Arrange
        int ticketId = 123;
        SupportTickets ticket = new SupportTickets();
        when(supportTicketsRepo.findById(ticketId)).thenReturn(Optional.of(ticket));

        // Act
        SupportTickets result = getTicketsById.getTicketByTicketId(ticketId);

        // Assert
        assertNotNull(result);
        assertEquals(ticket, result);
        verify(supportTicketsRepo, times(1)).findById(ticketId);
    }

    @Test
    void testGetTicketByTicketId_WhenTicketDoesNotExist() {
        // Arrange
        int ticketId = 456;
        when(supportTicketsRepo.findById(ticketId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> getTicketsById.getTicketByTicketId(ticketId));
        verify(supportTicketsRepo, times(1)).findById(ticketId);
    }
}