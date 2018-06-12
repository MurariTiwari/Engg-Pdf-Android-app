package com.tiwarithetiger11gmail.myengineeringpdfs;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MURARI TIWARI on 11/1/2017.
 */

public class modal {
    @SerializedName("subject")
    private String subject;
    @SerializedName("topic")
    private String Description;
    @SerializedName("pdf")
    private String pdfname;

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return Description;
    }

    public String getPdfname() {
        return pdfname;
    }

   }
