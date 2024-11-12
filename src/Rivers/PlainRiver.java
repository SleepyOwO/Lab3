package Rivers;

import static Compare.Comparator.isBoolean;

public class PlainRiver extends River {

    private boolean _swimable;
    private boolean _fishing;

    /**
     * Конструктор по умолчанию класса PlainRiver
     */
    public PlainRiver(){
        _swimable = false;
        _fishing = false;
    }

    /**
     * Конструктор с параметрами класса PlainRiver
     * @param name определяет название реки
     * @param location определяет расположение реки (федеральный округ)
     * @param width определяет ширину реки (м)
     * @param length определяет длину реки (км)
     * @param depth определяет глубину реки (м)
     * @param swimable определяет возможность плавания
     * @param fishing определяет возможность рыбалки
     */
    public PlainRiver(String name, String location, int width, int length, int depth,
                      boolean swimable, boolean fishing){
        super(name, location, width, length, depth);
        _swimable = swimable;
        _fishing = fishing;
    }

    /**
     * Конструктор с параметрами, принимающий на вход массив строк, содержащих параметры
     * @param params массив строк, содержащих параметры
     */
    public PlainRiver(String[] params){
        super(params);
        if (isBoolean(params[5]) && isBoolean(params[6])){
            _swimable = Boolean.parseBoolean(params[5]);
            _fishing = Boolean.parseBoolean(params[6]);
        } else throw new RuntimeException("Некорректные логические параметры");
    }

    /**
     * Метод возвращающий строку, содержащую полную информацию о реке
     * @return String info - строка с информацие о реке
     */
    @Override
    public String getInfo() {
        String info = super.getInfo() + "\nМожно плавать: " + _swimable + "\nМожно рыбачить: " + _fishing + '\n';
        return info;
    }

    /**
     * Метод, устанавливающий новое значение поля _swimable (можно плавать)
     * @param swimable новое значение поля
     */
    public void setSwimable(boolean swimable){
        _swimable = swimable;
    }

    /**
     * Метод, устанавливающий новое значение поля _fishing (можно рыбачить)
     * @param fishing новое значение поля
     */
    public void setFishing(boolean fishing) {
        _fishing = fishing;
    }
}
