package com.archer.domain;

/**
 * Created by archerlj on 2017/6/2.
 */
public class Setting {
    private int id;
    private String workTime;
    private String offWorkTime;
    private String checkDay;

    public Setting() {
        super();
    }

    public Setting(int id, String workTime, String offWorkTime, String checkDay) {
        this.id = id;
        this.workTime = workTime;
        this.offWorkTime = offWorkTime;
        this.checkDay = checkDay;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "id=" + id +
                ", workTime='" + workTime + '\'' +
                ", offWorkTime='" + offWorkTime + '\'' +
                ", checkDay='" + checkDay + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getOffWorkTime() {
        return offWorkTime;
    }

    public void setOffWorkTime(String offWorkTime) {
        this.offWorkTime = offWorkTime;
    }

    public String getCheckDay() {
        return checkDay;
    }

    public void setCheckDay(String checkDay) {
        this.checkDay = checkDay;
    }
}
