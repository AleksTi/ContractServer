package ru.yandex.sashanc.citbars.contractserver.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Contract {
    private Integer id;
    private LocalDate contractDate;
    private LocalDate contractDateUsed;
    private String status;
}
