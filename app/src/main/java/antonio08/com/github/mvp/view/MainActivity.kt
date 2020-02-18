package antonio08.com.github.mvp.view

import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import antonio08.com.github.mvp.R
import antonio08.com.github.mvp.model.User
import antonio08.com.github.mvp.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    private var mPresenter : MainActivityPresenter? = null
    private var mProgressBar : ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user : User = User()

        mPresenter = MainActivityPresenter(user, this)
        initProgressBar()

        mUserName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int) {
                mPresenter!!.updateFullName(s.toString())
            }

            override fun afterTextChanged(s: Editable) {
                hideProgressBar()
            }
        })

        mUserEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                hideProgressBar()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                mPresenter!!.updateEmail(p0.toString())
            }

        })
    }

    override fun updateUserInfoTextView(info: String) {
        mTextTyped.text = info
    }

    override fun showProgressBar() {
        mProgressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        mProgressBar!!.visibility = View.INVISIBLE
    }

    private fun initProgressBar() {
        mProgressBar = ProgressBar(this, null, R.attr.actionBarStyle)
        mProgressBar!!.isIndeterminate = true
        val params = RelativeLayout.LayoutParams(
            Resources.getSystem().getDisplayMetrics().widthPixels,
            250
        )
        params.addRule(RelativeLayout.CENTER_IN_PARENT)
        addContentView(mProgressBar, params)
        showProgressBar()
    }
}
