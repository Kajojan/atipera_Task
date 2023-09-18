package com.example.atipera;


import java.util.ArrayList;
import java.util.List;

public class Repository_Branch {
    private String name;
    private Login owner;
   private List<Branch> branches=new ArrayList<Branch>();

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public void addBranches(Branch branch){
        this.branches.add(branch);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Login getOwner() {
        return owner;
    }

    public void setOwner(Login owner) {
        this.owner = owner;
    }


}
