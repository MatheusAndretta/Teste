package br.com.matheus.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "category")
public class Category {

    @Id
    private String id;
    private String nomeDaCategoria;
    private String descDaCategoria;
    private String memeId;
    private String userId;
    private Date createdAt;

    public Category() {
        this.createdAt = new Date();
    }

    

    public String getMemeId() {
        return memeId;
    }

    public void setMemeId(String memeId) {
        this.memeId = memeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeDaCategoria() {
        return nomeDaCategoria;
    }

    public void setNomeDaCategoria(String nomeDaCategoria) {
        this.nomeDaCategoria = nomeDaCategoria;
    }

    public String getDescDaCategoria() {
        return descDaCategoria;
    }

    public void setDescDaCategoria(String descDaCategoria) {
        this.descDaCategoria = descDaCategoria;
    }

    public Date getCreateAT() {
        return createdAt;
    }

    public void setCreateAT(Date createAT) {
        this.createdAt = createAT;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



    public String getUserId() {
        return userId;
    }



    public void setUserId(String userId) {
        this.userId = userId;
    }

}
