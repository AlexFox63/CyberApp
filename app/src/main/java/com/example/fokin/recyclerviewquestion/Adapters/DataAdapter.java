package com.example.fokin.recyclerviewquestion.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.fokin.recyclerviewquestion.Enity.Answer;
import com.example.fokin.recyclerviewquestion.Enity.Question;
import com.example.fokin.recyclerviewquestion.R;

import java.util.List;

    public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
        private LayoutInflater inflater;
        private List<Answer> answers;

        public DataAdapter(Context context, List<Answer> answers){
            this.answers = answers;
            this.inflater = LayoutInflater.from(context);
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            final CheckBox checkBox;
            final TextView textAnswer;
            ViewHolder(View view){
                super(view);
                textAnswer = view.findViewById(R.id.textAnswer);
                checkBox = view.findViewById(R.id.checkBox);
            }
        }

        /** onCreateViewHolder: возвращает объект ViewHolder, который будет хранить данные по одному объекту Question. **/

        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.recycleview_item, parent, false);
            return new ViewHolder(view);
        }

        /**onBindViewHolder: выполняет привязку объекта ViewHolder к объекту Question по определенной позиции. **/

        @Override
        public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
            Answer answer = answers.get(position);
            holder.textAnswer.setText(answer.getText());
        }

        /**getItemCount: возвращает количество объектов в списке**/
        @Override
        public int getItemCount() {
            return answers.size();
        }

}
