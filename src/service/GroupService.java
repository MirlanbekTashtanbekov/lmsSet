package service;

import models.Group;

import java.util.List;


public interface GroupService {



    void saveGroup (String name, String description);

    Group getGroupByName (String name);

    Group updateGroupName (String oldName, String newName);

    List<Group> getAllGroups ();

    String deleteGroup (String name);



}
