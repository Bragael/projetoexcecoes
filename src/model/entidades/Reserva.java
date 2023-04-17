package model.entidades;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.excecoes.ExcecaoDominio;

public class Reserva {
    private static DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private Integer numeroQuarto;
    private LocalDate checkIn, checkOut;

    public Reserva() {
    }

    public Reserva(Integer numeroQuarto, LocalDate checkIn, LocalDate checkOut)  {
        if (!checkOut.isAfter(checkIn)){
            throw new ExcecaoDominio("Data de checkOut tem de ser após data de checkIn!");
        }
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
    
    public void atualizarReserva(LocalDate checkin, LocalDate checkout) {
        LocalDate agora = LocalDate.now();
        if (checkin.isBefore(agora) || checkout.isBefore(agora)){
            throw new ExcecaoDominio ("As datas atualizadas devem ser datas futuras.");
        }
        if (!checkout.isAfter(checkin)){
            throw new ExcecaoDominio("Data de checkOut tem de ser após data de checkIn!");
        }
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
