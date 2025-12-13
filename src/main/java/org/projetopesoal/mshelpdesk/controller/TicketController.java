package org.projetopesoal.mshelpdesk.controller;

import jakarta.validation.Valid;
import org.projetopesoal.mshelpdesk.dto.request.TicketCreateRequestDTO;
import org.projetopesoal.mshelpdesk.dto.request.TicketUpdateRequestDTO;
import org.projetopesoal.mshelpdesk.dto.response.TicketResponseDTO;
import org.projetopesoal.mshelpdesk.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponseDTO criar(@RequestBody @Valid TicketCreateRequestDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<TicketResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public TicketResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public TicketResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody TicketUpdateRequestDTO dto) {
        return service.atualizar(id, dto);
    }

}
