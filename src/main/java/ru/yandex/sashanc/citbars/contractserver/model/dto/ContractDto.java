package ru.yandex.sashanc.citbars.contractserver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContractDto implements Serializable {
    private Integer id;
    private String name;
    private String contractDate;
    private String contractUsingDate;
    private String status;
}

