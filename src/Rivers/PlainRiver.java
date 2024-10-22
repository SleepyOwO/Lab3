package Rivers;

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

    @Override
    public String getInfo() {
        String info = super.getInfo() + "\nМожно плавать: " + _swimable + "\nМожно рыбачить: " + _fishing;
        return info;
    }

    public void setSwimable(boolean swimable){
        _swimable = swimable;
    }

    public void setFishing(boolean fishing) {
        _fishing = fishing;
    }
}
