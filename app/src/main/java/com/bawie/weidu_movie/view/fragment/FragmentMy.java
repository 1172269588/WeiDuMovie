package com.bawie.weidu_movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bawie.weidu_movie.R;
import com.bawie.weidu_movie.view.activity.login.LoginActivity;

import butterknife.BindView;

public class FragmentMy extends Fragment {

    @BindView(R.id.iv_xinxi)
    ImageView ivXinxi;
    @BindView(R.id.iv_head_portrait)
    ImageView ivHeadPortrait;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.user_detailed_information)
    RelativeLayout userDetailedInformation;
    @BindView(R.id.user_movie_tickets)
    LinearLayout userMovieTickets;
    @BindView(R.id.iv_my_attention)
    ImageView ivMyAttention;
    @BindView(R.id.iv_my_reservation)
    ImageView ivMyReservation;
    @BindView(R.id.iv_my_ticket_record)
    ImageView ivMyTicketRecord;
    @BindView(R.id.iv_my_movie_seen)
    ImageView ivMyMovieSeen;
    @BindView(R.id.iv_my_comments)
    ImageView ivMyComments;
    @BindView(R.id.iv_feedback)
    ImageView ivFeedback;
    @BindView(R.id.iv_my_set_up)
    ImageView ivMySetUp;
    private View inflate;
    private ImageView frag_iv_my;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_fragment_my, container, false);
        frag_iv_my = inflate.findViewById(R.id.frag_iv_my);
        frag_iv_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),LoginActivity.class));
            }
        });
        return inflate;

    }

}
