package edu.auburn.app.diabetestoolkit.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.auburn.app.diabetestoolkit.R;
import edu.auburn.app.diabetestoolkit.activity.base.BaseActivity;
import edu.auburn.app.diabetestoolkit.controller.StateService;
import edu.auburn.app.diabetestoolkit.model.StateModel;

/**
 * Created by liguorui on 3/7/16.
 */
public class AddStateActivity extends BaseActivity implements View.OnClickListener{
    private static String TAG = "AddStateActivity";
    private StateService stateService;
    private TextView tvCancel, tvSave, tvLast, tvDate, tvTime;
    private EditText etBlood, etNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_state_activity);
        initView();
    }

    private void initView(){
        tvCancel = (TextView)findViewById(R.id.btnCancel);
        tvSave = (TextView)findViewById(R.id.btnSave);
        tvTime = (TextView)findViewById(R.id.tvTime);
        tvLast = (TextView) findViewById(R.id.tvLast);
        etBlood = (EditText) findViewById(R.id.etBlood);
        etNotes = (EditText) findViewById(R.id.etNotes);
        tvDate = (TextView) findViewById(R.id.etDate);
        stateService = new StateService(this);
        String lastBlood = stateService.getLast().getBlood();
        tvLast.setText(lastBlood);
        tvCancel.setOnClickListener(this);
        tvSave.setOnClickListener(this);
        tvDate.setOnClickListener(this);
        tvTime.setOnClickListener(this);
    }

    private String date = null;
    private String time = null;
    private String finalDate = null;
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Calendar calendar = Calendar.getInstance();
        switch (id){
            case R.id.etDate:
                tvDate.setFocusable(true);
                tvDate.setFocusableInTouchMode(true);

                Date d = new Date();
                calendar.setTime(d);

                DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date = (monthOfYear+1)+"/"+dayOfMonth+"/"+year;
                        tvDate.setText(date);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
                break;
            case R.id.tvTime:
                calendar.setTimeInMillis(System.currentTimeMillis());
                TimePickerDialog dialog1 = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time = hourOfDay+":"+minute;
                        tvTime.setText(time);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                dialog1.show();
                break;
            case R.id.btnCancel:
                this.finish();
                break;
            case R.id.btnSave:

                if (TextUtils.isEmpty(etBlood.getText().toString()) || TextUtils.isEmpty(etNotes.getText().toString())
                        || TextUtils.isEmpty(tvDate.getText().toString()) || TextUtils.isEmpty(tvTime.getText().toString())){
                    showToast("Please fill all items.");
                }else{
                    saveState();
                }
                break;
        }
    }


    private void saveState(){
        if (formatTime()!=-1){
            stateService.add(new StateModel(formatTime()+"",etBlood.getText().toString(),etNotes.getText().toString()));
            showToast("Save successfully!");
            this.finish();
        }

    }
    private long formatTime(){
        if ((!TextUtils.isEmpty(date))&&(!TextUtils.isEmpty(time))){
            finalDate = date + " "+time;
            SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm");
            Date dt2 = null;
            try {
                dt2 = sdf.parse(finalDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            /*long lTime = dt2.getTime();
            Date date1 = new Date(lTime);
            String printstr = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm").format(date1);
            showToast(printstr +"");*/
            return dt2.getTime();
        }
        else
            return -1;
    }
}
