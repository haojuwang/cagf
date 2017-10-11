package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class List@CLASSNAME@Action extends ActionSupport{

@Resource
private @CLASSNAME@Service @bean@Service;

    private List<@CLASSNAME@> list;

    public void setList(List<@CLASSNAME@> list) {
        this.list = list;

     }

     public List<@CLASSNAME@> getList(){

        return this.list;
     }

    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        this.list = this.@bean@Service.list@CLASSNAME@s(0,10);

        return SUCCESS;

    }


}