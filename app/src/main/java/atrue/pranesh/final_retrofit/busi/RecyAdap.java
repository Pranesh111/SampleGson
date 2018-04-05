package atrue.pranesh.final_retrofit.busi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.zip.Inflater;

import atrue.pranesh.final_retrofit.R;
import atrue.pranesh.final_retrofit.model.Stack;
import atrue.pranesh.final_retrofit.model.User;


public class RecyAdap extends RecyclerView.Adapter {
    RecyViewHol recyViewHol;
    List<Stack> userList;
    View.OnClickListener listener;

    public RecyAdap(List<Stack> userList, View.OnClickListener listener) {
        this.userList = userList;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ada1, parent, false);
        recyViewHol = new RecyViewHol(view);
        return recyViewHol;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        recyViewHol.onBind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
