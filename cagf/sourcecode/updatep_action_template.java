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

    private long id;

    private @CLASSNAME@ @bean@


    public long getId() {

        return id;
        }

     public long setId(long id) {
        this.id = id
        }

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