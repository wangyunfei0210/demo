package com.example.demo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.db.DBManager;
import com.example.demo.db.DBhelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button btn, delete, update;
    private LinearLayout linearLayout;
    private DBhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linearLayout);
        textView = findViewById(R.id.tv_name);
        btn = findViewById(R.id.btn);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        textView.setText("wangyunfei");
        linearLayout.setBackground(getDrawable(R.color.colorAccent));
        dbhelper = new DBhelper(this);
//        insert();
        btn.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
    }

    public void insert() {
        String sql = "insert into user(name,age,sex) values(?,?,?)";
        DBManager.getInstanace(this).insert(dbhelper.getWritableDatabase(), sql, new Object[]{"王云飞", 24, "男"});
        DBManager.getInstanace(this).insert(dbhelper.getWritableDatabase(), sql, new Object[]{"张三", 23, "女"});
        DBManager.getInstanace(this).insert(dbhelper.getWritableDatabase(), sql, new Object[]{"李四", 22, "男"});
        DBManager.getInstanace(this).insert(dbhelper.getWritableDatabase(), sql, new Object[]{"王二", 21, "女"});
        DBManager.getInstanace(this).insert(dbhelper.getWritableDatabase(), sql, new Object[]{"麻子", 1, "女"});
        DBManager.getInstanace(this).insert(dbhelper.getWritableDatabase(), sql, new Object[]{"王甲", 2, "男"});
        DBManager.getInstanace(this).insert(dbhelper.getWritableDatabase(), sql, new Object[]{"王乙", 3, "女"});
        DBManager.getInstanace(this).insert(dbhelper.getWritableDatabase(), sql, new Object[]{"王丙", 4, "男"});
        DBManager.getInstanace(this).insert(dbhelper.getWritableDatabase(), sql, new Object[]{"王丁", 5, "女"});
    }

    public void query() {
        String sql = "Select * from user";
        String text = DBManager.getInstanace(this).query(dbhelper.getWritableDatabase(), sql);
        textView.setText(text);
    }

    public void delete() {
        String sql = "Delete from user where userid=?";
        DBManager.getInstanace(this).delete(dbhelper.getWritableDatabase(), sql, new Object[]{1});
        query();
    }

    public void update() {
        ContentValues values = new ContentValues();
        values.put("name", "王云飞");
        values.put("age", "24");
        values.put("sex", "女");
        DBManager.getInstanace(this).update(dbhelper.getWritableDatabase(), values, "userid=?", new String[]{String.valueOf(2)});
        query();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                query();
                break;
            case R.id.delete:
                delete();
                break;
            case R.id.update:
                update();
                break;
        }
    }

    /**
     * 冒泡排序
     * @param str
     */
    public void score(int[] str) {
        if (str != null && str.length > 0) {
            for (int i = 0; i < str.length - 1; i++) {
                for (int j = 0; j < str.length - 1 - i; j++) {
                    if (str[i] < str[j]) {
                        int temp = str[j];
                        str[j] = str[j + 1];
                        str[j + 1] = temp;
                    }
                }
            }
        }
    }
}
