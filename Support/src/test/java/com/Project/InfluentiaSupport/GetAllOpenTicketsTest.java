package com.Project.InfluentiaSupport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;
import com.Project.InfluentiaSupport.service.GetAllOpenTickets;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetAllOpenTicketsTest {

    @Mock
    private SupportTicketsRepo supportTicketsRepo;

    @InjectMocks
    private GetAllOpenTickets getAllOpenTickets;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testViewAllNewTickets_WhenTicketsExist() throws ResourceNotFoundException {
        // Arrange
        List<SupportTickets> tickets = new ArrayList<>();
        tickets.add(new SupportTickets());
        when(supportTicketsRepo.findByTicketStatus("Open")).thenReturn(tickets);

        // Act
        Iterable<SupportTickets> result = getAllOpenTickets.viewAllNewTickets();

        // Assert
        assertNotNull(result);
        assertEquals(tickets, result);
        verify(supportTicketsRepo, times(1)).findByTicketStatus("Open");
    }

    @Test
    void testViewAllNewTickets_WhenNoTicketsExist() {
        // Arrange
        when(supportTicketsRepo.findByTicketStatus("Open")).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> getAllOpenTickets.viewAllNewTickets());
        verify(supportTicketsRepo, times(1)).findByTicketStatus("Open");
    }
}