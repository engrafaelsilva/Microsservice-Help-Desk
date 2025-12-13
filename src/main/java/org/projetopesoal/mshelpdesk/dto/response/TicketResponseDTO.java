package org.projetopesoal.mshelpdesk.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.projetopesoal.mshelpdesk.enums.TicketCategory;
import org.projetopesoal.mshelpdesk.enums.TicketPriority;
import org.projetopesoal.mshelpdesk.enums.TicketStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class TicketResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private TicketStatus status;
    private TicketPriority prioridade;
    private TicketCategory categoria;
    private Long clienteId;
    private Long tecnicoId;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
