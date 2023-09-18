package com.example.atipera;


public class Repository {
        private String name;
        private boolean fork;

        private Login owner;

        private String branches_url;
    private Branch Branches;

    public Branch getBranches() {
        return Branches;
    }

    public void setBranches(Branch branches) {
        Branches = branches;
    }

    public Login getOwner() {
        return owner;
    }

    public void setOwner(Login owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public String getBranches_url() {
        return branches_url;
    }

    public void setBranches_url(String branches_url) {
        this.branches_url = branches_url;
    }

//    public Repository getReposiroty(){
//        Repository subsetRepo = new Repository();
//        subsetRepo.setName(this.name);
//        subsetRepo.setOwner(this.owner);
//        return subsetRepo;
//    }

}
