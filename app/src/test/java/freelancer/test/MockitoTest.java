
package freelancer.test;
import static org.mockito.Mockito.*;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by arxangel on 4/28/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    private static final String ALL_LOCKED = "AllLocked";
    @Test
    public void clickingDoubleLockButton_shouldChangeResultsViewText() {

        MainActivity activity = mock(MainActivity.class);

        when(activity.mockitoTest()).thenReturn(ALL_LOCKED);
        String result = activity.mockitoTest();
        assertThat(result).isEqualTo(ALL_LOCKED);
    }
}
