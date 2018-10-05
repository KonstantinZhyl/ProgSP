/**
 * Created by ozzy on 04.10.2018.
 */
import java.io.*;   //импорт пакета, содержащего классы для ввода/вывода
import java.net.*;  //импорт пакета, содержащего классы для работы в Internet
import java.util.*;


public class Server
{
    public static String ansToString(List<Competitor> l) {
        String ans = "Соревнование не состоялось";
        Collections.sort(l);
        if (l.get(0).result != 0) {
            ans = "Первое место: " + l.get(0).surname + "\n";
        }

        if (l.get(1).result != 0) {
            ans += "Второе место: " + l.get(1).surname + "\n";
        }

        if (l.get(2).result != 0) {
            ans += "Третье место: " + l.get(2).surname + "\n";
        }
        return ans;
    }

    public static String listToString(List<Competitor> l) {
        String ans = "";
        for (int i = 0; i < l.size(); i++) {
            ans += "ID: " + l.get(i).num + " Surname: " + l.get(i).surname + "\n";
        }
        return ans;
    }

    public static void main(String[] arg)
    {
        List<Competitor> data = new ArrayList<Competitor>();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader("data.csv"));
            while ((line = br.readLine()) != null) {
                String[] tuple = line.split(",");
                data.add(new Competitor(Integer.parseInt(tuple[0]), tuple[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

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

            soos.writeObject(listToString(data));
            String clientMessageRecieved = (String) sois.readObject();
            String serverAnswer;
            while(!clientMessageRecieved.equals("quite"))
            //выполнение цикла: пока строка не будет равна «quite»
            {
                serverAnswer = "Incorrect request";
                String[] oneline = clientMessageRecieved.split(" ");
                try {
                    int id = Integer.valueOf(oneline[0]);
                    double value = Double.valueOf(oneline[1]);
                    if (oneline.length == 2) {
                        for (int i = 0; i < data.size(); i++) {
                            if (data.get(i).num == id) {
                                data.get(i).result = value;
                                serverAnswer = "Operation complete";
                                break;
                            }
                        }
                    }
                }
                catch (Exception e) {
                    System.out.println("Incorrect request");
                }
                //строке присваиваются данные потока ввода, представленные в виде строки
                //(передано клиентом
                soos.writeObject(serverAnswer);
                clientMessageRecieved = (String) sois.readObject();
            }
            soos.writeObject(ansToString(data));
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