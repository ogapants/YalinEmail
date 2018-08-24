package com.yalin.email2.ui;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.ui.AbstractConversationViewFragment;
import com.android.mail.ui.ConversationViewFragment;
import com.yalin.email.R;

public class GodActivity extends com.yalin.email2.ui.MailActivityEmail {

    public static Intent intent(Context mContext, Account account, Conversation c) {
        Intent intent = new Intent(mContext, GodActivity.class);
        intent.putExtra("a", account);
        intent.putExtra("b", c);
        return intent;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(com.android.mail.R.layout.activity_container);

        if (savedInstanceState == null) {
            Account a = (Account) getIntent().getParcelableExtra("a");
            Log.w("GodActivity", "onCreate: ****31__    "+(a==null));
            Fragment fragment = ConversationViewFragment.newInstance(
                    AbstractConversationViewFragment.makeBasicArgs(a),
                    (Conversation) getIntent().getParcelableExtra("b"));

            getFragmentManager().beginTransaction()
                    .add(R.id.come_on, fragment)
                    .commit();
        }
    }


}
