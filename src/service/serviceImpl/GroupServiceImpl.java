package service.serviceImpl;

import database.Database;
import database.GenerateId;
import models.Group;
import service.GroupService;


import java.util.List;

public class GroupServiceImpl implements GroupService {



    @Override
    public void saveGroup(String name, String description) {
        Group group = new Group(GenerateId.groupId(), name, description);
        Database.groups.add(group);
        //System.out.println(name+ " атуу жаны группа ийгиликтуу кошулду!");
        //System.out.println(group);
    }

    @Override
    public Group getGroupByName(String name) {
        for (Group group:Database.groups){
            if(group.getName().equalsIgnoreCase(name)){
                return group;
            }
        }

        return null;
    }


    @Override
    public Group updateGroupName(String oldName, String newName) {
        for (Group group: Database.groups){
            if (group.getName().equalsIgnoreCase(oldName)){
                group.setName(newName);
                System.out.println("Группанын аты ийгиликтуу озгортулду ");
                return group;
            }
        }return null;
    }


    @Override
    public List<Group> getAllGroups() {
        return Database.groups;
    }

    @Override
    public String deleteGroup(String name) {
        for (Group group : Database.groups){
            if (group.getName().equalsIgnoreCase(name)){
                Database.groups.remove(group);
                return group+" атуу группа ийгиликтуу очурулду";
            }
        }
        return null;
    }
}
