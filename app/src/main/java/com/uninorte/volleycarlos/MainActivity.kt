package com.uninorte.volleycarlos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            VolleySingleton.getInstance(this).addToRequestQueue(getJsonObjectRequest())
        }
    }

    fun getStringRequest() : StringRequest {
        val url = "https://www.google.com"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response->
                textView.text = response.toString()
            },
            Response.ErrorListener {
                textView.text = "error"
            }
        )
        return stringRequest
    }

    fun getJsonObjectRequest() : JsonObjectRequest {
        val url = "https://randomuser.me/api/?results=20"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response->
                //parseObject(response)
                parseObjectG(response)

            },
            Response.ErrorListener {
                textView.text = "error"
            }
        )
        return jsonObjectRequest
    }
    fun parseObject(response: JSONObject){
        val jsonArrayResults : JSONArray = response.getJSONArray("results")
        val size: Int = jsonArrayResults.length()
        val i: Int =0
        for (i in 0.. size -1){
            val userObject = jsonArrayResults.getJSONObject(i)
            val gender = userObject.getString("gender")
            val nameObject = userObject.getJSONObject("name")
            val firstName = userObject.getString("first")
            Log.d("JSONParsing",gender + " " + firstName)
        }
    }
    fun parseObjectG(response: JSONObject){
        var list = RandomUser.getUser(response)
        var text : String = ""
        val i:Int =0
        val size: Int = list.size
        for (i in 0.. size -1){
            val user = list.get(i)
            Log.d("WebJson", "element " + user.name.first)
            text = text + " " + user.name.first + "\n"
        }
        textView.text = text
    }

}
