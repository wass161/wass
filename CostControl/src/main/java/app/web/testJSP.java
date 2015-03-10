package app.web;

import app.logic.Groups;
import app.logic.ManagementSystem;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vbrovkin
 * Date: 06.03.15
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
public class testJSP {
    public List getGroupsList() throws Exception {
    List<Groups> groupsList = ManagementSystem.getInstance().getGroups();
        HashMap map = new HashMap();
        for(Groups gr : groupsList){
            map.put("id",Integer.toString(gr.getId()) );
            pageContext.getOut().write(gr.getName());
            pageContext.getOut().write(gr.getFd().toString());
            pageContext.getOut().write(Integer.toString(gr.getId()));
        }

    return
    }
}
