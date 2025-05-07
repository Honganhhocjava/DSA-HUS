package Hw5_22000070_NguyenThiAnh.BaiTap3;

public class Event implements Comparable<Event>{

    private String event;
    private int time;

    public Event(String event, int time) {
        this.event = event;
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Event o) {
        return this.time - o.time;
    }

    @Override
    public String toString() {
        return "Event[" +
                "event='" + event + '\'' +
                ", time=" + time +
                ']';
    }
}
