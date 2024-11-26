package service.serviceImpl;

import database.Database;
import models.Group;
import models.Lesson;
import service.LessonService;

public class LessonServiceImpl implements LessonService {

    @Override
    public void addLessonToGroup(String groupName, String lessonName, String description) throws Exception {
        Group group = new GroupServiceImpl().getGroupByName(groupName);
        Lesson lesson = new Lesson(lessonName, description);
        group.getLessons().add(lesson);
        Database.lessons.add(lesson);

    }

    @Override
    public Lesson getLessonByName(String name) {
        for (Lesson lesson:Database.lessons){
            if (lesson.getLessonName().equalsIgnoreCase(name)){
                return lesson;
            }
        }
        return null;
    }

    @Override
    public String deleteLesson(String name) {
        for (Lesson lesson:Database.lessons){
            if (lesson.getLessonName().equalsIgnoreCase(name)){
                Database.lessons.remove(lesson);
                return lesson+ "Сабагы очурулду";
            }
        }
        return null;
    }
}
