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

import java.util.Iterator;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.MediaRouteButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.github.pedrovgs.DraggableListener;
import com.github.pedrovgs.DraggablePanel;
//import com.github.pedrovgs.sample.R;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.squareup.picasso.Picasso;


/**
 * Sample activity created to show a video from YouTube using a YouTubePlayer.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class Displayvedio extends FragmentActivity {

    private static final String YOUTUBE_API_KEY = "AIzaSyC1rMU-mkhoyTvBIdTnYU0dss0tU9vtK48";
   String VIDEO_KEY ;
   String valclick;
   // private static final String VIDEO_POSTER_THUMBNAIL = "http://4.bp.blogspot.com/-BT6IshdVsoA/UjfnTo_TkBI/AAAAAAAAMWk/JvDCYCoFRlQ/s1600/xmenDOFP.wobbly.1.jpg";
    private static final String SECOND_VIDEO_POSTER_THUMBNAIL = "http://media.comicbook.com/wp-content/uploads/2013/07/x-men-days-of-future-past-wolverine-poster.jpg";
    private static final String VIDEO_POSTER_TITLE = "X-Men: Days of Future Past";
    int flag;
 
    
   
    DraggablePanel draggablePanel;
boolean check;
ListView lv;
    private YouTubePlayer youtubePlayer;
     YouTubePlayerSupportFragment youtubeFragment;
     MoviePosterFragment moviePosterFragment ;
    /**
     * Initialize the Activity with some injected data.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vediofile);
        flag=0;
        lv = (ListView) findViewById(R.id.iv_thumbnail);
        draggablePanel= (DraggablePanel)findViewById(R.id.draggable_panel);
       // ButterKnife.inject(this);
         moviePosterFragment = new MoviePosterFragment();
        initializeYoutubeFragment();
        initializeDraggablePanel();
        hookDraggablePanelListeners();
        lv.setOnItemClickListener(new OnItemClickListener() {
        	
    		@Override
    		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
    				long arg3) {
    		 VIDEO_KEY=it.getStringExtra("mystring");
                            youtubePlayer.loadVideo(VIDEO_KEY);
    		        draggablePanel.maximize();
    			 	
    			 	
		}
	});
    		
     
    }

    /**
     * Method triggered when the iv_thumbnail widget is clicked. This method maximize the DraggablePanel.
     */


    /**
     * Initialize the YouTubeSupportFrament attached as top fragment to the DraggablePanel widget and reproduce the
     * YouTube video represented with a YouTube url.
     */
    private void initializeYoutubeFragment() {
        youtubeFragment = new YouTubePlayerSupportFragment();
        youtubeFragment.initialize(YOUTUBE_API_KEY,
                new YouTubePlayer.OnInitializedListener() {

                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                        if (!wasRestored) {
                            youtubePlayer = player;
                          
                            Intent it=getIntent();
                            // Here i am getting vedio id from my main activity to play vedio
                            VIDEO_KEY=it.getStringExtra("mystring");
                            youtubePlayer.loadVideo(VIDEO_KEY);
                          
                            youtubePlayer.setShowFullscreenButton(true);
                        }
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                    }

                }
        );
    }

    @Override
	public void onAttachFragment(Fragment fragment) {
		// TODO Auto-generated method stub
		super.onAttachFragment(fragment);
		
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		

	@Override
	protected void onResumeFragments() {
		// TODO Auto-generated method stub
		super.onResumeFragments();
		
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
	}

	/**
     * Initialize and configure the DraggablePanel widget with two fragments and some attributes.
     */
    private void initializeDraggablePanel() {
        draggablePanel.setFragmentManager(getSupportFragmentManager());
        draggablePanel.setTopFragment(youtubeFragment);
        moviePosterFragment = new MoviePosterFragment();
       // moviePosterFragment.setPoster(VIDEO_POSTER_THUMBNAIL);
        moviePosterFragment.setPosterTitle(VIDEO_POSTER_TITLE);
        draggablePanel.setBottomFragment(moviePosterFragment);
        draggablePanel.initializeView();
     //*******************************************************************************************
        ODE FOR DISPLAYING LISTVIEW BEHIND DRAGGABLE PANNEL

        ProgressBar footer = (ProgressBar) footerLayout.findViewById(R.id.progressbar);
       
        lv.addFooterView(footerLayout);
        System.out.println("11111111111111111");
        //--page size = 10--
        ProdAdapter ad = new ProdAdapter(getApplicationContext(),15, footer,"L","car");
        System.out.println("ddddddddddddd");
   
       
		
	

        lv.setAdapter(ad);
      
        System.out.println("33333333");
        check=true;
        LoaderTask t = new LoaderTask(0,15,getApplicationContext(),ad,"L","car",check);
        System.out.println("44444444");
        t.execute();

 //*******************************************************************************************
    }

    /**
     * Hook the DraggableListener to DraggablePanel to pause or resume the video when the DragglabePanel is maximized
     * or closed.
     */

    private void hookDraggablePanelListeners() {
    
        draggablePanel.setDraggableListener(new DraggableListener() {
        	
            @Override
            public void onMaximized() {
                playVideo();
            
                
            }

            @Override
            public void onMinimized() {
            	
               
            	
                //Empty
            }

            @Override
            public void onClosedToLeft() {
                pauseVideo();
               
            }

            @Override
            public void onClosedToRight() {
                pauseVideo();
                
            }
        });
    }

    /**
     * Pause the video reproduced in the YouTubePlayer.
     */
    private void pauseVideo() {
        if (youtubePlayer.isPlaying()) {
            youtubePlayer.pause();
            System.out.println(" pauseVideo");
        }
    }

    /**
     * Resume the video reproduced in the YouTubePlayer.
     */
    private void playVideo() {
        if (!youtubePlayer.isPlaying()) {
            youtubePlayer.play();
            System.out.println(" playVideo");
        }
    }

}
