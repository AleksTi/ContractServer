package ru.yandex.sashanc.citbars.contractserver.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ContractDto implements Serializable {
    private Integer id;
    private String name;
    private LocalDate contractDate;
    private LocalDate contractUsingDate;
    private String status;
}

