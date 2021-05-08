package com.mickenet.mongotest;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Storlekar {
    //Tröja_strl Shorts strl. Strumpor strl.
    public String skirt;
    public String shorts;
    public String socks;

    public String getSkirt() {
        return skirt;
    }

    public void setSkirt(String skirt) {
        this.skirt = skirt;
    }

    public String getShorts() {
        return shorts;
    }

    public void setShorts(String shorts) {
        this.shorts = shorts;
    }

    public String getSocks() {
        return socks;
    }

    public void setSocks(String socks) {
        this.socks = socks;
    }
}
