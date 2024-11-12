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
     * Конструктор с параметрами, принимающий на вход массив строк, содержащих параметры
     * @param params массив строк, содержащих параметры
     */
    public MountainRiver(String[] params){
        super(params);
        if (Integer.parseInt(params[5]) >= 0 && Integer.parseInt(params[6]) >= 0){
            _speed = Integer.parseInt(params[5]);
            _height = Integer.parseInt(params[6]);
        } else {
            _RiverList.remove(this);
            throw new RuntimeException("Некорректные числовые параметры");
        }
    }

    /**
     * Метод возвращающий строку, содержащую полную информацию о реке
     * @return String info - строка с информацие о реке
     */
    @Override
    public String getInfo() {
        String info = super.getInfo() + "\nСкорость течения: " + _speed + " м/с\nВысота истока: " + _height + " км\n";
        return info;
    }

    /**
     * Метод, устанавливающий новое значение поля _speed (скорость течения)
     * @param speed новое значение поля _speed
     */
    public void setSpeed(int speed) {
        _speed = speed;
    }

    /**
     * Метод, устанавливающий новое значение поля _height (высота истока)
     * @param height новое значение поля _height
     */
    public void setHeight(int height) {
        _height = height;
    }
}
