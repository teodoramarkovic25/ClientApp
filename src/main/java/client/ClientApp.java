package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
 String host = args[0];
 int port = Integer.parseInt(args[1]);
        System.out.println("Kontaktirać server na adresi"+host + "" +port);

        try(Socket socket = new Socket(host,port);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner consoleScanner = new Scanner(System.in);
        ){
            while(consoleScanner.hasNext()){
                String poruka = consoleScanner.nextLine();
                out.println(poruka);
                out.flush();
                System.out.println("Server odgovorio sa "+br.readLine());
            }


        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
