package database;

public class GenerateId {

    public static Long groupsId = 0L;

    public static Long groupId (){
        return ++groupsId;
    }


    public static Long studentsId = 0L;

    public static Long studentId (){
        return ++studentsId;
    }
}
