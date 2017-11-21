package akoya.ua.com.groupstudent;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends Activity implements View.OnClickListener {

    int[] checkBoxes;
    ArrayList<CheckBox> checkBoxList;
    ArrayList<String> studList;
    Button buttonCheckAll, buttonReady;
    RadioButton radioStandard;
    boolean isCheckAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        checkBoxes = new int[]{R.id.id_1, R.id.id_2, R.id.id_3, R.id.id_4, R.id.id_5, R.id.id_6,
                R.id.id_7, R.id.id_8, R.id.id_9, R.id.id_10, R.id.id_11, R.id.id_12, R.id.id_13,
                R.id.id_14, R.id.id_15, R.id.id_16};
        checkBoxList = new ArrayList<>();
        for (int checkBox : checkBoxes) {
            checkBoxList.add((CheckBox) findViewById(checkBox));
        }

        buttonCheckAll = findViewById(R.id.buttonCheckAll);
        buttonCheckAll.setOnClickListener(this);

        buttonReady = findViewById(R.id.buttonReady);
        buttonReady.setOnClickListener(this);

        radioStandard = findViewById(R.id.standard);
        radioStandard.setChecked(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.buttonCheckAll:

                if (isCheckAll) {
                    for (int i = 0; i < 16; i++) {
                        checkBoxList.get(i).setChecked(false);
                        isCheckAll = false;
                        buttonCheckAll.setText("Выбрать всех");
                    }
                } else {
                    for (int i = 0; i < 16; i++) {
                        checkBoxList.get(i).setChecked(true);
                        isCheckAll = true;
                        buttonCheckAll.setText("Убрать всех");
                    }
                }
                break;

            case R.id.buttonReady:

                Intent intent = new Intent(MainActivity.this, StudentsActivity.class);
                studList = new ArrayList<>();
                for (CheckBox box : checkBoxList) {
                    if (box.isChecked()) {
                        studList.add(box.getText().toString());
                    }
                }
                if (radioStandard.isChecked()) {
                    intent.putExtra("list", studList);
                    startActivity(intent);
                    break;
                }else {
                    Collections.shuffle(studList);
                    intent.putExtra("list", studList);
                    startActivity(intent);
                    break;
                }
        }
    }
}
