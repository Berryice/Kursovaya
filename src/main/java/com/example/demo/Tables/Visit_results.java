package com.example.demo.Tables;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="visit_results")
public class Visit_results {
    public Visit_results(int result_id, int visit_id, String result, String addiction_file) {
        this.result_id = result_id;
        this.visit_id = visit_id;
        this.result = result;
        this.addiction_file = addiction_file;
    }
    public Visit_results() {

    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAddiction_file() {
        return addiction_file;
    }

    public void setAddiction_file(String addiction_file) {
        this.addiction_file = addiction_file;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int result_id;
    int visit_id;
    String result;
    String addiction_file;
}
