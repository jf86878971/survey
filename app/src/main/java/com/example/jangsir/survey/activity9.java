package com.example.jangsir.survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import utils.iofile;


public class activity9 extends AppCompatActivity {


    Button button ;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity9);
        button = (Button)findViewById(R.id.button);
        group = (RadioGroup)findViewById(R.id.sleep);



        setTitle("Sports Time Survey");

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int len = group.getChildCount(); // 获得单选按钮组的选项个数
                String msgString = ""; // 给选中的选项值赋值用的，初始化为空
                for (int i = 0; i < len; i++) {
                    RadioButton radioButton = (RadioButton) group.getChildAt(i); // 返回Group里的指定位置的视图(也就是按钮了)。
            /*
             * 查看android api 文档RadioButton的 public boolean isChecked
             * ()方法 如果未找到这个方法，往父类上找到，这个方法是用检测是否按钮被选中
             */
                    if (radioButton.isChecked()) {
                        msgString = radioButton.getText().toString();
                        break;
                    }
                }
                if(msgString == ""){msgString = "Please Choose One";}
                Toast.makeText(activity9.this, msgString,Toast.LENGTH_SHORT).show();
                if ( msgString != "Please Choose One") {
                    iofile.save(activity9.this,"9."+msgString+"|");
                Intent i;
                i = new Intent (activity9.this,activity10.class);
                startActivity(i);}
            }
        });
    }
}
