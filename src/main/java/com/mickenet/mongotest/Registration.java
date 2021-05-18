package com.mickenet.mongotest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "anmalningar")
public class Registration {
    @JsonSerialize(using = LegacyUuidSerializer.class)
    @JsonDeserialize(using = LegacyUuidDeserializer.class)
    public UUID _id;
    @JsonProperty("Lag")
    public String lag;
    public List<Sizes> sizes;
    public List<Personalia> personalia;
    public String _class;

    public Registration(UUID _id,String lag, List<Personalia> personalia, List<Sizes> sizes) {
        this._id = _id;
        this.lag= lag;
        this.personalia = personalia;
        this.sizes = sizes;
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public String getLag() {
        return lag;
    }

    public void setLag(String lag) {
        this.lag = lag;
    }

    public List<Sizes> getSizes() {
        return sizes;
    }

    public void setSizes(List<Sizes> sizes) {
        this.sizes = sizes;
    }

    public List<Personalia> getPersonalia() {
        return personalia;
    }

    public void setPersonalia(List<Personalia> personalia) {
        this.personalia = personalia;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }
}
