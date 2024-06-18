public class Main {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        Ticket ticket = ticketService.getTicketById(1);

        // Task 4
        ticket.share("123-456-7890");
        ticket.share("123-456-7890", "example@example.com");

        // Task 5
        User client = new Client();
        client.printRole();
        Ticket clientTicket = ((Client) client).getTicket(ticketService, 1);
        System.out.println(clientTicket);

        User admin = new Admin();
        admin.printRole();
        boolean isTicketValid = ((Admin) admin).checkTicket(ticketService, 1);
        System.out.println("Is ticket valid: " + isTicketValid);

        // *** additional task
        Ticket ticket2 = new Ticket();
        System.out.println(ticket2);
    }
}