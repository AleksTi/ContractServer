package ru.yandex.sashanc.citbars.contractserver.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contract {
    private Integer id;
    private String name;
    private LocalDate contractDate;
    private LocalDate contractUsingDate;
}
