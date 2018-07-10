package bbcag.ch.dime.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import bbcag.ch.dime.R;
import bbcag.ch.dime.dal.GalleryDao;
import bbcag.ch.dime.helper.TextHelper;

public class VideoAndPhotoFragment extends Fragment {
    private ProgressBar progressBar;
    View view;
    private GalleryDao dao;

    public static VideoAndPhotoFragment newInstance() {
        VideoAndPhotoFragment fragment = new VideoAndPhotoFragment();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videoandphoto, container, false);
        super.onCreate(savedInstanceState);
        dao.getAll();

        progressBar = view.findViewById(R.id.imageliste);
        return view;
    }
}






