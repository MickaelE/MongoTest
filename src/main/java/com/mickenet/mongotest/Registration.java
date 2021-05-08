package com.mickenet.mongotest;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "anmalningar")
public class Registration {
    @Id
    private UUID _id;
    private String Lag;

    private List<Storlekar> sizes;
    private List<Personalia> personalia;

    public Registration(String lag, List<Personalia> personalia, List<Storlekar> sizes) {
        this._id =UUID.randomUUID();
        this.Lag = lag;
        this.personalia = personalia;
        this.sizes = sizes;
    }


    public UUID get_id() {
        return _id;
    }

    public String getLag() {
        return Lag;
    }

    public void setLag(String lag) {
        Lag = lag;
    }

    public List<Storlekar> getSizes() {
        return sizes;
    }

    public void setSizes(List<Storlekar> sizes) {
        this.sizes = sizes;
    }

    public List<Personalia> getPersonalia() {
        return personalia;
    }

    public void setPersonalia(List<Personalia> personalia) {
        this.personalia = personalia;
    }
}
