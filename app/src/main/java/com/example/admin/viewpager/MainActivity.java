package com.example.admin.viewpager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.design.widget.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private android.support.v4.app.FragmentPagerAdapter mFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public Fragment getItem(int position) {
                return MainActivity.PlaceholderFragment.newInstance(position + 1);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.hoang_name);
                    case 1:
                        return getString(R.string.thang_name);
                    case 2:
                        return getString(R.string.na_name);
                    case 3:
                        return getString(R.string.tuan_name);
                }
                return null;
            }
        };

        mViewPager = findViewById(R.id.containers);
        mViewPager.setAdapter(mFragmentPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String KEY_NAME = "key name";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int name) {

            Bundle args = new Bundle();
            PlaceholderFragment fragment = new PlaceholderFragment();

            args.putInt(KEY_NAME, name);
            fragment.setArguments(args);
            return fragment;
        }

        @SuppressLint("ResourceAsColor")
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                            @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_layout, container, false);

            RelativeLayout relativeLayout = view.findViewById(R.id.relaytive_fragment);
            TextView text_Name = view.findViewById(R.id.text_label);
            ImageView imageView = view.findViewById(R.id.image_pic);

            switch (getArguments().getInt(KEY_NAME)) {
                case 1:
                    imageView.setImageResource(R.drawable.hoang);
                    text_Name.setText(getString(R.string.hoang_name));
                    text_Name.setBackgroundColor(R.color.colorNgot);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.thang);
                    text_Name.setText(getString(R.string.thang_name));
                    text_Name.setBackgroundColor(R.color.colorNgot);

                    break;
                case 3:
                    imageView.setImageResource(R.drawable.namanh);
                    text_Name.setText(getString(R.string.na_name));
                    text_Name.setBackgroundColor(R.color.colorNgot);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.tuan);
                    text_Name.setText(getString(R.string.tuan_name));
                    text_Name.setBackgroundColor(R.color.colorNgot);
                    break;
                default:
                    imageView.setImageResource(R.drawable.hoang);
                    text_Name.setText(getString(R.string.hoang_name));
                    text_Name.setBackgroundColor(R.color.colorNgot);
                    break;
            }
            return view;
        }
    }
}
