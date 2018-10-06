/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stud318a
 */
import java.net.*;
import java.io.*;

public class UDPClient {
    
    boolean proove(String x, String y, String z) {
        try {
                Double.valueOf(x);
                Double.valueOf(y);
                Double.valueOf(z);
            }
            catch(Exception e) {
                System.out.println("Wrong Input. Write only numbers.");
                return false;
            }
        return true;
    }
    
    public void runClient() throws IOException {
        DatagramSocket s = null;    //создание дейтаграммы
        try {
            byte[] buf = new byte[512];     //буфер для приема/передачи дейтаграммы
            s = new DatagramSocket();       //привязка сокета к реальному объету
            System.out.println("UDPClient: Started");
            byte[] verCmd = { 'V', 'E', 'R', 'S' };
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            String x, y, z;
            while (true) {
                System.out.print("Enter the x value: ");
                x = stdin.readLine();
                System.out.print("Enter the y value: ");
                y = stdin.readLine();
                System.out.print("Enter the z value: ");
                z = stdin.readLine();
                if (proove(x, y, z)) {
                    break;
                }
            }
            
            x += " " + y + " " + z;
            System.out.println(x);
            byte[] answer = x.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(verCmd, verCmd.length,
                    InetAddress.getByName("127.0.0.1"), 8001);      //создание дейтаграммы для отсылки
            sendPacket.setData(answer);            //установить массив посылаемых данных
            sendPacket.setLength(answer.length);   //установить длину посылаемых данных
            s.send(sendPacket);                 //послать данные серверу
            System.out.println("UDPClient: Ended");
        }
        finally {
            if (s != null) {
                s.close();                      //закрытие сокета клиента
            } 
        } 
    }
    
    public static void main(String[] args) {    //метод main
        try {
            UDPClient client = new UDPClient(); //создание объекта client
            client.runClient();                 //вызов метода объекта client
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
