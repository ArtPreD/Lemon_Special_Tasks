package akoya.ua.com.groupstudent;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class StudentsActivity extends Activity {
    LinearLayout layoutOdd, layoutEven, layoutDelimiter, layoutMain;
    ArrayList<TextView> odd, even , delimiter;
    int colorBlack;
    Intent intent;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_students);
        colorBlack = Color.parseColor("#000000");
        layoutOdd = findViewById(R.id.odd);
        layoutEven = findViewById(R.id.even);
        layoutDelimiter = findViewById(R.id.delimiter);
        layoutMain = findViewById(R.id.mainLayout);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                wrapContent, wrapContent);
        lParams.setMargins(10,10,10,10);
        intent = getIntent();

        ArrayList<String> studList = (ArrayList<String>) intent.getSerializableExtra("list");

        odd = new ArrayList<>();
        even = new ArrayList<>();
        delimiter = new ArrayList<>();

        float size = 12;
        int evenIndex = 0;
        int oddIndex = 0;

        if (!studList.isEmpty()) {
            for (int i = 0; i < studList.size(); i++) {
                if ((i + 1) % 2 != 0) {
                    odd.add(new TextView(this));
                    odd.get(oddIndex).setText(studList.get(i));
                    odd.get(oddIndex).setTextColor(colorBlack);
                    odd.get(oddIndex).setTextSize(size);
                    layoutOdd.addView(odd.get(oddIndex), lParams);

                    delimiter.add(new TextView(this));
                    delimiter.get(oddIndex).setText(" ===>");
                    delimiter.get(oddIndex).setTextColor(colorBlack);
                    delimiter.get(oddIndex).setTextSize(size);
                    layoutDelimiter.addView(delimiter.get(oddIndex), lParams);

                    oddIndex++;
                } else {
                    even.add(new TextView(this));
                    even.get(evenIndex).setText(studList.get(i));
                    even.get(evenIndex).setTextColor(colorBlack);
                    even.get(evenIndex).setTextSize(size);
                    layoutEven.addView(even.get(evenIndex), lParams);
                    evenIndex++;
                }
            }

            if (studList.size() % 2 != 0) {
                even.add(new TextView(this));
                even.get(even.size() - 1).setText("Андрей Козаченко :)");
                even.get(even.size() - 1).setTextColor(colorBlack);
                even.get(even.size() - 1).setTextSize(size);
                layoutEven.addView(even.get(even.size() - 1), lParams);
            }
        }else {
            TextView noneCheck = new TextView(this);
            noneCheck.setText("Никто не выбран");
            noneCheck.setTextColor(colorBlack);
            noneCheck.setTextSize(20);
            layoutMain.addView(noneCheck, lParams);
            TextView noneCheck1 = new TextView(this);
            noneCheck1.setText("Выберите хотя бы одного студента");
            noneCheck1.setTextColor(colorBlack);
            noneCheck1.setTextSize(15);
            layoutMain.addView(noneCheck1, lParams);
        }
   }
}
