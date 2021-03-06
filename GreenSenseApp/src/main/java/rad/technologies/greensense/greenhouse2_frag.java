package rad.technologies.greensense;
//R.A.D. Technologies
//Ryan McAdie, Aiden Waadallah, Daniel Bujold

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Objects;

public class greenhouse2_frag extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams") ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_greenhouse2_frag, null);

        flTempAndHumidity = root.findViewById(R.id.flTempAndHumidity);
        flManualControl = root.findViewById(R.id.flManualControl);

        tvTempAndHumidity = root.findViewById(R.id.fl_plant_ferns);
        tvManualControl = root.findViewById(R.id.tvManualControl);


        flTempAndHumidity.setOnClickListener(this::onClick);
        flManualControl.setOnClickListener(this::onClick);

        return root;

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private FrameLayout flTempAndHumidity, flManualControl;
    private TextView tvTempAndHumidity, tvManualControl;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    private void onClick(View v) {

        WhiteBackgroundFunction(flTempAndHumidity, tvTempAndHumidity);
        WhiteBackgroundFunction(flManualControl, tvManualControl);


        switch (v.getId()) {
            case R.id.flTempAndHumidity:
                GreenBackgroundFunction(flTempAndHumidity, tvTempAndHumidity);
                startActivity(new Intent(getActivity(), TempAndHumidityActivity.class));
                break;

            case R.id.flManualControl:
                GreenBackgroundFunction(flManualControl, tvManualControl);
                startActivity(new Intent(getActivity(), DevicesActivity.class));

                break;


        }
    }

    private void WhiteBackgroundFunction(FrameLayout frameLayout, TextView textView) {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            frameLayout.setBackgroundDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.rounded_button_white));
        } else {
            frameLayout.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.rounded_button_white));
        }

        textView.setTextColor(getResources().getColor(R.color.green));

    }

    private void GreenBackgroundFunction(FrameLayout frameLayout, TextView textView) {

        final int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            frameLayout.setBackgroundDrawable(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.rounded_button_green));
        } else {
            frameLayout.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getActivity()), R.drawable.rounded_button_green));
        }
        textView.setTextColor(getResources().getColor(R.color.white));


    }
}