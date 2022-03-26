package br.com.api.holiday.useCase;

import br.com.api.holiday.model.Holiday;
import br.com.api.holiday.service.HolidayApiService;
import br.com.api.holiday.service.form.HolidayForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HolidayUseCase {

    @Autowired
    HolidayApiService service;

    public List<Holiday> obterFeriadoDeUmPaisDeUmMes(String pais, String ano, String mes) throws InterruptedException {
        List<Holiday> holidays= new ArrayList<>();

        for (int i = 1; i <= Holiday.consultarQtdDias(mes); i++) {
            System.out.println("Dia" + i);
            List<HolidayForm>  holidayService = service.getHoliday(pais, ano, mes, i);
            System.out.println("Consulta obtida");
            holidays.addAll(Holiday.converter(holidayService));
            Thread.sleep(800);
            System.out.println("Adcionando a lista");
        }
        return holidays;
    }
}
