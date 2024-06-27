package br.com.bittencourt.user_api.domain;

import jakarta.persistence.*;
import lombok.*;

import static lombok.EqualsAndHashCode.Include;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_user")
public class User {

    @Include
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private Double hourlyPrice;


}
