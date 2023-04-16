package com.example.url_shortener.DAO;

import com.example.url_shortener.Utils.UUIDUtils;
import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table
public class Url {

    @Id
    private UUID id;
    private String url;

    private String uniqueIdentifier;

    public Url() {}

    public Url(String url) {
        this.url = url;
        this.id = UUID.randomUUID();
        this.uniqueIdentifier = UUIDUtils.uuidToBase64(id);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
