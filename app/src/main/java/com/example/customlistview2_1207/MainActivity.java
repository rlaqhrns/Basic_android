package com.example.customlistview2_1207;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //리스트 뷰 항목에 셋팅한 데이터
    int[] imgRes = {
            R.drawable.imgflag1,R.drawable.imgflag2,R.drawable.imgflag3,R.drawable.imgflag4,
            R.drawable.imgflag5,R.drawable.imgflag6,R.drawable.imgflag7,R.drawable.imgflag8
    };

    String[] data1 = {
            "토고","프랑스","스위스","스페인","일본","독일","브라질","대한민국"
    };

    String[] data2 = {
            "togo","france","swiss","spain","japan","german","brazil","korea"
    };

    //뷰의 주소 값을 담을 참조변수
    ListView list1;
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //뷰의 주소값을 받아온다.
        list1 = (ListView)findViewById(R.id.list1);
        text3 = (TextView)findViewById(R.id.textView3);
        //Log.d("image?",""+ imgRes[0]);
        //데이터를 가지고 있는 ArrayList 생성
        ArrayList<HashMap<String,Object>> datalist = new ArrayList<HashMap<String, Object>>();
        //데이터를 담는다.
        for(int i = 0;i<imgRes.length;i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("flag",imgRes[i]);
            map.put("data1",data1[i]);
            map.put("data2",data2[i]);
            datalist.add(map);
        }
        //해쉬 맵 객체에 데이터를 저장할 때 사용한 이름 배열
        String[] keys = {"flag","data1","data2"};
        //데이터를 셋팅할 뷰의 id
        int[] ids = {R.id.imageView,R.id.textView,R.id.textView2};
        SimpleAdapter adapter = new SimpleAdapter(this,datalist,R.layout.row,keys,ids); //this는 현재 클래스 MainActivity 이다.
        list1.setAdapter(adapter);

        //리스너를 리스트 뷰에 셋팅
        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);
    }
    //리스트 뷰의 항목을 터치하면 반응하는 리스너
    class ListListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            text3.setText(data1[position]);
        }
    }
}