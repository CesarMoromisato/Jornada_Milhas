package jornadamilhas.api.controller;

import jornadamilhas.api.domain.destinos.DadosCriarDestino;
import jornadamilhas.api.domain.destinos.DadosDetalhamentoDestinos;
import jornadamilhas.api.domain.destinos.DestinoRepository;
import jornadamilhas.api.domain.destinos.Destinos;
import org.aspectj.apache.bcel.Repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class DestinosControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosDetalhamentoDestinos> dadosDetalhamentoDestinosJacksonTester;

    @Autowired
    private JacksonTester<DadosCriarDestino> dadosCriarDestinoJacksonTester;

    @MockBean
    private DestinoRepository repository;

    @Test
    @DisplayName("Deveriar devolver erro 400 quando informacoes invalidas")
    @WithMockUser
    void criar() throws Exception {
        var response = mvc.perform(post("/destinos"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveriar devolver codigo 200 quando informacoes sao validas")
    @WithMockUser
    void criar1() throws Exception {

        var dadosDetalhamento =
                new DadosDetalhamentoDestinos(null, "foto 1", "foto 2", "nome", "string meta", "texto descritivo", true);
        //when(repository.save(any())).thenReturn(dadosDetalhamento);

        var response = mvc.perform(
                post("/destinos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCriarDestinoJacksonTester.write(
                                new DadosCriarDestino("foto 1", "foto 2","nome", "string meta", "texto descritivo")
                                )
                                .getJson()
                        )
                )
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        var jsonEsperado = dadosDetalhamentoDestinosJacksonTester.write(
                dadosDetalhamento
        ).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

}