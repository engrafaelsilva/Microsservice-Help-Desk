package org.projetopesoal.mshelpdesk.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignTechnicianRequestDTO {
    @NotNull
    private Long tecnicoId;
}
