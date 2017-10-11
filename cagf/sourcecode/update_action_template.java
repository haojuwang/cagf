package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


public class Update@CLASSNAME@Action extends ActionSupport{

@Resource
private @CLASSNAME@Service @bean@Service;



@UPDATEBEAN@

    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        @CLASSNAME@ bean = @bean@Service.get@CLASSNAME@( id);

        @UPDATEPROPERTY@

        @bean@Service.update@CLASSNAME@(bean);

        return SUCCESS;

    }


}