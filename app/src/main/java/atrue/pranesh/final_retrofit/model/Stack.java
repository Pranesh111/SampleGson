package atrue.pranesh.final_retrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Adminitrator on 4/5/2018.
 * Copyright IMDSTAR Technologies
 */

public class Stack implements Parcelable {


        @SerializedName("last_activity_date")
        public int last_activity_date;
        @SerializedName("question_id")
        public int question_id;
        @SerializedName("link")
        public String link;
        @SerializedName("title")
        public String title;


    protected Stack(Parcel in) {
        last_activity_date = in.readInt();
        question_id = in.readInt();
        link = in.readString();
        title = in.readString();
    }

    public static final Creator<Stack> CREATOR = new Creator<Stack>() {
        @Override
        public Stack createFromParcel(Parcel in) {
            return new Stack(in);
        }

        @Override
        public Stack[] newArray(int size) {
            return new Stack[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(last_activity_date);
        parcel.writeInt(question_id);
        parcel.writeString(link);
        parcel.writeString(title);
    }
}
