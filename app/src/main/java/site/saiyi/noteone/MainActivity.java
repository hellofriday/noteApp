package site.saiyi.noteone;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import site.saiyi.noteone.Module.NoteBo;
import site.saiyi.noteone.adapter.NoteAdapter;
import site.saiyi.noteone.service.NoteService;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView tevClock;
    private ListView listView;
    private NoteAdapter adapter;
    private final Handler handler = new Handler();
    private String currentDataAndTime;
    private ArrayList<NoteBo> noteBos;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
                search();
            }
        });

        tevClock = (TextView) findViewById(R.id.tev_clock);
        handler.post(task);

        noteBos = new ArrayList<>();
        adapter = new NoteAdapter(MainActivity.this);
        listView = (ListView) findViewById(R.id.lst);
        listView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.edt);
    }

    private void insert(){
        //获取文本
        String detail = editText.getText().toString();

        //存入
        NoteBo noteBo = new NoteBo(null, currentDataAndTime, detail, 0);
        NoteService.getInstance().save(noteBo);
    }

    private void search(){
        //取出sql数据库数据
        noteBos.clear();
        adapter.setData(NoteService.getInstance().queryAll());
    }

    private void displayCurrentTime(){
        currentDataAndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        tevClock.setText(currentDataAndTime);
    }

    private final Runnable task = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(task, 1000);
            displayCurrentTime();
        }
    };

    private void displaySqlData(){

    }
}
