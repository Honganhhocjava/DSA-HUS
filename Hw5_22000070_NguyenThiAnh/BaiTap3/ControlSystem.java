package Hw5_22000070_NguyenThiAnh.BaiTap3;

import Hw5_22000070_NguyenThiAnh.BaiTap3.Event;

import java.util.PriorityQueue;

public class ControlSystem {
    private PriorityQueue<Event> events;


    public ControlSystem() {
        this.events = new PriorityQueue<>();
    }

    public void add(String st,int time) {
        Event event = new Event(st,time);
        events.add(event);
        System.out.println("Thêm sự kiện : " + event);

    }

    public void processNextEvent() {
        if(events.isEmpty()) {
            System.out.println("Không có sự kiện");
        }else {
            Event event = events.poll();
            System.out.println("Xử lý sự kiện gần nhất : " + event );
        }
    }


    public boolean hasIsEmpty() {
        return !events.isEmpty();
    }
}
