package br.com.bittencourt.payrollapi.domain;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class Payroll {

    private String workerName;
    private String description;
    private Double hourlyPrice;
    private Double workerHours;
    private Double totalPayment;

}
