package br.com.api.holiday.useCase;

import br.com.api.holiday.model.Holiday;
import br.com.api.holiday.repository.HolidayRepository;
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

    @Autowired
    HolidayRepository repository;

    public String obterFeriadoDeUmAno(String pais, String ano) throws InterruptedException {
        System.out.println("Entrando no metodo para obter os feriados de um pais");
        List<Holiday> holidays = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            System.out.println("Mes" + i);
            holidays.addAll(obterFeriadoDeUmPaisDeUmMes(pais, ano, String.valueOf(i)));
            System.out.println("Adcionando a lista os feriados de um mes");
        }
        repository.saveAll(holidays);
        System.out.println("Salvando no repository");
        return "Todos os feriados dos anos foram obtidos com sucesso";
    }

    public List<Holiday> obterFeriadoDeUmPaisDeUmMes(String pais, String ano, String mes) throws InterruptedException {

        System.out.println("Chamando metodo para obter de um mes");
        List<Holiday> holidays= new ArrayList<>();

        for (int i = 1; i <= Holiday.consultarQtdDias(mes); i++) {
            System.out.println("Dia" + i);
            List<HolidayForm>  holidayService = service.getHoliday(pais, ano, mes, i);
            System.out.println("Consulta obtida");
            holidays.addAll(Holiday.converter(holidayService));
            Thread.sleep(200);
            System.out.println("Adcionando a lista");
        }
        repository.saveAll(holidays);
        return holidays;
    }
}
