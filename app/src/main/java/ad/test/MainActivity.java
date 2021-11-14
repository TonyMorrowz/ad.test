package ad.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;

public class MainActivity extends AppCompatActivity {
    private static final String CONSENT = "consent";
    boolean consent;
    public enum BannerPosition {
        BANNER(Appodeal.BANNER),
        BOTTOM(Appodeal.BANNER_BOTTOM),
        TOP(Appodeal.BANNER_TOP),
        VIEW(Appodeal.BANNER_VIEW),
        LEFT(Appodeal.BANNER_LEFT),
        RIGHT(Appodeal.BANNER_RIGHT);

        private final int value;

        BannerPosition(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        }

        public void initBannerSdkButton(View v) {
            Appodeal.setBannerViewId(R.id.appodealBannerView);
            Appodeal.initialize(this, "0940692e3598fd4dc4bc77ac8572eab8772ecbb65b27b781", Appodeal.BANNER, consent);
            Appodeal.setBannerCallbacks(new AppodealBannerCallbacks(this));
        }




        public void bannerShowButton(View v) {
            Spinner bannerPositionSpinner = findViewById(R.id.bannerPositionList);
            BannerPosition bannerPosition = (BannerPosition) bannerPositionSpinner.getSelectedItem();
            boolean isShown = Appodeal.show(this, bannerPosition.getValue());
            Toast.makeText(this, String.valueOf(isShown), Toast.LENGTH_SHORT).show();
        }

        public void bannerHideButton(View v) {
            Appodeal.hide(this, Appodeal.BANNER);
        }

        public void bannerDestroyButton(View v) {
            Appodeal.destroy(Appodeal.BANNER);
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Appodeal.initialize(this, "0940692e3598fd4dc4bc77ac8572eab8772ecbb65b27b781", Appodeal.BANNER, consent);
    }
}