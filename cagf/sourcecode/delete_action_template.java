package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class Delete@CLASSNAME@Action extends ActionSupport{

@Resource
private @CLASSNAME@Service @bean@Service;

    private long id;



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

       @bean@Service.delete@CLASSNAME@(id);

        return SUCCESS;

    }


}