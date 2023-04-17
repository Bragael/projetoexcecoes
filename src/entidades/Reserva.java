package entidades;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private static DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private Integer numeroQuarto;
    private LocalDate checkIn, checkOut;

    public Reserva() {
    }

    public Reserva(Integer numeroQuarto, LocalDate checkIn, LocalDate checkOut) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
    
    public long duracao(){
        Duration dur = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
        return dur.toDays();
    }
    
    public void atualizarReserva(LocalDate checkin, LocalDate checkout){
        this.checkIn = checkin;
        this.checkOut = checkout;
    }

    @Override
    public String toString() {
        return "Reserva: Quarto " + numeroQuarto 
                + ", check-in: " + checkIn.format(dt)
                + ", check-out: " + checkOut.format(dt)
                + ", " + duracao() + " noites." ;
    }
    
    
    
}
