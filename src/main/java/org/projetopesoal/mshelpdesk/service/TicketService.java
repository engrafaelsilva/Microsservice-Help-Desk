package org.projetopesoal.mshelpdesk.service;

import org.projetopesoal.mshelpdesk.dto.request.*;
import org.projetopesoal.mshelpdesk.dto.response.TicketResponseDTO;

import java.util.List;

public interface TicketService {

    TicketResponseDTO criar(TicketCreateRequestDTO dto);

    List<TicketResponseDTO> listar();

    TicketResponseDTO buscarPorId(Long id);

    TicketResponseDTO atualizar(Long id, TicketUpdateRequestDTO dto);

    TicketResponseDTO atualizarStatus(Long id, UpdateStatusRequestDTO dto);

    TicketResponseDTO atribuirTecnico(Long id, AssignTechnicianRequestDTO dto);

    void cancelar(Long id);
}
