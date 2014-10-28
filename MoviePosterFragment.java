/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.castscreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Fragment implementation created to show a poster inside an ImageView widget.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MoviePosterFragment extends Fragment {

  
    ImageView thumbnailImageView;

    private String videoPosterThumbnail;
    private String posterTitle;

    /**
     * Override method used to initialize the fragment.
     * I am using this fragment to display imageview at bottom of vedio
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.poster, container, false);
        thumbnailImageView=(ImageView)view.findViewById(R.id.iv_thumbnail2);
      
        //ButterKnife.inject(this, view);
        try {
			Picasso.with(getActivity()).load("http://4.bp.blogspot.com/-BT6IshdVsoA/UjfnTo_TkBI/AAAAAAAAMWk/JvDCYCoFRlQ/s1600/xmenDOFP.wobbly.1.jpg").placeholder(R.drawable.xmen_placeholder).into(thumbnailImageView);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return view;
    }
    
    /**
     * Show the poster image in the thumbnailImageView widget.
     *
     * @param videoPosterThumbnail
     */
    public void setPoster(String videoPosterThumbnail) {
        this.videoPosterThumbnail = videoPosterThumbnail;
    }

    /**
     * Store the poster title to show it when the thumbanil view is clicked.
     *
     * @param posterTitle
     */
    public void setPosterTitle(String posterTitle) {
        this.posterTitle = posterTitle;
    }

    /**
     * Method triggered when the iv_thumbnail widget is clicked. This method shows a toast with the poster information.
     */
    
}
