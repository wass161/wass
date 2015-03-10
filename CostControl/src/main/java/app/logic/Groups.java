package app.logic;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: vbrovkin
 * Date: 18.02.15
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */
public class Groups {
    private int id;
    public String name;
    private Date fd;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Date getFd(){
        return fd;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setFd(Date fd){
        this.fd = fd;
    }
}
