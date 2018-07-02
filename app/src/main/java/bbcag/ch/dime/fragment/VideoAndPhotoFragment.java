package bbcag.ch.dime.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import bbcag.ch.dime.MainActivity;
import bbcag.ch.dime.R;

public class VideoAndPhotoFragment extends Fragment {
private static String TAG = "ImageInfo";
private int badiId;
private ProgressBar progressBar;
public static final String WIE_WARM_API_URL = "http://www.wiewarm.ch/api/v1/bad.json/";

public static VideoAndPhotoFragment newInstance() {
        VideoAndPhotoFragment fragment = new VideoAndPhotoFragment();
        return fragment;
}

protected void onCreateview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        super.onCreate(savedInstanceState);
        setContent(R.layout.fragment_videoandphoto);
        progressBar = view.findViewById(R.id.imageliste);
        Intent intent = getIntent();
        badiId = intent.getIntExtra(MainActivity.EXTRA_BADI_ID, 0);
        String name = intent.getStringExtra(MainActivity.EXTRA_BADI_NAME);
        setTitle(name);
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_favorite:
        Intent intent = new Intent(getApplicationContext(), BadiFavoritesActivity.class);
        startActivity(intent);
        return true;
        case android.R.id.home:
        onBackPressed();
        return true;
default:
        return super.onOptionsItemSelected(item);
        }
        }


@Override
protected void onStart() {
        super.onStart();
        progressBar.setVisibility(View.VISIBLE);
        getBadiTemp(WIE_WARM_API_URL + badiId);
        }

private void getBadiTemp(String url)
        {
final ArrayAdapter<Becken> beckenInfosAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
final Activity mainActivity = this;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener<String>() {
@Override
public void onResponse(String response) {
        progressBar.setVisibility(View.GONE);
        try {
        Badi badi = WieWarmJsonParser.createBadiFromJsonString(response);
        beckenInfosAdapter.addAll(badi.getBecken());
        ListView badiInfoList = findViewById(R.id.becken_infos);
        badiInfoList.setAdapter(beckenInfosAdapter);

        } catch (JSONException e) {
        Log.e(TAG, e.getMessage(), e);
        DialogHelper.generateAlertDialog(mainActivity, getString(R.string.all_error), getString(R.string.badiDetails_alertDialogLoadingBadis));
        }

        }
        }, new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
        DialogHelper.generateAlertDialog(mainActivity, getString(R.string.all_error), getString(R.string.badiDetails_alertDialogLoadingBadis));
        }
        });

        queue.add(stringRequest);
        }


        }





