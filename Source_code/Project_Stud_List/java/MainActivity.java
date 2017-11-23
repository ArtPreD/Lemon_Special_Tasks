package meraya.ua.com.students_group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int[] checkBoxes;
    ArrayList<CheckBox> checkBoxList;
    ArrayList<String> studList;
    Button buttonCheckAll, buttonReady;
    RadioButton radioStandard;
    boolean isCheckAll;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxes = new int[]{R.id.id_1, R.id.id_2, R.id.id_3, R.id.id_4, R.id.id_5, R.id.id_6,
                R.id.id_7, R.id.id_8, R.id.id_9, R.id.id_10, R.id.id_11, R.id.id_12, R.id.id_13,
                R.id.id_14, R.id.id_15, R.id.id_16};
        checkBoxList = new ArrayList<>();
        for (int checkBox : checkBoxes) {
            checkBoxList.add((CheckBox) findViewById(checkBox));
        }

        buttonCheckAll = (Button) findViewById(R.id.checkAll);
        buttonCheckAll.setOnClickListener(this);

        buttonReady = (Button) findViewById(R.id.ready);
        buttonReady.setOnClickListener(this);

        radioStandard = (RadioButton) findViewById(R.id.standard);
        radioStandard.setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.checkAll:
                checkOrUncheck(isCheckAll);
                break;

            case R.id.ready:
                studList = createStudList();

                if(studList.isEmpty() && studList.size() == 0){
                    toast = Toast.makeText(MainActivity.this, R.string.toast_mess, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 180);
                    toast.show();
                }else {
                    if (radioStandard.isChecked()){
                        runStandard(studList);
                    }else {
                        runRandom(studList);
                    }
                }
        }
    }

    private ArrayList<String> createStudList(){
        studList = new ArrayList<>();
        for (CheckBox box : checkBoxList) {
            if (box.isChecked()) {
                studList.add(box.getText().toString());
            }
        }
        return studList;
    }

    private void checkOrUncheck(boolean isCheck){
        if (isCheckAll) {
            for (int i = 0; i < checkBoxList.size(); i++) {
                checkBoxList.get(i).setChecked(false);
            }
            isCheckAll = false;
            buttonCheckAll.setText("Выбрать всех");
        } else {
            for (int i = 0; i < checkBoxList.size(); i++) {
                checkBoxList.get(i).setChecked(true);
            }
            isCheckAll = true;
            buttonCheckAll.setText("Убрать всех");
        }
    }

    private void runStandard(ArrayList<String> studList) {
        Intent intent = new Intent(MainActivity.this, StudentsActivity.class);
        intent.putExtra("list", studList);
        startActivity(intent);
//        Toast standard = Toast.makeText(MainActivity.this, "Запущен стандартный режим", Toast.LENGTH_SHORT);
//        standard.show();
    }

    private void runRandom(ArrayList<String> studList) {
        Intent intent = new Intent(MainActivity.this, StudentsActivity.class);
        Collections.shuffle(studList);
        intent.putExtra("list", studList);
        startActivity(intent);
//        Toast random = Toast.makeText(MainActivity.this, "Запущен случайный режим", Toast.LENGTH_SHORT);
//        random.show();
    }
}

