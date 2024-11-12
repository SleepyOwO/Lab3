package Rivers;

import java.text.Collator;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static Compare.Comparator.*;

public abstract class River {

    private String _name;
    private int _width;
    private int _length;
    private int _depth;
    private String _location;

    public static List<River> _RiverList = new LinkedList<>();
    private static final int MAXLEN = 999999999;

    /**
     * Конструктор по умолчанию для класса River
     * Определяет стандартные значения полей _name, width, length, depth и location
     */
    public River(){
        _name = "NoName";
        _width = 0;
        _length = 0;
        _depth = 0;
        _location = "";
    }

    /**
     * Конструктор с параметрами класса River
     * @param name определяет название реки
     * @param location определяет расположение реки (федеральный округ)
     * @param width определяет ширину реки (м)
     * @param length определяет длину реки (км)
     * @param depth определяет глубину реки (м)
     */
    public River(String name, String location, int width, int length, int depth){
        _RiverList.add(this);
        _name = name;
        _width = width;
        _length = length;
        _depth = depth;
        _location = location;
    }

    /**
     * Конструктор с параметрами, принимающий на вход массив строк, содержащих параметры
     * @param params массив строк, содержащих параметры
     */
    public River(String[] params){
        _name = params[0];
        _location = params[1];
        if (Integer.parseInt(params[2]) >= 0 && Integer.parseInt(params[3]) >= 0 && Integer.parseInt(params[4]) >= 0 ){
            _width = Integer.parseInt(params[2]);
            _length = Integer.parseInt(params[3]);
            _depth = Integer.parseInt(params[4]);
        } else throw new RuntimeException("Некорректные числовые параметры");
        _RiverList.add(this);
    }

    /**
     * Метод возвращающий строку - название реки
     * @return String _name - Название реки
     */
    public String getName() {
        return _name;
    }

    /**
     * Метод возвращающий число - длину реки
     * @return int _length - длина реки
     */
    public int getLength() {
        return _length;
    }

    /**
     * Метод возвращающий строку, содержащую полную информацию о реке
     * @return String info - строка с информацие о реке
     */
    public String getInfo() {
        String info = "Информация о реке " + _name +":\n" + "Расположение: " + _location + "\nДлина: "
                + _length + " км\nШирина: " + _width + " м\nГлубина: " + _depth + " м";
        return info;
    }

    /**
     * Устанавливает новое название реки
     * @param name новое название реки
     */
    public void setName(String name) {
        _name = name;
    }

    /**
     * Устанавливает новое расположение реки
     * @param location новое расположение реки
     */
    public void setLocation(String location) {
        _location = location;
    }

    /**
     * Устанавливает новую длину реки (км)
     * @param length новая длина реки
     */
    public void setLength(int length) {
        _length = length;
    }

    /**
     * Устанавливает новую ширину реки (м)
     * @param width новая ширина реки
     */
    public void setWidth(int width) {
        _width = width;
    }

    /**
     * Устанавливает новую глубину реки (м)
     * @param depth новая глубина реки
     */
    public void setDepth(int depth) {
        _depth = depth;
    }

    /**
     * Метод, определяющий самую короткую реку
     * @return name - название самой короткой реки
     */
    public static String shortest_river(){
        if(_RiverList.isEmpty()) {
            return "Нет элементов\n";
        } else {
            int length = MAXLEN;
            String name = " ";
            for (var river : _RiverList){
                if(river.getLength() < length){
                    length = river.getLength();
                    name = river.getName();
                }
            }
            return "Самая короткая река: " + name;
        }
    }

    /**
     * Метод, выводящий информацию о реках с длиной больше средней
     * @return infos - информация о реках с длиной больше средней
     */
    public static String middle_info(){
        if(_RiverList.isEmpty()){
            return "Нет элементов\n";
        } else {
            int middle = 0;
            for (var river : _RiverList){
                middle += river.getLength();
            }
            middle /= _RiverList.size();

            String infos = "";
            for (var river : _RiverList){
                if (river.getLength() > middle)
                    infos += river.getInfo() + '\n' + '\n';
            }

            return infos;
        }
    }

    /**
     * Метод, упорядочивающий и выводящий список рек по названиям в алфавитном порядке\
     */
    public static String sortByName(){
        if (_RiverList.isEmpty()){
            return "Нечего сортировать\n";
        } else{
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
            return "Упорядоченный в алфавитном порядке список рек:\n" + sorted;
        }
    }

    /**
     * Метод, позволяющий изменить информацию о какой-либо реке
     * @param switcher  параметр, который надо изменить
     * @param name  имя реки
     * @param param  значение нового параметра
     * @return Информация о реке, включая исправленную
     */
    public static String changeField(int switcher, String name, String param){
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