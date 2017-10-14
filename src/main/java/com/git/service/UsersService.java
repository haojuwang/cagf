package com.git.service;

import java.util.*;


import com.git.bean.*;

public interface UsersService {

    public List<Users> listUserss(int start,int range);
    public List<Users> listUsersDesc(int start,int range);
    public List<Users> listUsersAsc(int start,int range);
    public Long getUsersCount();

    public void saveUsers(Users bean);
    public void updateUsers(Users bean);
    public void deleteUsers(Long id);

    public Users getUsers(Long id);

}
