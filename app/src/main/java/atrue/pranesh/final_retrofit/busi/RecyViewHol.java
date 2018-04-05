package atrue.pranesh.final_retrofit.busi;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import atrue.pranesh.final_retrofit.R;
import atrue.pranesh.final_retrofit.model.Stack;
import atrue.pranesh.final_retrofit.model.User;

/**
 * Created by Adminitrator on 4/5/2018.
 * Copyright IMDSTAR Technologies
 */

public class RecyViewHol extends RecyclerView.ViewHolder{
    TextView textView;
    public RecyViewHol(View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.txt1);
    }

    public void onBind(Stack user) {
        textView.setText(user.link);
    }
}
