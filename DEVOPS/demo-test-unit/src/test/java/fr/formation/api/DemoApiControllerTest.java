package fr.formation.api;

import java.util.List;

import org.hamcrest.Matchers;
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

import fr.formation.api.response.DemoResponse;
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

    @Test
    void shouldHelloDemoJsonStatusOk() throws Exception {
        // given
        DemoResponse r1 = new DemoResponse();
        DemoResponse r2 = new DemoResponse();
        DemoResponse r3 = new DemoResponse();

        r1.setContent("R1");

        List<DemoResponse> responses = List.of(r2, r1, r3);

        Mockito.lenient().when(this.service.demo()).thenReturn("Hello demo !!");
        Mockito.when(this.service.demoJson()).thenReturn(responses);

        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/demo/json"));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
        result.andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
        result.andExpect(MockMvcResultMatchers.jsonPath("$[1].content").value("R1"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(responses.size())));

        Mockito.verify(this.service).demoJson();
    }
}
