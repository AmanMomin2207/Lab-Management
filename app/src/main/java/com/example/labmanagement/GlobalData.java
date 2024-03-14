package com.example.labmanagement;
import android.app.Application;
public class GlobalData extends Application {

    String lablist[] = new String[5];
    String uname[] = new String[5];
    int index = 0;
    int index1=0;

    void setuname(String uname) {
        this.uname[index1++] = uname;
    }

    void setlabname(String lname) {
        this.lablist[index++] = lname;
    }

    String []getuname() {
        return uname;
    }

    public String[] getlname() {

        return lablist;
    }
}
