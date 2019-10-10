package com.zhenhua.mutilscrolllayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.ryan.rv_gallery.AnimManager;
import com.ryan.rv_gallery.GalleryRecyclerView;
import com.zhenhua.mutilscrolllayout.adapter.GalleryAdapter;
import com.zhenhua.mutilscrolllayout.adapter.ModuleAdapter;
import com.zhenhua.mutilscrolllayout.adapter.TabFragmentAdapter;
import com.zhenhua.mutilscrolllayout.bean.ModuleItem;
import com.zhenhua.mutilscrolllayout.fragment.MyFragment;

import java.util.ArrayList;

import cn.bingoogolapple.bgabanner.BGABanner;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ModuleItem> moduleItemList = new ArrayList<ModuleItem>();
    private ArrayList<ModuleItem> moduleItemGalleyList = new ArrayList<ModuleItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        initBanner();
        initGird();
        initGallery();
        initTabLayout();
    }

    private void initBanner(){
        ArrayList<String> imageUrls = new ArrayList<>();
        imageUrls.add("http://bgashare.bingoogolapple.cn/banner/imgs/17.png");
        imageUrls.add("http://bgashare.bingoogolapple.cn/banner/imgs/16.png");
        imageUrls.add("http://bgashare.bingoogolapple.cn/banner/imgs/12.png");

        ArrayList<Integer> imageUrls1 = new ArrayList<>();
        imageUrls1.add(R.mipmap.b1);
        imageUrls1.add(R.mipmap.b2);
        imageUrls1.add(R.mipmap.b3);

        ArrayList<String> titles = new ArrayList<>();
        titles.add("lufei");
        titles.add("123");
        titles.add("234");
        BGABanner banner = (BGABanner) findViewById(R.id.banner);
        banner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
                Glide.with(MainActivity.this)
                        .load(model)
                        .placeholder(R.mipmap.holder)
                        .error(R.mipmap.holder)
                        .centerCrop()
                        .dontAnimate()
                        .into(itemView);
            }
        });

        banner.setData(imageUrls, titles);
    }

    private void initGird(){
        RecyclerView rvGrid = (RecyclerView) findViewById(R.id.rv_Grid);
        initGirdList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
//        StaggeredGridLayoutManager  staggeredGridLayoutManager =
//                new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        rvGrid.setLayoutManager(gridLayoutManager);
        ModuleAdapter moduleAdapter = new ModuleAdapter(moduleItemList);
        rvGrid.setAdapter(moduleAdapter);
    }

    private void initGirdList() {
        moduleItemList.add(new ModuleItem("module 1", R.mipmap.ic_module));
        moduleItemList.add(new ModuleItem("module 2", R.mipmap.ic_module1));
        moduleItemList.add(new ModuleItem("module 3", R.mipmap.ic_module));
        moduleItemList.add(new ModuleItem("module 4", R.mipmap.ic_module1));
        moduleItemList.add(new ModuleItem("module 5", R.mipmap.ic_module));
        moduleItemList.add(new ModuleItem("module 6", R.mipmap.ic_module1));
        moduleItemList.add(new ModuleItem("module 7", R.mipmap.ic_module1));
        moduleItemList.add(new ModuleItem("module 8", R.mipmap.ic_module1));
        moduleItemList.add(new ModuleItem("module 9", R.mipmap.ic_module1));
    }

    private void initGallery(){
        initGalleryList();
        GalleryRecyclerView rvGallery = findViewById(R.id.rv_Gallery);
        GalleryAdapter adapter = new GalleryAdapter(moduleItemGalleyList);
        rvGallery.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvGallery.setAdapter(adapter);

        rvGallery
                // set scroll speed（pixel/s）
                .initFlingSpeed(9000)
                // set page distance and visible distance of the nearby.
                .initPageParams(0, 40)
                // set the animation factor
                .setAnimFactor(0.1f)
                // set animation type. you can choose AnimManager.ANIM_BOTTOM_TO_TOP or AnimManager.ANIM_TOP_TO_BOTTOM
                .setAnimType(AnimManager.ANIM_BOTTOM_TO_TOP)
                // set click listener
//                .setOnItemClickListener(this)
                // set whether auto play
                .autoPlay(true)
                // set auto play intervel
                .intervalTime(2000)
                // set default position
                .initPosition(1)
                // finally call method
                .setUp();
    }

    private void initGalleryList() {

        moduleItemGalleyList.add(new ModuleItem("module 1", R.mipmap.ic_1));
        moduleItemGalleyList.add(new ModuleItem("module 2", R.mipmap.ic_2));
        moduleItemGalleyList.add(new ModuleItem("module 3", R.mipmap.ic_3));
        moduleItemGalleyList.add(new ModuleItem("module 4", R.mipmap.ic_4));
        moduleItemGalleyList.add(new ModuleItem("module 5", R.mipmap.ic_5));
//        moduleItemList.add(new ModuleItem("module 6", R.mipmap.ic_module1));
//        moduleItemList.add(new ModuleItem("module 7", R.mipmap.ic_module1));
//        moduleItemList.add(new ModuleItem("module 8", R.mipmap.ic_module1));
//        moduleItemList.add(new ModuleItem("module 9", R.mipmap.ic_module1));
    }
    private void initTabLayout(){
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
        for (int i = 0; i < 4; i++) {
            fragmentList.add(new MyFragment());
        }
        String[] titleArr = {"Tab 1", "Tab 2", "Tab 3", "Tab 4"};
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(fragmentList,
                titleArr, getSupportFragmentManager(), this);
        viewPager.setAdapter(tabFragmentAdapter);
        viewPager.setOffscreenPageLimit(4);// 设置预加载Fragment个数
        viewPager.setCurrentItem(1);

        tabLayout.setupWithViewPager(viewPager);
    }
}
