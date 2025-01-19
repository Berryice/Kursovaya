package com.example.demo.Tables;


import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="visits")
public class Visits {
    public Visits() {

    }
    public Visits(int id, int user_id, int from_id, int to_id, String reason, Timestamp date_time) {
        this.id = id;
        this.user_id = user_id;
        this.from_id = from_id;
        this.to_id = to_id;
        this.reason = reason;
        this.date_time = date_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFrom_id() {
        return from_id;
    }

    public void setFrom_id(int from_id) {
        this.from_id = from_id;
    }

    public int getTo_id() {
        return to_id;
    }

    public void setTo_id(int to_id) {
        this.to_id = to_id;
    }

    public String getReasons() {
        return reason;
    }

    public void setReasons(String reason) {
        this.reason = reason;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int user_id;
    int from_id;
    int to_id;
    String reason;
    Timestamp date_time;
}
