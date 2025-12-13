package org.projetopesoal.mshelpdesk.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.projetopesoal.mshelpdesk.enums.TicketCategory;
import org.projetopesoal.mshelpdesk.enums.TicketPriority;

@Getter
@Setter
public class TicketUpdateRequestDTO {
    private String titulo;
    private String descricao;
    private TicketPriority prioridade;
    private TicketCategory categoria;
}
