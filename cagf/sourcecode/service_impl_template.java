package @PACKAGE@;

import java.util.*;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import @IMPORTBEANS@;
import @IMPORTDAOS@;
import @IMPORTSERVICE@;

@Service("@bean@Service")
public class  @CLASSNAME@ServiceImpl implements @CLASSNAME@Service {

    private String list_all_desc = "from @CLASSNAME@ bean order by bean.id desc";
    private String list_all_asc = "from @CLASSNAME@ bean order by bean.id asc";
    private String sql_count = "from @CLASSNAME@ ";

@Resource
@CLASSNAME@DAO @bean@DAO;

    @Transactional
    public List<@CLASSNAME@> list@CLASSNAME@s(int start,int range){

        return this.@bean@DAO.search@CLASSNAME@s(list_all_desc,null,start,range);
        }

    @Transactional
    public List<@CLASSNAME@> list@CLASSNAME@Desc(int start,int range){
        return this.@bean@DAO.search@CLASSNAME@s(list_all_desc,null,start,range);
        }

    @Transactional
    public List<@CLASSNAME@> list@CLASSNAME@Asc(int start,int range){
        return this.@bean@DAO.search@CLASSNAME@s(list_all_asc,null,start,range);

    }
    @Transactional
    public Long get@CLASSNAME@Count(){
        return this.@bean@DAO.get@CLASSNAME@Count(sql_count);
     }

    @Transactional
    public void save@CLASSNAME@(@CLASSNAME@ bean){
         this.@bean@DAO.save@CLASSNAME@(bean);
    }

    @Transactional
    public void update@CLASSNAME@(@CLASSNAME@ bean){
         this.@bean@DAO.update@CLASSNAME@(bean);
    }

    @Transactional
    public void delete@CLASSNAME@(Long id){
        this.@bean@DAO.remove@CLASSNAME@(id);
   }

}
