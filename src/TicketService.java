import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> tickets;

    public TicketService() {
        this.tickets = new ArrayList<>();

        for (int i = 0; i <10; i++) {
            tickets.add(new Ticket("ID" + i, "Concert" + i, 100 + i, LocalDateTime.now(), false, 'A', 5.0, new BigDecimal(50.00)));
        }
    }

    public Ticket getTicketById(String id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId().equals(id)) {
                return ticket;
            }
        }
        return null;
    }

    public List<Ticket> getTicketsByStadiumSector(char stadiumSector) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getStadiumSector() == stadiumSector) {
                result.add(ticket);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        Ticket ticket = ticketService.getTicketById("ID1");
        System.out.println(ticket);
    }
}
