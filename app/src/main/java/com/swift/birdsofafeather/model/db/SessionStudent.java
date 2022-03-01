package com.swift.birdsofafeather.model.db;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "sessions-students", foreignKeys = {
        @ForeignKey(entity = Student.class, parentColumns = "student_id",childColumns = "student_id"),
        @ForeignKey(entity = Session.class, parentColumns = "session_id",childColumns = "session_id")
        })
public class SessionStudent {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "session_id")
    public UUID sessionId;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "student_id")
    public UUID studentId;

    public SessionStudent(UUID sessionId, UUID studentId){
        this.sessionId = sessionId;
        this.studentId = studentId;
    }
}