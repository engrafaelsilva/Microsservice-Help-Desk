package org.projetopesoal.mshelpdesk.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.projetopesoal.mshelpdesk.enums.TicketCategory;
import org.projetopesoal.mshelpdesk.enums.TicketPriority;
import org.projetopesoal.mshelpdesk.enums.TicketStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketPriority prioridade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketCategory categoria;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "tecnico_id")
    private Long tecnicoId;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;
}
