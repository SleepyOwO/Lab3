package Rivers;

public class MountainRiver extends River{

    private int _speed;
    private int _height;

    /**
     * Конструктор по умолчанию класса MountainRiver
     * Определяет стандартные значения полей _speed и _height
     */
    public MountainRiver(){
        _speed = 0;
        _height = 0;
    }

    /**
     * Конструктор с параметрами класса MountainRiver
     * @param name определяет название реки
     * @param location определяет расположение реки (федеральный округ)
     * @param width определяет ширину реки (м)
     * @param length определяет длину реки (км)
     * @param depth определяет глубину реки (м)
     * @param speed определяет скорость течения реки (м/с)
     * @param height определяет высоту истока реки (км)
     */
    public MountainRiver(String name, String location, int width, int length, int depth, int speed, int height){
        super(name, location, width, length, depth);
        _speed = speed;
        _height = height;
    }

    /**
     * Метод возвращающий строку, содержащую полную информацию о реке
     * @return String info - строка с информацие о реке
     */
    @Override
    public String get_info() {
        String info = super.get_info() + "\nСкорость течения: " + _speed + " м/с\nВысота истока: " + _height + " км";
        return info;
    }
}
