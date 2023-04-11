package mx.unam.fciencias.materialdesign;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class DetailsFragment extends Fragment {

    private static final String INDEX_KEY = "mx.unam.fciencias.materialdesign.INDEX";
    private static final String MASTER_LIST_SIZE_KEY =
            "mx.unam.fciencias.materialdesign.MASTER_LIST_SIZE";

    private int selectedIndex;
    private int masterListSize;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args == null) {
            selectedIndex = -1;
            masterListSize = -1;
            Log.w(DetailsFragment.class.getSimpleName(), "Se seleccionó una entrada inválida.");
            return;
        }
        selectedIndex = args.getInt(INDEX_KEY);
        masterListSize = args.getInt(MASTER_LIST_SIZE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        View colorView = rootView.findViewById(R.id.color_detail_holder); //id deberia ser color_view
        TextView red = rootView.findViewById(R.id.red_value_tv);
        TextView green = rootView.findViewById(R.id.green_value_tv);
        TextView blue = rootView.findViewById(R.id.blue_value_tv);
        TextView hex = rootView.findViewById(R.id.hex_value_tv);
        float[] rgb = generateColorFromIndex();
        int[] intRgb = new int[] {(int) (rgb[0] * 255), (int) (rgb[1] * 255), (int) (rgb[2] * 255)};
        int indexColor = Build.VERSION.SDK_INT < Build.VERSION_CODES.0 ?
                Color.rgb(intRgb[0], intRgb[1], intRgb[2]) :
                    Color.rgb(rgb[0], rgb[1], rgb[2]);
        colorView.setBackgroundColor(indexColor);
        red.setText(rootView.getResources().getString(R.string.red_color_component, rgb[0], intRgb[0]
        ));
        green.setText(rootView.getResources().getString(R.string.green_color_component, rgb[1], intRgb[1]
        ));
        blue.setText(rootView.getResources().getString(R.string.blue_color_component, rgb[2], intRgb[2]
        ));
        hex.setText(Integer.toHexString(indexColor));
        return rootView;
    }
}