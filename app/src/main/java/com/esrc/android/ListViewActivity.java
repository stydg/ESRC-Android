package com.esrc.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.rxjava3.annotations.Nullable;

public class ListViewActivity extends AppCompatActivity {
    private String TAG = ListViewActivity.class.getSimpleName();

    private ListView listview = null;
    private ListViewAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_main);

        listview = (ListView) findViewById(R.id.listview);
        adapter = new ListViewAdapter();

        //Adapter 안에 아이템의 정보 담기
        adapter.addItem(new VideoItem("#북금곰 #빙하 #지구온난화", "북극곰의 눈물과 빙하", 1));
        adapter.addItem(new VideoItem("#기후피해 #인명피해 #폭설", "겨울철, 한 리조트에서",2));
        adapter.addItem(new VideoItem("#해양생물 #바다쓰레기 #오염", "죽어가는 바다 생태", 3));

        //리스트뷰에 Adapter 설정
        listview.setAdapter(adapter);
    }


    /* 리스트뷰 어댑터 */
    public class ListViewAdapter extends BaseAdapter {
        ArrayList<VideoItem> items = new ArrayList<VideoItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(VideoItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();
            final VideoItem videoItem = items.get(position);

            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listview_list_item, viewGroup, false);

            } else {
                View view = new View(context);
                view = (View) convertView;
            }

            TextView keyword = (TextView) convertView.findViewById(R.id.keyword);
            TextView title = (TextView) convertView.findViewById(R.id.title);

            keyword.setText(videoItem.getkeyword());
            title.setText(videoItem.gettitle());
            Log.d(TAG, "getView() - [ "+position+" ] "+videoItem.gettitle());

            //각 아이템 선택 event
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, videoItem.getkeyword()+" 번 - "+videoItem.gettitle()+" 입니다! ", Toast.LENGTH_SHORT).show();
                    TimerTask goGeo = new TimerTask(){
                        public void run(){
                            Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    };
                    Timer timer = new Timer();
                    timer.schedule(goGeo, 1000);
                }
            });

            return convertView;  //뷰 객체 반환
        }
    }

}
