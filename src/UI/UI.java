package UI;

import Rivers.MountainRiver;
import Rivers.PlainRiver;
import static Rivers.River.*;

import java.util.Scanner;

public class UI {

    private final Scanner _in;
    private String params;

    /**
     * Конструктор по умолчанию для класса UI
     * Определяет значение поля _in
     */
    public UI(){
        _in = new Scanner(System.in);
    }

    /**
     * Метод, предоставляющий интерфейс для добавления новой реки
     */
    private void addRiver(){
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
                                    (Название Расположение Ширина Длина Глубина Скорость Высота истока)""");
                _in.skip("\r\n|[\n\r\u2028\u2029\u0085]");
                params = _in.nextLine();
                new MountainRiver(params.split(" "));
                System.out.println("Река добавлена\n");
                break;
            case 2:
                System.out.println("""
                                    Введите параметры \
                                    (Название Расположение Ширина Длина Глубина Возможность плавать(bool) Возможность рыбачить(bool))""");
                _in.skip("\r\n|[\n\r\u2028\u2029\u0085]");
                params = _in.nextLine();
                new PlainRiver(params.split(" "));
                System.out.println("Река добавлена\n");
                break;
            default:
                System.out.println("Некорректное значение");
                break;
        }
    }


    /**
     * Метод, предоставляющий интерфейс для изменения параметра существующей реки
     */
    private void changeParam(){
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
        System.out.println(changeField(switcher, name, param));

    }

    /**
     * Метод запускающий интерфейс программы
     */
    public void Run(){
        boolean flag = true;
        do {

            System.out.println("""
                Выберите действие:\
                
                1) Добавить новую реку\
                
                2) Определить самую коротку реку\
                
                3) Вывести информацию о реках с длиной больше средней\
                
                4) Упорядочить список рек по названиям в алфавитном порядке\
                
                5) Исправить ошибку\
                
                6) Выход"""
            );

            try {
                switch (_in.nextInt()) {
                    case 1:
                        addRiver();
                        break;
                    case 2:
                        System.out.println(shortest_river());
                        break;
                    case 3:
                        System.out.println(middle_info());
                        break;
                    case 4:
                        System.out.println(sortByName());
                        break;
                    case 5:
                        _in.nextLine();
                        changeParam();
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.out.println("Некорректное значение");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
    }
}
