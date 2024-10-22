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

    public void add_river(int witcher, String params){
        String[] params_arr = params.split(" ");
        if (params_arr.length != 7) throw new RuntimeException("Неверное колличество параметров");
        String name = params_arr[0], location = params_arr[1];
        int width = Integer.parseInt(params_arr[2]), length = Integer.parseInt(params_arr[3]),
                depth = Integer.parseInt(params_arr[4]);

        switch (witcher){
            case 1:
                int speed = Integer.parseInt(params_arr[5]), height = Integer.parseInt(params_arr[6]);
                _RiverList.add(new MountainRiver(name, location, width, length, depth, speed, height));
                break;
            case 2:
                boolean swim = Boolean.parseBoolean(params_arr[5]), fish = Boolean.parseBoolean(params_arr[6]);
                _RiverList.add(new PlainRiver(name, location, width, length, depth, swim, fish));
                break;
        }
    }

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

    public void sortByName(){
        _RiverList.sort(new Comparator<River>() {
            @Override
            public int compare(River o1, River o2) {
                return Collator.getInstance().compare(o1.getName(), o2.getName());
            }
        });
    }

    public String changeField(int switcher, String name, String param){
        River river = null;
        for (var i : _RiverList){
            if (i.getName() == name) river = i;
        }

        if (river == null)
            throw new RuntimeException("Не найден элемент");

        switch(switcher){
            case 1:
                river.setName(param);
                break;
            case 2:
                river.setLocation(param);
                break;
            case 3:
                river.setWidth(Integer.parseInt(param));
                break;
            case 4:
                river.setLength(Integer.parseInt(param));
                break;
            case 5:
                river.setDepth(Integer.parseInt(param));
                break;
            case 6:
                if (river.getClass() == MountainRiver.class){
                    ((MountainRiver) river).setSpeed(Integer.parseInt(param));
                    break;
                } else {
                    ((PlainRiver) river).setSwimable(Boolean.parseBoolean(param));
                }
                break;
            case 7:
                if (river.getClass() == MountainRiver.class){
                    ((MountainRiver) river).setHeight(Integer.parseInt(param));
                    break;
                } else {
                    ((PlainRiver) river).setFishing(Boolean.parseBoolean(param));
                }
                break;
        }

        return river.getInfo();
    }

}