package antonio08.com.github.mvp.model

/**
 * Created by Antonio Lozano on 2020-02-17.
 */
class User() {

    var mUserName : String = ""
    var mUserEmail : String = ""

    constructor(userName : String, email : String) : this(){
        mUserName =userName
        mUserEmail = email
    }

    override fun toString(): String {
        return "Email: $mUserEmail \nFull Name: $mUserName"
    }


}