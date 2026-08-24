/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop368
 */
public class Task {

    private static int idCounter = 1; // gán mặc định là 1 --> biến static --> đếm id chung
    private int id ; 
    private String taskTypeId;
    private String requirementName;
    private String date;
    private double planFrom, planTo;
    private String assignee, reviewer;

    public Task() {
    }

    public Task(String requirementName, String taskTypeId, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = idCounter++; // gán id rồi tăng lên 1
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    // getter

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
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

    public double getPlanFrom() {
        return planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    
   
}
