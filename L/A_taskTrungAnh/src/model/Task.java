package model;

public class Task {

    private int id;
    private static int idCount = 1;
    private String taskTypeId;
    private String requirementName;
    private String date;
    
    private double fromPlan, toPlan;
    private String reviewer, assignee;

    
    // Contructor
    public Task() {
    }
    
    
    // bỏ int id và đổi id count++
    public Task(String taskTypeId, String requirementName, String date, double fromPlan, double toPlan, String reviewer, String assignee) {
        this.id = idCount++;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.fromPlan = fromPlan;
        this.toPlan = toPlan;
        this.reviewer = reviewer;
        this.assignee = assignee;
    }
    
    // Getter

    public int getId() {
        return id;
    }

    public static int getIdCount() {
        return idCount;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public String getDate() {
        return date;
    }

    public double getFromPlan() {
        return fromPlan;
    }

    public double getToPlan() {
        return toPlan;
    }

    public String getReviewer() {
        return reviewer;
    }

    public String getAssignee() {
        return assignee;
    }
    
    
    
}



































///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package model;
//
///**
// *
// * @author Trung Anh
// */
//public class Task {
//
//    private static int idCounter = 1;   // biến staic, đếm id chung và = 1
//    private int id;
//    private String taskTypeID;
//    private String requireName;
//    private String date;
//
//    //date
//    private double fromPlan, toPlan;
//
//    // reviewer va woker
//    private String assignee, reviewer;
//
//    // Contructor
//    public Task() {
//    }
//    // không được thêm id vào contructor
//    public Task(String taskTypeID, String requireName, String date, double fromPlan, double toPlan, String assignee, String reviewer) {
//        this.id = idCounter++; //gán id và tăng lên 1
//        this.taskTypeID = taskTypeID;
//        this.requireName = requireName;
//        this.date = date;
//        this.fromPlan = fromPlan;
//        this.toPlan = toPlan;
//        this.assignee = assignee;
//        this.reviewer = reviewer;
//    }
//
//    
//    //Getter là lấy giá trị
//    //Setter là gán / thay đổi giá trị 
//    //vì mình chỉ cần lấy nên chỉ dùng getter
//    
//    // Getter
//    public static int getIdCounter() {
//        return idCounter;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getTaskTypeID() {
//        return taskTypeID;
//    }
//
//    public String getRequireName() {
//        return requireName;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public double getFromPlan() {
//        return fromPlan;
//    }
//
//    public double getToPlan() {
//        return toPlan;
//    }
//
//    public String getAssignee() {
//        return assignee;
//    }
//
//    public String getReview() {
//        return reviewer;
//    }
//
//}
