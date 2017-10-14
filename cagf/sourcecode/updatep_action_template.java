package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;



public class Updatep@CLASSNAME@Action extends ActionSupport{

@Resource
private @CLASSNAME@Service @bean@Service;

    private long id;


    private @CLASSNAME@ @bean@;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @CLASSNAME@ get@CLASSNAME@() {

        return this.@bean@;
     }

    public void set@CLASSNAME@(@CLASSNAME@ @bean@) {
        this.@bean@ = @bean@;
    }


    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        @bean@ = @bean@Service.get@CLASSNAME@(id);

        return SUCCESS;

    }


}