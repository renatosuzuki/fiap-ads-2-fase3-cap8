package com.fiap.microservicos.atividadecap8.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import org.checkerframework.checker.nullness.qual.NonNull;

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

    @NonNull
    @Column
    private String endereco;

    @NonNull
    @Column(name = "data_coleta")
    private LocalDateTime dataColeta;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "horario_coleta")
//    private Time horarioColeta;

    @Column(name = "tipo_residuo")
    private String tipoResiduo;

    @Column(name = "observacoes")
    private String observacoes;

}
