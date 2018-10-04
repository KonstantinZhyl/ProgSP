/**
 * Created by ozzy on 04.10.2018.
 */
import java.io.*;   //импорт пакета, содержащего классы для ввода/вывода
import java.net.*;  //импорт пакета, содержащего классы для работы в сети
public class Client  {
    public static void main(String[] arg) {
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1", 2525); // установление соединения между локальной машиной и указанным портом узла сети
            System.out.println("connection established....");

            //создание буферизированного символьного потока ввода
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

            //создание потока вывода
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());

            //создание потока ввода
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());

            System.out.println("Enter any string to send to server \n\t('quite' − programme terminate)");
            String clientMessage = stdin.readLine();
            while(!clientMessage.equals("quite")) {                     //выполнение цикла, пока строка не будет равна «quite»
                coos.writeObject(clientMessage);                        //потоку вывода присваивается значение строковой переменной (передается серверу)
                System.out.println("~server~: " + cois.readObject());     // выводится на экран содержимое потока ввода (переданное сервером)
                System.out.println("---------------------------");
                clientMessage = stdin.readLine();                       // ввод текста с клавиатуры
                System.out.println("you've entered: "+clientMessage);       //вывод в консоль строки и значения строковой переменной
            }
            coos.close();                       //закрытие потока вывода
            cois.close();                       //закрытие потока ввода
            clientSocket.close();               //закрытие сокета
        }
        catch(Exception e) {
            e.printStackTrace();                //выполнение метода исключения е
        }
    }
}
