package br.com.api.holiday.repository;

import br.com.api.holiday.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository <Holiday, Long> {
}
