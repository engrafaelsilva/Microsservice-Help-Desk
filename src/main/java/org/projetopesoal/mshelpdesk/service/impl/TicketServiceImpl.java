package org.projetopesoal.mshelpdesk.service.impl;

import org.projetopesoal.mshelpdesk.dto.request.AssignTechnicianRequestDTO;
import org.projetopesoal.mshelpdesk.dto.request.TicketCreateRequestDTO;
import org.projetopesoal.mshelpdesk.dto.request.TicketUpdateRequestDTO;
import org.projetopesoal.mshelpdesk.dto.request.UpdateStatusRequestDTO;
import org.projetopesoal.mshelpdesk.dto.response.TicketResponseDTO;
import org.projetopesoal.mshelpdesk.entity.Ticket;
import org.projetopesoal.mshelpdesk.enums.TicketStatus;
import org.projetopesoal.mshelpdesk.exception.ResourceNotFoundException;
import org.projetopesoal.mshelpdesk.repository.TicketRepository;
import org.projetopesoal.mshelpdesk.service.TicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public TicketResponseDTO criar(TicketCreateRequestDTO dto) {
        Ticket ticket = new Ticket();
        ticket.setTitulo(dto.getTitulo());
        ticket.setDescricao(dto.getDescricao());
        ticket.setPrioridade(dto.getPrioridade());
        ticket.setCategoria(dto.getCategoria());
        ticket.setClienteId(dto.getClienteId());
        ticket.setStatus(TicketStatus.ABERTO);
        ticket.setDataCriacao(LocalDateTime.now());

        return toDTO(repository.save(ticket));
    }

    @Override
    public List<TicketResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TicketResponseDTO buscarPorId(Long id) {
        return toDTO(buscarEntidade(id));
    }

    @Override
    public TicketResponseDTO atualizar(Long id, TicketUpdateRequestDTO dto) {
        Ticket ticket = buscarEntidade(id);

        if (dto.getTitulo() != null) ticket.setTitulo(dto.getTitulo());
        if (dto.getDescricao() != null) ticket.setDescricao(dto.getDescricao());
        if (dto.getPrioridade() != null) ticket.setPrioridade(dto.getPrioridade());
        if (dto.getCategoria() != null) ticket.setCategoria(dto.getCategoria());

        ticket.setDataAtualizacao(LocalDateTime.now());
        return toDTO(repository.save(ticket));
    }

    @Override
    public TicketResponseDTO atualizarStatus(Long id, UpdateStatusRequestDTO dto) {
        Ticket ticket = buscarEntidade(id);
        ticket.setStatus(dto.getStatus());
        ticket.setDataAtualizacao(LocalDateTime.now());
        return toDTO(repository.save(ticket));
    }

    @Override
    public TicketResponseDTO atribuirTecnico(Long id, AssignTechnicianRequestDTO dto) {
        Ticket ticket = buscarEntidade(id);
        ticket.setTecnicoId(dto.getTecnicoId());
        ticket.setDataAtualizacao(LocalDateTime.now());
        return toDTO(repository.save(ticket));
    }

    @Override
    public void cancelar(Long id) {
        Ticket ticket = buscarEntidade(id);
        ticket.setStatus(TicketStatus.CANCELADO);
        ticket.setDataAtualizacao(LocalDateTime.now());
        repository.save(ticket);
    }

    private Ticket buscarEntidade(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket não encontrado"));
    }

    private TicketResponseDTO toDTO(Ticket ticket) {
        TicketResponseDTO dto = new TicketResponseDTO();
        dto.setId(ticket.getId());
        dto.setTitulo(ticket.getTitulo());
        dto.setDescricao(ticket.getDescricao());
        dto.setStatus(ticket.getStatus());
        dto.setPrioridade(ticket.getPrioridade());
        dto.setCategoria(ticket.getCategoria());
        dto.setClienteId(ticket.getClienteId());
        dto.setTecnicoId(ticket.getTecnicoId());
        dto.setDataCriacao(ticket.getDataCriacao());
        dto.setDataAtualizacao(ticket.getDataAtualizacao());
        return dto;
    }
}