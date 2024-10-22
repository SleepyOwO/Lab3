package UI;

import Rivers.RiverViewer;

import java.util.Scanner;

public class UI {

    private final Scanner _in;
    private String params;

    public UI(){
        _in = new Scanner(System.in);
    }

    public void Run(){
        boolean flag = true;
        RiverViewer viewer = new RiverViewer();
        System.out.println("""
                Выберите действие:\
                
                1) Добавить новую реку\
                
                2) Определить самую коротку реку\
                
                3) Вывести информацию о реках с длиной больше средней\
                
                4) Упорядочить список рек по названиям в алфавитном порядке\
                
                5) Исправить ошибку\
                
                6) Выход"""
        );
        while (true){
            switch (_in.nextInt()){
                case 1:
                    System.out.println("""
                        Выберите реку:\
                        
                        1) Горная река\
                        
                        2) Равнинная река""");
                    switch (_in.nextInt()) {
                        case 1:
                            System.out.println("""
                                Введите параметры"\
                                (name location width length depth speed height)""");
                            _in.skip("\r\n|[\n\r\u2028\u2029\u0085]");
                            params = _in.nextLine();
                            viewer.add_river(1, params);
                            break;
                        case 2:
                            System.out.println("""
                                Введите параметры\
                                (name location width length depth swimable(bool) fishing(bool))""");
                            _in.skip("\r\n|[\n\r\u2028\u2029\u0085]");
                            params = _in.nextLine();
                            viewer.add_river(2, params);
                            break;
                        default:
                            System.out.println("Некорректное значение");
                            break;
                    }
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Некорректное значение");
                    break;
            }
        }
    }
}
