package fr.formation.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.formation.service.DemoService;

@ExtendWith(MockitoExtension.class)
class DemoApiControllerTest {
    private MockMvc mockMvc;

    @Mock // On demande à Mockito de la simuler
    private DemoService service;

    @InjectMocks // On demande à Mockito d'injecter les instances
    private DemoApiController ctrl;

    @BeforeEach
    public void beforeEach() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(ctrl).build();
    }

    @Test
    void shouldHelloDemoStatusOk() throws Exception {
        // given
        Mockito.when(this.service.demo()).thenReturn("Hello demo !!");

        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/demo"));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
        result.andExpect(MockMvcResultMatchers.content().string("Hello demo !!"));

        // Mockito.verify(this.service).demo();
        Mockito.verify(this.service, Mockito.times(1)).demo();
    }
}
