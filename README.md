# 🛠️ Help Desk - Ticket Service

Microsserviço responsável pelo gerenciamento de chamados (tickets)
de um sistema Help Desk.

## 🚀 Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Bean Validation

## 📌 Funcionalidades
- Criar ticket
- Atualizar ticket
- Atualizar status
- Atribuir técnico
- Cancelar ticket
- Filtros por status, prioridade e categoria

## ▶️ Como rodar
1. Criar o banco `ms-helpdesk`
2. Configurar `application.yml`
3. Rodar a aplicação
4. Testar via Insomnia ou Swagger

## 📬 Endpoints
- POST `/api/tickets`
- GET `/api/tickets`
- PUT `/api/tickets/{id}`
- PUT `/api/tickets/{id}/status`
- PUT `/api/tickets/{id}/assign`
- DELETE `/api/tickets/{id}`
