package @ACTIONPACKAGENAME@;

import java.util.*;

import @BEANPACKAGENAME@;
import @SERVICEPACKAGENAME@;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.annotation.Resource;
import com.cagf.tool.util.* ;
import org.apache.struts2.ServletActionContext;

public class List@CLASSNAME@Action extends ActionSupport{

@Resource
private @CLASSNAME@Service @bean@Service;

    private int start;
    private int range;
    private String pageInfo;


    private List<@CLASSNAME@> list;

    public void setList(List<@CLASSNAME@> list) {
        this.list = list;

     }

     public List<@CLASSNAME@> getList(){

        return this.list;
     }

     public void setStart(int start) {
         this.start = start;
     }

    public int getStart() {
         return this.start;

    }

    public void setRange(int range) {
        this.range = range;
        }


    public int getRange() {
        return this.range;
     }

    public String getPageInfo() {
        return this.pageInfo;

        }



    @Override
    public void validate() {

    }

    @Override
    public  String execute() throws Exception{

        if(0 == this.range) {
            this.range =10;
        }


        long count = this.@bean@Service.get@CLASSNAME@Count();
        this.pageInfo = Page.getPage(ServletActionContext.getRequest(),"",start,range,count);
        this.list = this.@bean@Service.list@CLASSNAME@s(this.start,this.range);

        return SUCCESS;

    }


}