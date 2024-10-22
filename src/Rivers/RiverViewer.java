package Rivers;

import java.util.*;

public class RiverViewer {

    private List<River> _RiverList;
    private final int MAXLEN;

    public RiverViewer(){
        _RiverList = new LinkedList<>();
        MAXLEN = 99999999;
    }

    public void add_river(int witcher, String params){
        String[] params_arr = params.split(" ");
        if (params_arr.length != 7) throw new RuntimeException();
        String name = params_arr[0], location = params_arr[1];
        int width = Integer.parseInt(params_arr[2]), length = Integer.parseInt(params_arr[3]),
                depth = Integer.parseInt(params_arr[4]), speed = Integer.parseInt(params_arr[5]),
                height = Integer.parseInt(params_arr[6]);
        boolean swim = Boolean.parseBoolean(params_arr[5]), fish = Boolean.parseBoolean(params_arr[6]);

        switch (witcher){
            case 1:
                _RiverList.add(new MountainRiver(name, location, width, length, depth, speed, height));
                break;
            case 2:
                _RiverList.add(new PlainRiver(name, location, width, length, depth, swim, fish));
                break;
        }
    }

    public String shortest_river(){
        int length = MAXLEN;
        String name = " ";
        for (var river : _RiverList){
            if(river.get_length() < length){
                length = river.get_length();
                name = river.get_name();
            }
        }
        return name;
    }

    public String middle_info(){
        int middle = 0;
        for (var river : _RiverList){
            middle += river.get_length();
        }
        middle /= _RiverList.size();

        String infos = "";
        for (var river : _RiverList){
            if (river.get_length() > middle)
                infos += river.get_info() + '\n';
        }

        return infos;
    }

    public void sortByName(){
        //_RiverList.sort();
    }

}
