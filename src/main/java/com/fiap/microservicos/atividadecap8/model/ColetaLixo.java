package com.fiap.microservicos.atividadecap8.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name="agendamento_coleta")
@Table(name="agendamento_coleta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class ColetaLixo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String endereco;

    @Column(name = "data_coleta", nullable = false)
    private Date dataColeta;

    @Column(name = "horario_coleta", nullable = false)
    private String horarioColeta;

    @Column(name = "tipo_residuo")
    private String tipoResiduo;

    @Column(name = "observacoes")
    private String observacoes;

}
