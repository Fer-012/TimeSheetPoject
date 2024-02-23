package com.project.TimeSheet.TimeProject.models;

import java.util.ArrayList;
import java.util.List;

public class IntermediaireProjectModel {
    
    private Projects project;
    private List<TimeWork> timeWorks = new ArrayList<TimeWork>();


    public Projects getProject() {
        return project;
    }

    public List<TimeWork> getTimeWorks() {
        return timeWorks;
    }

    public IntermediaireProjectModel() {

    }

    public IntermediaireProjectModel(Projects p, List<TimeWork> timeWorksList){
        this.project = p;
        for(TimeWork T: timeWorksList){
            this.timeWorks.add(T);
        }
    }

     public IntermediaireProjectModel(Projects p){
        this.project = p;
       
    }

    @Override
    public String toString() {
        return "IntermediaireProjectModel [project=" + project + ", timeWorks=" + timeWorks + "]";
    }


}
