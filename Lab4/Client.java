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

            System.out.println("List of competitors:");
            System.out.println((String) cois.readObject());
            System.out.print("Enter competitor's id: ");
            String id = stdin.readLine();
            System.out.print("Enter competitor's result: ");
            String result = stdin.readLine();
            String clientMessage;
            if (!((id.equals("quite")) || (result.equals("quite")))) {
                clientMessage = id + " " + result;
                while (true) {
                    clientMessage = id + " " + result;                      //выполнение цикла, пока строка не будет равна «quite»
                    coos.writeObject(clientMessage);                        //потоку вывода присваивается значение строковой переменной (передается серверу)
                    System.out.println((String) cois.readObject());
                    System.out.print("Enter competitor's id: ");
                    id = stdin.readLine();
                    if (id.equals("quite")) {
                        break;
                    }
                    System.out.print("Enter competitor's result: ");
                    result = stdin.readLine();
                    if (result.equals("quite")) {
                        break;
                    }
                }
            }

            coos.writeObject("quite");
            System.out.println((String) cois.readObject());
            coos.close();                       //закрытие потока вывода
            cois.close();                       //закрытие потока ввода
            clientSocket.close();               //закрытие сокета
        }
        catch(Exception e) {
            e.printStackTrace();                //выполнение метода исключения е
        }
    }
}
