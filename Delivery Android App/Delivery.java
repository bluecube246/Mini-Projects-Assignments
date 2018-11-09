package com.example.bluec.delivery_homework2;

/**
 * Created by bluec on 2018-02-14.
 */

public class Delivery {
    private String source;
    private String dest;
    private String instruction;

    public Delivery(String source, String dest, String instruction) {
        this.source = source;
        this.dest = dest;
        this.instruction = instruction;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDest() {
        return dest;
    }
    public void setDest(String dest) {
        this.dest = dest;
    }
    public String getinstruction() {
        return instruction;
    }
    public void setinstruction(String instruction) {
        this.instruction = instruction;
    }
}
