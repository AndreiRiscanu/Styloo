package com.richkane.styloo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.richkane.styloo.persistence.GenderEnum;
import com.richkane.styloo.persistence.dto.RoleDTO;
import com.richkane.styloo.persistence.dto.UserDTO;
import com.richkane.styloo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void addUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content(asJsonString(new UserDTO("TestFirst", "TestLast", "email",
                        "0712345678", LocalDate.of(1990, 10, 5), GenderEnum.OTHER,
                        Set.of(new RoleDTO(1L, "ADMIN")))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ArgumentCaptor<UserDTO> userCaptor = ArgumentCaptor.forClass(UserDTO.class);
        Mockito.verify(userService).addUser(userCaptor.capture());
        assertEquals(userCaptor.getValue().firstName(), "TestFirst");
        assertEquals(userCaptor.getValue().lastName(), "TestLast");
        assertEquals(userCaptor.getValue().email(), "email");
        assertEquals(userCaptor.getValue().birthDay(), LocalDate.of(1990, 10, 5));
        assertEquals(userCaptor.getValue().phoneNumber(), "0712345678");
        assertEquals(userCaptor.getValue().gender(), GenderEnum.OTHER);
        assertEquals(userCaptor.getValue().roles().size(), 1);
        assertEquals(userCaptor.getValue().roles().stream().findFirst().get().id(), 1L);
        assertEquals(userCaptor.getValue().roles().stream().findFirst().get().name(), "ADMIN");
    }

    @Test
    public void getUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

        Mockito.verify(userService).getUser(1L);
    }

    @Test
    public void getAllUsersTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/all")
                .accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

        Mockito.verify(userService).getAllUsers();
    }

    @Test
    public void deleteUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

        Mockito.verify(userService).deleteUser(1L);
    }

    public static String asJsonString(final Object obj) {
        try {
            ObjectMapper mapper =  new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
