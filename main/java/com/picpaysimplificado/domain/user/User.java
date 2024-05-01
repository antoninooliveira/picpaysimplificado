package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.usertype.UserType;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do usuário
    private String firstName; // Primeiro nome do usuário
    private String lastName; // Sobrenome do usuário
    @Column(unique = true)
    private String document; // CPF
    private String password; // Senha do usuário (pode ser armazenada de forma segura, como hash)
    @Column(unique = true)
    private String email; // Endereço de e-mail do usuário
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;


    public void user (UserDTO data){
this.firstName = data.FirstName();
this.lastName = data.LastName();
this.password = data.password();
this.email = data.email();
this.userType = data.userType();
}


}
