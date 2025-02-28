package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(SecureController.class)
public class SecureControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    @WithMockUser(username = "admin", roles = "ADMIN")
//    void shouldAllowAdminAcces() throws Exception {
//        mockMvc.perform(get("/secure/admin"))
//                .andExpect(status().isOk());
//    }

}
