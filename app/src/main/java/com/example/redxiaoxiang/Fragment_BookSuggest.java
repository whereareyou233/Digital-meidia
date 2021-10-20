package com.example.redxiaoxiang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_BookSuggest extends Fragment {

    private View view;//定义view用来设置fragment的layout
    public RecyclerView mCollectRecyclerView;//定义RecyclerView
    private Book[] function = {
            new Book(R.drawable.changzheng, "订单接收"), new Book(R.drawable.bookrec_1, "用户评价"),
            new Book(R.drawable.book_icon3, "物流跟踪"), new Book(R.drawable.book_icon3, "个人信息"),
            new Book(R.drawable.book_icon3, "物流跟踪"), new Book(R.drawable.book_icon3, "个人信息"),
            new Book(R.drawable.book_icon3, "物流跟踪"), new Book(R.drawable.book_icon3, "个人信息"),
            new Book(R.drawable.book_icon3, "物流跟踪"), new Book(R.drawable.book_icon3, "个人信息"),
            new Book(R.drawable.book_icon3, "物流跟踪"), new Book(R.drawable.book_icon3, "个人信息"),
    };
    private List<Book> Functionlist = new ArrayList<>();
    private BookAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_book, container, false);

        initFruit();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.book_recycle);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BookAdapter(Functionlist);
        recyclerView.setAdapter(adapter);
        //模拟数据
        return view;
    }

    private void initFruit() {
        Functionlist.clear();
        for (int x = 0; x < 12; x++) {
            Functionlist.add(function[x]);
        }
    }

   /* private void initRecyclerView() {
        //获取RecyclerView
        mCollectRecyclerView = (RecyclerView) view.findViewById(R.id.book_recycle);
        //创建adapter
        mCollectRecyclerAdapter = new BookAdapter.ViewHolder(getActivity(), goodsEntityList);
        //给RecyclerView设置adapter
        mCollectRecyclerView.setAdapter(mCollectRecyclerAdapter);
*/
    //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
    //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
//        mCollectRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        /*//设置item的分割线
        mCollectRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));*/

    //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
        /*mCollectRecyclerAdapter.setOnItemClickListener(new CollectRecycleAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, Book data) {
                //此处进行监听事件的业务处理
                Toast.makeText(getActivity(), "我是item", Toast.LENGTH_SHORT).show();
            }
        });
    }*/


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_book);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        toolbar.setTitle("图书馆");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        if (getChildFragmentManager().getBackStackEntryCount() == 0) {
            inflater.inflate(R.menu.book_menu, menu);
        }
        MenuItem mySearch = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) mySearch.getActionView();
        //设置搜索默认提示文字
        searchView.setQueryHint("搜索");
        //相当于设置点击事件
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //提交是进行搜索
            @Override                       //没什么作用，必须重写//好像用于回车查询的
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            //输入字符改变是进行搜索
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;

            }
        });
    }
}
