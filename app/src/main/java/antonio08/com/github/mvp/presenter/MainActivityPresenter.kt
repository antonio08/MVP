package antonio08.com.github.mvp.presenter

import android.view.View
import antonio08.com.github.mvp.model.User

/**
 * Created by Antonio Lozano on 2020-02-17.
 */
class MainActivityPresenter (user: User, view : View) {

    private val mUser : User = user
    private val mView : View = view
    /**
     *
     */
    fun updateFullName(fullName : String) {
        mUser.mUserName = fullName
        mView.updateUserInfoTextView(mUser.toString())
    }

    /**
     *
     */
    fun updateEmail(email : String) {
        mUser.mUserEmail = email
        mView.updateUserInfoTextView(mUser.toString())
    }


    interface View {
        /**
         *
         */
        fun updateUserInfoTextView(info : String)

        /**
         *
         */
        fun showProgressBar()

        /**
         *
         */
        fun hideProgressBar()
    }


}