package freelancer.test;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Created by arxangel on 4/28/17.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RoboelectricTest {

    @Test
    public void clickingLockButton_shouldChangeResultsViewText() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button btnLock = (Button) activity.findViewById(R.id.btnLock);
        TextView tvCorrespondingText = (TextView) activity.findViewById(R.id.tvCorrespondingText);

        btnLock.performClick();
        assertThat(tvCorrespondingText.getText().toString()).isEqualTo("AllLocked");
    }

}
