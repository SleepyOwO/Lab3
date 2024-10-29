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
        do {
            switch (_in.nextInt()) {
                case 1:
                    System.out.println("""
                            \
                            Выберите реку:\
                            
                            1) Горная река\
                            
                            2) Равнинная река""");
                    switch (_in.nextInt()) {
                        case 1:
                            System.out.println("""
                                    \
                                    Введите параметры \
                                    (Название Расположение Ширина Длина Глубина Скорость Высота)""");
                            _in.skip("\r\n|[\n\r\u2028\u2029\u0085]");
                            params = _in.nextLine();
                            viewer.add_river(1, params);
                            break;
                        case 2:
                            System.out.println("""
                                    Введите параметры \
                                    (Название Расположение Ширина Длина Глубина Возможность плавать(bool) Возможность рыбачить(bool))""");
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
                    System.out.println("Самая коротка река: " + viewer.shortest_river());
                    break;
                case 3:
                    System.out.println(viewer.middle_info());
                    break;
                case 4:
                    viewer.sortByName();
                    break;
                case 5:
                    _in.nextLine();
                    System.out.println("\nВведите имя редактируемой реки:");
                    String name = _in.nextLine();
                    System.out.println("""
                            Выберите редактируемый параметр: \
                            1) Название \
                            2) Расположение \
                            3) Ширина \
                            4) Длина \
                            5) Глубина \
                            6) Скорость или Возможность плавать \
                            7) Высота или Возможность Рыбачить
                            """);
                    int switcher = _in.nextInt();
                    _in.nextLine();
                    System.out.println("Введите новое значение параметра:");
                    String param = _in.nextLine();
                    System.out.println(viewer.changeField(switcher, name, param));
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Некорректное значение");
                    break;
            }
        } while (true);
    }
}
