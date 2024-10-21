package Rivers;

import java.util.List;

public class River {

    private String _name;
    private int _width;
    private int _length;
    private int _depth;
    private String _location;

    /**
     * Конструктор по умолчанию для класса River
     * Определяет значения полей _name, width, length, depth и location
     */
    public River(){
        _name = "";
        _width = 0;
        _length = 0;
        _depth = 0;
        _location = "";
    }

    /**
     * Конструктор с параметрами класса River
     *
     * @param name определяет название реки
     * @param location определяет расположение реки (федеральный округ)
     * @param width определяет ширину реки (км)
     * @param length определяет длину реки (км)
     * @param depth определяет глубину реки (м)
     */
    public River(String name, String location, int width, int length, int depth){
        _name = name;
        _width = width;
        _length = length;
        _depth = depth;
        _location = location;
    }

}
