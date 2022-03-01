package com.swift.birdsofafeather.model.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;
import java.util.UUID;

@Dao
public interface ClassesDao {
    @Transaction
    @Query("SELECT * FROM classes")
    List<Class> getAllClasses();

    @Transaction
    @Query("SELECT * FROM classes WHERE student_id=:studentId")
    List<Class> getForStudent(UUID studentId);

    @Query("SELECT * FROM classes WHERE class_id=:classId")
    Class getClass(UUID classId);

    @Query("SELECT COUNT(*) FROM classes")
    int count();

    @Query("SELECT EXISTS(SELECT * FROM classes WHERE year=:year AND quarter=:quarter " +
            "AND subject=:subject AND course_number=:courseNumber)")
    boolean checkExist(int year, String quarter, String subject, String courseNumber);

    @Query("SELECT EXISTS(SELECT * FROM classes WHERE student_id=:studentId AND year=:year " +
            "AND quarter=:quarter AND subject=:subject AND course_number=:courseNumber)")
    boolean checkExist(UUID studentId, int year, String quarter, String subject, String courseNumber);

    @Insert
    void insert(Class toInsert);

    @Query("DELETE FROM classes WHERE NOT student_id=:studentId")
    void deleteExceptStudent(UUID studentId);

    @Query("DELETE FROM classes")
    void nukeTable();
}
