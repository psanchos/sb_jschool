package ru.sbrf.jschool.multithread.part2;

import java.util.ArrayList;
import java.util.List;

public class SkladExample {
    List<Integer> in = new ArrayList<>();
    List<Integer> out = new ArrayList<>();

    public void input(Integer i){
        synchronized (in){
            in.add(i);
        }
    }


    public Integer get(){
        return out.remove(0);
    }
}
