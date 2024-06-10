import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket {
    private String id;  // I choose String here because the requirement is that it is possible to contain char. otherwise it should be long.
    private String concertHall;
    private int eventCode;
    private LocalDateTime time;
    private boolean isPromo;
    private char stadiumSector;
    private double maxBackpackWeight;
    private BigDecimal price;

    public Ticket(String id, String concertHall, int eventCode, LocalDateTime time, boolean isPromo, char stadiumSector, double maxBackpackWeight, BigDecimal price) {
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
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && id.length() <= 4) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID must be 4 digits and/or characters max.");
        }
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
}
