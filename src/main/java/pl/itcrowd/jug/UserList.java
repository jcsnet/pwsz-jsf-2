package pl.itcrowd.jug;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserList implements Serializable {

    public int generateId=1;

    private List<User> userList = new ArrayList<User>();
    private User selectedUser = new User();


    @PostConstruct

    public void postConstruct()
    {
        userList.add(new User(generateId,"Lukasz", "Jackowski",1989));
        generateId++;
        userList.add(new User(generateId,"Adam", "Kowalski",1989));
        generateId++;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser() {

        selectedUser.setId(generateId++);
        userList.add(selectedUser);
        selectedUser=new User();
    }


    public void deleteUser(User user) {

        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); )
        {
            User usr = iterator.next();

            if (usr.getId() == user.getId()) {
                iterator.remove();
            }
        }
    }


//    public int getSelectedUserId() {
//        return selectedUser == null ? null : selectedUser.getId();
//    }
//
//    public void setSelectedUserId(Integer selectedUserId) {
//
//        if(selectedUserId==null)
//        {
//            selectedUser = new User();
//        }
//    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
