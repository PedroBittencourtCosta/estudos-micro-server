package br.com.bittencourt.payrollapi.domain;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;


}
