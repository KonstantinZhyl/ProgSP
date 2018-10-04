/**
 * Created by ozzy on 04.10.2018.
 */
import java.io.*;   //импорт пакета, содержащего классы для ввода/вывода
import java.net.*;  //импорт пакета, содержащего классы для работы в Internet
public class Server
{
    public static void main(String[] arg)
    {
        //объявление объекта класса ServerSocket
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;   //объявление объекта класса Socket
        ObjectInputStream sois = null;  //объявление байтового потока ввода
        ObjectOutputStream soos = null; //объявление байтового потока вывода
        try {
            System.out.println("server starting....");

            //создание сокета сервера для заданного порта
            serverSocket = new ServerSocket(2525);

            //выполнение метода, который обеспечивает реальное подключение сервера к клиенту
            clientAccepted = serverSocket.accept();
            System.out.println("connection established....");

            //создание потока ввода
            sois = new ObjectInputStream(clientAccepted.getInputStream());

            //создание потока вывода
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());
            String clientMessageRecieved = (String) sois.readObject();   //объявление

            //строки и присваивание ей данных потока ввода, представленных
            //в виде строки (передано клиентом)
            while(!clientMessageRecieved.equals("quite"))
            //выполнение цикла: пока строка не будет равна «quite»
            {
                System.out.println("message recieved: '" + clientMessageRecieved + "'");

                //приведение символов строки к верхнему регистру
                clientMessageRecieved = clientMessageRecieved.toUpperCase();

                //потоку вывода присваивается значение строковой переменной (передается клиенту)
                soos.writeObject(clientMessageRecieved);

                //строке присваиваются данные потока ввода, представленные в виде строки
                //(передано клиентом)
                clientMessageRecieved = (String) sois.readObject();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                sois.close();           //закрытие потока ввода
                soos.close();           //закрытие потока вывода
                clientAccepted.close(); //закрытие сокета, выделенного для клиента
                serverSocket.close();   //закрытие сокета сервера
            } catch(Exception e) {
                e.printStackTrace();    //вызывается метод исключения е
            }
        }
    }
}