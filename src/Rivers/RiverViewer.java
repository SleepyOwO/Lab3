package Rivers;

import java.text.Collator;
import java.util.*;

public class RiverViewer {

    private List<River> _RiverList;
    private final int MAXLEN;

    /**
     * Конструктор по умолчанию класса RiverViewer
     */
    public RiverViewer(){
        _RiverList = new LinkedList<>();
        MAXLEN = 99999999;
    }

    /**
     * Метод, добавляющий новую реку в коллекцию
     * @param witcher параметр, отвечающий за выполнение проверки определенного типа реки
     * @param params параметры новой реки
     */
    public void add_river(int witcher, String params){
        String[] params_arr = params.split(" ");

        if (params_arr.length != 7) throw new RuntimeException("Неверное колличество параметров");

        String name = params_arr[0], location = params_arr[1];

        if (!isNumeric(params_arr[2]) || !isNumeric(params_arr[3]) || !isNumeric(params_arr[4]))
            throw new RuntimeException("Ширина, длина и глубина должны быть положительными числами");

        int width = Integer.parseInt(params_arr[2]), length = Integer.parseInt(params_arr[3]),
                depth = Integer.parseInt(params_arr[4]);

        switch (witcher){
            case 1:
                // Проверка скорости и высоты (должны быть числа)
                if (!isNumeric(params_arr[5]) || !isNumeric(params_arr[6]))
                    throw new RuntimeException("Скорость и высота должны быть положительными числами");

                int speed = Integer.parseInt(params_arr[5]), height = Integer.parseInt(params_arr[6]);

                _RiverList.add(new MountainRiver(name, location, width, length, depth, speed, height));
                break;
            case 2:
                // Проверка для параметров с типом boolean (должны быть "true" или "false")
                if (!isBoolean(params_arr[5]) || !isBoolean(params_arr[6]))
                    throw new RuntimeException("Параметры плавания и рыбалки должны быть true или false");

                boolean swim = Boolean.parseBoolean(params_arr[5]), fish = Boolean.parseBoolean(params_arr[6]);

                _RiverList.add(new PlainRiver(name, location, width, length, depth, swim, fish));
                break;
        }
    }

    /**
     * Метод, проверяющий вводимую строку, являеется ли она числом
     * @param str проверяемая строка
     * @return true или false - резуьтат проверки
     */
    public boolean isNumeric(String str) {
        return str != null && !str.trim().isEmpty() && str.matches("\\d*\\.?\\d+");
    }

    /**
     * Метод, проверяющий вводимую строку, является ли она логическим значением
     * @param str проверяемая строка
     * @return true или false - резуьтат проверки
     */
    public boolean isBoolean(String str) {
        return "true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str);
    }

    /**
     * Метод, проверяющий вводимую строку, является ли она строкой
     * @param str проверяемая строка
     * @return true или false - резуьтат проверки
     */
    public boolean isString(String str) {
        if (str == null || str.trim().isEmpty()) return false;
        return !isNumeric(str) && !isBoolean(str);
    }

    /**
     * Метод, определяющий самую короткую реку
     * @return name - название самой короткой реки
     */
    public String shortest_river(){
        int length = MAXLEN;
        String name = " ";
        for (var river : _RiverList){
            if(river.getLength() < length){
                length = river.getLength();
                name = river.getName();
            }
        }
        return name;
    }

    /**
     * Метод, выводящий информацию о реках с длиной больше средней
     * @return infos - информация о реках с длиной больше средней
     */
    public String middle_info(){
        int middle = 0;
        for (var river : _RiverList){
            middle += river.getLength();
        }
        middle /= _RiverList.size();

        String infos = "";
        for (var river : _RiverList){
            if (river.getLength() > middle)
                infos += river.getInfo() + '\n';
        }

        return infos;
    }

    /**
     * Метод, упорядочивающий и выводящий список рек по названиям в алфавитном порядке\
     */
    public void sortByName(){
        _RiverList.sort(new Comparator<River>() {
            @Override
            public int compare(River o1, River o2) {
                return Collator.getInstance().compare(o1.getName(), o2.getName());
            }
        });

        String sorted = "";
        for (var river : _RiverList){
                sorted += river.getName() + '\n';
        }
        System.out.println("Упорядоченный в алфавитном порядке список рек:\n" + sorted);
    }

    /**
     * Метод, позволяющий изменить информацию о какой-либо реке
     * @param switcher  параметр, который надо изменить
     * @param name  имя реки
     * @param param  значение нового параметра
     * @return Информация о реке, включая исправленную
     */
    public String changeField(int switcher, String name, String param){
        River river = null;
        for (var i : _RiverList){
            if (Objects.equals(i.getName(), name)) river = i;
        }

        if (river == null) throw new RuntimeException("Не найден элемент");

        switch(switcher){
            case 1:
                if (!isString(param)) throw new RuntimeException("Название должно быть строкой");
                river.setName(param);
                break;
            case 2:
                if (!isString(param)) throw new RuntimeException("Расположение должно быть строкой");
                river.setLocation(param);
                break;
            case 3:
                if (!isNumeric(param)) throw new RuntimeException("Ширина должна быть числом");
                river.setWidth(Integer.parseInt(param));
                break;
            case 4:
                if (!isNumeric(param)) throw new RuntimeException("Длина должна быть числом");
                river.setLength(Integer.parseInt(param));
                break;
            case 5:
                if (!isNumeric(param)) throw new RuntimeException("Глубина должна быть числом");
                river.setDepth(Integer.parseInt(param));
                break;
            case 6:
                if (river.getClass() == MountainRiver.class){
                    if (!isNumeric(param)) throw new RuntimeException("Скорость должна быть числом");
                    ((MountainRiver) river).setSpeed(Integer.parseInt(param));
                    break;
                } else {
                    if (!isBoolean(param)) throw new RuntimeException("Возможность рыбачить должна быть логическим значением");
                    ((PlainRiver) river).setSwimable(Boolean.parseBoolean(param));
                }
                break;
            case 7:
                if (river.getClass() == MountainRiver.class){
                    if (!isNumeric(param)) throw new RuntimeException("Высота должна быть числом");
                    ((MountainRiver) river).setHeight(Integer.parseInt(param));
                    break;
                } else {
                    if (!isBoolean(param)) throw new RuntimeException("Возможность рыбачить должна быть логическим значением");
                    ((PlainRiver) river).setFishing(Boolean.parseBoolean(param));
                }
                break;
        }
        return river.getInfo();
    }
}