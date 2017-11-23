package meraya.ua.com.students_group;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentsActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    LinearLayout layoutOdd, layoutEven, layoutDelimiter, layoutMain;
    ArrayList<TextView> odd, even , delimiter;
    SeekBar seekBar;
    int colorBlack;
    Intent intent;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        seekBar = (SeekBar) findViewById(R.id.seekBar4);
        seekBar.setOnSeekBarChangeListener(this);
        colorBlack = Color.parseColor("#000000");
        layoutOdd = (LinearLayout) findViewById(R.id.odd);
        layoutEven = (LinearLayout) findViewById(R.id.even);
        layoutDelimiter = (LinearLayout) findViewById(R.id.delimiter);
        layoutMain = (LinearLayout) findViewById(R.id.mainLayout);
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                wrapContent, wrapContent);
        lParams.setMargins(10,10,10,10);
        intent = getIntent();

        ArrayList<String> studList = (ArrayList<String>) intent.getSerializableExtra("list");

        odd = new ArrayList<>();
        even = new ArrayList<>();
        delimiter = new ArrayList<>();

        float size = 15;
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
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        for (TextView view: even){
            view.setTextSize(i);
        }
        for (TextView view: delimiter){
            view.setTextSize(i);
        }
        for (TextView view: odd){
            view.setTextSize(i);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
