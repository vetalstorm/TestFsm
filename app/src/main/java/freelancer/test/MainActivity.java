package freelancer.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivAlarm;
    private TextView tvCorrespondingText;
    public final int ALARM_DISARMED_ALL_UNLOCKED = 1;
    public final int ALARM_DISARMED_ALL_LOCKED = 2;
    public final int ALARM_ARMED_ALL_LOCKED = 3;
    public final int ALARM_DISARMED_DRIVER_UNLOCKED = 4;

    public final int EVENT_LOCK = 10;
    public final int EVENT_DOUBLE_LOCK = 11;
    public final int EVENT_UNLOCK = 12;
    public final int EVENT_DOUBLE_UNLOCK = 13;

    public final int COLOR_RED = 21;
    public final int  COLOR_GREEN =22;

    public static int current_position = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        ivAlarm = (ImageView) findViewById(R.id.ivAlarm);

        tvCorrespondingText = (TextView) findViewById(R.id.tvCorrespondingText);

        Button btnLock = (Button) findViewById(R.id.btnLock);
        btnLock.setOnClickListener(this);

        Button btnDoubleLock = (Button) findViewById(R.id.btnDoubleLock);
        btnDoubleLock.setOnClickListener(this);

        Button btnUnlock = (Button) findViewById(R.id.btnUnlock);
        btnUnlock.setOnClickListener(this);

        Button btnDoubleUnlock = (Button) findViewById(R.id.btnDoubleUnlock);
        btnDoubleUnlock.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLock:
                showResult(EVENT_LOCK);
                break;

            case R.id.btnDoubleLock:
                showResult(EVENT_DOUBLE_LOCK);
                break;

            case R.id.btnUnlock:
                showResult(EVENT_UNLOCK);
                break;

            case R.id.btnDoubleUnlock:
                showResult(EVENT_DOUBLE_UNLOCK);
                break;

        }
    }
    public void showResult(int i){
        switch(current_position){
            case ALARM_DISARMED_ALL_UNLOCKED:
                switch (i){
                    case EVENT_LOCK:
                        tvCorrespondingText.setText(R.string.all_locked);
                        current_position=ALARM_DISARMED_ALL_LOCKED;
                        break;
                    case EVENT_DOUBLE_LOCK:
                        setColor(COLOR_RED);
                        tvCorrespondingText.setText(R.string.all_locked);
                        current_position=ALARM_ARMED_ALL_LOCKED;
                        break;
                    case EVENT_UNLOCK:
                    case EVENT_DOUBLE_UNLOCK:
                        break;
                }
                break;
            case ALARM_DISARMED_ALL_LOCKED:
                switch (i){
                    case EVENT_LOCK:
                    case EVENT_DOUBLE_LOCK:
                        setColor(COLOR_RED);
                        tvCorrespondingText.setText(R.string.all_locked);
                        current_position=ALARM_ARMED_ALL_LOCKED;
                        break;
                    case EVENT_UNLOCK:
                        tvCorrespondingText.setText(R.string.driver_unlocked);
                        current_position=ALARM_DISARMED_DRIVER_UNLOCKED;
                        break;
                    case EVENT_DOUBLE_UNLOCK:
                        tvCorrespondingText.setText(R.string.all_unlocked);
                        current_position=ALARM_DISARMED_ALL_UNLOCKED;
                        break;
                }
                break;
            case ALARM_ARMED_ALL_LOCKED:
                switch (i){
                    case EVENT_LOCK:
                    case EVENT_DOUBLE_LOCK:
                        break;
                    case EVENT_UNLOCK:
                        ivAlarm.setBackgroundResource(R.drawable.circle_green);
                        tvCorrespondingText.setText(R.string.driver_unlocked);
                        current_position=ALARM_DISARMED_DRIVER_UNLOCKED;
                        break;
                    case EVENT_DOUBLE_UNLOCK:
                        setColor(COLOR_GREEN);
                        tvCorrespondingText.setText(R.string.all_unlocked);
                        current_position=ALARM_DISARMED_ALL_UNLOCKED;
                        break;
                }
                break;
            case ALARM_DISARMED_DRIVER_UNLOCKED:
                switch (i){
                    case EVENT_LOCK:
                        tvCorrespondingText.setText(R.string.all_locked);
                        current_position=ALARM_DISARMED_ALL_LOCKED;
                        break;
                    case EVENT_DOUBLE_LOCK:
                        setColor(COLOR_RED);
                        tvCorrespondingText.setText(R.string.all_locked);
                        current_position=ALARM_ARMED_ALL_LOCKED;
                        break;
                    case EVENT_UNLOCK:
                    case EVENT_DOUBLE_UNLOCK:
                        break;
                }
                break;
        }

    }
    public void setColor(int color){
        if (color == COLOR_RED)
            ivAlarm.setBackgroundResource(R.drawable.circle_red);
        else
            ivAlarm.setBackgroundResource(R.drawable.circle_green);

    }


    public String mockitoTest(){
        showResult(EVENT_DOUBLE_LOCK);
        String s= tvCorrespondingText.getText().toString();
        return s;
    }
}
