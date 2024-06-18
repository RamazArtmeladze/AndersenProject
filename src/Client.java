public class Client extends User {
    @Override
    public void printRole() {
        System.out.println("Role: Client");
    }

    public Ticket getTicket(TicketService ticketService, int ticketId) {
        return ticketService.getTicketById(ticketId);
    }
}
