public class Admin extends User {
    @Override
    public void printRole() {
        System.out.println("Role: Admin");
    }

    public boolean checkTicket(TicketService ticketService, int ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        return ticket != null;
    }
}
