package br.com.api.holiday.service;

import br.com.api.holiday.service.form.HolidayForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@FeignClient(name = "api-holiday", url = "https://holidays.abstractapi.com/v1")
@Service
public interface HolidayApiService {

    //&country=US&year=2020&month=12&day=25
    //country={country}&year={year}&month={month}&day={day}
    //PathVariable String country, @PathVariable String year, @PathVariable String month, @PathVariable String day

    @RequestMapping(method = RequestMethod.GET, value = "?api_key=5b2c02d787c74b049ddc84981367bfe5&country={pais}&year={ano}&month={mes}&day={dia}")
    List<HolidayForm> getHoliday(@PathVariable String pais,@PathVariable String ano ,@PathVariable String mes, @PathVariable int dia);
}

