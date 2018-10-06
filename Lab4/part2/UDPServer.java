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

public class UDPServer {
    public final static int DEFAULT_PORT = 8001;    //определение порта сервера
    public final String VERSION_CMD = "VERS";       //определение версии команды
    public final String QUIT_CMD = "QUIT";          //определение команды «выход»
    public final byte[] UNKNOWN_CMD = { 'U', 'n', 'k', 'n', 'o', 'w', 'n', ' ',
                'c', 'o', 'm', 'm', 'a', 'n', 'd' };    //неизвестная команда

    public void runServer() throws IOException {    //метод сервера runServer
        DatagramSocket s = null;    //создание объекта DatagramSocket
        try {
            boolean stopFlag = false;   //создание флага stopFlag и его инициализация значением false
            byte[] buf = new byte[512]; //буфер для приема/передачи дейтаграммы
            s = new DatagramSocket(DEFAULT_PORT);   //привязка сокета к реальному объекту с портом DEFAULT_PORT
            System.out.println("UDPServer: Started on " + s.getLocalAddress() + ":"
            + s.getLocalPort());    //вывод к консоль сообщения

            while(!stopFlag) {
                //создание объекта дейтаграммы для получения данных
                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);
                s.receive(recvPacket);  //помещение полученного содержимого в объект дейтаграммы
                String cmd = new String(recvPacket.getData()).trim();   //извлечение команды из пакета
                System.out.println("UDPServer: Command: " + cmd);
                
                String[] data = cmd.split(" ");
                Double[] array = new Double[data.length];
                int n = 0;
                if (data.length != 3) {
                    n = UNKNOWN_CMD.length;
                    System.arraycopy(UNKNOWN_CMD, 0, buf, 0, n);
                }
                else {
                    for (int i = 0; i < data.length; i++) {
                        array[i] = Double.valueOf(data[i]);
                    }
                    Double x = array[0], y = array[1], z = array[2];
                    System.out.println(x);
                    System.out.println(y);
                    System.out.println(z);
                    Double func = 8 + Math.pow(x + y, 2) + z;
                    func = Math.sqrt(func) / (x * x + y * y + z * z);
                    func -= Math.pow(Math.E, Math.abs(x - y)) 
                     * (Math.pow(Math.tan(z), 2) + Math.pow(Math.abs(z), 1/5));
                    cmd = func.toString();
                    n = cmd.length();
                    System.arraycopy(cmd, 0, buf, 0, n);                    
                }
                
                DatagramPacket sendPacket = new DatagramPacket(buf, 0,
                recvPacket.getAddress(), recvPacket.getPort()); //формирование объекта
                // дейтаграммы для отсылки данных
                //int n = 0;  //количество байт в ответе
//                if (cmd.equals(VERSION_CMD)) {  //проверка версии команды
//                    n = VERSION.length;
//                    System.arraycopy(VERSION, 0, buf, 0, n);
//                }
//                else if (cmd.equals(QUIT_CMD)) {
//                    stopFlag = true;//остановка сервера
//                    continue;
//                }
//                else {
//                    n = UNKNOWN_CMD.length;
//                    System.arraycopy(UNKNOWN_CMD, 0, buf, 0, n);
//                }
                sendPacket.setData(buf);//установить массив посылаемых данных
                sendPacket.setLength(n);//установить длину посылаемых данных
                s.send(sendPacket);//послать сами данные
            } // while(server is not stopped)
            System.out.println("UDPServer: Stopped");
        }
        finally {
                if (s != null) {
                    s.close();          //закрытие сокета сервера
                }
        }
    }

    public static void main(String[] args) {
        try {
            UDPServer udpSvr = new UDPServer();     //создание объекта udpSvr
            udpSvr.runServer();                     //вызов метода объекта runServer
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
