package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class Add@CLASSNAME@Action extends ActionSupport{

@Resource
private @CLASSNAME@Service @bean@Service;


@SETPROPERTY@

    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

    @ADDBEAN@

    return SUCCESS;

    }


}