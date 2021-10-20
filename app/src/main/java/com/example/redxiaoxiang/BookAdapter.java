package com.example.redxiaoxiang;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private Context mContent;
    private List<Book> mBook;

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView bookImage;
        TextView bookName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView=(CardView)itemView;
            bookName=(TextView)cardView.findViewById(R.id.book_name);
            bookImage=(ImageView)cardView.findViewById(R.id.book_image);
        }
    }
    public BookAdapter(List<Book> functionList) {
        mBook=functionList;
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {

        Book fruit=mBook.get(position);
        holder.bookName.setText(fruit.getName());
        Glide.with(mContent).load(fruit.getImgPath()).into(holder.bookImage);
    }

    @Override
    public int getItemCount() {
        return mBook.size();
    }
    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContent==null){
            mContent=parent.getContext();
        }
        View view= LayoutInflater.from(mContent).inflate(R.layout.book_cardview,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        //员工端功能的点击事件
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Book function=mBook.get(position);
               /* switch (position){
              *//*      case 0:
                        Intent intent0=new Intent(mContent,Accept_order.class);
                        mContent.startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1=new Intent(mContent,UserReview.class);
                        mContent.startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2=new Intent(mContent,LogisticTracking.class);
                        mContent.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(mContent,PersonMessage.class);
                        mContent.startActivity(intent3);
                        break;
                    default:break;*//*
                }*/
            }
        });
        return holder;
    }
}
