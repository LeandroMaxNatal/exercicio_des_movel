package br.com.leandromax.datepickerexercicio;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener
{
    private int day, month, year, hour, minute, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);

        Calendar c = Calendar.getInstance();
        this.year = c.get(Calendar.YEAR);
        this.month = c.get(Calendar.MONTH);
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.hour = c.get(Calendar.HOUR_OF_DAY);
        this.minute = c.get(Calendar.MINUTE);
        this.second = c.get(Calendar.SECOND);

        String dataAndTimeString = this.day + "/" + this.month + "/" + this.year + " " + this.hour
                + ":" + this.minute + ":" + this.second;

        TextView tvData = (TextView) findViewById(R.id.tvData);
        tvData.setText(dataAndTimeString);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker!");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        this.year = year;
        this.month = month;
        this.day = dayOfMonth;

        String dataAndTimeString = this.day + "/" + this.month + "/" + this.year + " " + this.hour
                + ":" + this.minute + ":" + this.second;

        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        System.out.println(currentDateString);

        TextView tv = (TextView) findViewById(R.id.tvData);
        tv.setText(dataAndTimeString);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.hour = hourOfDay;
        this.minute = minute;

        Calendar c = Calendar.getInstance();
        this.second = c.get(Calendar.SECOND);

        String dataAndTimeString = this.day + "/" + this.month + "/" + this.year + " " + this.hour
                + ":" + this.minute + ":" + this.second;

        TextView textView = (TextView) findViewById(R.id.tvData);
        textView.setText(dataAndTimeString);
    }
}
