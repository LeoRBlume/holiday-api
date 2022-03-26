package br.com.api.holiday.controller;

import br.com.api.holiday.model.Holiday;
import br.com.api.holiday.useCase.HolidayUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HolidayController {

    @Autowired
    HolidayUseCase useCase;

    @RequestMapping("/obterFeriadoAnual")
    @GetMapping
    @ResponseBody
    public String obterFeriadosDeUmPais(String pais, String ano) {
        try {
            System.out.println("Chamando o endpoint");
             String s =  useCase.obterFeriadoDeUmAno(pais, ano);
            System.out.println("Consulta finalizada");
            return s;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
