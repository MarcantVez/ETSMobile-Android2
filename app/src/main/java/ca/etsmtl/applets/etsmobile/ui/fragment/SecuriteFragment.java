package ca.etsmtl.applets.etsmobile.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapView;

import ca.etsmtl.applets.etsmobile.ui.activity.MainActivity;
import ca.etsmtl.applets.etsmobile.ui.activity.UrgenceActivity;
import ca.etsmtl.applets.etsmobile.util.AnalyticsHelper;
import ca.etsmtl.applets.etsmobile2.R;

public class SecuriteFragment extends BaseFragment {


    private ListView listView;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.security, container, false);

        final AppCompatActivity activity = (AppCompatActivity) getActivity();

        listView = (ListView) v.findViewById(android.R.id.list);

        final ViewGroup viewGroup = (ViewGroup) inflater.inflate(
                R.layout.secu_list_header,
                (ViewGroup) v.findViewById(R.id.secu_list_header_layout));
        listView.addHeaderView(viewGroup, null, false);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> arg0, final View arg1,
                                    final int arg2, final long arg3) {
                final Intent intent = new Intent(activity,
                        UrgenceActivity.class);
                intent.putExtra("id", arg2);
                startActivity(intent);

            }
        });

        listView.setAdapter(new ArrayAdapter<String>(activity, R.layout.row_text_with_arrow, R.id.titleTextView, activity.getResources().getStringArray(R.array.secu_urgence)));

        viewGroup.findViewById(R.id.secu_list_header_phone).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(final View v) {
                        final String phoneNumber = ((TextView) v).getText()
                                .toString();
                        final String uri = "tel:" + phoneNumber.trim();
                        final Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse(uri));

                        AnalyticsHelper.getInstance(getActivity())
                                .sendActionEvent(getClass()
                                        .getSimpleName(), UrgenceActivity.APPEL_D_URGENCE);

                        startActivity(intent);
                    }
                });

        AnalyticsHelper.getInstance(getActivity()).sendScreenEvent(getClass().getSimpleName());

        return v;
    }

    @Override
    public String getFragmentTitle() {
        return getString(R.string.menu_section_2_securite);
    }
}
