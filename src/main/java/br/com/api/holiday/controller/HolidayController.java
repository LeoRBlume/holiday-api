package br.com.api.holiday.controller;

import br.com.api.holiday.model.Holiday;
import br.com.api.holiday.useCase.HolidayUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HolidayController {

    @Autowired
    HolidayUseCase useCase;

    @RequestMapping("/obterFeriadoMensal")
    @GetMapping
    @ResponseBody
    public List<Holiday> obterFeriadosDeUmMesDeUmPais(String pais, String ano, String mes) {
        try {
            System.out.println("Entrando");
            return useCase.obterFeriadoDeUmPaisDeUmMes(pais, ano, mes);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
