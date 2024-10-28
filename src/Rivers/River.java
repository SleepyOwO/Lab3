package Rivers;

public class River {

    private String _name;
    private int _width;
    private int _length;
    private int _depth;
    private String _location;

    /**
     * Конструктор по умолчанию для класса River
     * Определяет стандартные значения полей _name, width, length, depth и location
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
     * @param name определяет название реки
     * @param location определяет расположение реки (федеральный округ)
     * @param width определяет ширину реки (м)
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
}
