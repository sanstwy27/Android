package com.sanstwy777.activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class HeadActivity extends AppCompatActivity {
    public int[] imageId = new int[] {
            R.drawable.touxiang1, R.drawable.touxiang2,
            R.drawable.touxiang3, R.drawable.touxiang4, R.drawable.touxiang5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageview;
                if (convertView == null) {
                    // set image width, height and padding
                    imageview = new ImageView(HeadActivity.this);
                    imageview.setAdjustViewBounds(true);
                    imageview.setMaxWidth(158);
                    imageview.setMaxHeight(150);
                    imageview.setPadding(5, 5, 5, 5);
                } else {
                    imageview = (ImageView) convertView;
                }
                imageview.setImageResource(imageId[position]);
                return imageview;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public int getCount() {
                return imageId.length;
            }
        };

        // adapt to GridView
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("imageId", imageId[position]);
                intent.putExtras(bundle);
                setResult(0x11, intent);
                // close current activity
                finish();
            }
        });
    }
}