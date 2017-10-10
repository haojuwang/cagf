package @PACKAGE@;

import java.util.*;


import @IMPORTBEANS@;

public interface @CLASSNAME@DAO
{
//save
public void save@CLASSNAME@ (@CLASSNAME@ bean);

//saves
public void save@CLASSNAME@(List<@CLASSNAME@> beans);
//remove
public void remove@CLASSNAME@(Long id);

public void remove@CLASSNAME@(@CLASSNAME@ bean);

public void remove@CLASSNAME@s(List<Long> ids);

public void update@CLASSNAME@(@CLASSNAME@ bean);

public void update@CLASSNAME@s(List<@CLASSNAME@> beans);

public long get@CLASSNAME@Count(String queryString) ;

public long get@CLASSNAME@Count(String queryString, Map<String, Object> params)	;

public long  get@CLASSNAME@Count(String queryString, String key, Object value);

//search
public  List<@CLASSNAME@> search@CLASSNAME@s(String queryString);
public  List<@CLASSNAME@> search@CLASSNAME@s(String queryString, String key, Object value);
public  List<@CLASSNAME@> search@CLASSNAME@s(String queryString, Map<String, Object> params);

public	@CLASSNAME@	search@CLASSNAME@(String queryString, Map<String, Object> params);

public	@CLASSNAME@	search@CLASSNAME@(String queryString);

public	@CLASSNAME@	search@CLASSNAME@(String queryString, String key, Object value);


public @CLASSNAME@ getId(long id) ;

public  List<@CLASSNAME@> search@CLASSNAME@s(String queryString, Map<String, Object> params, int start, int number) ;
}