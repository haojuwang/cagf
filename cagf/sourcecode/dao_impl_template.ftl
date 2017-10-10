package @PACKAGE@;

import java.util.*;
import com.cagf.tool.util.*;

import javax.annotation.Resource;

import @IMPORTBEANS@;
import @IMPORTDAOINTERFACE@;
import org.springframework.stereotype.Repository;
@Repository("@Dao@DAO")
public class @CLASSNAME@DAOImpl extends BaseDAO<@CLASSNAME@> implements @CLASSNAME@DAO
{

	//save
	public void save@CLASSNAME@ (@CLASSNAME@ bean){
		storeObj(bean);
	}

	//saves
	public void save@CLASSNAME@(List<@CLASSNAME@> beans){
		storeObjs(beans);
	}

	//remove
	public void remove@CLASSNAME@(Long id){
		removeObj(@CLASSNAME@.class,id);
	}

	public void remove@CLASSNAME@(@CLASSNAME@ bean){
		remove@CLASSNAME@(bean.getId());
	}


    public void remove@CLASSNAME@s(List<Long> ids) {
        removeObjs(@CLASSNAME@.class,ids);
    }

     public void update@CLASSNAME@(@CLASSNAME@ bean) {
        updateObj(bean);
     }

     public void update@CLASSNAME@s(List<@CLASSNAME@> beans) {
        updateObjs(beans);
     }

	public long get@CLASSNAME@Count(String queryString) {

		return retrieveObjsCount(queryString);
	}

	public long get@CLASSNAME@Count(String queryString, Map<String, Object> params)	{
		return retrieveObjsCount(queryString,params);
	}

	public long  get@CLASSNAME@Count(String queryString, String key, Object value){
		return retrieveObjsCount(queryString,key,value);
	}


	//search
	public  List<@CLASSNAME@> search@CLASSNAME@s(String queryString) {
		return retrieveObjs(queryString);
	}

	public  List<@CLASSNAME@> search@CLASSNAME@s(String queryString, String key, Object value){

		return retrieveObjs(queryString,key,value);
	}
	public  List<@CLASSNAME@> search@CLASSNAME@s(String queryString, Map<String, Object> params){

		return retrieveObjs(queryString,params);
	}

	public	@CLASSNAME@	search@CLASSNAME@(String queryString, Map<String, Object> params){
		return retrieveObj(queryString,params);
    }

    public	@CLASSNAME@	search@CLASSNAME@(String queryString){
		return retrieveObj(queryString);
    }

    public	@CLASSNAME@	search@CLASSNAME@(String queryString, String key, Object value){
		return retrieveObj(queryString,key,value);
    }

    public @CLASSNAME@ getId(long id) {
         return retrieveObj( @CLASSNAME@.class ,id);
    }

    public  List<@CLASSNAME@> search@CLASSNAME@s(String queryString, Map<String, Object> params, int start, int number) {
         return retrievePageObjs(queryString,params,start,number);
    }



}