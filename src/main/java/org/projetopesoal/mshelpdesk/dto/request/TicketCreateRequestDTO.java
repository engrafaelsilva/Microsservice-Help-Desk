package org.projetopesoal.mshelpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.projetopesoal.mshelpdesk.enums.TicketCategory;
import org.projetopesoal.mshelpdesk.enums.TicketPriority;

@Getter
@Setter
public class TicketCreateRequestDTO {
    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotNull
    private TicketPriority prioridade;

    @NotNull
    private TicketCategory categoria;

    @NotNull
    private Long clienteId;
}
