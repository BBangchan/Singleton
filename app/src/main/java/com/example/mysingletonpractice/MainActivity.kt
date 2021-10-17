package com.example.mysingletonpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

// Singleton은 DB와 레트로핏에 사용이된다.
// 메모리를 한개를 계속 사용하는 것이다.
// 생성자가 여러개여도 실제로 생성되는 객체는 하나이고, 그 이후에 생성된 생성자는 최초의 생성된 객체를 리턴한다.

class MainActivity : AppCompatActivity() {
    
    val TAG : String ="로그"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "MainActivity - onCreate() called()")

        // 변수를 선언할때는 숫자를 넣어서 사용하면 안된다.
        // 지금은 테스트용으로 사용하는 것
        val myNormalClass_1 = MyNormalClass()
        val myNormalClass_2 = MyNormalClass()

        Log.d(TAG, "MainActivity - myNormalClass_1 :$myNormalClass_1")
        Log.d(TAG, "MainActivity - myNormalClass_2 :$myNormalClass_2")

        // mySingletonClass 1과 2는 같은 주소를 가르키고 있다.
        val mySingletonClass_1 = MySingletonClass
        val mySingletonClass_2 = MySingletonClass

        Log.d(TAG, "MainActivity - mySingletonClass_1 :$mySingletonClass_1")
        Log.d(TAG, "MainActivity - mySingletonClass_2 :$mySingletonClass_2")
        
        val mySQLOpenHelper_1 = MySQLOpenHelper(this)
        val mySQLOpenHelper_2 = MySQLOpenHelper(this)

        Log.d(TAG, "MainActivity - mySQLOpenHelper_1 :$mySQLOpenHelper_1")
        Log.d(TAG, "MainActivity - mySQLOpenHelper_2 :$mySQLOpenHelper_2")

        val mySQLOpenHelperSingleton_1 = MySQLOpenHelperSingleton.getInstance(this)
        val mySQLOpenHelperSingleton_2 = MySQLOpenHelperSingleton.getInstance(this)

        Log.d(TAG, "MainActivity - mySQLOpenHelperSingleton_1 : $mySQLOpenHelperSingleton_1")
        Log.d(TAG, "MainActivity - mySQLOpenHelperSingleton_2 : $mySQLOpenHelperSingleton_2")

    }
}