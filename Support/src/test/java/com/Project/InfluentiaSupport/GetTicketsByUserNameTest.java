package com.Project.InfluentiaSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;
import com.Project.InfluentiaSupport.service.GetTicketsByUserName;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class GetTicketsByUserNameTest {

    private MockMvc mockMvc;

    @Mock
    private SupportTicketsRepo supportTicketsRepo;

    @InjectMocks
    private GetTicketsByUserName getTicketsByUserName;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(getTicketsByUserName).build();
    }

    @Test
    public void testGetAllTicketsByUserName() throws Exception {
        String userName = "JohnDoe";

        // Create a list of dummy support tickets
        List<SupportTickets> dummyTickets = new ArrayList<>();
        dummyTickets.add(new SupportTickets());
        dummyTickets.add(new SupportTickets());

        // Mock the repository method to return the dummy tickets
        when(supportTicketsRepo.findByRaisedByUserName(userName)).thenReturn(dummyTickets);

        // Perform the GET request to the controller endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/tickets/{userName}", userName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(dummyTickets.size()));
    }

    @Test
    public void testGetAllTicketsByUserName_NoTicketsFound() {
        String userName = "JohnDoe";

        // Mock the repository method to return an empty list
        when(supportTicketsRepo.findByRaisedByUserName(userName)).thenReturn(new ArrayList<>());

        // Assert that a ResourceNotFoundException is thrown
        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            getTicketsByUserName.getAllTicketsByUserName(userName);
        });
    }
}