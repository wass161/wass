package app.web.tag;

import app.logic.Groups;
import app.logic.ManagementSystem;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vbrovkin
 * Date: 25.02.15
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */
public class CostControlTag extends TagSupport{
    private String name = null;
    @Override
    public int doStartTag() throws JspException {
        try {
            List<Groups> groupsList = ManagementSystem.getInstance().getGroups();
            for(Groups gr : groupsList){
                pageContext.getOut().write(gr.getName());
                pageContext.getOut().write(gr.getFd().toString());
                pageContext.getOut().write(Integer.toString(gr.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return super.doStartTag();    //To change body of overridden methods use File | Settings | File Templates.
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
