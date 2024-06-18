import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket extends ID implements Print {
    private String concertHall;
    private int eventCode;
    private LocalDateTime time;
    private boolean isPromo;
    private char stadiumSector;
    private double maxBackpackWeight;
    private BigDecimal price;

    public Ticket(Integer id, String concertHall, int eventCode, LocalDateTime time, boolean isPromo, char stadiumSector, double maxBackpackWeight, BigDecimal price) {
        setId(id);
        setConcertHall(concertHall);
        setEventCode(eventCode);
        this.time = time;
        this.isPromo = isPromo;
        setStadiumSector(stadiumSector);
        setMaxBackpackWeight(maxBackpackWeight);
        setPrice(price);
    }

    public Ticket(String concertHall, int eventCode, LocalDateTime time) {
        setConcertHall(concertHall);
        setEventCode(eventCode);
        this.time = time;
    }

    public Ticket() {
        this.time = LocalDateTime.now();
        NullableWarningCheck.checkNullWarnings(this);
    }

    public String getConcertHall() {
        return concertHall;
    }

    public void setConcertHall(String concertHall) {
        if (concertHall != null && concertHall.length() <= 10) {
            this.concertHall = concertHall;
        } else {
            throw new IllegalArgumentException("Concert Hall must be 10 characters max.");
        }
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        if (String.valueOf(eventCode).length() == 3) {
            this.eventCode = eventCode;
        } else {
            throw new IllegalArgumentException("Event Code must be exactly 3 digits.");
        }
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean isPromo) {
        this.isPromo = isPromo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        if (stadiumSector >= 'A' && stadiumSector <= 'C') {
            this.stadiumSector = stadiumSector;
        } else {
            throw new IllegalArgumentException("Stadium Sector must be between 'A' and 'C'.");
        }
    }

    public double getMaxBackpackWeight() {
        return maxBackpackWeight;
    }

    public void setMaxBackpackWeight(double maxBackpackWeight) {
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + getId()  +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxBackpackWeight=" + maxBackpackWeight +
                ", price=" + price +
                '}';
    }

    public String getAllValues() {
        return toString();
    }
    @Override
    public void print() {
        Print.super.print();
    }
    public void updateTime(LocalDateTime time) {
        this.time = time;
    }

    public void updateStadiumSector(char stadiumSector) {
        if (stadiumSector >= 'A' && stadiumSector <= 'C') {
            this.stadiumSector = stadiumSector;
        } else {
            throw new IllegalArgumentException("Stadium Sector must be between 'A' and 'C'.");
        }
    }

    public void share(String phoneNumber) {
        System.out.println("Ticket shared to phone: " + phoneNumber);
    }

    public void share(String phoneNumber, String email) {
        System.out.println("Ticket shared to phone: " + phoneNumber + " and email: " + email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), concertHall, eventCode, time, isPromo, stadiumSector, maxBackpackWeight, price);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId() &&
                eventCode == ticket.eventCode &&
                isPromo == ticket.isPromo &&
                stadiumSector == ticket.stadiumSector &&
                Double.compare(ticket.maxBackpackWeight, maxBackpackWeight) == 0 &&
                concertHall.equals(ticket.concertHall) &&
                time.equals(ticket.time) &&
                price.equals(ticket.price);
    }
}
