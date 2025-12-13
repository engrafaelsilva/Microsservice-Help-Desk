package org.projetopesoal.mshelpdesk.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.projetopesoal.mshelpdesk.enums.TicketStatus;

@Getter
@Setter
public class UpdateStatusRequestDTO {
    @NotNull
    private TicketStatus status;
}
