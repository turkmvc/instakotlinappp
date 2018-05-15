package com.emrealtunbilek.instakotlinapp.Profile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.emrealtunbilek.instakotlinapp.R
import com.emrealtunbilek.instakotlinapp.utils.BottomnavigationViewHelper
import com.emrealtunbilek.instakotlinapp.utils.UniversalImageLoader
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {

    private val ACTIVITY_NO=4
    private val TAG="ProfileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupToolbar()
        setupNavigationView()
        setupProfilePhoto()
    }

    private fun setupProfilePhoto() {

        val imgUrl="www.wallpaperup.com/uploads/wallpapers/2016/06/24/991808/9ab236cccae5470451c20329ca43ec6b-1400.jpg"
        UniversalImageLoader.setImage(imgUrl,circleProfileImage,progressBar,"https://")
    }

    private fun setupToolbar() {
       imgProfileSettings.setOnClickListener {
           var intent=Intent(this,ProfileSettingsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
           startActivity(intent)
       }

       tvProfilDuzenleButon.setOnClickListener {

           profileRoot.visibility= View.GONE
           var transaction=supportFragmentManager.beginTransaction()
           transaction.replace(R.id.profileContainer,ProfileEditFragment())
           transaction.addToBackStack("editProfileFragmentEklendi")
           transaction.commit()

       }

    }

    fun setupNavigationView(){

        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this, bottomNavigationView)
        var menu=bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }

    override fun onBackPressed() {
        profileRoot.visibility= View.VISIBLE
        super.onBackPressed()
    }
}