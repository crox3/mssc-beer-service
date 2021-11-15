package crox.microservices.msscbeerservices.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import crox.microservices.msscbeerservices.web.model.BeerDto;


@WebMvcTest(BeerController.class)
class BeerControllerTest
{
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    final String URL = "/api/v1/beer/";

    @Test
    void getBeerById() throws Exception
    {
        mockMvc.perform(get(URL + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception
    {
        mockMvc.perform(
                post(URL).accept(MediaType.APPLICATION_JSON).content(beerDtoToJSON(generateBeerDto())))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception
    {
        mockMvc.perform(put(URL + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON).content(beerDtoToJSON(generateBeerDto())))
                .andExpect(status().isCreated());
    }

    private BeerDto generateBeerDto()
    {
        BeerDto dto = BeerDto.builder().build();
        dto.setId(null);
        return dto;
    }

    private String beerDtoToJSON(BeerDto beerDto) throws JsonProcessingException
    {
        return objectMapper.writeValueAsString(beerDto);
    }
}