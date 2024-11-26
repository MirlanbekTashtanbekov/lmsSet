package service;

import models.Lesson;

public interface LessonService {

    void addLessonToGroup(String groupName, String lessonName, String description) throws Exception;

    Lesson getLessonByName (String name);

    String deleteLesson (String name);


}
