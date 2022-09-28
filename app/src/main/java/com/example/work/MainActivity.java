package com.example.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment fragment1,fragment2,fragment3,fragment4;
    private ImageView imageView1,imageView2,imageView3,imageView4;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1=findViewById(R.id.layout1);
        linearLayout2=findViewById(R.id.layout2);
        linearLayout3=findViewById(R.id.layout3);
        linearLayout4=findViewById(R.id.layout4);

        fragment1=new ChatFragment();
        fragment2=new PeopleFragment();
        fragment3=new FindFragment();
        fragment4=new PersonalFragment();

        manager=getSupportFragmentManager();
        initImageView();
        initial();

        hidden();

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

    }

    private void initial() {
        transaction=manager.beginTransaction()
                .add(R.id.frameLayout,fragment1)
                .add(R.id.frameLayout,fragment2)
                .add(R.id.frameLayout,fragment3)
                .add(R.id.frameLayout,fragment4);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layout1:select(1);
                break;
            case R.id.layout2:select(2);
                break;
            case R.id.layout3:select(3);
                break;
            case R.id.layout4:select(4);
                break;
        };
    }

    private void select( int i) {
        TextView textView = findViewById(R.id.textView);
        hidden();
        resetImg();
        switch (i){
            case 1:showfragment(fragment1);
                imageView1.setImageResource(R.drawable.weixinthis);
                textView.setText(R.string.vx);
                break;
            case 2:showfragment(fragment2);
                imageView2.setImageResource(R.drawable.contactthis);
                textView.setText(R.string.contact);
                break;
            case 3:showfragment(fragment3);
                imageView3.setImageResource(R.drawable.findthis);
                textView.setText(R.string.find);
                break;
            case 4:showfragment(fragment4);
                imageView4.setImageResource(R.drawable.myselfthis);
                textView.setText(R.string.myself);
                break;
        }
    }

    private void showfragment(Fragment fragment) {
        transaction.show(fragment);
    }

    private void hidden() {
        transaction=manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        transaction.commit();

    }
    private void initImageView() {
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);

        linearLayout1 = findViewById(R.id.layout1);
        linearLayout2 = findViewById(R.id.layout2);
        linearLayout3 = findViewById(R.id.layout3);
        linearLayout4 = findViewById(R.id.layout4);
    }

    private void resetImg() {    //调用灰色的图片，以让点击过后的图片回复原色
        imageView1.setImageResource(R.drawable.weixin);
        imageView2.setImageResource(R.drawable.contact);
        imageView3.setImageResource(R.drawable.find);
        imageView4.setImageResource(R.drawable.myself);

    }


}