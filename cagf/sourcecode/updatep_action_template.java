package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;


<<<<<<< HEAD
public class Update@CLASSNAME@Action extends ActionSupport{
=======
public class Updatep@CLASSNAME@Action extends ActionSupport{
>>>>>>> 4d3a32ab099d9f10692563296fae99ca663d5bb9

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

<<<<<<< HEAD
        @CLASSNAME@ bean = @bean@Service.get@CLASSNAME@( id);

        @UPDATEPROPERTY@

        @bean@Service.update@CLASSNAME@(bean);
=======
        this.@bean@ = @bean@Service. get@CLASSNAME@(id);
>>>>>>> 4d3a32ab099d9f10692563296fae99ca663d5bb9

        return SUCCESS;

    }


}