package models;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Item extends Model {
    @Required
    public String name;
    public String tag;
    @Required
    public float price;
    @Required
    public String picture;
    
    @Required
    @MaxSize(value=255, message = "email.maxsize")
    @play.data.validation.Email
    public String email;
    public String details;
    public boolean bid = false;
    public boolean sell = false;
    public String soldpeople;
}