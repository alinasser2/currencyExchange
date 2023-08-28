package com.gp.currencyexchange;


import com.gp.currencyexchange.web.controller.CurrencyExchangeController;
import com.gp.currencyexchange.web.response.CurrencyPreferencesResponse;
import com.gp.currencyexchange.service.ExchangeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class ExchangeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ExchangeService exchangeService;

    @InjectMocks
    private CurrencyExchangeController currencyController;


    @Test
    public void testGetLatestExchangeRate() throws Exception {
        String base = "USD";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/latest/{base}", base))
                .andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(status().isOk());

    }

    @Test
    public void testGetPairExchangeRate() throws Exception {
        String base = "USD";
        String target = "EUR";
        String amount ="50";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/pair/{base}/{target}/{amount}", base, target,amount))
                .andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(status().isOk());

    }

    @Test
    public void testGetHistoryExchangeRate() throws Exception {
        String base = "USD";
        String year = "2023";
        String month = "08";
        String day = "27";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/history/{base}/{year}/{month}/{day}", base, year, month, day))
                .andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(status().isOk());
        // Add further assertions as needed
    }
    @Test
    public void testCompareTwoCurrencies() throws Exception {
        String base = "USD";
        String first_target = "EUR";
        String second_target = "AED";
        String amount ="50";
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/compare/{base}/{first_target}/{second_target}/{amount}",base,first_target,second_target,amount))
                .andDo(MockMvcResultHandlers.print());
        resultActions.andExpect(status().isOk());

    }
    @Test
    public void testCompareManyCurrencies() throws Exception {

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/rates")
                        .param("base_code", "USD")
                        .param("targets", "EUR", "GBP","AED")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
              resultActions.andExpect(status().isOk());

    }}