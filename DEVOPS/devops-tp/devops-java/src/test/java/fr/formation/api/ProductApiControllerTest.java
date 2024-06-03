package fr.formation.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.model.Product;
import fr.formation.repo.ProductRepository;
import fr.formation.request.CreateProductRequest;

@ExtendWith(MockitoExtension.class)
class ProductApiControllerTest {
    private final static String ENDPOINT = "/api/product";

    private MockMvc mockMvc;
    private ObjectMapper mapper;

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductApiController ctrl;

    @BeforeEach
    public void beforeEach() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.ctrl).build();
        this.mapper = new ObjectMapper();
    }

    @Test
    void shouldFindAllStatusOk() throws Exception {
        // given

        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldFindAllCallsRepository() throws Exception {
        // given
        Mockito.when(this.repository.findAll()).thenReturn(List.of(new Product(), new Product(), new Product()));

        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT));

        // then
        result.andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
        result.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));

        Mockito.verify(this.repository).findAll();
    }

    @Test
    void shouldCreateStatusCreated() throws Exception {
        // given
        Product product = new Product();
        CreateProductRequest request = new CreateProductRequest();

        request.setName("Nom test");
        request.setPrice(new BigDecimal("57.98"));

        Mockito.when(this.repository.save(Mockito.any())).thenReturn(product);

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .post(ENDPOINT)
                .content(this.mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isCreated());
        result.andExpect(MockMvcResultMatchers.jsonPath("$.id").hasJsonPath());

        Mockito.verify(this.repository).save(Mockito.any());
    }

    @ParameterizedTest
    @MethodSource("provideCreateProductRequests")
    void shouldCreateStatusBadRequest(String name, BigDecimal price) throws Exception {
        // given
        CreateProductRequest request = new CreateProductRequest();

        request.setName(name);
        request.setPrice(price);

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .post(ENDPOINT)
                .content(this.mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private static Stream<Arguments> provideCreateProductRequests() {
        return Stream.of(
            Arguments.of(null, new BigDecimal("57")),
            Arguments.of(" ", new BigDecimal("57")),
            Arguments.of("", new BigDecimal("57")),

            Arguments.of("Un test", new BigDecimal("0")),
            Arguments.of("Un test", new BigDecimal("-1.57")),
            Arguments.of("Un test", null)
        );
    }
}
