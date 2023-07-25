package com.Project.InfluentiaSupport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Project.InfluentiaSupport.DTO.SubscriptionPlanDTO;
import com.Project.InfluentiaSupport.DTO.SupportTicketsDTO;
import com.Project.InfluentiaSupport.DTO.UserSubscriptionDTO;
import com.Project.InfluentiaSupport.Entity.SubscriptionPlanSLAs;
import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.InvalidCredentialException;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Repo.SubscriptionPlanSLAsRepo;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;
import com.Project.InfluentiaSupport.service.CreateNewTickets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collections;

public class CreateNewTicketsTest {

    @Mock
    private FeignClients feignClient;

    @Mock
    private SupportTicketsRepo supportTicketsRepo;

    @Mock
    private SubscriptionPlanSLAsRepo subscriptionPlanSLAsRepo;

    @InjectMocks
    private CreateNewTickets createNewTickets;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPlanName() {
        // Arrange
        String userName = "testUser";
        UserSubscriptionDTO subscriptionDTO = new UserSubscriptionDTO();
        subscriptionDTO.setPlanid(new SubscriptionPlanDTO(0, "Basic", 0));
        when(feignClient.getAllPlansByUsername(userName)).thenReturn(Collections.singletonList(subscriptionDTO));

        // Act
        String planName = createNewTickets.getPlanName(userName);

        // Assert
        assertEquals("Basic", planName);
        verify(feignClient, times(1)).getAllPlansByUsername(userName);
    }

    @Test
    public void testAddNewTicket() throws ResourceNotFoundException, InvalidCredentialException {
        // Arrange
        SupportTicketsDTO supportTicketsDTO = new SupportTicketsDTO(null, null, null, null);
        supportTicketsDTO.setRaisedByUserName("testUser");
        supportTicketsDTO.setTicketType("Post Management");
        when(subscriptionPlanSLAsRepo.findByPlanName(anyString())).thenReturn(new SubscriptionPlanSLAs());
        when(supportTicketsRepo.findTicketsByDate(anyString())).thenReturn(0);

        // Act
        String result = createNewTickets.addNewTicket(supportTicketsDTO);

        // Assert
        assertEquals("Added a new Ticket", result);
        verify(subscriptionPlanSLAsRepo, times(1)).findByPlanName(anyString());
        verify(supportTicketsRepo, times(1)).findTicketsByDate(anyString());
        verify(supportTicketsRepo, times(1)).save(any(SupportTickets.class));
    }
}