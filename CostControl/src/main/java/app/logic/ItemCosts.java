package app.logic;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vbrovkin
 * Date: 18.02.15
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */
public class ItemCosts {
    private int id;
    private int idGroup;
    private String name;
    private int cash;
    private Date fd;

    public int getId(){
        return id;
    }
    public int getIdGroup(){
        return idGroup;
    }
    public String getName(){
        return name;
    }
    public int getCash(){
        return cash;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCash(int cash){
        this.cash = cash;
    }
    public void setFd(Date fd){
        this.fd = fd;
    }
}
