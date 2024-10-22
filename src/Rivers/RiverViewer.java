package Rivers;

import java.util.*;

public class RiverViewer {

    private List<River> _RiverList;

    public RiverViewer(){
        _RiverList = new LinkedList<>();
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

}
