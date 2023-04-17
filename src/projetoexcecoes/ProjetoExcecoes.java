package projetoexcecoes;

import model.entidades.Reserva;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.excecoes.ExcecaoDominio;

public class ProjetoExcecoes {

    public static void main(String[] args) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Número do quarto: ");
            int numQ = sc.nextInt();
            System.out.print("Data de checkIn (DD/MM/AAAA): ");
            LocalDate dataCheckin = LocalDate.parse(sc.next(), dt);
            System.out.print("Data de checkOut (DD/MM/AAAA): ");
            LocalDate dataCheckout = LocalDate.parse(sc.next(), dt);
        
            Reserva res = new Reserva(numQ, dataCheckin, dataCheckout);
            System.out.println(res);  
            
            System.out.println();
            System.out.println("Informe os dados para atualização da reserva:");
            System.out.print("Data de checkIn (DD/MM/AAAA): ");
            dataCheckin = LocalDate.parse(sc.next(), dt);
            System.out.print("Data de checkOut (DD/MM/AAAA): ");
            dataCheckout = LocalDate.parse(sc.next(), dt);
            
            res.atualizarReserva(dataCheckin, dataCheckout);
            System.out.println(res); 
        } catch (ExcecaoDominio e){
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Erro inesperado!");
        }     
 
         

        
    }
    
}
