package atrue.pranesh.final_retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Adminitrator on 4/5/2018.
 * Copyright IMDSTAR Technologies
 */

public class User implements Parcelable{


    protected User(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
        post_date = in.readString();
        EventAddress = in.readString();
        MobileNumber = in.readString();
        TypeMode = in.readString();
        EventStartDate = in.readString();
        EventEndDate = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(post_date);
        parcel.writeString(EventAddress);
        parcel.writeString(MobileNumber);
        parcel.writeString(TypeMode);
        parcel.writeString(EventStartDate);
        parcel.writeString(EventEndDate);
    }

    public static class Image {
        @SerializedName("url")
        public String url;
        @SerializedName("width")
        public int width;
        @SerializedName("height")
        public int height;
    }


        @SerializedName("id")
        public String id;
        @SerializedName("title")
        public String title;
        @SerializedName("description")
        public String description;
        @SerializedName("post_date")
        public String post_date;
        @SerializedName("EventAddress")
        public String EventAddress;
        @SerializedName("MobileNumber")
        public String MobileNumber;
        @SerializedName("image")
        public List<Image> image;
        @SerializedName("TypeMode")
        public String TypeMode;
        @SerializedName("EventStartDate")
        public String EventStartDate;
        @SerializedName("EventEndDate")
        public String EventEndDate;

}
